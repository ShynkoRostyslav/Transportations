package ee;

import BD.Bd_connector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet("/registration")
public class Registration extends HttpServlet {


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Registration.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher;
        ArrayList<Person> person = new ArrayList<>();

        String name = null;
        String password = null;
        String surname = null;
        String age = null;

        for (Map.Entry<String, String[]> map : req.getParameterMap().entrySet()) {
            if (map.getKey().equals("username")) {
                name = String.join("and", map.getValue());
            }
            if (map.getKey().equals("password")) {
                password = String.join("and", map.getValue());

            }
            if (map.getKey().equals("age")) {
                age = String.join("and", map.getValue());

            }
            if (map.getKey().equals("surname")) {
                surname = String.join("and", map.getValue());

            }

        }

        Bd_connector pipe = new Bd_connector();
        System.out.println(name + " NAME");
        System.out.println(password);
        try {
            requestDispatcher = req.getRequestDispatcher("/cabinet.jsp");
            pipe.addUser(name, surname, password, Integer.parseInt(age));
        } catch (SQLException e) {
            requestDispatcher = req.getRequestDispatcher("ERROR/Person_exist.html");
            requestDispatcher.forward(req, resp);

            e.printStackTrace();
        }


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


}
