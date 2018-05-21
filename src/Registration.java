import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class Registration extends JFrame {

	ArrayList<AuctionObject> allObjects = new ArrayList<>();
	JTextArea display;
	String[] boxString = { "Jewelry", "Stock", "Electronics" };
	JComboBox<String> cBox = new JComboBox<>(boxString);
	JRadioButton valueButton;
	JRadioButton nameButton;


	public Registration() {
		super("Registration");

		display = new JTextArea();
		JScrollPane scroll = new JScrollPane(display);
		display.setEditable(false);
		add(scroll, BorderLayout.CENTER);

		JPanel right = new JPanel();
		right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
		add(right, BorderLayout.EAST);

		right.add(new JLabel("Sort by"));

		nameButton = new JRadioButton("Name", true);
		right.add(nameButton);

		valueButton = new JRadioButton("Value");
		right.add(valueButton);

		ButtonGroup bg = new ButtonGroup();
		bg.add(nameButton);
		bg.add(valueButton);

		JPanel down = new JPanel();
		add(down, BorderLayout.SOUTH);

		down.add(new Label("New:"));

		down.add(cBox);
		cBox.addActionListener(new BoxLis());

		JButton showButton = new JButton("Show");
		down.add(showButton);
		showButton.addActionListener(new ShowLis());

		JButton blackMondayButton = new JButton("Black Monday");
		down.add(blackMondayButton);
		blackMondayButton.addActionListener(new BlackMondayLis());

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 500);
		setVisible(true);

	}

	class FormularJewelry extends JPanel {
		private JTextField nameField = new JTextField(10);
		private JTextField jewlsField = new JTextField(3);
		private JCheckBox goldBox = new JCheckBox("Gold");

		public FormularJewelry() {
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			JPanel line1 = new JPanel();
			line1.add(new JLabel("Name;"));
			line1.add(nameField);
			add(line1);

			JPanel line2 = new JPanel();
			line2.add(new JLabel("Jewels:"));
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

	class FormularStock extends JPanel {
		private JTextField nameField = new JTextField(10);
		private JTextField priceField = new JTextField(5);
		private JTextField amountField = new JTextField(5);

		public FormularStock() {
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			JPanel line1 = new JPanel();
			line1.add(new JLabel("Name:"));
			line1.add(nameField);
			add(line1);

			JPanel line2 = new JPanel();
			line2.add(new JLabel("Price:"));
			line2.add(priceField);
			add(line2);

			JPanel line3 = new JPanel();
			line3.add(new JLabel("Amount:"));
			line3.add(amountField);
			add(line3);
		}

		public String getName() {
			return nameField.getText();
		}

		public int getPrice() {
			return Integer.parseInt(priceField.getText());
		}

		public int getAmount() {
			return Integer.parseInt(amountField.getText());
		}

		protected boolean stock(AuctionObject stock) {
			return true;
		}
	}

	class FormularElectronics extends JPanel {
		private JTextField nameField = new JTextField(10);
		private JTextField priceField = new JTextField(5);
		private JTextField damageField = new JTextField(2);

		public FormularElectronics() {
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			JPanel line1 = new JPanel();
			line1.add(new JLabel("Name:"));
			line1.add(nameField);
			add(line1);

			JPanel line2 = new JPanel();
			line2.add(new JLabel("Price:"));
			line2.add(priceField);
			add(line2);

			JPanel line3 = new JPanel();
			line3.add(new JLabel("Damage:"));
			line3.add(damageField);
			add(line3);
		}

		public String getName() {
			return nameField.getText();
		}

		public int getPrice() {
			return Integer.parseInt(priceField.getText());
		}

		public int getDamege() {
			return Integer.parseInt(damageField.getText());
		}

	}

	class BoxLis implements ActionListener {

		public void actionPerformed(ActionEvent ave) {
			String bSelec = (String) cBox.getSelectedItem();
			System.out.println(bSelec);

			if (bSelec.equals("Jewelry")) {
				jewelryCreation();
				System.out.println("Jewelry created");
			} else if (bSelec.equals("Stock")) {
				stockCreation();
				System.out.println("Stock Created");

			} else if (bSelec.equals("Electronics")) {
				electronicsCreation();
				System.out.println("Electronics created");
			}

		}

		public void electronicsCreation() {
			try {
				FormularElectronics fe = new FormularElectronics();
				int answer = JOptionPane.showConfirmDialog(Registration.this, fe, "New", JOptionPane.OK_CANCEL_OPTION);
				
				if (answer != JOptionPane.OK_OPTION) {
					return;
				}
				if(fe.getName() == null ||fe.getName().equals("")) {
					JOptionPane.showConfirmDialog(null, "You need to name the object", "ERROR", JOptionPane.OK_OPTION);
					return;
				}
				String name = fe.getName();
				int price = fe.getPrice();
				double damage = fe.getDamege();

				Electronics eReg = new Electronics(name, price, damage);
				allObjects.add(eReg);
				System.out.println("eReg");
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(Registration.this, "Wrong inputdata");
			}
		}

		public void jewelryCreation() {
			try {
				FormularJewelry fj = new FormularJewelry();
				int answer = JOptionPane.showConfirmDialog(Registration.this, fj, "New", JOptionPane.OK_CANCEL_OPTION);

				if (answer != JOptionPane.OK_OPTION) {
					return;
				}
				String name = fj.getName();
				int jewls = fj.getJewls();
				boolean goldBox = fj.getGold();

				Jewelry jReg = new Jewelry(name, jewls, goldBox);
				allObjects.add(jReg);
				System.out.println("jREG");
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(Registration.this, "Wrong inputdata");
			}

		}

		public void stockCreation() {
			try {
				FormularStock fs = new FormularStock();
				int answer = JOptionPane.showConfirmDialog(Registration.this, fs, "New", JOptionPane.OK_CANCEL_OPTION);

				if (answer != JOptionPane.OK_OPTION) {
					return;
				}
				String name = fs.getName();
				int price = fs.getPrice();
				int amount = fs.getAmount();

				Stock sReg = new Stock(name, price, amount);
				allObjects.add(sReg);
				System.out.println("sReg");
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(Registration.this, "Wrong inputdata");
			}
		}

	}

	class ShowLis implements ActionListener {

		public void actionPerformed(ActionEvent ave) {
			display.setText("");

			if (valueButton.isSelected()) {
				Collections.sort(allObjects, new ValueCmp());
				for (AuctionObject obj : allObjects) {
					display.append(obj.toString() + "\n");
				}
			} else {
				Collections.sort(allObjects, new NameCmp());
				for (AuctionObject obj : allObjects) {
					display.append(obj.toString() + "\n");
				}
			}
		}
	}

	class BlackMondayLis implements ActionListener {

		public void actionPerformed(ActionEvent ave) {
			for (AuctionObject obj : allObjects) {
				if (obj instanceof Stock) {
					((Stock) obj).blackMonday();
				}

			}
			System.out.println("Black Monday bby!");

		}

	}

	class NameCmp implements Comparator<AuctionObject> {
		public int compare(AuctionObject obj1, AuctionObject obj2) {
			return obj1.getName().compareTo(obj2.getName());
		}
	}

	class ValueCmp implements Comparator<AuctionObject> {
		public int compare(AuctionObject obj1, AuctionObject obj2) {
			return obj2.getValue() - obj1.getValue();
		}
	}

	public static void main(String[] args) {
		new Registration();

	}

	static {
		Font f = new Font("Dialog", Font.BOLD, 15);
		String[] comps = { "Button", "Label", "RadioButton", "CheckBox", "ToggleButton", "TextArea", "TextField",
				"Menu", "MenuItem", "ComboBox", "List" };
		for (String s : comps)
			UIManager.put(s + ".font", f);
	}

}
