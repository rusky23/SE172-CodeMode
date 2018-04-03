import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HW3 {

	public static void main(String[] args) {
		runCustomerMain();
	}

	private static JFrame mainCustomerFrame;
	
	public static void runCustomerMain(){
			mainCustomerFrame = new JFrame("Main Menu");

			//INTEGRATION 1
			JButton Integration1 = new JButton("Integration 1");
			Integration1.setAlignmentX(Component.CENTER_ALIGNMENT);
			Integration1.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)
			  {
			  	//action performed for integration 1
			  }
			});

			//INTEGRATION 2
			JButton Integration2 = new JButton("Integration 2");
			Integration2.setAlignmentX(Component.CENTER_ALIGNMENT);

			Integration2.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)
			  {
			  	//perform action for integration 2
			  }
			});

			//INTEGRATION 3
			JButton Integration3 = new JButton("Integration 3");
			Integration3.setAlignmentX(Component.CENTER_ALIGNMENT);

			Integration3.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)
			  {
			  	//action performed for integration 3
			  }
			});

			//INTEGRATION 4
			JButton Integration4 = new JButton("Integration 4");
			Integration4.setAlignmentX(Component.CENTER_ALIGNMENT);

			Integration4.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)
			  {
			  	//action performed for integration 4
			  }
			});

			//INTEGRATION 5
			JButton Integration5 = new JButton("Integration 5");
			Integration5.setAlignmentX(Component.CENTER_ALIGNMENT);

			Integration5.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)
			  {
			  	//action performed for integration 5
			  }
			});

			//INTEGRATION 6
			JButton Integration6 = new JButton("Integration 6");
			Integration6.setAlignmentX(Component.CENTER_ALIGNMENT);

			Integration6.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)
			  {
			  	//action performed for integration 6
			  }
			});

			//INTEGRATION 7
			JButton Integration7 = new JButton("Integration 7");
			Integration7.setAlignmentX(Component.CENTER_ALIGNMENT);

			Integration7.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)
			  {
				//action performed for integration 7
			  }
			});

			//INTEGRATION 8
			JButton Integration8 = new JButton("Integration 8");
			Integration8.setAlignmentX(Component.CENTER_ALIGNMENT);

			Integration8.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)
			  {
				//action performed for integration 8
			  }
			});


			JPanel panel = new JPanel();
		    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		    panel.add(Integration1);
		    panel.add(Integration2);
		    panel.add(Integration3);
		    panel.add(Integration4);
		    panel.add(Integration5);
		    panel.add(Integration6);
		    panel.add(Integration7);
		    panel.add(Integration8);
		    mainCustomerFrame.add(panel);
		    mainCustomerFrame.setSize(new Dimension(200,300));
		    mainCustomerFrame.setVisible(true);
		}
}