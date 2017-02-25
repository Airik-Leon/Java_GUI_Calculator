package Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

public class source extends JFrame
{
  private static final int WIDTH = 325; 
  private static final int HEIGHT = 200; 
  
  private JTextField firstNumInput; 
  private JLabel secondNumLabel; 
  private JTextField secondNumInput; 
  private JLabel resultLabel; 
  
  private double result; 
  private JButton addButton; 
  private JButton subButton; 
  private JButton multButton; 
  private JButton divButton; 
  
  public source()
  {
	  setTitle("Mini calculator");
	  setSize(WIDTH, HEIGHT);
	  setLayout(new FlowLayout()); 
	  setDefaultCloseOperation(EXIT_ON_CLOSE); 
	  createContents(); 
	  setVisible(true);
  }
  private void createContents()
  {
	  JLabel firstLabel = new JLabel("First number: "); 
	  add(firstLabel); 
	  firstNumInput = new JTextField(15); 
	  add(firstNumInput); 
	  secondNumLabel = new JLabel ("second number: "); 
	  add(secondNumLabel); 
	  secondNumInput = new JTextField(15); 
	  add(secondNumInput); 
	  
	  
	  addButton = new JButton("+"); 
	  add(addButton); 
	  subButton = new JButton("-"); 
	  add(subButton);
	  multButton= new JButton("x"); 
	  add(multButton);
	  divButton = new JButton("/"); 
	  add(divButton);
	  resultLabel = new JLabel(": "); 
	  add(resultLabel);
	  addButton.addActionListener(new Listener());
	  subButton.addActionListener(new Listener());
	  multButton.addActionListener(new Listener());
	  divButton.addActionListener(new Listener());
  }
  private class Listener implements ActionListener
  {
	  public void actionPerformed(ActionEvent e)
	  {
		  if(firstNumInput.equals("") || secondNumInput.equals(""))
		  {
			  JOptionPane.showMessageDialog(null, "Please input two numbers", "Missing input", JOptionPane.ERROR_MESSAGE);
		  }
		  else
			  try{
				  double firstNumInput1 = Double.parseDouble(firstNumInput.getText());
				  double secondNumInput2 = Double.parseDouble(secondNumInput.getText());
				  if(e.getSource() == addButton)
				  {
					  result = firstNumInput1 + secondNumInput2; 
				  }
				  if(e.getSource() == subButton)
				  {
					  result = firstNumInput1 - secondNumInput2; 
				  }
				  if(e.getSource() == multButton)
				  {
					  result = firstNumInput1 * secondNumInput2; 
				  }
				  if(e.getSource() == divButton)
				  {
					  result = firstNumInput1 / secondNumInput2; 
				  }
				  resultLabel.setText(Double.toString(result)); 
		  }
		  catch(NumberFormatException NFE)
		  {
			  JOptionPane.showMessageDialog(null, "Please input two numbers",
		              "MIssing input", JOptionPane.ERROR_MESSAGE); 
		  }	  
	  }
  }
  public static void main(String args[])
  {
	  new source();
  }
}