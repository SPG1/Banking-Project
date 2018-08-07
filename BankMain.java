//Main class
import java.io.*;
class BankMain
{
	public static void main(String[] args)throws Exception
	{
		Authentication aut=new Authentication();
		int t=aut.ValidateUser();
		if(t==1)
		{
			System.out.println("*****WELCOME TO BANK MENU*****");
			Service s=new Service();
			s.menu();
		}
		else
		System.out.println("Invalid User");
	}
}