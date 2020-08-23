package SQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BD {
    private final String HOST = "localhost";
    private final String Port = "3306";
    private final String DB = "java_bd";
    private final String Login = "root";
    private final String Pass = null;
    private Connection dbCon = null;
    List <String> list = new ArrayList<>();
    public List<String> getList(List list){
        return list;
    }

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
    public  void createOrder(String tableName) throws SQLException, ClassNotFoundException{
        String sql = "CREATE TABLE IF NOT EXISTS "+tableName
                +"(id INT AUTO_INCREMENT PRIMARY KEY, user_id int, item_id int)"+
                " ENGINE=MYISAM";

        Statement statement = getDbConection().createStatement();
        statement.executeUpdate(sql);
    }



    public void insertOrder(int id,int user_id, int  item_id) throws SQLException, ClassNotFoundException{
        String sql = "INSERT INTO  `orders` (id,user_id, item_id) VALUES (?,?,?)";
        PreparedStatement prSt = getDbConection().prepareStatement(sql);
        prSt.setInt(1,id);
        prSt.setInt(2,user_id);
        prSt.setInt(3,item_id);
        prSt.executeUpdate();
    }

    public  void createTable(String tableName) throws SQLException, ClassNotFoundException{
        String sql = "CREATE TABLE IF NOT EXISTS "+tableName
                +"(id INT AUTO_INCREMENT PRIMARY KEY, title VARCHAR(50), price int, category VARCHAR(50) )"+
                 " ENGINE=MYISAM";

        Statement statement = getDbConection().createStatement();
        statement.executeUpdate(sql);
    }
    public void insertItems1(String tittle, int prisse, String categoria)throws SQLException, ClassNotFoundException{
        String sql = "INSERT INTO `items1` (title, price, category) VALUES (?,?,?)";
        PreparedStatement prSt = getDbConection().prepareStatement(sql);
        prSt.setString(1,tittle);
        prSt.setInt(2,prisse);
        prSt.setString(3,categoria);

        prSt.executeUpdate();
    }

    public List getItems1(String table) throws SQLException, ClassNotFoundException{
        //String sql = "SELECT * FROM "+ table + " WHERE `id`<>1" ;
        String sql = "SELECT * FROM "+ table + " WHERE `category` LIKE '%hats%'" ;
        Statement statement = getDbConection().createStatement();
        ResultSet res = statement.executeQuery(sql);//vibiraem danie
        while (res.next()){
            list.add(res.getString("title"));
        }

        return list;
    }

    public void insertUsers(String login,String password)throws SQLException, ClassNotFoundException{
        String sql = "INSERT INTO `users` (login, password) VALUES (?,?)";
        PreparedStatement prSt = getDbConection().prepareStatement(sql);
        prSt.setString(1,login);
        prSt.setString(2,password);
        prSt.executeUpdate();
    }
    public String getUsers(String table) throws SQLException, ClassNotFoundException{
        //String sql = "SELECT * FROM "+ table + " WHERE `id`<>1" ;
        String sql = "SELECT * FROM "+ table + " WHERE `login` LIKE '%john%'" ;
        String nam = null;
        Statement statement = getDbConection().createStatement();
        ResultSet res = statement.executeQuery(sql);//vibiraem danie
        while (res.next()){
            nam = res.getString("login");
        }
        return nam;
    }
}
