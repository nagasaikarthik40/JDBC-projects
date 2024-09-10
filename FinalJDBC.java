package FinalJDBCproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.*;

public class FinalJDBC {
    
    public static void main(String[] args) throws Exception{
        //execute--------------------------------
        try {
            String url = "jdbc:mysql://localhost:3306/";

            String databaseName = "vit7";
            String userName = "root";
            String password = "root";
    
            Connection connection = DriverManager.getConnection(url,userName, password);
    
            String sql = "CREATE DATABASE " + databaseName;
    
            Statement statement = connection.createStatement();
            statement.execute(sql);
            statement.close();
            JOptionPane.showMessageDialog(null, databaseName + " Database has been created successfully", "System Message", JOptionPane.INFORMATION_MESSAGE);
    
        } catch (Exception e) {
            e.printStackTrace();
        }

        //executeupdate----------------------------

        try (Scanner sc = new Scanner(System.in)) {
            String name=sc.nextLine();
            int age= sc.nextInt();
            sc.nextLine();
            String city= sc.nextLine();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/shivam","root","root");
            Statement st= con.createStatement();
            // st.execute("create table shivudu(name varchar(20),age int,city varchar(20))");
            st.executeUpdate("insert into shivudu values('"+name+"',"+age+",'"+city+"')");

            //executeQuery-----------------------------

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/shivam","root","root");
            Statement sta=con.createStatement();
            ResultSet rs=st.executeQuery("select * from shivudu");
            String name1;
            int age1;
            String city1;
            while(rs.next()){
                name1 = rs.getString("name") ;
                age1=rs.getInt("age");
                city1= rs.getString("city");
                System.out.println(name1);
                System.out.println(age1);
                System.out.println(city1);
                System.out.println("---------------------------");
            }
            con.close();
        }

        



    }
}
