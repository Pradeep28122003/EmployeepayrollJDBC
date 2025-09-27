 import java.sql.*;
import java.util.Scanner;

public class Updateemployeepay {
    public static void Update() throws Exception {
        String url = "jdbc:mysql://localhost:3306/payroll";
        String username = "root";
        String password = "Pradeep#003";
        String query = "select * from staff";

        try (
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE
            );
            ResultSet rs = st.executeQuery(query);
            Scanner sc = new Scanner(System.in)
        ) {
           
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine(); 

            System.out.print("Enter First Name: ");
            String fname = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine(); 

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

       
            rs.moveToInsertRow();
            rs.updateInt(1, id); 
            rs.updateString("First_name", fname);
            rs.updateDouble("salary", salary);
            rs.updateString("email", email);
            rs.insertRow();
            System.out.println(" Employee inserted successfully!");
            if (rs.first()) {
                System.out.print("Enter new email for first employee: ");
                String newEmail = sc.nextLine();
                rs.updateString("email", newEmail);
                rs.updateRow();
                System.out.println(" First employee's email updated!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        Update();
    }
}

