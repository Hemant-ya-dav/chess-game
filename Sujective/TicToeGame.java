package Sujective;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;
import javax.swing.*;

public class TicToeGame implements ActionListener {

	static int ocount = 0, xcount = 0;
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] buttons = new JButton[9];
	JButton reset = new JButton();
	boolean player1_turn;
	Quiz qe = new Quiz();

	TicToeGame() throws IOException {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650, 650);
		frame.setResizable(true);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);

		textfield.setBackground(new Color(25, 25, 25));
		textfield.setForeground(new Color(25, 255, 0));
		textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true);

		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0, 0, 650, 100);

		button_panel.setLayout(new GridLayout(4, 3));
		button_panel.setBackground(new Color(50, 50, 50));

		for (int i = 0; i < 9; i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		reset = new JButton("Reset");
		reset.setBounds(90, 320, 130, 30);
		button_panel.add(reset);
		reset.setFont(new Font("MV Boli", Font.BOLD, 40));
		reset.setFocusable(true);
		reset.addActionListener(new A());

		title_panel.add(textfield);
		frame.add(title_panel, BorderLayout.NORTH);
		frame.add(button_panel);

		firstTurn();
	}

	class A implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			for (int i = 0; i < 9; i++) {
				buttons[i].setText("");
			}
			firstTurn();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (qe.Cor[qe.index] == true) {
			for (int i = 0; i < 9; i++) {
				if (e.getSource() == buttons[i]) {
					if (player1_turn) {
						if (buttons[i].getText() == "") {
							buttons[i].setForeground(new Color(255, 0, 0));
							buttons[i].setText("X");
							player1_turn = false;
							textfield.setText("O turn");
							check();
						}
					} else {
						if (buttons[i].getText() == "") {
							buttons[i].setForeground(new Color(0, 0, 255));
							buttons[i].setText("O");
							player1_turn = true;
							textfield.setText("X turn");
							check();
						}
					}
				}
			}
		}
		else {
			if(player1_turn) {
				player1_turn=false;
				textfield.setText("O turn");
			}
			else
			{
				player1_turn=true;
				textfield.setText("X turn");
			}
		}
	}

	public void firstTurn() {

		button_panel.setBackground(new Color(50, 50, 50));

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (random.nextInt(2) == 0) {
			player1_turn = true;
			textfield.setText("X turn");
		} else {
			player1_turn = false;
			textfield.setText("O turn");
		}
	}

	public void check() {
		// check X win conditions
		if ((buttons[0].getText() == "X") && (buttons[1].getText() == "X") && (buttons[2].getText() == "X")) {
			xWins(0, 1, 2);
		}
		if ((buttons[3].getText() == "X") && (buttons[4].getText() == "X") && (buttons[5].getText() == "X")) {
			xWins(3, 4, 5);
		}
		if ((buttons[6].getText() == "X") && (buttons[7].getText() == "X") && (buttons[8].getText() == "X")) {
			xWins(6, 7, 8);
		}
		if ((buttons[0].getText() == "X") && (buttons[3].getText() == "X") && (buttons[6].getText() == "X")) {
			xWins(0, 3, 6);
		}
		if ((buttons[1].getText() == "X") && (buttons[4].getText() == "X") && (buttons[7].getText() == "X")) {
			xWins(1, 4, 7);
		}
		if ((buttons[2].getText() == "X") && (buttons[5].getText() == "X") && (buttons[8].getText() == "X")) {
			xWins(2, 5, 8);
		}
		if ((buttons[0].getText() == "X") && (buttons[4].getText() == "X") && (buttons[8].getText() == "X")) {
			xWins(0, 4, 8);
		}
		if ((buttons[2].getText() == "X") && (buttons[4].getText() == "X") && (buttons[6].getText() == "X")) {
			xWins(2, 4, 6);
		}
		// check O win conditions
		if ((buttons[0].getText() == "O") && (buttons[1].getText() == "O") && (buttons[2].getText() == "O")) {
			oWins(0, 1, 2);
		}
		if ((buttons[3].getText() == "O") && (buttons[4].getText() == "O") && (buttons[5].getText() == "O")) {
			oWins(3, 4, 5);
		}
		if ((buttons[6].getText() == "O") && (buttons[7].getText() == "O") && (buttons[8].getText() == "O")) {
			oWins(6, 7, 8);
		}
		if ((buttons[0].getText() == "O") && (buttons[3].getText() == "O") && (buttons[6].getText() == "O")) {
			oWins(0, 3, 6);
		}
		if ((buttons[1].getText() == "O") && (buttons[4].getText() == "O") && (buttons[7].getText() == "O")) {
			oWins(1, 4, 7);
		}
		if ((buttons[2].getText() == "O") && (buttons[5].getText() == "O") && (buttons[8].getText() == "O")) {
			oWins(2, 5, 8);
		}
		if ((buttons[0].getText() == "O") && (buttons[4].getText() == "O") && (buttons[8].getText() == "O")) {
			oWins(0, 4, 8);
		}
		if ((buttons[2].getText() == "O") && (buttons[4].getText() == "O") && (buttons[6].getText() == "O")) {
			oWins(2, 4, 6);
		}
	}

	public void xWins(int a, int b, int c) {
		/*
		 * buttons[a].setBackground(Color.GREEN); buttons[b].setBackground(Color.GREEN);
		 * buttons[c].setBackground(Color.GREEN);
		 */

		/*
		 * for(int i=0;i<9;i++) { buttons[i].setEnabled(false); }
		 */
		xcount++;
		textfield.setText("Player1 wins Time " + xcount);
	}

	public void oWins(int a, int b, int c) {
		/*
		 * buttons[a].setBackground(Color.GREEN); buttons[b].setBackground(Color.GREEN);
		 * buttons[c].setBackground(Color.GREEN);
		 */

		/*
		 * for(int i=0;i<9;i++) { buttons[i].setEnabled(false); }
		 */
		ocount++;
		textfield.setText("Player2 wins Time " + ocount);

	}
}
