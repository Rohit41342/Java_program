import java.util.Scanner;
class Account  
{
int bal;
Account(int b)
{
 bal=b;
}
public boolean isSufficientBal(int withdrawmoney)
{
    if(bal>=withdrawmoney)
    {
        return true;
    }
    else{
        return false;
    }
}
void withdraw(int withdrawmoney)
{
 bal=bal-withdrawmoney;
 System.out.println("Withdrawal Sucessful");
 System.out.println("Available Bal is :"+bal);
}
    
}
class Customer implements Runnable  
{
    Account h1;
    String name;
    Customer(Account g1,String s1)
    {
        h1=g1;
        name=s1;

    }
    public void run()
    {
        synchronized(h1)
        { 
            Scanner s1=new Scanner(System.in);
            System.out.println(name+" Enter your amount : ");
            int amt=s1.nextInt();
            if(h1.isSufficientBal(amt))
            {
              System.out.println(name+" ");
              h1.withdraw(amt);
            }
            else
            {
                System.out.println(name+" Insufficient Balance");
            }
        }
    }

    
}
public class Sycronizemultithreading {

    public static void main(String[] args) 
    {
     Account a1=new Account(5000);
     Customer c1=new Customer(a1, "Rohit");
     Customer c2=new Customer(a1, "Ketan");  
     Thread t1=new Thread(c1);
     Thread t2=new Thread(c2);
     t1.start();
     t2.start();       
    }
    
}
