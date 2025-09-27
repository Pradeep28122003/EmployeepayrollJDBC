import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
public class Metadata {
public static void main(String[]args) throws Exception {
	String url="jdbc:mysql://localhost:3306/payroll";
	String username="root";
	String password= "Pradeep#003";
	String Query="Select * from staff";
Connection con =DriverManager.getConnection(url, username, password);
Statement st=con.createStatement();
ResultSet rt=st.executeQuery(Query);
ResultSetMetaData rsmd=rt.getMetaData();
int columncount =rsmd.getColumnCount();
System.out.println("Number of columns:"+columncount);

for(int i=1;i<=columncount;i++) {
	System.out.println("column"+i+":"+rsmd.getColumnName(i)+"("+rsmd.getColumnTypeName(i)+")");
}

}
}
