package ee;

import BD.Bd_connector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class Servlet_1 extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String params = getParameter(req);
        resp.getWriter().write("url =>>" + uri + "   param" + params);
        resp.getWriter().write(" Hello  ");
        ArrayList<Person> person = new ArrayList<>();
        int age = 0;
        String name = "";
        for (Map.Entry<String, String[]> map : req.getParameterMap().entrySet()) {

            if (map.getKey().equals("Age")) {
                age = Integer.parseInt(String.join("", map.getValue()));

            }
            if (map.getKey().equals("Name")) {
                name = String.join("and", map.getValue());

            }
        }
        Bd_connector pipe = new Bd_connector();
        try {
            pipe.connect(name,age);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        person.add(new Person(name, age));


        req.setAttribute("people", person);

        /*  person.add(new Person())*/
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/output.jsp");
        requestDispatcher.forward(req, resp);


    }

    private String getParameter(HttpServletRequest req) {
        return req.getParameterMap()
                .entrySet()
                .stream()
                .map(stringEntry -> {
                    String param = String.join("and", stringEntry.getValue());
                    return stringEntry.getKey() + "=>>" + param;
                }).collect(Collectors.joining("\n"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void destroy() {

    }


}
