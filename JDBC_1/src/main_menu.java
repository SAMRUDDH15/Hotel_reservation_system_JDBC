import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.sql.Statement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class main_menu {

	private JFrame frmHotelReservationSystem;
	private final static String url = "jdbc:mysql://localhost:3306/mydatabase";
	private final static String username ="root";
	private final static String  password ="Ranjanmahathi";
	private Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_menu window = new main_menu();
					window.frmHotelReservationSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public main_menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//create connection with database
		try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
	 try {
		 con = DriverManager.getConnection(url,username,password);
	 }catch(Exception e) {System.out.println(e.getMessage());}
	 
	 
	 
	 // GUI
		frmHotelReservationSystem = new JFrame();
		frmHotelReservationSystem.setTitle("Hotel Reservation System");
		frmHotelReservationSystem.setBounds(100, 100, 450, 300);
		frmHotelReservationSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHotelReservationSystem.getContentPane().setLayout(null);
		
		JButton Reservebtn = new JButton("Reserve Room");
		Reservebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Reserve a room function
				JFrame frmHotelReservationSystem = new JFrame();
				frmHotelReservationSystem.setTitle("Reserve Room");
				frmHotelReservationSystem.setBounds(100, 100, 450, 300);
				frmHotelReservationSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frmHotelReservationSystem.getContentPane().setLayout(null);
				frmHotelReservationSystem.setVisible(true);
				JLabel namelbl = new JLabel("Name:");
				namelbl.setBounds(63, 58, 75, 16);
				frmHotelReservationSystem.getContentPane().add(namelbl);
				
			     JTextField nametxtfld = new JTextField();
				nametxtfld.setBounds(177, 53, 190, 26);
				frmHotelReservationSystem.getContentPane().add(nametxtfld);
				nametxtfld.setColumns(10);
				
				JTextField contacttxtfld = new JTextField();
				contacttxtfld.setBounds(177, 129, 190, 26);
				frmHotelReservationSystem.getContentPane().add(contacttxtfld);
				contacttxtfld.setColumns(10);
				
				JTextField roomtxtfld = new JTextField();
				roomtxtfld.setBounds(177, 195, 190, 26);
				frmHotelReservationSystem.getContentPane().add(roomtxtfld);
				roomtxtfld.setColumns(10);
				
				JLabel contactlbl = new JLabel("Contact number");
				contactlbl.setBounds(63, 134, 61, 16);
				frmHotelReservationSystem.getContentPane().add(contactlbl);
				
				JLabel roomlbl = new JLabel("Room No");
				roomlbl.setBounds(63, 200, 61, 16);
				frmHotelReservationSystem.getContentPane().add(roomlbl);
			}
		});
		Reservebtn.setBounds(150, 16, 171, 29);
		frmHotelReservationSystem.getContentPane().add(Reservebtn);
		
		JButton Viewrevbtn = new JButton("View Reservation");
		Viewrevbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//View reservation function
				
				 String sql = "SELECT * FROM employee";
			        try {Statement statement = con.createStatement();
			                ResultSet rs = statement.executeQuery(sql);
	                    JFrame frame = new JFrame("Database Results");
	                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                    frame.setSize(600, 400);

	                    JTable table = new JTable();
	                    DefaultTableModel model = new DefaultTableModel();
	                    table.setModel(model);
	                    //get row names
                        ResultSetMetaData metaData = rs.getMetaData();
                        int columnCount = metaData.getColumnCount();
                        for (int i = 1; i <= columnCount; i++) {
                            model.addColumn(metaData.getColumnName(i));
                        }

                        // Get row data
                        while (rs.next()) {
                            Object[] row = new Object[columnCount];
                            for (int i = 0; i < columnCount; i++) {
                                row[i] = rs.getObject(i + 1);
                            }
                            model.addRow(row);
                        }

                    JScrollPane scrollPane = new JScrollPane(table);
                    frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
                    frame.setVisible(true);         	
			}catch(Exception e1) {e1.printStackTrace();}
			}});
		Viewrevbtn.setBounds(150, 64, 171, 29);
		frmHotelReservationSystem.getContentPane().add(Viewrevbtn);
		
		JButton getroombtn = new JButton("Get Room");
		getroombtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//get room function
				JFrame frmHotelReservationSystem = new JFrame();
				frmHotelReservationSystem.setTitle("Get Room No");
				frmHotelReservationSystem.setBounds(100, 100, 450, 300);
				frmHotelReservationSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frmHotelReservationSystem.getContentPane().setLayout(null);
				frmHotelReservationSystem.setVisible(true);
				
				JLabel namelbl = new JLabel("Name");
				namelbl.setBounds(59, 62, 61, 16);
				frmHotelReservationSystem.getContentPane().add(namelbl);
				
				JTextField nametxtfld = new JTextField();
				nametxtfld.setBounds(187, 57, 130, 26);
				frmHotelReservationSystem.getContentPane().add(nametxtfld);
				nametxtfld.setColumns(10);
				String name = nametxtfld.getText();
				
				
				JLabel idlbl = new JLabel("Reservation ID");
				idlbl.setBounds(33, 128, 114, 16);
				frmHotelReservationSystem.getContentPane().add(idlbl);
				
				JTextField idtxtfld = new JTextField();
				idtxtfld.setBounds(187, 123, 130, 26);
				frmHotelReservationSystem.getContentPane().add(idtxtfld);
				idtxtfld.setColumns(10);
				String id = idtxtfld.getText();
				
				JLabel roomnolbl = new JLabel("Room No ");
				roomnolbl.setBounds(33, 216, 87, 16);
				frmHotelReservationSystem.getContentPane().add(roomnolbl);
				
				JTextField roomtxtfld = new JTextField();
				roomtxtfld.setBounds(187, 211, 130, 26);
				frmHotelReservationSystem.getContentPane().add(roomtxtfld);
				roomtxtfld.setColumns(10);
				
				JButton getbtn = new JButton("Get");
				getbtn.setBounds(255, 170, 117, 29);
				frmHotelReservationSystem.getContentPane().add(getbtn);
				
		        getbtn.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	try {
		            		String sql = "SELECT room_number FROM reservation WHERE reservation_id = " + id + " AND guest_name = '" + name + "'";
							Statement s =con.createStatement();
							ResultSet r = s.executeQuery(sql);
							int rs = r.getInt("room_number");
							roomtxtfld.setText(String.valueOf(rs));
						} catch (SQLException e1) {
							e1.printStackTrace();
						}	
		            }
		        });	
			}
		});
		getroombtn.setBounds(150, 111, 171, 29);
		frmHotelReservationSystem.getContentPane().add(getroombtn);
		
		JButton Updaterevbtn = new JButton("Update Reservation");
		Updaterevbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//update reservation function
				JFrame frmHotelReservationSystem = new JFrame();
				frmHotelReservationSystem.setTitle("Get Room No");
				frmHotelReservationSystem.setBounds(100, 100, 450, 300);
				frmHotelReservationSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frmHotelReservationSystem.getContentPane().setLayout(null);
				frmHotelReservationSystem.setVisible(true);
				
				
				JLabel namelbl = new JLabel("Name");
				namelbl.setBounds(49, 113, 86, 16);
				frmHotelReservationSystem.getContentPane().add(namelbl);
				
				JTextField nametxtfld = new JTextField();
				nametxtfld.setBounds(182, 108, 130, 26);
				frmHotelReservationSystem.getContentPane().add(nametxtfld);
				nametxtfld.setColumns(10);
				String name = nametxtfld.getText();
				
				JLabel contactlbl = new JLabel("Contact No");
				contactlbl.setBounds(48, 151, 109, 16);
				frmHotelReservationSystem.getContentPane().add(contactlbl);
				
				JTextField contacttxtfld = new JTextField();
				contacttxtfld.setBounds(182, 146, 130, 26);
				frmHotelReservationSystem.getContentPane().add(contacttxtfld);
				contacttxtfld.setColumns(10);
				String contactno = contacttxtfld.getText(); 
				
				JLabel roomnolbl = new JLabel("Room No");
				roomnolbl.setBounds(48, 196, 61, 16);
				frmHotelReservationSystem.getContentPane().add(roomnolbl);
				
				JTextField roomnotxtfld = new JTextField();
				roomnotxtfld.setBounds(182, 191, 130, 26);
				frmHotelReservationSystem.getContentPane().add(roomnotxtfld);
				roomnotxtfld.setColumns(10);
				String roomno = roomnotxtfld.getText();
					
				
				JLabel reslbl = new JLabel("Reservation ID");
				reslbl.setBounds(48, 35, 109, 16);
				frmHotelReservationSystem.getContentPane().add(reslbl);
				
				JTextField restxtfld = new JTextField();
				restxtfld.setBounds(182, 30, 130, 26);
				frmHotelReservationSystem.getContentPane().add(restxtfld);
				restxtfld.setColumns(10);
				String res = restxtfld.getText();  
				
		
				JButton updatebtn = new JButton("Update");
				updatebtn.setBounds(300, 229, 117, 29);
				frmHotelReservationSystem.getContentPane().add(updatebtn);
				
				JButton getbtn = new JButton("Check");
				getbtn.setBounds(203, 68, 117, 29);
				frmHotelReservationSystem.getContentPane().add(getbtn);
				//action of check button
				
		        getbtn.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	String sql ="SELECT * FROM reservation WHERE reservation_id= "+res;
		            	try {
		            		Statement s = con.createStatement();
		            		ResultSet r = s.executeQuery(sql);
		            		 if (!r.next()) { // Check if the ResultSet is empty
		                         // Show a pop-up message if no data is found
		                         JOptionPane.showMessageDialog(null, "No reservation found with the given ID", "Error", JOptionPane.ERROR_MESSAGE);
		                     } 
		                }catch(Exception e1) {e1.printStackTrace();}		    
			        }});
		        updatebtn.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	String sql1 = "UPDATE reservations SET " +
		                        "guest_name = '" + name+ "', " +
		                        "room_number = " + roomno + ", " +
		                        "contact_number = '" + contactno + "' " +
		                        "WHERE reservation_id = " + res;
		            	try {
		            		Statement s = con.createStatement();
		            		int affectedRows = s.executeUpdate(sql1);
		            		if(affectedRows>0) {
		            			JOptionPane.showMessageDialog(null, "Update Successfull", "Updated!!", JOptionPane.INFORMATION_MESSAGE);
		            		}else {
		            			JOptionPane.showMessageDialog(null, "No reservation found with the given ID", "Error", JOptionPane.ERROR_MESSAGE);
		            		}
		            	}catch(Exception e2) {e2.printStackTrace();}
		            }
		        });
		        }
			});
		Updaterevbtn.setBounds(150, 159, 171, 29);                       
		frmHotelReservationSystem.getContentPane().add(Updaterevbtn); 
		
		JButton deleterevbtn = new JButton("Delete Reservations");
		deleterevbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//delete function
				JFrame frmHotelReservationSystem = new JFrame();
				frmHotelReservationSystem.setTitle("Get Room No");
				frmHotelReservationSystem.setBounds(100, 100, 450, 300);
				frmHotelReservationSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frmHotelReservationSystem.getContentPane().setLayout(null);
				frmHotelReservationSystem.setVisible(true);
				
				JLabel idlbl = new JLabel("Reservation ID");
				idlbl.setBounds(22, 85, 113, 16);
				frmHotelReservationSystem.getContentPane().add(idlbl);
				
				JTextField idtxtfld = new JTextField();
				idtxtfld.setBounds(183, 80, 193, 26);
				frmHotelReservationSystem.getContentPane().add(idtxtfld);
				idtxtfld.setColumns(10);
				String id = idtxtfld.getText();      //get id
				
				JButton deletebtn = new JButton("Delete");
				deletebtn.setBounds(183, 180, 117, 29);
				frmHotelReservationSystem.getContentPane().add(deletebtn);
				
		        deletebtn.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	String sql = "DELETE FROM reservations WHERE reservation_id = "+id;
		            	try {
							Statement s = con.createStatement();
							int affectedRows = s.executeUpdate(sql);
							if(affectedRows>0) {
		            			JOptionPane.showMessageDialog(null, "Update Successfull", "Updated!!", JOptionPane.INFORMATION_MESSAGE);
		            		}else {
		            			JOptionPane.showMessageDialog(null, "No reservation found with the given ID", "Error", JOptionPane.ERROR_MESSAGE);
		            		}
						} catch (SQLException e1) {e1.printStackTrace();}
		            }		            		       
		        });
			}
		});
		deleterevbtn.setBounds(150, 217, 171, 29);
		frmHotelReservationSystem.getContentPane().add(deleterevbtn);
		
		JButton exitbtn = new JButton("Exit");
		exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHotelReservationSystem.dispose();
			}
		});
		exitbtn.setBounds(327, 237, 117, 29);
		frmHotelReservationSystem.getContentPane().add(exitbtn);
		
		JButton createtable = new JButton("Create Table");
		createtable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {         //function to create a new table this is to be
				                      							//performed only when the app is runned for the 
																//first time.
				String sql =  "     ";
				
				
				
				
				
			}
		});
		createtable.setBounds(6, 192, 117, 29);
		frmHotelReservationSystem.getContentPane().add(createtable);
		try {
		con.close();
		}catch(Exception e) {e.printStackTrace();}
	}
	}