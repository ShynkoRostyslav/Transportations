package ee;

import BD.Bd_connector;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class LogIn extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Logger logger = LogManager.getLogger("LogIn");


        RequestDispatcher requestDispatcher = null;

        String uri = req.getRequestURI();
        String params = getParameter(req);
        ArrayList<Person> person = new ArrayList<>();
        Bd_connector pipe = new Bd_connector();
        int age = 0;
        String name = "";
        String password = "";

        password = req.getParameter("Password");
        name = req.getParameter("Username");


        try {
            if (pipe.isPerson(name)) {
                requestDispatcher = req.getRequestDispatcher("/cabinet.jsp");
                if (!pipe.is_Password(password, name)) {
                    requestDispatcher = req.getRequestDispatcher("ERROR/WrongPassword.html");
                }

                logger.log(Level.INFO, name + " user tries to log in");
            } else {
                logger.log(Level.INFO, "Wrong name");

                requestDispatcher = req.getRequestDispatcher("ERROR/WrongName.html");
            }

        } catch (SQLException | ClassNotFoundException e) {

            logger.log(Level.ERROR, "Problem", new SQLException());

            requestDispatcher = req.getRequestDispatcher("ERROR/WrongName.html");
            e.printStackTrace();
        }

        requestDispatcher.forward(req, resp);


    }

    private String getParameter(HttpServletRequest req) {
        return req.getParameterMap().entrySet().stream().map(
                stringEntry -> {
                    String param = String.join(" and ", stringEntry.getValue());
                    param = stringEntry.getKey() + " param====>" + param;
                    return param;

                }).collect(Collectors.joining("\n"));


    }


}
