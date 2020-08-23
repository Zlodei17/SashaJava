import java.sql.SQLException;

public class main {
    public static void main(String[] args) {
        DB db = new DB();
        try {
            db.deleteSamsing();
            //db.updeitArticals("Helzaeeeeer");
            //db.getArticals("articles");
            //db.insertUsers("Sasha" ,"17sta");
            //db.insertArticale("Новая статья4544", "Текст статьи13422 ", "2050-12-12", "Admin");
            //db.createTable("users");
           // db.isConected();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
