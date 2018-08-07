//T*R*A*N*S*A*C*T*I*O*N
import java.io.*;
import java.sql.*;
class Transaction
{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//*********************DEPOSIT*********************
	void Deposit()throws Exception
	{
		System.out.println("Enter Accno to Deposit:");
		int accno=Integer.parseInt(br.readLine());
		System.out.println("Enter the Amount to Deposit:");
		double damt=Double.parseDouble(br.readLine());
		connect c=new connect();
		Connection con=c.fetchcon();
		Statement stmt=con.createStatement();
		String q1="select tid,balance from Bank_Transaction where accno="+accno+" and tid=(select max(tid) from Bank_transaction where accno="+accno+")";
		ResultSet rs=stmt.executeQuery(q1);
		int tid=0;
		double balance=0;
		if(rs.next())
		{	
			tid=rs.getInt(1);
			balance=rs.getDouble(2);
		}
		tid=tid+1;
		double wamt=0;
		java.util.Date st=new java.util.Date();
		String dt1=String.valueOf(st);
		balance=balance+damt;
		String q2="insert into Bank_Transaction values("+tid+","+accno+","+damt+","+wamt+",'"+st+"',"+balance+")";
		int t=stmt.executeUpdate(q2);
		if(t>0)
			System.out.println("DEPOSITED SUCCESSFULLY");
		con.close();
	}
//*********************WITHDRAWAL***************************************
void Withdrawal()throws Exception
{
	System.out.println("Enter Accno to Withdraw:");
		int accno=Integer.parseInt(br.readLine());
		System.out.println("Enter the Amount to Withdraw:");
		double wamt=Double.parseDouble(br.readLine());
		connect c=new connect();
		Connection con=c.fetchcon();
		Statement stmt=con.createStatement();
		String q1="select tid,balance from Bank_Transaction where accno="+accno+" and tid=(select max(tid) from Bank_transaction where accno="+accno				+")";
		ResultSet rs=stmt.executeQuery(q1);
		int tid=0;
		double balance=0;
		if(rs.next())
		{	
			tid=rs.getInt(1);
			balance=rs.getDouble(2);
		}
		tid=tid+1;
		if(balance-wamt>500)
		{
			double damt=0;
			java.util.Date dt=new java.util.Date();
			String dt1=String.valueOf(dt);
			balance=balance-wamt;
			String q2="insert into Bank_Transaction values("+tid+","+accno+","+damt+","+wamt+",'"+dt+"',"+balance+")";
			int t=stmt.executeUpdate(q2);
			if(t>0)
				System.out.println("DEBITED SUCCESSFULLY");
			else
				System.out.println("INSUFFICIENT BALANCE");
		}
		con.close();

}
//*************************MINISTATEMENT***************************************
void Ministatement()throws Exception
{
	System.out.println("Enter the AccountNO:");
	int accno=Integer.parseInt(br.readLine());
	connect c=new connect();
	Connection con=c.fetchcon();
	Statement stmt=con.createStatement();
	System.out.println("Tid\tAccno\t damt\t wamt\tdate\t\t\t\tBalance");
	String q1="select * from Bank_Transaction where accno="+accno;
	ResultSet rs=stmt.executeQuery(q1);
	while(rs.next())
	{
		System.out.println(rs.getInt(1)+"\t"+rs.getInt(2)+"\t"+rs.getDouble(3)+"\t"+rs.getDouble(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6));
	}
	con.close();
}

//************************BALANCE CHECK********************************
void balCheck()throws Exception
{
	System.out.println("Enter the AccountNO:");
	int accno=Integer.parseInt(br.readLine());
	connect c=new connect();
	Connection con=c.fetchcon();
	Statement stmt=con.createStatement();
	//System.out.println("Tid \t Accno \t damt \t wamt \t date\t\t\t Balance");
	String q1="select tid, balance from Bank_Transaction where accno="+accno+" and tid=(select max(tid) from Bank_transaction where accno="+accno+")";
	double balance=0;
	ResultSet rs=stmt.executeQuery(q1);
	if(rs.next())
	balance=rs.getDouble(2);
	System.out.println("your avaiable bal. is Rs"+balance+"");
	con.close();
}
}
	
	

	



























		
	