 import java.sql.*;


public class Updateemployeepay{
public static void Update() throws Exception {
	String url="jdbc:mysql://localhost:3306/payroll";
	String username="root";
	String password="Pradeep#003";
	String query="select * from staff";
        try (  
        		
        		
        		Connection con = DriverManager.getConnection(url, username, password)) {
            try (Statement st = con.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE)) {

                ResultSet rs = st.executeQuery(query);

                rs.moveToInsertRow();
                rs.updateString("First_name", "kumar");
                rs.updateDouble("salary", 10000);
                rs.updateString("email", "pradeep23@gmail.com");
                rs.insertRow();
                System.out.println("Inserted new employee:");

                if (rs.first()) {
                    rs.updateString("email", "kumar23@company.com");
                    rs.updateRow();
                    System.out.println("Updated email :");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
}

  public static void main(String[]args) throws Exception{
	  Update();
  
    }
}
