package ee;

import BD.Bd_connector;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class Cabinet extends HttpServlet {

    public Cabinet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger logger = LogManager.getLogger(Cabinet.class.getName());
        logger.log(Level.DEBUG, "Initialization of logger");
        try {
            logger.log(Level.INFO, "adding transporatation");

            new Bd_connector().addTransporation(req.getParameter("Username"), req.getParameter("City_to"), req.getParameter("date_to"), req.getParameter("From_city"), req.getParameter("date_from"));
        } catch (SQLException e) {
            logger.log(Level.ERROR,"Problem", new SQLException());
            e.printStackTrace();
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

}

