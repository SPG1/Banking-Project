//SERVICES PROVIDED BY THE BANK
import java.io.*;
class Service
{
	public void menu()throws Exception
	{
		while(true)
		{
			System.out.println("1:Create a New Account");
			System.out.println("2:Deposit");
			System.out.println("3:Withdrawal");
			System.out.println("4:MiniStatement");
			System.out.println("5:Balance Enquiry");
			System.out.println("6:Change Password");
			System.out.println("7:View Account Details");
			System.out.println("8:Exit");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("ENTER YOUR CHOICE:");
		int choice=Integer.parseInt(br.readLine());
		UserAccount uc=new UserAccount();
		Transaction t=new Transaction();
		switch(choice)
		{
			case 1:
				uc.CreateAccount();
				break;
			case 2:
				t.Deposit();
				break;
			case 3:
				t.Withdrawal();
				break;
			case 4:
				t.Ministatement();
				break;
			case 5:
				t.balCheck();
				break;
			case 6:
				uc.Changepass();
				break;
			case 7:
				uc.AccDetails();
				break;
			case 8:
				System.exit(0);
				break;

			}
		}
			
	}
}
