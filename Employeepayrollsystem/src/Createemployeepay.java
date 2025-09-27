import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Createemployeepay {
    public static void create()throws Exception {
        String url = "jdbc:mysql://localhost:3306/payroll";
        String username = "root";
        String password = "Pradeep#003";
        String query = "insert  into staff values(?, ?,?,?,?,?)";
        Connection con=DriverManager.getConnection(url, username, password);
    	PreparedStatement pst=con.prepareStatement(query);
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter Staff ID: ");
            int id = sc.nextInt();
            sc.nextLine(); 

            System.out.print("Enter Staff First_Name: ");
            String first_name = sc.nextLine();
            
            System.out.print("Enter Staff last_Name: ");
            String last_name = sc.nextLine();
            
            System.out.print("Enter Email: ");
            String email = sc.nextLine();
            System.out.print("Enter Department: ");
            String department= sc.nextLine();
            System.out.print("Enter Salary: ");
            Double salary= sc.nextDouble();

      
            pst.setInt(1, id);
            pst.setString(2, first_name);
            pst.setString(3, last_name);
            pst.setString(4, email);
            pst.setString(5, department);
            pst.setDouble(6,salary);
            
            int rows = pst.executeUpdate();
            System.out.println(rows + " row(s) inserted successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            con.close();
             
            }
        }

    public static void main(String[] args)throws Exception {
        create();
    }
}
