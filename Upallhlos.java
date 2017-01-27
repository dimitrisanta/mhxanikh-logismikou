package mhxalog;

import java.sql.*;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class Upallhlos extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private JTextField textName;
	private JTextField textField;
	private JTextField textField_1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Upallhlos frame = new Upallhlos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Upallhlos() {
		setTitle("Upallhlos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogOut = new JButton("log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				GUI logOut2= new GUI();
				logOut2.setVisible(true);
			}
		});
		btnLogOut.setBounds(303, 385, 97, 25);
		contentPane.add(btnLogOut);
				
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
				
				
			}
		}
	
			


	
	

