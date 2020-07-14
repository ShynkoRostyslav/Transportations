import BD.Bd_connector;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        Bd_connector bd = new Bd_connector();

                bd.deleteUser(1113);
                bd.updateSurname("Siegmmayor","Solar");
    }
}
