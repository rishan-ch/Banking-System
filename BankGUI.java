//importing packages for creating a gui and arraylist
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.*;


/*
    GUI SUMMARY
    The components are added to three different frames respecctively
    MainFrame contains all the components for adding debit card, credit card and the buttons to open three new frames
    They can be switched with buttons
    With this procedure we can group the related elements with eachother and make it much easier to review the code
   
    MULTIPLE FRAMES CONCEPT
    When we run main method only MainFrame is dispalyed
    Other frames for making withdrawal, granting and canceling credit card have false visibility
    when respective button present in MainFrame is clicked the frames for similar operation is opened
    
    USE OF BOOLEAN
    in actionPerformed() method, boolean is used in most of the else if 
    this is done in order to check if the there were any objects present in the arraylist of respective class
    it is required when we have a code outside the iterator
    */
public class BankGUI implements ActionListener
{
    //declaring every elements as a global variable inorder to access them in another methods
    private JFrame MainFrame ,Frame1 ,Frame2 ,Frame3;
    private JLabel line1, Footer, MainTitle,SubTitle1,SubTitle2,DrFrameTitle ,CrFrameTitle,CancelCrFrameTitle, PINDr, CompName, CardID, CardIDDr, CardIDCr,CardIDCancel, ClientName, IssuerBank, BankAcc, BalanceAm, PIN, WithdrawalAm, CVCnum, CreditLimit, InterestRate, GracePeriod, WithdrawalDate, ExpirationDate;
    private JTextField PINtxtDr, CardIDtxt, CardIDtxtDr, CardIDtxtCr, CardIDCanceltxt, ClientNametxt, IssuerBanktxt, BankAcctxt, BalanceAmtxt, PINtxt, WithdrawalAmtxt, CVCnumtxt, CreditLimittxt, InterestRatetxt, GracePeriodtxt;
    private JComboBox<String> WithdrawalYearCBX,WithdrawalMonthCBX,WithdrawalDayCBX, ExpirationYearCBX, ExpirationMonthCBX, ExpirationDayCBX;
    private JButton PrmCancelCredit, AddDbtCard, AddCrdtCard, WithdrawDbtCard, SetCrdtLimit, CancelCrdtCard, DisplayDr, DisplayCr, Clear, Withdraw, SetCredit;
    
    
    //Arraylist to add debit and crdit card object
    ArrayList<BankCard> BankCardAL = new ArrayList<BankCard>(); 
    
