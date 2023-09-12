public class DebitCard extends BankCard//child class of BankCard for inheriting certain properties parent class
{
    
   private int PINnumber;
   private int WithdrawalAmount;
   private String dateOfWithdrawal;
   private boolean hasWithdrawn;
   
   //this is a constructor for child class DebitCard 
   public DebitCard(int BalanceAmount,int CardId, String BankAccount, String IssuerBank, String ClientName,int PINnumber)
   {
       super(BankAccount, IssuerBank, CardId, BalanceAmount);//calling the constructor of superclass with parameters
       setClientName(ClientName);//values being assigned respectively
       this.PINnumber = PINnumber;
       this.hasWithdrawn = false;
   }
   
   //using mutator/setter method for setting withdrawal amount through other classes as well 
   public void setWithdrawalAmount(int WithdrawalAmount)
   {
        this.WithdrawalAmount=WithdrawalAmount;    
   }
   
   //Accessor methods so that other classes can get access to private variables of this class
   public int getPINnumber()
   {
       return this.PINnumber;
   }
   public int getWithdrawlAmount()
   {
       return this.WithdrawalAmount;
   }
   public String getdateOfWithdrawal()
   {
       return this.dateOfWithdrawal;
   }
   public boolean gethasWithdrawn()
   {
       return this.hasWithdrawn;
   }
   
   //this method is for making withdrawals
   public void withdraw(int WithdrawalAmount, String dateOfWithdrawal, int PINnumber) 
   {
        if ( this.PINnumber==PINnumber)
        {
            if(getBalanceAmount() >= WithdrawalAmount)
            {
                System.out.println("Previous balance = " + getBalanceAmount());
                System.out.println("Withdraw Amount = "+WithdrawalAmount);
                //following setter method is called from parent class for changing the amount of balance after transaction is done 
                setBalanceAmount(getBalanceAmount()-WithdrawalAmount);
                System.out.println("Remaining Balance = "+getBalanceAmount());
                System.out.println("Transaction succesful!");
                hasWithdrawn=true;
                this.dateOfWithdrawal=dateOfWithdrawal;
                this.WithdrawalAmount=WithdrawalAmount;
            }
            
            else//incase the pin is correct but there is no enough balance amount
            {
                System.out.println("Current Balance = "+getBalanceAmount());
                System.out.println("Not enough Bank balance");
            }
            
        } 
        
        else//incase of wrong pin 
        {
            System.out.println("Wrong PIN detected.");
        } 
        
   }
   
   //display method for displaying the details of debit card
   public void display()
   {
       if (hasWithdrawn)
       {
           super.display();
           System.out.println("PIN number = "+PINnumber);
           System.out.println("Amount Withdrawn = "+WithdrawalAmount);
           System.out.println("Date of withdrawal = "+dateOfWithdrawal);
       }
       else
       {
           super.display();
       }
   }
}