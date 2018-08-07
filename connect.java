//Connection
import java.sql.*;
class connect
{
//whenever we declare a variable globally we need to first initialize 
	  Connection con=null;//type of con is Connection
	  public Connection fetchcon()//fetchcon is a method 
	{
	 try
		{
		//forName is a method which loads a class into Classloader(OracleDriver)
		Class.forName("oracle.jdbc.OracleDriver");
//for creating connection obj. OracleDriver is registered to Drivermanager and the through getconnection() connection is established.
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123456");
		}
	catch(Exception e)
	{}
	return con;
	}
}
		








 