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
import entities.Employee;
import entities.Local;
import entities.LongDistance;
import entities_2.Bike;
import frame.MainFrame;


public class Deleteinfo_LongDistance extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2528010327207966820L;
	//private static BookRoomDialog bookRoomDialog ;
	private JLabel bg;
	private JTextField jtf1;
	private JTextField jtf2;
	private JTextField jtf3;
	private JTextField jtf4;
	private JTextField jtf5;
	private JTextField jtf6;
	private JTextField jtf7;
	
	public Deleteinfo_LongDistance(){

		bg=new JLabel(new ImageIcon(this.getClass().getResource("/image_2/LongDistance_Info.png")));
		
		jtf1 = new JTextField();
		jtf2 = new JTextField();
		jtf3 = new JTextField();
		jtf4 = new JTextField();
		jtf5 = new JTextField();
		jtf6 = new JTextField();
		jtf7 = new JTextField();
		
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
		add(jtf6);
		add(jtf7);
		add(bg);
		
		bg.setBounds(0, 0, (int) getWidth(),(int) getHeight());
		
		//部件位置摆放
		jtf1.setBounds(133, 83, 74, 22);
		jtf2.setBounds(133, 113, 74, 22);
		jtf3.setBounds(133, 142, 74, 22);
		jtf4.setBounds(133, 169, 74, 22);
		jtf5.setBounds(133, 196, 74, 22);
		jtf6.setBounds(133, 224, 74, 22);
		jtf7.setBounds(133, 251, 74, 22);
		//设置控件不可编辑
		jtf1.setEditable(false);
		jtf2.setEditable(false);
		jtf3.setEditable(false);
		jtf4.setEditable(false);
		jtf5.setEditable(false);
		jtf6.setEditable(false);
		jtf7.setEditable(false);
		
		ensure.setBounds(350, 200, 48, 48);
		cancel.setBounds(410, 200, 48, 48);
							
		ensure.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(jtf1.getText().equalsIgnoreCase("") 
					||jtf2.getText().equalsIgnoreCase("") 
					||jtf3.getText().equalsIgnoreCase("")
					||jtf4.getText().equalsIgnoreCase("")
					||jtf5.getText().equalsIgnoreCase("")
					||jtf6.getText().equalsIgnoreCase("")
					||jtf7.getText().equalsIgnoreCase("") ){
					
					JOptionPane.showMessageDialog(null, "请输入完整的信息！", "提示",JOptionPane.ERROR_MESSAGE);
				}
				else{					
					LongDistance temp = new LongDistance(jtf1.getText(),jtf2.getText(),jtf3.getText(),jtf4.getText(),jtf5.getText(),jtf6.getText(),jtf7.getText());
					try {
						temp.deleteDB(jtf1.getText());				
						JOptionPane.showMessageDialog(null, "您选择的信息已删除！", "提示",JOptionPane.ERROR_MESSAGE);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "数据库插入异常！", "提示",JOptionPane.ERROR_MESSAGE);
					}
					MainFrame.instance().closeDeleteinfo_LongDistance();
				}				
			}			
		});
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {				
				MainFrame.instance().closeDeleteinfo_LongDistance();
			}
		});
		this.setVisible(false);	
	}
	public void setDefaultInfo(String Num) throws ClassNotFoundException, SQLException{		
		int i = 0; 
		LongDistance temp = new LongDistance();
		String [] value = temp.getinfo(Num);
		jtf1.setText(value[i++]);
		jtf2.setText(value[i++]);
		jtf3.setText(value[i++]);
		jtf4.setText(value[i++]);
		jtf5.setText(value[i++]);
		jtf6.setText(value[i++]);
		jtf7.setText(value[i++]);
	}
}
