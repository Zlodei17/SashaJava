package NewSql;

import java.sql.*;

public class BazaDate {
    private final String HOST = "localhost";
    private final String Port = "3306";
    private final String DB = "java_bd";
    private final String Login = "root";
    private final String Pass = null;
    private Connection dbCon = null;
    //Podkluchaim bazu danix
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
    //sozdadim tablizu
    public  void createTable(String tableName) throws SQLException, ClassNotFoundException{
        String sql = "CREATE TABLE IF NOT EXISTS "+tableName
                +"(id INT AUTO_INCREMENT PRIMARY KEY, Prezzo VARCHAR(100), Nome VARCHAR(100))"+
                " ENGINE=MYISAM";

        Statement statement = getDbConection().createStatement();
        statement.executeUpdate(sql);
    }
    public  void insertTable(int prezzo, String nome) throws SQLException, ClassNotFoundException{
        String sql = "INSERT INTO `roba` (Prezzo, Nome) VALUES (?, ?)";
        PreparedStatement prST = getDbConection().prepareStatement(sql);
        prST.setInt(1,prezzo);
        prST.setString(2,nome);
        prST.executeUpdate();
    }
    public void getTable(String table) throws SQLException, ClassNotFoundException{
        //String sql = "SELECT * FROM "+ table + " WHERE `id`<>1" ;
        String sql = "SELECT * FROM "+ table + " WHERE `prezzo` LIKE '%50%' or `id`=1" ;

        Statement statement = getDbConection().createStatement();
        ResultSet res = statement.executeQuery(sql);//vibiraem danie
        while (res.next()){
            System.out.println(res.getString("prezzo"));
        }
    }

}
