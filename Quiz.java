
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

import chessgui.BoardFrame;
import chessgui.ChessGUI;

//---------------------------- Quiz ----------------------------
public class Quiz extends JComponent implements ActionListener {

	String[] questions = { "1)Recall ,Who developed Linux?", "2)In which year Linux was developed?",
			"3)Memories ,The name of SA is also known as root user or?", "4)Choose the other name of new shell?",
			"5)In Linux hard disk partition, hda2, a stands for the ___",
			"6)Recognize Single dot (.) with cd refers to ___", "7)Select the piping symbol?",
			"8)What should be the minimum length of a password?", "9)Select Who can change the password of any user?",
			"10)Recognize the first version of Linux?", "11)Identify where User directories are created?",
			"12)mnt stands for?", "13)This structure prevents name collision?",
			"14)Identify The first ___ always represents the root directory?",
			"15)Choose the correct text file contains by the Linux commands?" };
	String[][] options = { { "Dennis Ritchie", "Linus Torvalds", "Ken Thompson", "Prof. Andrew S. Tannenbaum" },
			{ "1989", "1990", "1991", "1992" }, { "Supervisor", "Multi user", "Single user", "Super user" },
			{ "Baby shell", "Junior shell", "Child shell", "Assistant shell" },
			{ "first hard drive", "first partition", "second partition", "second hard drive" },
			{ "Change directory", "Created directory", "Current directory", "Parent directory" },
			{ "_", "|", "~", "!" }, { "5", "6", "7", "8" }, { "Everyone", "SA", "Supervisor", "End-user" },
			{ "1.0", "0.11", "1.01", "0.10" }, { "Bin directory", "Temp directory", "Dev directory", "Home directory" },
			{ "move", "moving", "mounting", "mount" }, { "Root", "Tree", "Branch", "Lea" },
			{ "– minus", "/ slash", "* asterisks", "+ plu" },
			{ "Editor script", "Unix script", "Minix script", "Shell scrip" },

	};
	char[] answers = { 'B', 'C', 'D', 'C', 'A', 'C', 'B', 'B', 'B', 'B', 'D', 'D', 'B', 'B', 'D'

	};
	boolean Cor[] = new boolean[15];
	static int white=0;
	static int black=0;
	static String win="";
	char guess;
	char answer;
	int index;
	int correct_guesses = 0;
	int total_questions = questions.length;
	//int result;
	int seconds = 10;

	JFrame frame = new JFrame();
	JTextField textfield = new JTextField();
	JTextArea textarea = new JTextArea();
	JButton Next = new JButton();
	JButton buttonA = new JButton();
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JButton buttonD = new JButton();
	JLabel answer_labelA = new JLabel();
	JLabel answer_labelB = new JLabel();
	JLabel answer_labelC = new JLabel();
	JLabel answer_labelD = new JLabel();
	JLabel time_label = new JLabel();
	JLabel seconds_left = new JLabel();
	JTextField number_right = new JTextField();
	JTextField percentage = new JTextField();

	/*
	 * Timer timer = new Timer(1000, new ActionListener() {
	 * 
	 * @Override public void actionPerformed(ActionEvent e) { seconds--;
	 * seconds_left.setText(String.valueOf(seconds)); if(seconds<=0) {
	 * displayAnswer(); } } });
	 */

	public Quiz() throws IOException {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650, 650);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setLayout(null);
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

		buttonA.setBounds(0, 100, 100, 100);
		buttonA.setFont(new Font("MV Boli", Font.BOLD, 35));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("A");

		buttonB.setBounds(0, 200, 100, 100);
		buttonB.setFont(new Font("MV Boli", Font.BOLD, 35));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("B");

		buttonC.setBounds(0, 300, 100, 100);
		buttonC.setFont(new Font("MV Boli", Font.BOLD, 35));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("C");

		buttonD.setBounds(0, 400, 100, 100);
		buttonD.setFont(new Font("MV Boli", Font.BOLD, 35));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setText("D");

		/*
		 * Next.setBounds(0,500,100,100); Next.setFont(new
		 * Font("MV Boli",Font.BOLD,35)); Next.setFocusable(false);
		 * Next.addActionListener(this); Next.setText("Next");
		 */

		answer_labelA.setBounds(125, 100, 500, 100);
		answer_labelA.setBackground(new Color(50, 50, 50));
		answer_labelA.setForeground(new Color(25, 255, 0));
		answer_labelA.setFont(new Font("MV Boli", Font.PLAIN, 35));

		answer_labelB.setBounds(125, 200, 500, 100);
		answer_labelB.setBackground(new Color(50, 50, 50));
		answer_labelB.setForeground(new Color(25, 255, 0));
		answer_labelB.setFont(new Font("MV Boli", Font.PLAIN, 35));

		answer_labelC.setBounds(125, 300, 500, 100);
		answer_labelC.setBackground(new Color(50, 50, 50));
		answer_labelC.setForeground(new Color(25, 255, 0));
		answer_labelC.setFont(new Font("MV Boli", Font.PLAIN, 35));

