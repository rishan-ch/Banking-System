public class BankCard//super class for DebitCard and CreditCard class
{
    private String ClientName;
    private String IssuerBank;
    private String BankAccount;
    private int BalanceAmount;
    private int CardId;
    
    //this is a constructor for BankCard class
    public BankCard(String BankAccount, String IssuerBank, int CardId,int BalanceAmount)
    {
        this.ClientName ="";//Client name is assigned with empty string at the beginning
        this.IssuerBank=IssuerBank;
        this.BalanceAmount=BalanceAmount;
        this.CardId=CardId;
        this.BankAccount=BankAccount;
    }
    
    //mutator methods 
    public void setClientName(String ClientName)//this method is for entering the name of the client
    {
        this.ClientName=ClientName;
    }
    public void setBalanceAmount(int BalanceAmount)//mutator method for changing the balance amount after transactioins
    {
        this.BalanceAmount=BalanceAmount;
    }
    
    //accesor methods wwith which child classes can get access to the private variables 
    public String getClientName()
    {
        return this.ClientName;
    }
    public String getIssuerBank()
    {
        return this.IssuerBank;
    }
    public String getBankAccount()
    {
        return this.BankAccount;
    }
    public int getBalanceAmount()
    {
        return this.BalanceAmount;
    }
    public int getCardId()
    {
        return this.CardId;
    }
    
    //for printing all the details of the client after verifying the client name is not empty
    public void display()
    {
        
        if (ClientName.equals (""))//incase the client name is empty
        {
            System.out.println("Please enter valid client name");
        }
        else
        {
            System.out.println( "Client Name = "+ClientName);
            System.out.println("Issuer Bank = "+IssuerBank);
            System.out.println("Bank Account = " + BankAccount);
            System.out.println("Card ID = "+CardId);
            System.out.println("Balance Amount = "+BalanceAmount);
        }
        
    }
} 