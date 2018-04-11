import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Registration extends JFrame{

	ArrayList<Object> allObject = new ArrayList<>();
	JTextArea display;
	
	public Registration(){
		super("Registration");
		
		display = new JTextArea();
		JScrollPane scroll = new JScrollPane(display);
		display.setEditable(false);
		add(scroll, BorderLayout.CENTER);
		
		JPanel right = new JPanel();
		right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
		add(right, BorderLayout.EAST);
		right.add(new Label("Sort by"));
		JRadioButton nameButton = new JRadioButton("Name", true);
		right.add(nameButton);
		
		JRadioButton valueButton = new JRadioButton("Value");
		right.add(valueButton);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(nameButton);
		bg.add(valueButton);
		
		
		
		
		JPanel down = new JPanel();
		add(down, BorderLayout.SOUTH);
		JButton newButton = new JButton("New");
		down.add(newButton);
		newButton.addActionListener(new NewLis());
		JButton showButton = new JButton("Show");
		down.add(showButton);
		showButton.addActionListener(new ShowLis());
		JButton blackMondayButton = new JButton ("Black Monday");
		down.add(blackMondayButton);
		//blackMondayButton.addActionListner(new blackMondayLyss());
		
		
		setSize(400,500);
		setVisible(true);
		
		
		
	}

	class FormularJewlery extends JPanel{
		JTextField nameField = new JTextField(10);
		JTextField jewlsField = new JTextField(3); 
		JCheckBox goldBox = new JCheckBox("Gold");
		
		FormularJewlery(){
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			JPanel line1 = new JPanel();
			line1.add(new JLabel("Name;"));
			line1.add(nameField);
			add(line1);
			
			JPanel line2 = new JPanel();
			line2.add(new JLabel("Jewls:"));
			line2.add(jewlsField);
			add(line2);
			add(goldBox);
			
		}
		public String getName() {
			return nameField.getText();
			
		}
		public int getJewls() {
			return Integer.parseInt(jewlsField.getText());
			
		}
		public boolean getGold() {
			return goldBox.isSelected();
		}
	}
	
	

	
	
	class NewLis implements ActionListener{
		public void actionPerformed(ActionEvent ave) {
			FormularJewlery fj = new FormularJewlery();
			int answer = JOptionPane.showConfirmDialog(Registration.this, fj, "New", JOptionPane.OK_CANCEL_OPTION);
			
			
			if (answer != JOptionPane.OK_CANCEL_OPTION) {
				return;
			}
			String name = fj.getName();
			int jewls = fj.getJewls();
			boolean goldBox = fj.getGold();
			
			Jewelry reg = new Jewelry(name, jewls, goldBox);
			allObject.add(reg);
			
		}
	}

	
	class ShowLis implements ActionListener{
		
		public void actionPerformed(ActionEvent ave) {
			display.setText("");
			for (Object reg : allObject) {
				display.append(reg.toString());
			}
		}
		
	}
	
	
	public static void main(String [] args) {
		new Registration();		
	}
	
	
	static   {
	       Font f = new Font("Dialog", Font.BOLD, 18);
	       String[] comps = {"Button", "Label", "RadioButton", "CheckBox",
				 "ToggleButton", "TextArea", "TextField",
				 "Menu", "MenuItem", "ComboBox", "List"};
	       for(String s : comps)
		   UIManager.put(s+".font", f);       
	    }
	
	
}
