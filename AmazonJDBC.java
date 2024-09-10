package AmazonJDBCproject;

import java.sql.*;
import java.util.Scanner;

public class AmazonJDBC
{
    static Connection connection;
    public static void connectToDatabase() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
      connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/amazoncustomer","root","root");

    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        try {
            System.out.println("Welcome to Amazon Application");
            System.out.println("Are you 1)Existing Customer  2)New User");
            try (Scanner scan = new Scanner(System.in)) {
                int choice = scan.nextInt();
                connectToDatabase();
                switch (choice) {
                    case 1:
                        System.out.println("ENter User name");
                        String username1= scan.next();
                        System.out.println("ENter password");
                        String pw= scan.next();
                        Statement stmt=connection.createStatement();
                      ResultSet result= stmt.executeQuery("select username,password from customerinfo");
                      boolean login=false;
                      while(result.next())
                      {
                          if(result.getString("username").equalsIgnoreCase(username1)&&result.getString("password").equals(pw))
                          {
                                System.out.println(" Welcome "+ username1);
                                login=true;
                          }
                      }
                      if(login==false)
                      {
                          System.out.println("Invalid username or password");
                      }
                        break;
                    case 2:
                        System.out.println("ENter username name");
                        String username = scan.nextLine();
                        System.out.println("ENter first name");
                        String fn = scan.nextLine();
                        System.out.println("ENter Last name");
                        String ln = scan.nextLine();
                        System.out.println("ENter mobile number");
                        String mobile = scan.nextLine();
                        System.out.println("ENter Email ID");
                        String EmailID = scan.nextLine();
                        System.out.println("ENter Address");
                        String address = scan.nextLine();
                        System.out.println("ENter password");
                        String password = scan.nextLine();
                        Statement statement = connection.createStatement();
                        statement.executeUpdate("insert into customerinfo values('"+username+"','" + EmailID + "','" + fn + "','" + ln + "','" + mobile + "','" + address + "','" + password + "')");
                        break;
                    default:
                        System.out.println(" Sorry Invalid choice");
                }
            }
        }catch (Exception ex)
        {
            System.out.println(" Sorry Invalid choice");
        }
    }
}

