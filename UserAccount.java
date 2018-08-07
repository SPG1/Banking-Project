//USER ACCOUNT
import java.io.*;
import java.sql.*;
class UserAccount
{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//*******************CREATE A NEW ACCOUNT******************************************************
	public void CreateAccount()throws Exception
	{
		int accno=0;
		connect c=new connect();
		Connection con=c.fetchcon();
		Statement stmt=con.createStatement();
		String q1="select max(accno)from bank_user";
		ResultSet rs=stmt.executeQuery(q1);
		if(rs.next())
			accno=rs.getInt(1);
			accno=accno+1;
			System.out.println("NEW ACCOUNT NUMBER IS: " +accno);
			System.out.println("Enter Name:");
			String name=br.readLine();
			System.out.println("Enter Address :");
			String addr=br.readLine();
			System.out.println("Enter Phone no:");
			String phno=br.readLine();
			System.out.println("Enter Aadhaar Id:");
			String aid=br.readLine();
			System.out.println("Enter Date of birth:");
			String dob=br.readLine();
			System.out.println("Enter Email Id:");
			String email=br.readLine();
			System.out.println("Enter Opening balance:");
			double oppbal=Double.parseDouble(br.readLine());
		String q2="insert into bank_user values("+accno+",'"+name+"','"+addr+"','"+phno+"','"+aid+"','"+dob+"','"+email+"')";
		int t=stmt.executeUpdate(q2);
		int tid=1;
		double damt=oppbal;
		double wamt=0;
		java.util.Date dt=new java.util.Date();
		String dt1=String.valueOf(dt);
		double balance=oppbal;
		String q3="insert into bank_transaction values("+tid+","+accno+","+damt+","+wamt+",'"+dt+"',"+balance+")";
		int t1=stmt.executeUpdate(q3);
		if(t>0&&t1>0)
		{
		System.out.println("Account Created SuccessFully:");
		con.close();
		}
		}
//********************************ACCOUNT DETAILS**********************************

	public void AccDetails()throws Exception
	{
		System.out.println("Enter Account Number:");
		int accno=Integer.parseInt(br.readLine());
		connect c=new connect();
		Connection con=c.fetchcon();
		Statement stmt=con.createStatement();
		String q1="select *from bank_user where accno="+accno;
		ResultSet rs=stmt.executeQuery(q1);
		if(rs.next())
		{
			System.out.println("Accno.:"+rs.getInt(1));
			System.out.println(" NAME: "+rs.getString(2)+"\n ADDRESS: "+rs.getString(3)+"\n PHNO: "+rs.getString(4)+"\n AADHAAR-ID: "+rs.getString(5)+"\n DOB: "+rs.getString(6)+"\n EMAIL-ID: "+rs.getString(7));
	
		}
		else
			System.out.println("Invalid Account");
			con.close();
	}	
//*****************************CHANGE PASSWORD***************************************
void Changepass()throws Exception
{
	System.out.println("Enter the UserId:");
	String uid=br.readLine();
	System.out.println("Enter Old Password:");
	String opass=br.readLine();
	System.out.println("Enter the new Password:");
	String npass=br.readLine();
	connect c=new connect();
	Connection con=c.fetchcon();
	Statement stmt=con.createStatement();
	String q1="update Bank_Authentication set Password='"+npass+"'where UserId='"+uid+"' and Password='"+opass+"'";
	int t=stmt.executeUpdate(q1);
	if(t>0)
	System.out.println("Password UpDated Successfully:");
	con.close();
}
}
		





















		