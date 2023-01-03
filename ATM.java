import java.util.*;
class BankAccount
{
	double balance;
	int Account;
	int prevT;
	String custnm;
	String custId;
	int flag=0;
	BankAccount()
	{
		
	}
	BankAccount(String a,String b)
	{
		custnm = a;
		custId = b;
	}
	void checkId()
	{
		System.out.println("Welcome "+custnm);
		System.out.println();
		System.out.println("Please Enter customer Id: ");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		if(s.equals(custId))
		{
			System.out.println("-----------------");
			System.out.println("Login Succesful....");
			System.out.println("-----------------");
		}
		else
		{
			System.out.println("-----------------");
			System.out.println("Login Failed");
			System.out.println("-----------------");
			if(flag<3)
			{
				flag++;
				checkId();
			}
		}
	}
	void deposite(int amt)
	{
		if(amt != 0)
		{
			balance = balance + amt;
			prevT = amt;
		}
	}
	void withdraw(int amt)
	{
		if(this.balance > amt)
		{
			balance = balance - amt;
			prevT = -amt;
		}
		else
		{
			System.out.println("--------------");
			System.out.println("Sufficient balance is not available...");
			System.out.println("--------------");
		}
	}
	void getPrevTransaction()
	{
		if(prevT>0)
		{
			System.out.println("Deposite: "+prevT);
		}
		else if(prevT<0)
		{
			System.out.println("withdraw: "+Math.abs(prevT));
		}
		else
		{
			System.out.println("No Transaction Occoured");
		}
	}
	public void transfer(double amt, BankAccount a)
	{
		if(this.balance < amt)
		{
			System.out.println("--------------");
			System.out.println("Transfer Failed due to insufficient balance");
		}
		else
		{
			this.balance -= amt;
			a.balance += amt;
			System.out.println("Account of "+ this.custnm +" becomes "+ this.balance+" Rs");
			System.out.println("Account of "+ a.custnm +" becomes "+ a.balance+" Rs");
			System.out.println("\n");
		}
	}
	public void showMenu()
	{
		int ch;
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome "+custnm);
		System.out.println("Your Id: "+custId);
		do 
		{
			System.out.println("\n");
			System.out.println("\n");
			System.out.println("1. Check Balance");
			System.out.println("2. Deposite");
			System.out.println("3. withdraw");
			System.out.println("4. Previous Transaction");
			System.out.println("5. Transfer");
			System.out.println("6. Exit");
			System.out.println("---------------");
			System.out.println("Enter your choice");
			System.out.println("---------------");
			ch = sc.nextInt();
			System.out.println("\n");
			switch(ch)
			{
				case 1:
					System.out.println("------------");
					System.out.println("Balance "+balance);
					System.out.println("------------");
					System.out.println("\n");
					break;
				case 2:
					System.out.println("-------------");
					System.out.println("Enter amount of deposite: ");
					System.out.println("-------------");
					int amt = sc.nextInt();
					deposite(amt);
					System.out.println("\n");
					break;
				case 3:
					System.out.println("------------");
					System.out.println("Enter amount of withdraw: ");
					System.out.println("------------");
					int amt1 = sc.nextInt();
					withdraw(amt1);
					System.out.println("\n");
					break;
				case 4:
					System.out.println("-----------");
					getPrevTransaction();
					System.out.println("-----------");
					System.out.println("\n");
					break;
				case 5:
					System.out.println("-----------");
					System.out.println("To Whome");
					BankAccount b = new BankAccount("abc","200");
					System.out.println(b.custnm);
					System.out.println("-----------");
					System.out.println("Amount Transfer");
					double am = sc.nextDouble();
					System.out.println("-----------");
					transfer(am,b);
					break;
				case 6:
					System.out.println("-----------");
					break;
				default:
					System.out.println("Invalid choice");
					break;
					
			}
		}while(ch!=6);
	}
}
class ATM
{
	public static void main(String args[])
	{
		BankAccount ob = new BankAccount("XYZ","100");
		ob.checkId();
	}
}