		answer_labelD.setBounds(125, 400, 500, 100);
		answer_labelD.setBackground(new Color(50, 50, 50));
		answer_labelD.setForeground(new Color(25, 255, 0));
		answer_labelD.setFont(new Font("MV Boli", Font.PLAIN, 35));

		seconds_left.setBounds(535, 510, 100, 100);
		seconds_left.setBackground(new Color(25, 25, 25));
		seconds_left.setForeground(new Color(255, 0, 0));
		seconds_left.setFont(new Font("Ink Free", Font.BOLD, 60));
		seconds_left.setBorder(BorderFactory.createBevelBorder(1));
		seconds_left.setOpaque(true);
		seconds_left.setHorizontalAlignment(JTextField.CENTER);
		seconds_left.setText(String.valueOf(seconds));

		/*
		 * time_label.setBounds(535,475,100,25); time_label.setBackground(new
		 * Color(50,50,50)); time_label.setForeground(new Color(255,0,0));
		 * time_label.setFont(new Font("MV Boli",Font.PLAIN,16));
		 * time_label.setHorizontalAlignment(JTextField.CENTER);
		 * time_label.setText("timer >:D");
		 */

		number_right.setBounds(225, 225, 1000, 100);
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

		frame.add(time_label);
		frame.add(seconds_left);
		frame.add(answer_labelA);
		frame.add(answer_labelB);
		frame.add(answer_labelC);
		frame.add(answer_labelD);
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);
		frame.add(buttonD);
//	frame.add(Next);
		frame.add(textarea);
		frame.add(textfield);
		frame.setVisible(true);

		nextQuestion();
	}

	public void nextQuestion() {

		if (index >= total_questions) {
			results();
		} else {
			if((index+1)%2==0)
			{
				textfield.setText("Question " + (index + 1)+" for black");	
			}
			else
			{
				textfield.setText("Question " + (index + 1)+" for White");
			}
			textarea.setText(questions[index]);
			answer_labelA.setText(options[index][0]);
			answer_labelB.setText(options[index][1]);
			answer_labelC.setText(options[index][2]);
			answer_labelD.setText(options[index][3]);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		Next.setEnabled(false);

		if (e.getSource() == buttonA) {
			answer = 'A';
			if (answer == answers[index]) {
				correct_guesses++;
				Cor[index]=true;
				if(index%2==0)
					white++;
				else
					black++;
				if (e.getSource() == Next)
					nextQuestion();
			}
		}
		if (e.getSource() == buttonB) {
			answer = 'B';
			if (answer == answers[index]) {
				correct_guesses++;
				Cor[index]=true;
				if(index%2==0)
					white++;
				else
					black++;
				if (e.getSource() == Next)
					nextQuestion();
			}
		}
		if (e.getSource() == buttonC) {
			answer = 'C';
			if (answer == answers[index]) {
				correct_guesses++;
				Cor[index]=true;
				if(index%2==0)
					white++;
				else
					black++;
				if (e.getSource() == Next)
					nextQuestion();
			}
		}
		if (e.getSource() == buttonD) {
			answer = 'D';
			if (answer == answers[index]) {
				correct_guesses++;
				Cor[index]=true;
				if(index%2==0)
					white++;
				else
					black++;
				if (e.getSource() == Next)
					nextQuestion();
			}
		}
		if (e.getSource() == Next)
			nextQuestion();
		displayAnswer();
	}

	public void displayAnswer() {

		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);

		if (answers[index] != 'A')
			answer_labelA.setForeground(new Color(255, 0, 0));
		if (answers[index] != 'B')
			answer_labelB.setForeground(new Color(255, 0, 0));
		if (answers[index] != 'C')
			answer_labelC.setForeground(new Color(255, 0, 0));
		if (answers[index] != 'D')
			answer_labelD.setForeground(new Color(255, 0, 0));

		Timer pause = new Timer(2000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				answer_labelA.setForeground(new Color(25, 255, 0));
				answer_labelB.setForeground(new Color(25, 255, 0));
				answer_labelC.setForeground(new Color(25, 255, 0));
				answer_labelD.setForeground(new Color(25, 255, 0));

				answer = ' ';
				seconds = 10;
				seconds_left.setText(String.valueOf(seconds));
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				buttonD.setEnabled(true);
				Next.setEnabled(true);
				index++;
				nextQuestion();
			}
		});
		pause.setRepeats(false);
		pause.start();
	}

	public void results() {

		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);

	//	result = (int) ((correct_guesses / (double) total_questions) * 100);

		textfield.setText("RESULTS!");
		textarea.setText("");
		answer_labelA.setText("");
		answer_labelB.setText("");
		answer_labelC.setText("");
		answer_labelD.setText("");

		number_right.setText("(Player1(White) :" +white+ " And Player2(Black) :" + black + ")");
		if(white>black)
			win="White";
		else
			win="Black";
	//	percentage.setText(result + "%");

		frame.add(number_right);
	//	frame.add(percentage);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
