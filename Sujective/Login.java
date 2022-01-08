package Sujective;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	 private static final String INSERT_ADMIN_SQL="INSERT INTO `login`(`Player1`, `Player2`, `Score1`, `Score2`, `Winner`) VALUES (?,?,?,?,?)";

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
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

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 359);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PLAYER1 NAME");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(26, 81, 145, 24);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textField.setBounds(181, 81, 272, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("                           INFORMATION PAGE");
		lblNewLabel_1.setIcon(null);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBounds(10, 0, 470, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PLAYER2 NAME");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setBounds(26, 152, 145, 24);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		textField_1.setBounds(181, 152, 272, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("NEXT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/examsystem?serverTimezone=UTC","root","");
					Statement stm=con.createStatement();
					String sql="INSERT INTO `subjective`(`player1`, `player2`, `score1`, `score2`, `winner`) VALUES (?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1,textField.getText() );
					ps.setString(2,textField_1.getText());
					ps.setLong(3, TicToeGame.xcount);
					ps.setLong(4, TicToeGame.ocount);
					if(TicToeGame.xcount>TicToeGame.ocount)
					{
						ps.setString(5, textField.getText());	
					}
					else if(TicToeGame.xcount<TicToeGame.ocount)
					{
						ps.setString(5, textField_1.getText());
					}
					else
						ps.setString(5,"Draw");
					int i=ps.executeUpdate();
					//ResultSet rs=stm.executeQuery(sql);
					if(i>0)
					{
						JOptionPane.showMessageDialog(null,"Record Save Sucessful");
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Something Error In Database");
					}
					con.close();
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\saura\\Desktop\\Qems Icon Jframe\\qems\\Next.png"));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBounds(39, 233, 130, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("RESET");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\saura\\Desktop\\Qems Icon Jframe\\qems\\Back.png"));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_1.setBounds(288, 235, 120, 29);
		contentPane.add(btnNewButton_1);
	}
}
