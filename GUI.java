package mhxalog;

import java.sql.*;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblUsername;
	private JLabel lblPassward;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setTitle("Log In");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 344, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(100, 196, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(100, 260, 116, 22);
		contentPane.add(passwordField);
		
		lblUsername = new JLabel("username");
		lblUsername.setBounds(133, 167, 71, 16);
		contentPane.add(lblUsername);
		
		lblPassward = new JLabel("password");
		lblPassward.setBounds(133, 231, 71, 16);
		contentPane.add(lblPassward);
		
		JButton btnLog = new JButton(" Log In");
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StorageFunctions st = new StorageFunctions();
				try {
					st.connection();
					Users a= st.getStatus(textField.getText(),String.valueOf(passwordField.getPassword()));
					if(a.getStatus()==1)
					{
						dispose();
						Diaxeirisths diax= new Diaxeirisths();
						diax.setVisible(true);
					}
					else if(a.getStatus()==2)	
					{
						dispose();
						Upallhlos upal= new Upallhlos();
						upal.setVisible(true);
					}
					else 
					{
					JOptionPane.showMessageDialog(null,"Username or password is wrong.TRY AGAIN");
					}
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, "Username or password is wrong.TRY AGAIN");
				}
	
			}
		});//
		btnLog.setBounds(107, 327, 97, 25);
		contentPane.add(btnLog);
	}
}
