
import java.sql.*;
import java.util.Scanner;
public class Updateemployeepay{
public static void Update() throws Exception {
	    String url="jdbc:mysql://localhost:3306/payroll";
	    String username="root";
	    String password= "Pradeep#003";
        Connection con = DriverManager.getConnection(url, username, password);
        con.setAutoCommit(false);

        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Emp ID: ");
            int id = sc.nextInt();
            System.out.print("Enter Salary Amount to Process: ");
            double amt = sc.nextDouble();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT salary FROM staff WHERE emp_id=" + id);
            if (rs.next()) {
                double balance = rs.getDouble("salary") + amt;

                PreparedStatement pst = con.prepareStatement(
                        "INSERT INTO payslip(emp_id,amount,balance) VALUES(?,?,?)");
                pst.setInt(1, id);
                pst.setDouble(2, amt);
                pst.setDouble(3, balance);
                pst.executeUpdate();

                PreparedStatement up = con.prepareStatement("UPDATE staff SET salary=? WHERE emp_id=?");
                up.setDouble(1, balance);
                up.setInt(2, id);
                up.executeUpdate();

                con.commit();
                System.out.println("✅ Salary processed successfully!");
            } else {
                System.out.println("❌ staff  not found!");
                con.rollback();
            }
        } catch (Exception e) {
            con.rollback();
            e.printStackTrace();
        } finally {
            con.setAutoCommit(true);
            con.close();
        }
        }
 public static void main(String[]args)throws Exception {
	 Update();
 }
    }