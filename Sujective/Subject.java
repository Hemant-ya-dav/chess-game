package Sujective;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Subject extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Subject frame = new Subject();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	String[] questions = {"1)Recall ,Who developed Linux?"};
	String[][] options = {{"Dennis Ritchie","Linus Torvalds","Ken Thompson","Prof. Andrew S. Tannenbaum"}};
	boolean Cor[]=new boolean[15];
	int index;
	int correct_guesses = 0;
	int total_questions = questions.length;
	int result;
	int seconds = 10;
	JFrame frame = new JFrame();
	JTextField textfield = new JTextField();
	JTextArea textarea = new JTextArea();
	
	JTextField number_right = new JTextField();
	JTextField percentage = new JTextField();
	private final JTextField textField = new JTextField();
	
	JTextField second=new JTextField();
	
	
	public Subject() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 650);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setResizable(true);
		textfield.setBounds(0, 0, 650, 50);
		textfield.setBackground(new Color(25, 25, 25));
		textfield.setForeground(new Color(25, 255, 0));
		textfield.setFont(new Font("Ink Free", Font.BOLD, 30));
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		textarea.setBounds(0, 50, 650, 50);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground(new Color(25, 25, 25));
		textarea.setForeground(new Color(25, 255, 0));
		textarea.setFont(new Font("MV Boli", Font.BOLD, 25));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false);
		second.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String s=second.getText();
				
				for(int i=0;i<4;i++)
				{
					
				}
				
				
				
				
			}
		});
		
		second.setBounds(54, 159, 596, 50);
		second.setBackground(new Color(25, 25, 25));
		second.setForeground(new Color(25, 255, 0));
		second.setFont(new Font("Ink Free", Font.BOLD, 30));
		second.setBorder(BorderFactory.createBevelBorder(1));
		second.setHorizontalAlignment(JTextField.CENTER);
		
		number_right.setBounds(225, 225, 200, 100);
		number_right.setBackground(new Color(25, 25, 25));
		number_right.setForeground(new Color(25, 255, 0));
		number_right.setFont(new Font("Ink Free", Font.BOLD, 50));
		number_right.setBorder(BorderFactory.createBevelBorder(1));
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setEditable(false);

		percentage.setBounds(225, 325, 200, 100);
		percentage.setBackground(new Color(25, 25, 25));
		percentage.setForeground(new Color(25, 255, 0));
		percentage.setFont(new Font("Ink Free", Font.BOLD, 50));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);
		frame.getContentPane().setLayout(null);
		
		frame.getContentPane().add(textarea);
		frame.getContentPane().add(textfield);
		
	//	frame.getContentPane().add(textField);
		frame.getContentPane().add(second);
		frame.setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		nextQuestion();
	}
	
	public void nextQuestion() {

		if (index >= total_questions) {
			results();
		} else {
			textfield.setText("Question " + (index + 1));
			textarea.setText(questions[index]);
			
		}
	}
	
	public void results() {


		result = (int) ((correct_guesses / (double) total_questions) * 100);

		textfield.setText("RESULTS!");
		textarea.setText("");

		number_right.setText("(" + correct_guesses + "/" + total_questions + ")");
		percentage.setText(result + "%");

		frame.getContentPane().add(number_right);
		frame.getContentPane().add(percentage);

	}

}
