//Authentication
import java.io.*;//for taking inputs at runtime
import java.sql.*;//for Query
class Authentication
{
	//BufferedReader is a perdefined class used to take runtime input.
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public int ValidateUser()//A function created of Int type.
	{
		int t=0;//initially transaction(t)=0;
		try
		{
			System.out.println("Enter UserId:");
			String Userid=br.readLine();//readLine() is used to all inputs except characters

			System.out.println("Enter PASSWORD:");
			String Password=br.readLine();

			connect c=new connect();
			Connection con=c.fetchcon();

			Statement stmt=con.createStatement();

		String q1="select*from Bank_Authentication where UserId='"+Userid+"'and Password='"+Password+"'";
		ResultSet rs=stmt.executeQuery(q1);

		if(rs.next())
		t=1;
		con.close();
		}
		catch(Exception e)
		{}
		return t;
	}
} 
//AFTER EXECUTION ONLY CASE SENSITIVE IS THE PASSWORD AND USERID IN TERMS OF CASES THAT IS UPPER OR LOWER:)