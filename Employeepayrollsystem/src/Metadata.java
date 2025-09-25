import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
public class Metadata {
public static void main(String[]args) throws Exception {
	String url="jdbc:mysql://localhost:3306/payroll";
	String username="root";
	String password= "Pradeep#003";
Connection con =DriverManager.getConnection(url, username, password);
DatabaseMetaData dbm=con.getMetaData();
    ResultSet rs = dbm.getColumns(null, null, "staff", null);

    System.out.println(" staff Table");
    while (rs.next()) {
        System.out.println(rs.getString("COLUMN_NAME") +
        		":"+rs.getString("TYPE_NAME")+"");
    }
    con.close();
}


} 
