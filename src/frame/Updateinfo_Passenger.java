package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import entities.Bus;
import entities.Manager;
import entities.Passenger;
import entities_2.Bike;
import frame.MainFrame;


public class Updateinfo_Passenger extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2528010327207966820L;
	//private static BookRoomDialog bookRoomDialog ;
	private JLabel bg;
	private JTextField jtf1;
	private JTextField jtf2;
	private JComboBox jtf3;
	private JTextField jtf4;
	private JTextField jtf5;
	
	public Updateinfo_Passenger(){

		bg=new JLabel(new ImageIcon(this.getClass().getResource("/image_2/Passenger_Info.png")));
		
		jtf1 = new JTextField();
		jtf2 = new JTextField();
		String value[] = {"男","女"};
		jtf3 = new JComboBox(value);
		jtf4 = new JTextField();
		jtf5 = new JTextField();
		ImageButton ensure = new ImageButton("ok");
		ImageButton cancel = new ImageButton("cancel");
		
		this.setSize(479, 275);
		this.setLayout(null);
		this.setOpaque(false);
				
		bg.setOpaque(false);
		
		add(ensure);
		add(cancel);
		add(jtf1);
		add(jtf2);
		add(jtf3);
		add(jtf4);
		add(jtf5);
		add(bg);
		
		bg.setBounds(0, 0, (int) getWidth(),(int) getHeight());
		
		//部件位置摆放
		jtf1.setBounds(102, 76, 74, 22);
		jtf2.setBounds(103, 113, 74, 22);
		jtf3.setBounds(104, 148, 74, 22);
		jtf4.setBounds(105, 184, 74, 22);
		jtf5.setBounds(105, 218, 74, 22);
		
		
		ensure.setBounds(350, 200, 48, 48);
		cancel.setBounds(410, 200, 48, 48);
							
		ensure.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(jtf1.getText().equalsIgnoreCase("") 
					||jtf2.getText().equalsIgnoreCase("") 
					||jtf3.getToolTipText().equalsIgnoreCase("")
					||jtf4.getText().equalsIgnoreCase("")
					||jtf5.getText().equalsIgnoreCase("") ){
					
					JOptionPane.showMessageDialog(null, "请输入完整的信息！", "提示",JOptionPane.ERROR_MESSAGE);
				}
				else{					
					Passenger temp = new Passenger(jtf1.getText(),jtf2.getText(),jtf3.getToolTipText(),jtf4.getText(),jtf5.getText());
					try {
						temp.storeToDB();						
						JOptionPane.showMessageDialog(null, "您修改的信息已保存！", "提示",JOptionPane.ERROR_MESSAGE);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "数据库插入异常！", "提示",JOptionPane.ERROR_MESSAGE);
					}
					MainFrame.instance().closeUpdateinfo_Passenger();
				}				
			}
			
		});
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {				
				MainFrame.instance().closeUpdateinfo_Passenger();
			}
		});
		this.setVisible(false);	
	}	
	public void setDefaultInfo(String Num) throws ClassNotFoundException, SQLException{		
		int i = 0; 
		Passenger temp = new Passenger();
		String [] value = temp.getinfo(Num);
		jtf1.setText(value[i++]);
		jtf2.setText(value[i++]);
		jtf3.setToolTipText(value[i++]);
		jtf4.setText(value[i++]);
		jtf5.setText(value[i++]);		
	}
}
