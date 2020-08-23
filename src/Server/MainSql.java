package Server;

import SQL.BD;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainSql {
    public static void main(String[] args) {
        BD bd = new BD();
        List<String> list = new ArrayList<>();
        try {

            String logo = bd.getUsers("users");
            System.out.println("Vse zakazi");


           list = bd.getList(bd.getItems1("items1"));
            System.out.println(logo +" - "+ list.get(0));
            System.out.println(logo +" - "+ list.get(1));
            for(String opa: list){

                System.out.println(logo +" - "+ opa);
            }
            bd.insertOrder(1,4,6);
            //bd.createOrder("Orderfull");
            //bd.insertItems1("Футболка Рик и Морти", 700,"shirts");
            //bd.getUsers("users");
            //bd.insertUsers("alex", "somme_pass");
            //bd.createTable("Items1");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
