package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.ArrayUtils;

public class UsersServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {

        String pathInfo = request.getPathInfo();

        if (pathInfo == null) {
            showUsers(request, response);
            return;
        }

        String[] pathParts = pathInfo.split("/");
        String id = ArrayUtils.get(pathParts, 1, "");

        showUser(request, response, id);
    }

    private List<Map<String, String>> getUsers() throws JsonProcessingException, IOException {
        // BEGIN
        String fileContent = Files.readString(Path.of("./src/main/resources/users.json"));
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(fileContent, new TypeReference<>() {
        });
        // END
    }

    private void showUsers(HttpServletRequest request,
                           HttpServletResponse response)
            throws IOException {

        // BEGIN
        List<Map<String, String>> listOfUsers = getUsers();
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");

        StringBuilder sb = new StringBuilder();
        sb.append("""
                <!DOCTYPE html>
                <html lang=\"ru\">
                    <head>
                        <meta charset=\"UTF-8\">
                        <title>Example application</title>
                        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\"
                              rel=\"stylesheet\"
                              integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\"
                              crossorigin=\"anonymous\">
                    </head>
                    <body>
                        <div class=\"container\">
                            <table>
                                <tr>
                                    <th>id</th>
                                    <th>fullName</th>
                                </tr>
                """);
        for (var user : listOfUsers) {
            sb.append("<tr>"
                    + "<td>" + user.get("id") + "</td>"
                    + "<td>" + "<a href=\"/users/" + user.get("id") + "\">"
                    + user.get("firstName") + " " + user.get("lastName") + "</a></td>" +
                    "</tr>");
        }
        sb.append("""
                            </table>
                        </div>
                    </body>
                </html>
                """);
        pw.println(sb);
        // END
    }

    private void showUser(HttpServletRequest request,
                          HttpServletResponse response,
                          String id)
            throws IOException {

        // BEGIN
        Map<String, String> user = getUser(getUsers(), id);
        if (user == null) {
            response.sendError(404, "Not found");
        } else {
            PrintWriter pw = response.getWriter();
            response.setContentType("text/html;charset=UTF-8");

            StringBuilder sb = new StringBuilder();
            sb.append("""
                    <!DOCTYPE html>
                    <html lang=\"ru\">
                        <head>
                            <meta charset=\"UTF-8\">
                            <title>Example application</title>
                            <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\"
                                  rel=\"stylesheet\"
                                  integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\"
                                  crossorigin=\"anonymous\">
                        </head>
                        <body>
                            <div class=\"container\">
                                <table>
                                    <tr>
                                        <th>id</th>
                                        <th>fullName</th>
                                        <th>email</th>
                                    </tr>
                    """);
            sb.append("<tr>"
                    + "<td>" + user.get("id") + "</td>"
                    + "<td>" + user.get("firstName") + " " + user.get("lastName") + "</td>"
                    + "<td>" + user.get("email") + "</td>"
                    + "</a></td>"
                    + "</tr>");
            sb.append("""
                                </table>
                           </div>
                       </body>
                    </html>
                    """);
            pw.println(sb);
        }
        // END
    }
    private Map<String, String> getUser(List<Map<String, String>> listOfUsers, String id) {
        return  listOfUsers.stream().filter(user -> user.get("id").equals(id)).findFirst().orElse(null);
    }
}