    //constructor for creating gui 
    public BankGUI()
    {
        //creating frames for respective operations
        MainFrame = new JFrame();
        Frame1 = new JFrame("Make a Withdrawal");
        Frame2 = new JFrame("Set Credit Limit");
        Frame3 = new JFrame("Cancel Credit Card");
        
        
        //labels, textfield and comboboxes
        CompName = new JLabel("ING Bank Pvt. Ltd.");
        CompName.setFont(new Font("Monospaced",Font.BOLD,40));
        CompName.setBounds(250,30,800,50);
        
        //add debit/credit card section
        MainTitle = new JLabel("Add Debit/Credit Card");
        MainTitle.setFont(new Font("Arial",Font.BOLD,20));
        MainTitle.setBounds(350,115,230,20);
        
        //first row
        CardID = new JLabel("*Card ID:");
        CardID.setBounds(40,145,70,20);
        CardIDtxt = new JTextField();
        CardIDtxt.setBounds(50,165,220,30);
        ClientName = new JLabel("*Client Name:");
        ClientName.setBounds(653,145,100,20);
        ClientNametxt = new JTextField();
        ClientNametxt.setBounds(663,165,220,30);
        
        //second row 
        BalanceAm = new JLabel("*Balance Amount:");
        BalanceAm.setBounds(40,210,150,20);
        BalanceAmtxt = new JTextField();
        BalanceAmtxt.setBounds(50,230,220,30);
        BankAcc = new JLabel("*Bank Account:");
        BankAcc.setBounds(340,210,100,20);
        BankAcctxt = new JTextField();
        BankAcctxt.setBounds(350,230,220,30);
        IssuerBank = new JLabel("*Issuer Bank:");
        IssuerBank.setBounds(653,210,100,20);
        IssuerBanktxt = new JTextField();
        IssuerBanktxt.setBounds(663,230,220,30);
        
        
        //debit card section
        SubTitle1 = new JLabel("For debit card only!!");
        SubTitle1.setFont(new Font("Arial",Font.BOLD,20));
        SubTitle1.setBounds(70,300,200,20);
        PIN = new JLabel("PIN:");
        PIN.setBounds(40,330,70,20);
        PINtxt = new JTextField();
        PINtxt.setBounds(50,350,220,30);
        AddDbtCard = new JButton("Add Debit Card");
        AddDbtCard.setBounds(80,410,150,30);
        AddDbtCard.addActionListener(this);
        AddDbtCard.setFont(new Font("Arial",Font.BOLD,15));
        
        DisplayDr = new JButton("Display");
        DisplayDr.setBounds(80,450,150,30);
        DisplayDr.addActionListener(this);
        DisplayDr.setFont(new Font("Arial",Font.BOLD,15));
        
        
        //Credit card section
        SubTitle2 = new JLabel("For credit card only!!");
        SubTitle2.setFont(new Font("Arial",Font.BOLD,20));
        SubTitle2.setBounds(470,300,200,20);
        CVCnum = new JLabel(" CVC number:");
        CVCnum.setBounds(653,330,100,20);
        CVCnumtxt = new JTextField();
        CVCnumtxt.setBounds(663,350,220,30);
        InterestRate = new JLabel("Interest Rate:");
        InterestRate.setBounds(340,330,100,20);
        InterestRatetxt = new JTextField();
        InterestRatetxt.setBounds(350,350,220,30);
        ExpirationDate = new JLabel("Expiration Date:");
        ExpirationDate.setBounds(340,390,100,20);
        String ExpYear[]={"2020","2021","2022","2023"};
        ExpirationYearCBX = new JComboBox<String>(ExpYear);
        ExpirationYearCBX.setBounds(350,410,70,30);
        String ExpMonth[]={"01","02","03","04","05","06","07","08","09","10","11","12"};
        ExpirationMonthCBX = new JComboBox<String>(ExpMonth);
        ExpirationMonthCBX.setBounds(425,410,70,30);
        String ExpDay[]={"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20"
                            ,"21","22","23","24","25","26","27","28","29","30"};
        ExpirationDayCBX = new JComboBox<String>(ExpDay);
        ExpirationDayCBX.setBounds(500,410,70,30);
        AddCrdtCard = new JButton("Add Credit Card");
        AddCrdtCard.setBounds(703,410,150,30);
        AddCrdtCard.setFont(new Font("Arial",Font.BOLD,15));
        AddCrdtCard.addActionListener(this);
        DisplayCr = new JButton("Display");
        DisplayCr.setBounds(703,450,150,30);
        DisplayCr.addActionListener(this);
        DisplayCr.setFont(new Font("Arial",Font.BOLD,15));
        
        Clear = new JButton("Clear");
        Clear.setBounds(410,480,100,40);
        Clear.addActionListener(this);
        Clear.setFont(new Font("Arial",Font.BOLD,15));
        
        //line1 jlabel is to create a division between the form and other buttons that open up new frame
        line1= new JLabel("-------------------------------------------------------------------------------------------" +
                          "-------------------------------------------------------------------------------------------" +
                          "---------------------------------------------------");
        line1.setBounds(1,550,950,10);
        
        //Buttons
        Withdraw = new JButton("Withdraw Money");
        Withdraw.setBounds(220,590,150,30);
        Withdraw.addActionListener(this);
        Withdraw.setFont(new Font("Arial",Font.BOLD,15));
        SetCredit = new JButton("Set Credit Limit");
        SetCredit.setBounds(400,590,150,30);
        SetCredit.addActionListener(this);
        SetCredit.setFont(new Font("Arial",Font.BOLD,15));
        PrmCancelCredit = new JButton("Cancel Credit Card");
        PrmCancelCredit.setBounds(580,590,170,30);
        PrmCancelCredit.addActionListener(this);
        PrmCancelCredit.setFont(new Font("Arial",Font.BOLD,15));
        
        Footer = new JLabel("'*' marked components are needed to be filled for adding both debit and credit card.");
        Footer.setFont(new Font("Arial",Font.ITALIC,15));
        Footer.setBounds(20,640,800,20);
        
        //these component are for withdrawal process
        //frame size 530*400
        DrFrameTitle = new JLabel("Withdrawal Section");
        DrFrameTitle.setBounds(150,40,300,20);
        DrFrameTitle.setFont(new Font("Arial",Font.BOLD,20));
        CardIDDr = new JLabel("Card ID:");
        CardIDDr.setBounds(20,110,80,20);
        CardIDtxtDr = new JTextField();
        CardIDtxtDr.setBounds(30,130,200,30);
        WithdrawalDate = new JLabel("Withdrawal Date:");
        WithdrawalDate.setBounds(270,110,120,20);
        String WthdrwYear[]={"2020","2021","2023","2024"};
        WithdrawalYearCBX =new JComboBox<String>(WthdrwYear);
        WithdrawalYearCBX.setBounds(280,130,66,30);
        String WthdrwMonth[]={"01","02","03","04","05","06","07","08","09","10","11","12"};
        WithdrawalMonthCBX =new JComboBox<String>(WthdrwMonth);
        WithdrawalMonthCBX.setBounds(356,130,50,30);
        String WthdrwDay[]={"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20"
                            ,"21","22","23","24","25","26","27","28","29","30"};
        WithdrawalDayCBX =new JComboBox<String>(WthdrwDay);
        WithdrawalDayCBX.setBounds(422,130,50,30);
        
        WithdrawalAm = new JLabel("Withdrawal Amount:");
        WithdrawalAm.setBounds(20,190,120,20);
        WithdrawalAmtxt = new JTextField();
        WithdrawalAmtxt.setBounds(30,210,200,30);
        PINDr = new JLabel("PIN:");
        PINDr.setBounds(270,190,80,20);
        PINtxtDr = new JTextField();
        PINtxtDr.setBounds(280,210,200,30);
        WithdrawDbtCard = new JButton("Withdraw");
        WithdrawDbtCard.setBounds(190,270,150,30);
        WithdrawDbtCard.addActionListener(this);
        WithdrawDbtCard.setFont(new Font("Arial",Font.BOLD,15));
        
        
        //these component are for credit card's use
        //frame size 530*400
        CrFrameTitle = new JLabel("Set Credit Limit");
        CrFrameTitle.setBounds(150,40,250,20);
        CrFrameTitle.setFont(new Font("Arial",Font.BOLD,20));
        CardIDCr = new JLabel("Card ID:");
        CardIDCr.setBounds(170,110,80,20);
        CardIDtxtCr = new JTextField();
        CardIDtxtCr.setBounds(180,130,200,30);
        GracePeriod = new JLabel("Grace period:");
        GracePeriod.setBounds(20,190,120,20);
        GracePeriodtxt = new JTextField();
        GracePeriodtxt.setBounds(30,210,200,30);
        CreditLimit = new JLabel("Credit Limit:");
        CreditLimit.setBounds(270,190,80,20);
        CreditLimittxt = new JTextField();
        CreditLimittxt.setBounds(280,210,200,30);
        SetCrdtLimit = new JButton("Set Credit Limit");
        SetCrdtLimit.setBounds(180,290,150,30);
        SetCrdtLimit.addActionListener(this);
        SetCrdtLimit.setFont(new Font("Arial",Font.BOLD,15));
        
        
        //Cancel Credit card
        //Frame size 300*250
        CancelCrFrameTitle = new JLabel("Cancel Credit Card");
        CancelCrFrameTitle.setFont(new Font("Arial",Font.BOLD,20));
        CancelCrFrameTitle.setBounds(50,30,290,20);
        CardIDCancel = new JLabel("Card ID");
        CardIDCancel.setBounds(35,80,150,20);
        CardIDCanceltxt = new JTextField();
        CardIDCanceltxt.setBounds(45,100,200,30);
        CancelCrdtCard = new JButton("Cancel Credit Card");
        CancelCrdtCard.setBounds(70,150,150,30);
        CancelCrdtCard.addActionListener(this);        
        CancelCrdtCard.setFont(new Font("Arial",Font.BOLD,12));
        
        //adding colors to frames and buttons
        MainFrame.getContentPane().setBackground(Color.orange);
        Frame1.getContentPane().setBackground(Color.orange);
        Frame2.getContentPane().setBackground(Color.orange);
        Frame3.getContentPane().setBackground(Color.orange);
        AddDbtCard.setBackground(Color.LIGHT_GRAY);
        PrmCancelCredit.setBackground(Color.LIGHT_GRAY);
        AddCrdtCard.setBackground(Color.LIGHT_GRAY);
        WithdrawDbtCard.setBackground(Color.LIGHT_GRAY);
        SetCrdtLimit.setBackground(Color.LIGHT_GRAY);
        CancelCrdtCard.setBackground(Color.LIGHT_GRAY);
        DisplayDr.setBackground(Color.LIGHT_GRAY);
        DisplayCr.setBackground(Color.LIGHT_GRAY);
        Clear.setBackground(Color.LIGHT_GRAY);
        Withdraw.setBackground(Color.LIGHT_GRAY);
        SetCredit.setBackground(Color.LIGHT_GRAY);
        
        
        //adding respective compinents to MainFrame
        MainFrame.add(CompName);
        MainFrame.add(MainTitle);
        MainFrame.add(CardID);
        MainFrame.add(ClientName);
        MainFrame.add(IssuerBank);
        MainFrame.add(BankAcc);
        MainFrame.add(BalanceAm);
        MainFrame.add(PIN);
        MainFrame.add(CVCnum);
        MainFrame.add(InterestRate);
        MainFrame.add(ExpirationDate);
        MainFrame.add(CardIDtxt);
        MainFrame.add(ClientNametxt);
        MainFrame.add(IssuerBanktxt);
        MainFrame.add(BankAcctxt);
        MainFrame.add(BalanceAmtxt);
        MainFrame.add(PINtxt);
        MainFrame.add(CVCnumtxt);
        MainFrame.add(InterestRatetxt);
        MainFrame.add(ExpirationYearCBX);
        MainFrame.add(ExpirationMonthCBX);
        MainFrame.add(ExpirationDayCBX);
        MainFrame.add(AddDbtCard);
        MainFrame.add(AddCrdtCard);
        MainFrame.add(Withdraw);
        MainFrame.add(SetCredit);
        MainFrame.add(DisplayDr);
        MainFrame.add(DisplayCr);
        MainFrame.add(Clear);
        MainFrame.add(SubTitle1);
        MainFrame.add(SubTitle2);
        MainFrame.add(PrmCancelCredit);
        MainFrame.add(Footer);
        MainFrame.add(DisplayDr);
        MainFrame.add(Clear);
        MainFrame.add(line1);

        
        //adding respective components to Frame1 for making a withdrawal
        Frame1.add(DrFrameTitle);
        Frame1.add(CardIDDr);
        Frame1.add(CardIDtxtDr);
        Frame1.add(WithdrawalAm);
        Frame1.add(WithdrawalAmtxt);
        Frame1.add(WithdrawalDate);
        Frame1.add(WithdrawalYearCBX);
        Frame1.add(WithdrawalMonthCBX);
        Frame1.add(WithdrawalDayCBX);
        Frame1.add(PINDr);
        Frame1.add(PINtxtDr);
        Frame1.add(WithdrawDbtCard);
        

        
        //adding realted components to Frame2 for granting credit card
        Frame2.add(CrFrameTitle);
        Frame2.add(CardIDCr);
        Frame2.add(CardIDtxtCr);
        Frame2.add(CreditLimit);
        Frame2.add(CreditLimittxt);
        Frame2.add(GracePeriod);
        Frame2.add(GracePeriodtxt);
        Frame2.add(SetCrdtLimit);
        
        
        //Adding related compnents for Frame3 for cancelling credit card
        Frame3.add(CancelCrFrameTitle);
        Frame3.add(CardIDCancel);
        Frame3.add(CardIDCanceltxt);
        Frame3.add(CancelCrdtCard);
               
        
        Frame1.setLayout(null);
        Frame1.setVisible(false);
        Frame1.setResizable(false);
        
        Frame2.setLayout(null);
        Frame2.setVisible(false);
        Frame2.setResizable(false);
        
        Frame3.setLayout(null);
        Frame3.setVisible(false);
        Frame3.setResizable(false);
        
        
        MainFrame.setLayout(null);
        MainFrame.setResizable(false);
        MainFrame.setSize(950,700);
        MainFrame.setVisible(true);
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public static void main(String[] args)
    {
        //calling the constructor for GUI
        new BankGUI();
    }
    
    @Override
    public void actionPerformed(ActionEvent a)
    {
        //buttons for opening frames
        if (a.getSource()==Withdraw)
        {
            Frame1.setVisible(true);
            Frame1.setSize(530,400);
        }
        else if(a.getSource()==SetCredit)
        {
            Frame2.setVisible(true);
            Frame2.setSize(530,400);
        }
        else if(a.getSource()==PrmCancelCredit)
        {
            Frame3.setVisible(true);
            Frame3.setSize(300,250);
        }
        
        //Other functionalities for buttons
        else if(a.getSource()==Clear)
        {
            CardIDtxt.setText("");
            ClientNametxt.setText("");
            BalanceAmtxt.setText("");
            BankAcctxt.setText("");
            IssuerBanktxt.setText("");
            PINtxt.setText("");
            CVCnumtxt.setText("");
            InterestRatetxt.setText("");
        }
        
        //adding a debit card
        else if(a.getSource()==AddDbtCard)
        {
            //checking if any empty values is being entered by the user
            if(CardIDtxt.getText().equals("") || ClientNametxt.getText().equals("") || BalanceAmtxt.getText().equals("") 
                || BankAcctxt.getText().equals("") || IssuerBanktxt.getText().equals("") || PINtxt.getText().equals("") )
            {
                JOptionPane.showMessageDialog(MainFrame,"Empty field/s detected","Alert",JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                
                //looks for any kind of exception and execeutes the codes present in catch.
                //in this scenerio only NumberFormatException is detected
                try
                {
                    int CardID = Integer.parseInt(CardIDtxt.getText());
                    String ClientName = ClientNametxt.getText();
                    int BalanceAmt = Integer.parseInt(BalanceAmtxt.getText());
                    String BankAccount = BankAcctxt.getText();
                    String IssuerBank = IssuerBanktxt.getText();
                    int PIN = Integer.parseInt(PINtxt.getText());
                    
                    //Incase arraylist is empty we can directly add the object to the array list
                    if(BankCardAL.isEmpty())
                    {
                        DebitCard DebitCardobj = new DebitCard(BalanceAmt, CardID,  BankAccount,  IssuerBank,  ClientName, PIN);
                        
                        BankCardAL.add(DebitCardobj); 
                        
                        JOptionPane.showMessageDialog(MainFrame,"Debit card for ID "+ CardID +" has been added.");
                    }
                    
                    else
                    {
                        
                        //iterating through each objects presents in array list
                        for(BankCard i : BankCardAL)
                        {
                            boolean DebitCardAdded = false;
                            //if there is an instance of debit card present in arraylist the value will be set to true
                            if(i instanceof DebitCard)
                            {
                                
                                DebitCardAdded = true;
                                if(i.getCardId() == CardID)
                                {
                                    //incase the card id entered by user is already present  
                                    JOptionPane.showMessageDialog(MainFrame,"Debit card for ID "+ CardID +" already exists.");
                                    break;
                                }
                                
                                else if(i == BankCardAL.get(BankCardAL.size()-1))
                                {
                                    //if there is no similar card ids it means this is a new instance so it is added
                                    DebitCard DebitCardobj = new DebitCard(BalanceAmt, CardID,  BankAccount,  IssuerBank,  ClientName, PIN);
                                    BankCardAL.add(DebitCardobj);
                                    JOptionPane.showMessageDialog(MainFrame,"Debit card for ID "+ CardID +" has been added.");
                                    break;
                                }
                                
                            }
                            else if(i == BankCardAL.get(BankCardAL.size()-1) && DebitCardAdded == false)
                            {
                                
                                //this block executes only when there is no instance of debit card in arraylist
                                DebitCard DebitCardobj = new DebitCard(BalanceAmt, CardID,  BankAccount,  IssuerBank,  ClientName, PIN);
                                BankCardAL.add(DebitCardobj);
                                JOptionPane.showMessageDialog(MainFrame,"Debit card for ID "+ CardID +" has been added.");
                                break;
                                
                            }
                            
                        }
                    }
                }
                    
                catch(NumberFormatException NFE)
                {
                    //exception handling incase any string value is entered in place of integer
                    JOptionPane.showMessageDialog(MainFrame,"Please enter valid informations.","Alert",JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        
        //adding a debit card
        else if(a.getSource()==AddCrdtCard)
        {
            
            //checking if any empty values is being entered by the user
            if(CardIDtxt.getText().equals("") || ClientNametxt.getText().equals("") || BalanceAmtxt.getText().equals("") 
                || BankAcctxt.getText().equals("") || IssuerBanktxt.getText().equals("") || InterestRatetxt.getText().equals("")
                || CVCnumtxt.getText().equals(""))
            {
                    JOptionPane.showMessageDialog(MainFrame,"Empty field/s detected","Alert",JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                
                //looks for any kind of exception and execeutes the codes present in catch.
                try{
                    int CardID = Integer.parseInt(CardIDtxt.getText());
                    String ClientName = ClientNametxt.getText();
                    int BalanceAmt = Integer.parseInt(BalanceAmtxt.getText());
                    String BankAccount = BankAcctxt.getText();
                    String IssuerBank = IssuerBanktxt.getText();
                    int CVCnum = Integer.parseInt(CVCnumtxt.getText());
                    Double Interest = Double.parseDouble(InterestRatetxt.getText());
                    String ExpYear = ExpirationYearCBX.getSelectedItem().toString();
                    String ExpMonth = ExpirationMonthCBX.getSelectedItem().toString();
                    String ExpDay = ExpirationDayCBX.getSelectedItem().toString();
                    String ExpirationDate = ExpYear +"/"+ ExpMonth +"/"+ ExpDay;
                    
                    //Incase arraylist is empty we can directly add the object to the array list
                    if(BankCardAL.isEmpty())
                    {
                        
                        CreditCard CreditCardobj = new CreditCard(CardID,  ClientName,  IssuerBank,  BankAccount,  BalanceAmt,  CVCnum,  Interest, ExpirationDate);
                        
                        BankCardAL.add(CreditCardobj);
                        JOptionPane.showMessageDialog(MainFrame,"Credit card for Card ID : "+CardID+" has been added");
                        
                    }
                    else
                    {
                        
                        //iterating through each objects presents in array list
                        for(BankCard i : BankCardAL)
                        {
                            
                            boolean CreditCardAdded = false;
                            //if there is an instance of debit card present in arraylist the value will be set to true
                            if(i instanceof CreditCard)
                            {
                                
                                CreditCardAdded = true;
                                
                                if(i.getCardId() == CardID)
                                {
                                    //incase the card id entered by user is already present 
                                    JOptionPane.showMessageDialog(MainFrame,"Credit card already exists.","Alert",JOptionPane.WARNING_MESSAGE);
                                    break;
                                    
                                }
                                
                                //if there is no similar card ids it means this is a new instance so it is added
                                else if(i == BankCardAL.get(BankCardAL.size()-1))
                                {
                                    
                                    CreditCard CreditCardobj = new CreditCard(CardID,  ClientName,  IssuerBank,  BankAccount,  BalanceAmt,  CVCnum,  Interest, ExpirationDate);
                                    BankCardAL.add(CreditCardobj);
                                    JOptionPane.showMessageDialog(MainFrame,"Credit card for Card ID : "+CardID+" has been added");
                                    break;
                                    
                                }
                                
                            }
                            
                            //this block executes only when there is no instance of debit card in arraylist
                            else if(i == BankCardAL.get(BankCardAL.size()-1) && CreditCardAdded == false)
                            {
                                
                                CreditCard CreditCardobj = new CreditCard(CardID,  ClientName,  IssuerBank,  BankAccount,  BalanceAmt,  CVCnum,  Interest, ExpirationDate);
                                BankCardAL.add(CreditCardobj);
                                JOptionPane.showMessageDialog(MainFrame,"Credit card for Card ID : "+CardID+" has been added"); 
                                break;
                            }
                        }
                    }
                }
                
                //exception handling incase any string value is entered in place of integer
                catch(NumberFormatException NFEx)
                {
                    JOptionPane.showMessageDialog(MainFrame,"Please enter valid informations.","Alert",JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        
        
        //if the buttons in other frames present are pressed\
        
        //make a withdrawal
        else if(a.getSource()==WithdrawDbtCard)
        {
            //checking if any empty textfields are entered
            if(CardIDtxtDr.getText().equals("") || WithdrawalAmtxt.getText().equals("") || PINtxtDr.getText().equals("") )
            {
                JOptionPane.showMessageDialog(Frame1,"Empty field/s detected","Alert",JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                try
                {
                    //assigning values of textfields to the variables
                    int CardID = Integer.parseInt(CardIDtxtDr.getText());
                    int WithdrawAmount = Integer.parseInt(WithdrawalAmtxt.getText());
                    int PIN = Integer.parseInt(PINtxtDr.getText());
                    String WithdrawYear = WithdrawalYearCBX.getSelectedItem().toString();
                    String WithdrawMonth = WithdrawalMonthCBX.getSelectedItem().toString();
                    String WithdrawDay = WithdrawalDayCBX.getSelectedItem().toString();
                    String WithdrawDate = WithdrawYear + "/" + WithdrawMonth + "/" + WithdrawDay;  
                    
                    //Withdrawal cant be made if there is no object present in the array list 
                    if(BankCardAL.isEmpty())
                    {
                        
                        JOptionPane.showMessageDialog(MainFrame,"Information unavailable","Alert",JOptionPane.WARNING_MESSAGE);
                    
                    }
                    else
                    {
                        for(BankCard i : BankCardAL)
                        {
                            // {obj1,0bj2,obj3}
                            //iterates through every single objects of arraylist
                            boolean withdrawn = false;
                            if(i instanceof DebitCard)
                            {
                                
                                withdrawn = true;
                                if(i.getCardId() == CardID)
                                {
                                    //performing a downcasting for accesing methods of child class though parent class
                                    DebitCard DbtCard = (DebitCard) i;
                                    if(DbtCard.getPINnumber() == PIN){
                                        if(DbtCard.getBalanceAmount() >= WithdrawAmount)
                                        {
                                            DbtCard.withdraw(WithdrawAmount,WithdrawDate,PIN);
                                            JOptionPane.showMessageDialog(Frame1,"Withdraw Amount : " + WithdrawAmount +"\nWithdrawn on : "+ WithdrawDate);
                                            break;
                                        }
                                        //when balance amount is lower than withdrawl amount
                                        else
                                        {
                                            JOptionPane.showMessageDialog(Frame1,"Insufficient amount for making a withdrawal");
                                            break;
                                        }
                                    }
                                    //when user inputs invalid PIN
                                    else if(i == BankCardAL.get(BankCardAL.size()-1))
                                    {
                                        JOptionPane.showMessageDialog(Frame1,"Wrong PIN detected! Please try again.","ALert",JOptionPane.WARNING_MESSAGE);
                                        break;
                                    }
                                    
                                }
                                //incase there is no objject of debitcard class
                                else if (i == BankCardAL.get(BankCardAL.size()-1))
                                {
                                    JOptionPane.showMessageDialog(Frame1,"No debit card detected");
                                }
                                
                            }
                            
                            else if(i == BankCardAL.get(BankCardAL.size()-1) && withdrawn == false)
                            {
                                JOptionPane.showMessageDialog(Frame1,"Enter valid card id");
                            }
                            
                        }
                    }
                }
                
                catch(NumberFormatException NFE)
                {
                    //displays error messages incase there are any type of data entered instead of string
                    JOptionPane.showMessageDialog(MainFrame,"Please enter valid informations.","Alert",JOptionPane.WARNING_MESSAGE);

                }
            }
        } 
        
        //for granting credit card
        else if(a.getSource()==SetCrdtLimit)
        {
            
            if(CardIDtxtCr.getText().equals("") || GracePeriodtxt.getText().equals("") || CreditLimittxt.getText().equals(""))
            {
                JOptionPane.showMessageDialog(Frame2,"Empty field/s detected","Alert",JOptionPane.WARNING_MESSAGE);
            }
            
            else
            {
                
                try
                {
                    //assigning values of textfields to respective named variable
                    int CardID = Integer.parseInt(CardIDtxtCr.getText());
                    int GracePeriod = Integer.parseInt(GracePeriodtxt.getText());
                    int CreditLimit = Integer.parseInt(CreditLimittxt.getText());  
                    
                    if(BankCardAL.isEmpty())
                    {
                        //if array list is empty then there is no credit card objects
                        JOptionPane.showMessageDialog(Frame2,"Information unavailable","Alert",JOptionPane.WARNING_MESSAGE);    
                    }
                    else
                    {
                        
                        for(BankCard i : BankCardAL)
                        {
                            
                            boolean setCrdtLimit = false;
                            if(i instanceof CreditCard)
                            {
                                CreditCard CrdtCard = (CreditCard)i;
                                setCrdtLimit = true;
                                
                                if(i.getCardId() == CardID)
                                {
                                    CrdtCard.setCreditLimit(CreditLimit, GracePeriod);
                                    JOptionPane.showMessageDialog(Frame2,"Credit limit : " + CreditLimit + "\nSet for ID : "+ CardID);
                                    break;
                                }
                                //if the user inputs wrong card id or there are is no credit card object present for the card id entered by user
                                else if(i == BankCardAL.get(BankCardAL.size()-1))//checks if the object is last in array list
                                {
                                    
                                    JOptionPane.showMessageDialog(Frame2,"No information found. Please enter valid Card ID");
                                    
                                }
                                
                            }
                            
                            //if there are no instacne of credit card available
                            else if(i == BankCardAL.get(BankCardAL.size()-1) && setCrdtLimit == false)
                            {
                                JOptionPane.showMessageDialog(Frame2,"Credit Card information of is not found");
                            }
                        }
                    }
                }
                
                //Cathces nuber formmat exception in frame2
                catch(NumberFormatException NFE)
                {
                    JOptionPane.showMessageDialog(MainFrame,"Please enter valid informations.","Alert",JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        
        //this block execites when cancel crdit card button in frame3 is pressed
        else if(a.getSource()==CancelCrdtCard)
        {
            if(CardIDCanceltxt.getText().equals(""))
            {
                JOptionPane.showMessageDialog(Frame3,"Empty field/s detected","Alert",JOptionPane.WARNING_MESSAGE);
            }
            
            else
            {
                
                try
                {
                    //we only require card id for cancelling serrvices of credit card
                    int CardID = Integer.parseInt(CardIDCanceltxt.getText());
                    if(BankCardAL.isEmpty())
                    {
                        JOptionPane.showMessageDialog(Frame3,"Information unavailable","Alert",JOptionPane.WARNING_MESSAGE);
                    }
                    else
                    {
                        for(BankCard i : BankCardAL)
                        {
                            //iterates through every single objects in array list
                            boolean cancelled =  false;
                            if(i instanceof CreditCard)
                            {
                                //incase the object is instance of credit card
                                CreditCard CrdtCard = (CreditCard)i;
                                cancelled = true;
                                if(i.getCardId()==CardID)
                                {
                                    //executes when card id entered by user matches with the object
                                    CrdtCard.cancelCreditCard();
                                    JOptionPane.showMessageDialog(Frame3,"Credit card services for Card ID " + CardID+" has been cancelled");
                                    break;
                                }
                                
                                else if(i == BankCardAL.get(BankCardAL.size()-1))
                                {
                                    //if the object iterating is last in array list and doesn't amtches to any card id
                                    //it means the card id entered is invalid
                                    JOptionPane.showMessageDialog(Frame2,"No information found. Please enter valid Card ID");
                                    break;
                                }
                                
                            }
                            else if(i == BankCardAL.get(BankCardAL.size()-1) && cancelled == false)
                            {
                                JOptionPane.showMessageDialog(Frame3,"No information of credit card relating to Card ID "+CardID+" has been found");
                                break;
                            }
                            
                        }
                    }
                }
                
                //catches number format exception in frame3
                catch(NumberFormatException NFE)
                {
                    JOptionPane.showMessageDialog(MainFrame,"Please enter valid informations.","Alert",JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        
        //displays details of every single instance of debitcard present in arraylist
        else if(a.getSource() == DisplayDr)
        {
            
            if(BankCardAL.isEmpty())
            {
                JOptionPane.showMessageDialog(MainFrame,"There is no data available","Alert",JOptionPane.WARNING_MESSAGE);
            }
            
            else
            {
                
                boolean DebitCardAdded = false;
                
                for(BankCard i : BankCardAL)
                {
                    
                    if(i instanceof DebitCard)
                    {
                        DebitCardAdded = true;
                        DebitCard DbtCard = (DebitCard) i;
                        DbtCard.display();
                    } 
                }
                if(DebitCardAdded == false)
                    {
                        JOptionPane.showMessageDialog(MainFrame,"No information of Debit card holders have been detected.");
                        
                    }
            }
            
        }
        
        //displays details of every objects present in arraylist
        else if(a.getSource() == DisplayCr)
        {
            
            if(BankCardAL.isEmpty())
            {
                JOptionPane.showMessageDialog(MainFrame,"There is no data available","Alert",JOptionPane.WARNING_MESSAGE);
            }
            
            else
            {
                
                boolean CreditCardAdded = false;
                
                for(BankCard i : BankCardAL)
                {
                    //iterating through every object present in the arraylist
                    if(i instanceof CreditCard)
                    {
                        //if any objecct of credit card is present then it is displayed in the terminal 
                        CreditCardAdded = true;
                        CreditCard CrdtCard = (CreditCard) i;
                        CrdtCard.display();
                    } 
                    
                }
                
                //this code executes incase there are no instance of credit card in the arraylist
                if(CreditCardAdded == false)
                    {
                        JOptionPane.showMessageDialog(MainFrame,"No information of Credit card holders have been detected.");
                        
                    }
            }
        }
    }
}