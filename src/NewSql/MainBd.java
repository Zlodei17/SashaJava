package NewSql;

import java.sql.SQLException;

public class MainBd {
    public static void main(String[] args) {
        BazaDate bazaDate = new BazaDate();
        try {
            //bazaDate.insertTable(550,"Noutbuk2");
            bazaDate.getTable("Roba");
            //bazaDate.createTable("Roba");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
