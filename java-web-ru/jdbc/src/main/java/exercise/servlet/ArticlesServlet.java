package exercise.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;

import java.sql.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import org.apache.commons.lang3.ArrayUtils;

import exercise.TemplateEngineUtil;


public class ArticlesServlet extends HttpServlet {

    private String getId(HttpServletRequest request) {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null) {
            return null;
        }
        String[] pathParts = pathInfo.split("/");
        return ArrayUtils.get(pathParts, 1, null);
    }

    private String getAction(HttpServletRequest request) {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null) {
            return "list";
        }
        String[] pathParts = pathInfo.split("/");
        return ArrayUtils.get(pathParts, 2, getId(request));
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        String action = getAction(request);

        switch (action) {
            case "list":
                showArticles(request, response);
                break;
            default:
                showArticle(request, response);
                break;
        }
    }

    private void showArticles(HttpServletRequest request,
                          HttpServletResponse response)
                throws IOException, ServletException {

        ServletContext context = request.getServletContext();
        Connection connection = (Connection) context.getAttribute("dbConnection");
        // BEGIN
        String textPage = request.getParameter("page");
        int page;
        int numberOfArticles;
        int maxArticlePerPage = 10;
        if (textPage == null) {
            page = 1;
        } else {
            page = Integer.parseInt(textPage);
        }

        try {
            String queryForPages = "SELECT COUNT(*) FROM articles";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryForPages);
            resultSet.next();
            numberOfArticles = resultSet.getInt("COUNT(*)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (page <= 0 || page > numberOfArticles / maxArticlePerPage + 1) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        List<Map<String, String>> articles = new ArrayList<>();
        String queryForArticles = "SELECT id, title, body FROM articles ORDER BY id LIMIT ? OFFSET ?";
        try {
            PreparedStatement statement = connection.prepareStatement(queryForArticles);
            statement.setInt(1, maxArticlePerPage);
            statement.setInt(2, maxArticlePerPage * (page - 1));
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                articles.add(Map.of("id", resultSet.getString("id"),
                        "title", resultSet.getString("title"),
                        "body", resultSet.getString("body")));
            }
        } catch (SQLException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        request.setAttribute("articles", articles);
        request.setAttribute("page", page);
        // END
        TemplateEngineUtil.render("articles/index.html", request, response);
    }

    private void showArticle(HttpServletRequest request,
                         HttpServletResponse response)
                 throws IOException, ServletException {

        ServletContext context = request.getServletContext();
        Connection connection = (Connection) context.getAttribute("dbConnection");
        // BEGIN
        String id = getId(request);
        Map<String, String> article = new HashMap<>();
        int maxId;
        String queryMaxId = "SELECT MAX(id) FROM articles";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryMaxId);
            resultSet.next();
            maxId = resultSet.getInt("MAX(id)");
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        assert id != null;
        if (Integer.parseInt(id) > maxId) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        String query = "SELECT title, body FROM articles WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                article.put("title", resultSet.getString("title"));
                article.put("body", resultSet.getString("body"));
            }
        } catch (SQLException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        request.setAttribute("article", article);
        // END
        TemplateEngineUtil.render("articles/show.html", request, response);
    }
}
