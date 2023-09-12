public class CreditCard extends BankCard//child class of BankCard
{
    
    private int CVCnumber;
    private double CreditLimit;
    private double InterestRate;
    private String ExpirationDate;
    private int GracePeriod;
    private boolean isGranted;
    
    //this is a constructor for CreditCard class
    public CreditCard (int CardId, String ClientName, String IssuerBank, String BankAccount, int BalanceAmount, int CVCnumber, double InterestRate,String ExpirationDate) 
    {
        super (BankAccount, IssuerBank, CardId, BalanceAmount);//calling the parent class constructor
        super.setClientName(ClientName);
        this.CVCnumber=CVCnumber;
        this.InterestRate=InterestRate;
        this.ExpirationDate=ExpirationDate;
        isGranted=false;
    }
    
    //accessor methods so that private variable's access can be gained through other classes
    public int getCVCnumber()
    {
        return this.CVCnumber;
    }
    public double getCreditLimit()
    {
        return this.CreditLimit;
    } 
    public double getInterestRate()
    {
        return this.InterestRate;
    } 
    public String getExpirationDate()
    {
        return this.ExpirationDate;
    } 
    public int getGracePeriod()
    {
        return this.GracePeriod;
    } 
    public boolean getisGranted()
    {
        return this.isGranted;
    }
    
    //mutator method for checking if the credit can be granted or not
    public void setCreditLimit (double CreditLimit, int GracePeriod)
    {
        
        if (CreditLimit<=2.5*getBalanceAmount ())
        {
            isGranted=true;
            this.CreditLimit=CreditLimit;
            this.GracePeriod=GracePeriod;
        }
        else
        {
            System.out.println ("The credit can't be issued as you have reached your credit limit. For more information please contact the Bank.");
        }
        
    }
    
    //method for cancelling credit card
    public void cancelCreditCard ()
    {
        
        CVCnumber=0;
        CreditLimit=0;
        GracePeriod=0;
        isGranted=false;
        
    }
    
    //display method for viewing details of credit card
    public void display ()
    {
        
        if (isGranted)
        {
            super.display();
            System.out.println("Credit Limit = "+ CreditLimit);
            System.out.println("GracePeriod = "+GracePeriod);
            System.out.println("CVC number = "+CVCnumber);
            System.out.println("Expiration date = "+ExpirationDate);
            System.out.println("Interest rate = "+InterestRate);
        }
        else
        {
            super.display();
            System.out.println("Credit Card hasn't been granted");
            //since the credit card isnt granted no details of credit limit will be valid
        }
        
    }
}