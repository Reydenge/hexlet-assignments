package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static exercise.Data.getCompanies;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        // BEGIN
        List<String> result = new ArrayList<>();
        String parameter = request.getQueryString();
        String parameterValue = request.getParameter("search");
        PrintWriter pw = response.getWriter();

        if (parameter == null || parameterValue == null) {
            result = getCompanies();
        } else {
            List<String> companies = getCompanies().stream().filter(company -> company.contains(parameterValue))
                    .toList();
            if (companies.size() == 0) {
                pw.println("Companies not found");
            } else {
                result = companies;
            }
        }
        for (String company : result) {
            pw.println(company);
        }
        // END
    }
}
