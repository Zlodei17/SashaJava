import java.sql.*;


public class DB {
    private final String HOST = "localhost";
    private final String Port = "3306";
    private final String DB = "java_bd";
    private final String Login = "root";
    private final String Pass = null;
    private Connection dbCon = null;
    private Connection getDbConection() throws ClassNotFoundException, SQLException {
        String connStr = "jdbc:mysql://"+HOST+":"+Port+"/"+DB+"?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbCon = DriverManager.getConnection(connStr,Login,Pass);
        return  dbCon;
    }
    public void isConected() throws SQLException, ClassNotFoundException {
        dbCon = getDbConection();
        System.out.println(dbCon.isValid(1000));
    }
    public  void createTable(String tableName) throws SQLException, ClassNotFoundException{
        String sql = "CREATE TABLE IF NOT EXISTS "+tableName
                +"(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50), password VARCHAR(100))"+
                " ENGINE=MYISAM";

        Statement statement = getDbConection().createStatement();
        statement.executeUpdate(sql);
    }
    public void insertUsers(String name,String password)throws SQLException, ClassNotFoundException{
        String sql = "INSERT INTO `users` (name, password) VALUES (?,?)";
        PreparedStatement prSt = getDbConection().prepareStatement(sql);
        prSt.setString(1,name);
        prSt.setString(2,password);
        prSt.executeUpdate();

    }
    public  void insertArticale(String title, String text, String date, String autor) throws SQLException, ClassNotFoundException{
        String sql = "INSERT INTO `articles` (title, text, date, avtor) VALUES (?, ?, ?, ?)";
        PreparedStatement prST = getDbConection().prepareStatement(sql);
        prST.setString(1,title);
        prST.setString(2,text);
        prST.setString(3,date);
        prST.setString(4,autor);
        prST.executeUpdate();
    }
    public void getArticals(String table) throws SQLException, ClassNotFoundException{
        //String sql = "SELECT * FROM "+ table + " WHERE `id`<>1" ;
        String sql = "SELECT * FROM "+ table + " WHERE `title` LIKE '%Новая статья%' or `ID`>1 ORDER BY `id` DESC LIMIT 2 OFFSET 2" ;

        Statement statement = getDbConection().createStatement();
        ResultSet res = statement.executeQuery(sql);//vibiraem danie
        while (res.next()){
            System.out.println(res.getString("id"));
        }
    }
    public void updeitArticals(String title) throws SQLException, ClassNotFoundException{
        String sql = "UPDATE `articles` SET `title` = ? WHERE `id` = 2";
        PreparedStatement prST = getDbConection().prepareStatement(sql);
        prST.setString(1,title);
        prST.executeUpdate();
    }
    public void deleteSamsing()throws SQLException, ClassNotFoundException{
        String sql = "DELETE FROM `articles` WHERE `id` = 2";
        //String sql = "DROP TABLE `articles`;
        Statement statement = getDbConection().createStatement();
        statement.executeUpdate(sql);
    }

}
