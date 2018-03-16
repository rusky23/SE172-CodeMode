import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Main entry to program.
 */
public class ProgramLauncher {

	public static String loginId;
	private static JFrame frame;
	private static JFrame customerFrame;
	private static JFrame loginFrame;

	private static JFrame mainCustomerFrame;
	private static JFrame adminFrame;

	private static JFrame openAccountFrame;
	private static JFrame closeAccountFrame;
	private static JFrame depositFrame;
	private static JFrame withdrawFrame;
	private static JFrame transferFrame;
	private static JFrame summaryFrame;

	private static JFrame reportAFrame;
	private static JFrame reportBFrame;

	public static void main(String argv[]) {
		System.out.println(":: PROGRAM START");

		if (argv.length < 1) {
			System.out.println("Need database properties filename");
		} else {
			BankingSystem.init(argv[0]);
			BankingSystem.testConnection();
			BatchInputProcessor.run(argv[0]);
		}
		runMainMenu();
	}

	public static void runCustomerMain(String id){
		mainCustomerFrame = new JFrame("Customer Main Menu");

		//Open Account
		JButton openAccount = new JButton("Open Account");
		openAccount.setAlignmentX(Component.CENTER_ALIGNMENT);
		openAccount.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		  	openAccountFrame = new JFrame("Open a New Account");
			JTextField idText = new JTextField();
			JTextField typeText = new JTextField();
			JTextField balanceText = new JTextField();

			JLabel id = new JLabel("Customer ID:");
			JLabel type = new JLabel("Type:");
			JLabel balance = new JLabel("Balance:");

		    idText.setPreferredSize(new Dimension(100,30));
		    typeText.setPreferredSize(new Dimension(100,30));
		    balanceText.setPreferredSize(new Dimension(100,30));

			JButton createAccount = new JButton("Create New Account");
			createAccount.addActionListener(new ActionListener()
			{
		  		public void actionPerformed(ActionEvent e)
		  		{
		  			String thisId = idText.getText();
		  			String thisType = typeText.getText();
		  			String balance = balanceText.getText();
		  			if(loginId.equals(thisId)){
		  				BankingSystem.openAccount(thisId, thisType, balance);
		  			}
		  			else{
		  				System.out.println("Cannot create an Account for another User");
		  			}
		  		}
		  	});

			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			panel.add(id);
			panel.add(idText);
			panel.add(type);
			panel.add(typeText);
			panel.add(balance);
			panel.add(balanceText);
			panel.add(createAccount);
			openAccountFrame.add(panel);
		  	openAccountFrame.setSize(new Dimension(400,200));
		  	openAccountFrame.setVisible(true);
		  }
		});

		//Close Account
		JButton closeAccount = new JButton("Close Account");
		closeAccount.setAlignmentX(Component.CENTER_ALIGNMENT);

		closeAccount.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		  	closeAccountFrame = new JFrame("Close Account");
		  	closeAccountFrame.setSize(new Dimension(400,200));
		  	JLabel account = new JLabel("Account Number: ");
			JTextField accountText = new JTextField();
			accountText.setPreferredSize(new Dimension(150, 40));
			JButton closeAccount = new JButton("Close Account");
			closeAccount.addActionListener(new ActionListener()
			{
		  		public void actionPerformed(ActionEvent e)
		  		{
		  			String account = accountText.getText();
		  			if(BankingSystem.validateAction(account)){
		  				BankingSystem.closeAccount(account);
		  			}
		  			else{
		  				System.out.println("Error");
		  			}
		  			
		  		}
		  	});
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			panel.add(account);
			panel.add(accountText);
			panel.add(closeAccount);
			closeAccountFrame.add(panel);
		  	closeAccountFrame.setVisible(true);
		  }
		});

		//Deposit money
		JButton deposit = new JButton("Deposit");
		deposit.setAlignmentX(Component.CENTER_ALIGNMENT);

		deposit.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		  	depositFrame = new JFrame("Deposit");
		  	JLabel account = new JLabel("Account Number: ");
		  	JLabel amount = new JLabel("Deposit Amount: ");

			JTextField accountText = new JTextField();
			JTextField amountText = new JTextField();
		  	accountText.setPreferredSize(new Dimension(100,30));
		  	amountText.setPreferredSize(new Dimension(100,30));

			JButton depositButton = new JButton("Deposit");
			depositButton.addActionListener(new ActionListener()
			{
		  		public void actionPerformed(ActionEvent e)
		  		{
		  			String account = accountText.getText();
		  			String amount = amountText.getText();	  				
		  			BankingSystem.deposit(account, amount);
		  		}
		  	});
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			panel.add(account);
			panel.add(accountText);
			panel.add(amount);
			panel.add(amountText);
			panel.add(depositButton);
			depositFrame.add(panel);
		  	depositFrame.setSize(new Dimension(400,200));
		  	depositFrame.setVisible(true);
		  }
		});

		//Withdraw Money
		JButton withdraw = new JButton("Withdraw");
		withdraw.setAlignmentX(Component.CENTER_ALIGNMENT);

		withdraw.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		  	withdrawFrame = new JFrame("Withdraw");
		  	JLabel account = new JLabel("Account Number: ");
		  	JLabel amount = new JLabel("Withdraw Amount: ");
		  	JTextField accountText = new JTextField();
			JTextField amountText = new JTextField();
			accountText.setPreferredSize(new Dimension(100,30));
		  	amountText.setPreferredSize(new Dimension(100,30));
			JButton withdrawButton = new JButton("Withdraw");
			withdrawButton.addActionListener(new ActionListener()
			{
		  		public void actionPerformed(ActionEvent e)
		  		{
		  			String account = accountText.getText();
		  			String amount = amountText.getText();
		  			if(BankingSystem.validateAction(account)){
		  				BankingSystem.withdraw(account, amount);
		  			}
		  			else{
		  				System.out.println("Cannot withdraw from another User's Account");
		  			}
		  		}
		  	});
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			panel.add(account);
			panel.add(accountText);
			panel.add(amount);
			panel.add(amountText);
			panel.add(withdrawButton);

			withdrawFrame.add(panel);
		  	withdrawFrame.setSize(new Dimension(400,200));
		  	withdrawFrame.setVisible(true);
		  }
		});

		//Transfer Money
		JButton transfer = new JButton("Transfer");
		transfer.setAlignmentX(Component.CENTER_ALIGNMENT);

		transfer.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		  	transferFrame = new JFrame("Transfer");
		  	JLabel srcAccount = new JLabel("Source Account Number: ");
		  	JLabel destAccount = new JLabel("Destination Account Number: ");
		  	JLabel amount = new JLabel("Transfer Amount: ");
			JTextField sourceText = new JTextField();
			JTextField destinationText = new JTextField();
			JTextField amountText = new JTextField();
			sourceText.setPreferredSize(new Dimension(100,30));
		  	destinationText.setPreferredSize(new Dimension(100,30));
			amountText.setPreferredSize(new Dimension(100,30));
			JButton transferButton = new JButton("Transfer");
			transferButton.addActionListener(new ActionListener()
			{
		  		public void actionPerformed(ActionEvent e)
		  		{
		  			String srcAccount = sourceText.getText();
		  			String destAccount = destinationText.getText();
		  			String amount = amountText.getText();
		  			if(BankingSystem.validateAction(srcAccount)){
		  				BankingSystem.transfer(srcAccount, destAccount, amount);
		  			}
		  			else{
		  				System.out.println("Cannot transfer from another User's Account");
		  			}
		  		}
		  	});
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			panel.add(srcAccount);
			panel.add(sourceText);
			panel.add(destAccount);
			panel.add(destinationText);
			panel.add(amount);
			panel.add(amountText);
			panel.add(transferButton);
			transferFrame.add(panel);
		  	transferFrame.setSize(new Dimension(400,200));
		  	transferFrame.setVisible(true);
		  }
		});

		//Account Summary
		JButton summary = new JButton("Account Summary");
		summary.setAlignmentX(Component.CENTER_ALIGNMENT);

		summary.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		  	BankingSystem.accountSummary(loginId);
		  }
		});

		//Go back to Main Menu
		JButton exit = new JButton("Exit");
		exit.setAlignmentX(Component.CENTER_ALIGNMENT);

		exit.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		  	mainCustomerFrame.setVisible(false);
		  	frame.setVisible(true);
		  }
		});
		JPanel panel = new JPanel();
	    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
	    panel.add(openAccount);
	    panel.add(closeAccount);
	    panel.add(deposit);
	    panel.add(withdraw);
	    panel.add(transfer);
	    panel.add(summary);
	    panel.add(exit);
	    mainCustomerFrame.add(panel);
	    mainCustomerFrame.setSize(new Dimension(200,300));
	    mainCustomerFrame.setVisible(true);
	}


	public static void runAdminMain(){
		adminFrame = new JFrame("Administrator Main Menu");
		JButton accountSummaryButton = new JButton("Account Summary");
		JTextField accountNum = new JTextField();
		accountSummaryButton.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		  	String account = accountNum.getText();
		  	BankingSystem.accountSummary(account);
		  }
		});	

		JButton reportA = new JButton("Report A");
		reportA.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		  	BankingSystem.reportA();
		  }
		});
		JButton reportB = new JButton("Report B");
		JTextField min = new JTextField();
		JTextField max = new JTextField();
		reportB.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		  	String minimum = min.getText();
		  	String maximum = max.getText();
		  	BankingSystem.reportB(minimum, maximum);
		  }
		});
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		  	adminFrame.setVisible(false);
		  	frame.setVisible(true);
		  }
		});
		JPanel panel = new JPanel();	    
		accountNum.setPreferredSize(new Dimension(100,30));
	    min.setPreferredSize(new Dimension(100,30));
	    max.setPreferredSize(new Dimension(100,30));

	    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
	    panel.add(new JLabel("Enter the account Number:"));
	    panel.add(accountNum);

	    panel.add(accountSummaryButton);
	    panel.add(reportA);
	   	panel.add(new JLabel("Enter the Minimum Age:"));
	    panel.add(min);
	   	panel.add(new JLabel("Enter the Maximum Age:"));
	    panel.add(max);
	    panel.add(reportB);
	    panel.add(exit);
	    adminFrame.add(panel);
	    adminFrame.setSize(new Dimension(300,300));
	    adminFrame.setVisible(true);
	}


	public static void runMainMenu(){
	   frame = new JFrame("Banking System");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       JLabel title = new JLabel("Welcome to the Self Services Banking System! – Main Menu");
       title.setAlignmentX(Component.CENTER_ALIGNMENT);

       //Create New Customer fucntionality
       JButton newCustomer = new JButton("New Customer");
       newCustomer.setAlignmentX(Component.CENTER_ALIGNMENT);
		newCustomer.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    customerFrame = new JFrame("Create New Customer");
		    JLabel name = new JLabel("Name:");
		    JLabel gender = new JLabel("Gender:");
		    JLabel age = new JLabel("Age:");
		    JLabel pin = new JLabel("Pin:");
		    JTextField nameText = new JTextField();
		    JTextField genderText = new JTextField();
		    JTextField ageText = new JTextField();
		    JTextField pinText = new JTextField();
		    nameText.setPreferredSize(new Dimension(100,30));
		    genderText.setPreferredSize(new Dimension(100,30));
		    ageText.setPreferredSize(new Dimension(100,30));
		    pinText.setPreferredSize(new Dimension(100,30));
		    //add submit functionality
			JButton submit = new JButton("Create New Customer");
			submit.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)
			  {
			  	String name = nameText.getText();
			  	String gender = genderText.getText();
			  	String age = ageText.getText();
			  	String pin = pinText.getText();
			  	if(BankingSystem.newCustomer(name, gender, age, pin)){
			  		System.out.println("Success, new customer created");
			  	}
			  	else{
			  		System.out.println("Failure: User info is wrong");
			  	}
			  }
			});

		    JPanel panel = new JPanel();
		    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		    panel.add(name);
		    panel.add(nameText);
		    panel.add(gender);
		    panel.add(genderText);
		    panel.add(age);
		    panel.add(ageText);
		    panel.add(pin);
		    panel.add(pinText);
		    panel.add(submit);
		    customerFrame.add(panel);
		    customerFrame.pack();
		    customerFrame.setVisible(true);
		  }
		});

		//Login button functionality
       JButton login = new JButton("Customer Login");
		login.setAlignmentX(Component.CENTER_ALIGNMENT);

       	login.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    loginFrame = new JFrame("Login");
		    JLabel idLabel = new JLabel("Id:");
		    JLabel pinLabel = new JLabel("Pin");
		    JTextField idText = new JTextField();
		    JTextField pinText = new JTextField();
		    idText.setPreferredSize(new Dimension(100,30));
		    pinText.setPreferredSize(new Dimension(80,30));
		    //add submit functionality
			JButton submit = new JButton("Login");
			submit.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)
			  {
			  	loginId = idText.getText();
			  	String pin = pinText.getText();

			  	if(loginId.equals("0") && pin.equals("0")){
			  		loginFrame.setVisible(false);
			  		frame.setVisible(false);
			  		runAdminMain();
			  	}
			  	else if(BankingSystem.login(loginId, pin)){
			  		loginFrame.setVisible(false);
			  		frame.setVisible(false);
			  		runCustomerMain(loginId);
			  	}
			  }
			});

		    JPanel panel = new JPanel();
		    panel.setLayout(new GridBagLayout());
		    panel.add(idLabel);
		    panel.add(idText);
		    panel.add(pinLabel);
		    panel.add(pinText);
		    panel.add(submit);
		    loginFrame.add(panel);
		    loginFrame.setSize(new Dimension(400,200));
		    loginFrame.setVisible(true);
		  }
		});

       	//Exit Button functionaility
       JButton exit = new JButton("Exit");
       exit.setAlignmentX(Component.CENTER_ALIGNMENT);

        exit.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		  	System.out.println("Exiting program");
		  	System.exit(0);
		  }
		});

	   JPanel contents = new JPanel();
	   contents.setLayout(new BoxLayout(contents, BoxLayout.PAGE_AXIS));
	   contents.add(title);
	   contents.add(newCustomer);
	   contents.add(login);
	   contents.add(exit);

	   frame.add(contents);
       frame.setSize(new Dimension(400,200));
       frame.setVisible(true);
	}
}