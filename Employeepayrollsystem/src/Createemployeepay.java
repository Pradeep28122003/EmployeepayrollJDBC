import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class Createemployeepay{
	public static void create() throws Exception {
		String url="jdbc:mysql://localhost:3306/payroll";
		String username="root";
		String password="Pradeep#003";
		String query="insert into employee values( ?,?)";
		Connection con=DriverManager.getConnection(url, username, password);
		PreparedStatement pst=con.prepareStatement(query);
		pst.setInt(1, 103);
		pst.setString(2, "ragul");
		pst.executeUpdate();
		con.close();
	}
	public static void main(String[]args) throws Exception{
		create();
	}

}
