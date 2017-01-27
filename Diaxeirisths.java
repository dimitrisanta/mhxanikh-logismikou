package mhxalog;

import javax.swing.*;

import java.sql.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Diaxeirisths extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private JTextField textName;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Diaxeirisths frame = new Diaxeirisths();
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
	public Diaxeirisths() {
		setTitle("Diaxeirisths");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogOut = new JButton("log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GUI logOut= new GUI();
				logOut.setVisible(true);
			}
		});
		btnLogOut.setBounds(504, 33, 97, 25);
		contentPane.add(btnLogOut);
		
		JButton btnCreate = new JButton("create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StorageFunctions create=new StorageFunctions();
				create.connection();
				if(textName.getText().trim().isEmpty() || textField_1.getText().trim().isEmpty() )
				{
					JOptionPane.showMessageDialog(null,"Fill all the fields");
				}
				else
				{
				boolean cr = create.createProduct(textName.getText(),Float.valueOf(textField.getText()),Integer.valueOf(textField_1.getText()));
				if(cr==true)
				{
					JOptionPane.showMessageDialog(null,"Success!!!");

				}
				else
					JOptionPane.showMessageDialog(null,"FILL ALL THE FIELDS CORRECTLY");
				}
			}
		});
		btnCreate.setBounds(12, 100, 97, 25);
		contentPane.add(btnCreate);
		
	
		
		JButton btnEditStock = new JButton("editStock");
		btnEditStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StorageFunctions edit=new StorageFunctions();
				edit.connection();
				if(textName.getText().trim().isEmpty() || textField_1.getText().trim().isEmpty() )
				{
					JOptionPane.showMessageDialog(null,"Fill all the fields");
				}
				else
				{
				boolean ed = edit.processingProduct(textName.getText(),Integer.valueOf(textField_1.getText()));
					if(ed==true)
						{
							JOptionPane.showMessageDialog(null,"Success!!!");

						}
					else
					JOptionPane.showMessageDialog(null,"Product Not found!TRY AGAIN");

				}
			}
			
	
			
		});
		btnEditStock.setBounds(12, 222, 97, 25);
		contentPane.add(btnEditStock);
		
	
		
		
		
		
		textName = new JTextField();
		
		textName.setBounds(12, 53, 116, 22);
		contentPane.add(textName);
		textName.setColumns(10);
		
		JLabel lblStock = new JLabel("");
		lblStock.setBounds(212, 156, 117, 16);
		contentPane.add(lblStock);
		
		JButton btnShowStock = new JButton("showStock");
		btnShowStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StorageFunctions sh = new StorageFunctions();
				sh.connection();
				Product show= sh.getStock(textName.getText());
				if(show!=null)
					lblStock.setText("Stock:"+Integer.toString(show.getStock()));
				else
					lblStock.setText("Product Not Found");
			}
		});
		btnShowStock.setBounds(12, 156, 97, 25);
		contentPane.add(btnShowStock);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(! (Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE ))
				{
					e.consume();
				}
			}
		});
		textField.setBounds(173, 53, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(! (Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE ))
				{
					e.consume();
				}
			}
		});
		textField_1.setBounds(341, 53, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblName = new JLabel("name");
		lblName.setBounds(41, 37, 56, 16);
		contentPane.add(lblName);
		
		JLabel lblPrice = new JLabel("price");
		lblPrice.setBounds(207, 37, 56, 16);
		contentPane.add(lblPrice);
		
		JLabel lblStock_1 = new JLabel("stock");
		lblStock_1.setBounds(370, 37, 56, 16);
		contentPane.add(lblStock_1);
		
		JLabel lblId = new JLabel("");
		lblId.setBounds(220, 277, 69, 16);
		contentPane.add(lblId);
		
		JLabel lblProion = new JLabel("");
		lblProion.setBounds(281, 277, 105, 16);
		contentPane.add(lblProion);
		
		JLabel lblPr = new JLabel("");
		lblPr.setBounds(398, 277, 97, 16);
		contentPane.add(lblPr);
		
		JLabel lblSt = new JLabel("");
		lblSt.setBounds(507, 277, 105, 16);
		contentPane.add(lblSt);
		
		JButton btnSearch = new JButton("search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StorageFunctions search = new StorageFunctions();
				search.connection();
				Product sr = search.getName(textName.getText());
				if(sr!=null)
				{
					lblId.setText("ID:"+sr.getId());
					lblProion.setText("Proion:"+sr.getName());
					lblPr.setText("Price:"+sr.getPrice());
					lblSt.setText("Stock:"+Integer.toString(sr.getStock()));

					
				}
				else
					lblProion.setText("Product Not Found");
			}
		});
		btnSearch.setBounds(12, 273, 97, 25);
		contentPane.add(btnSearch);
		
		JLabel lblAVG = new JLabel("");
		lblAVG.setBounds(144, 339, 137, 16);
		contentPane.add(lblAVG);
		
		JLabel lblMax = new JLabel("");
		lblMax.setBounds(293, 339, 164, 16);
		contentPane.add(lblMax);
		
		JLabel lblMin = new JLabel("");
		lblMin.setBounds(488, 339, 145, 16);
		contentPane.add(lblMin);
		
		JLabel lblMaxStock = new JLabel("");
		lblMaxStock.setBounds(144, 394, 137, 16);
		contentPane.add(lblMaxStock);
		
		JLabel lblMinStock = new JLabel("");
		lblMinStock.setBounds(293, 394, 164, 16);
		contentPane.add(lblMinStock);
		
		JLabel lblNumOfPr = new JLabel("");
		lblNumOfPr.setBounds(488, 394, 145, 16);
		contentPane.add(lblNumOfPr);
		
		JButton btnStatistics = new JButton("statistics");
		btnStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StorageFunctions stat = new StorageFunctions();
				stat.connection();
				lblAVG.setText("AVERAGE:"+String.format("%.2f",stat.avg()));
				lblMax.setText("MAX PRICE:"+stat.max());
				lblMin.setText("MIN PRICE:"+stat.min());
				lblMaxStock.setText("MAX STOCK:"+stat.maxStock());
				lblMinStock.setText("MIN STOCK:"+stat.minStock());
				lblNumOfPr.setText("SUM OF PRODUCTS:"+stat.numOfProducts());




			}
		});
		btnStatistics.setBounds(12, 335, 97, 25);
		contentPane.add(btnStatistics);
		
	}
}
	

