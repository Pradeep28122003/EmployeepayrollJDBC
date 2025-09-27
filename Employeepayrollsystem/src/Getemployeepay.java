import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.*;
public class Getemployeepay {
	public static void get() throws Exception {
		String url="jdbc:mysql://localhost:3306/payroll";
		String username="root";
		String password="Pradeep#003";
		Connection con=DriverManager.getConnection(url, username, password);
		Statement st=con.createStatement(
		     ResultSet.TYPE_SCROLL_INSENSITIVE,
		     ResultSet.CONCUR_UPDATABLE
		     
		); 
		{
            String query = "SELECT emp_id, first_name, last_name, email FROM staff";
            try (ResultSet rs = st.executeQuery(query)) {
                System.out.println("Updating Email for first record");
                if (rs.first()) { 
                    rs.updateString("email", "pradeep2003@gmail.com");
                    rs.updateRow();
                    System.out.println("Email updated for the first employee:");
                }

                System.out.println(" Inserting a new employee");
                rs.moveToInsertRow();
                rs.updateInt("emp_id", 3);
                rs.updateString("first_name", "Joe");
                rs.updateString("last_name", "Don");
                rs.updateString("email", "john.don@gmail.com");
                rs.insertRow();
                System.out.println("New employee inserted via ResultSet.");

                rs.beforeFirst(); 
                System.out.println(" Updated Employee List ");
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("emp_id") + ", Email: " + rs.getString("email"));
                }
            }
            }
	}
public static void main(String[]args)throws Exception {
	get();
}}
