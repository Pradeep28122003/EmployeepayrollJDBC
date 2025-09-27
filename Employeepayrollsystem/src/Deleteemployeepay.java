import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class Deleteemployeepay {

public static void deleteEmployee() {
	String url="jdbc:mysql://localhost:3306/payroll";
	String username="root";
	String password= "Pradeep#003";
    try (Connection con = DriverManager.getConnection(url, username, password);
         Scanner sc = new Scanner(System.in)) {

        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM staff WHERE emp_id=?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id);
            int rows = pst.executeUpdate();
            System.out.println(rows + " Employee deleted.");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}