package playground;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator2 extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel central, superior, grid;
	private JTextField textFieldDisplay;
	private Font font;
	private JButton[] button;
	private String valueToShow, buttonClicked;
	private String buttonLabel[];

	public static void main(String[] args) {
		new Calculator2();
	}
	
	public Calculator2() {
		// TODO Auto-generated constructor stub
		setup();
		initComponents();
		addComponents();
		setEvents();
		
		this.setVisible(true);
	}

	/**
	 * 
	 */
	private void setup() {
		this.setTitle("Calculator V2");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		central = new JPanel(new BorderLayout());
		superior = new JPanel(new BorderLayout());
		grid = new JPanel(new GridLayout(4, 4));
		
		font = new Font(Font.MONOSPACED, Font.PLAIN, 30);
		textFieldDisplay = new JTextField();
		textFieldDisplay.setFont(font);
		
		generateButtons();
		
	}
	
	private void generateButtons() {
		// TODO Auto-generated method stub
		button = new JButton[16];
		
		buttonLabel = new String[] {
				"7", "8", "9", "C", "4", "5", "6", "+",
				"1", "2", "3", "-", "*", "0", "/", "=",
		};
		
		for (int i = 0; i < button.length; i++) {
			button[i] = new JButton(buttonLabel[i]);
			button[i].setFont(font);
			grid.add(button[i]);
		}
		
	}

	private void addComponents() {
		superior.add(textFieldDisplay);
		central.add(superior, BorderLayout.NORTH);
		central.add(grid);
		this.add(central);
	}

	private void setEvents() {
		// TODO Auto-generated method stub
		for (int i= 0; i < button.length; i++) {
			button[i].addActionListener(this);
			button[i].setActionCommand(buttonLabel[i]);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			if(e.getActionCommand().equals("7")) {
				setDisplay(e);
			} else if(e.getActionCommand().equals("8")) {
				setDisplay(e);
			} else if(e.getActionCommand().equals("9")) {
				setDisplay(e);
			} else if(e.getActionCommand().equals("C")) {
				clearDisplay();
			} else if(e.getActionCommand().equals("4")) {
				setDisplay(e);
			} else if(e.getActionCommand().equals("5")) {
				setDisplay(e);
			} else if(e.getActionCommand().equals("6")) {
				setDisplay(e);
			} else if(e.getActionCommand().equals("+")) {
				setDisplay(e);
			} else if(e.getActionCommand().equals("1")) {
				setDisplay(e);
			} else if(e.getActionCommand().equals("2")) {
				setDisplay(e);
			} else if(e.getActionCommand().equals("3")) {
				setDisplay(e);
			} else if(e.getActionCommand().equals("-")) {
				setDisplay(e);
			} else if(e.getActionCommand().equals("*")) {
				setDisplay(e);
			} else if(e.getActionCommand().equals("0")) {
				setDisplay(e);
			} else if(e.getActionCommand().equals("/")) {
				setDisplay(e);
			} else if(e.getActionCommand().equals("=")) {
				setResult();
		}
	}

	private void setResult() {
		String valueToCheck = valueToShow;
		String[] number = null;
		String operator = null;
		
		if(valueToShow.contains("+")) {
			addition(valueToCheck, operator, number);
		}
		
		else if(valueToShow.contains("-")) {
			subtraction(valueToCheck, operator, number);
		}
		
		else if(valueToShow.contains("*")) {
			multiplication(valueToCheck, operator, number);
		}
		
		else if(valueToShow.contains("/")) {
			division(valueToCheck, operator, number);
		}
	}

	/**
	 * @param valueToCheck
	 * @param operator 
	 * @param number 
	 */
	private void division(String valueToCheck, String operator, String[] number) {
		operator = "/";
		number = valueToCheck.split(operator);
		int a = Integer.parseInt(number[0]);
		int b = Integer.parseInt(number[1]);
		if(b == 0) {
			textFieldDisplay.setText("Error: Division by zero");
		}
		else {
			int result = a/b;
			System.out.println(result);
			textFieldDisplay.setText(String.valueOf(result));
		}
	}

	/**
	 * @param valueToCheck
	 * @param operator 
	 * @param number 
	 */
	private void multiplication(String valueToCheck, String operator, String[] number) {
		operator = "\\*";
		number = valueToCheck.split(operator);
		int a = Integer.parseInt(number[0]);
		int b = Integer.parseInt(number[1]);
		int result = a*b;
		System.out.println(result);
		textFieldDisplay.setText(String.valueOf(result));
	}

	/**
	 * @param valueToCheck
	 * @param operator 
	 * @param number 
	 */
	private void subtraction(String valueToCheck, String operator, String[] number) {
		operator = "-";
		number = valueToCheck.split(operator);
		int a = Integer.parseInt(number[0]);
		int b = Integer.parseInt(number[1]);
		int result = a-b;
		System.out.println(result);
		textFieldDisplay.setText(String.valueOf(result));
	}

	/**
	 * @param valueToCheck
	 * @param operator 
	 * @param number 
	 */
	private void addition(String valueToCheck, String operator, String[] number) {
		operator = "\\+";
		number = valueToCheck.split(operator);
		int a = Integer.parseInt(number[0]);
		int b = Integer.parseInt(number[1]);
		int result = a+b;
		System.out.println(result);
		textFieldDisplay.setText(String.valueOf(result));
	}

	private void clearDisplay() {
		// TODO Auto-generated method stub
		buttonClicked = "";
		valueToShow = "";
		textFieldDisplay.setText(valueToShow);	
	}

	private void setDisplay(ActionEvent e) {
		buttonClicked = e.getActionCommand();
		valueToShow = textFieldDisplay.getText();
		valueToShow = valueToShow.concat(buttonClicked);
		textFieldDisplay.setText(valueToShow);
		System.out.println(buttonClicked);
	}
	
}