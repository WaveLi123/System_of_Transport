package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entities.Transportation;

import frame.ImageButton;
import frame.MainFrame;
import frame.ResultPanel;

public class Add_Info_DialogListener implements ActionListener {
	
	private JTextField jtfName;
	private JTextField jtfPhoneNum;
	private JComboBox jcbRoomType;
	private ImageButton ensure ;
	private ImageButton cancel ;
	
	public Add_Info_DialogListener(JTextField jtfName, JTextField jtfPhoneNum,
			JComboBox jcbRoomType, ImageButton ensure, ImageButton cancel) {
		super();
		this.jtfName = jtfName;
		this.jtfPhoneNum = jtfPhoneNum;
		this.jcbRoomType = jcbRoomType;
		this.ensure = ensure;
		this.cancel = cancel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==ensure){
			String type =(String)jcbRoomType.getSelectedItem();
			if(type.equalsIgnoreCase("Bus����ģ��")){
				MainFrame.instance().closeAdd_Info_Dialog();
				MainFrame.instance().openAddinfo_Bus();				
			}
			if(type.equalsIgnoreCase("Route��·����ģ��")){
				MainFrame.instance().closeAdd_Info_Dialog();
				MainFrame.instance().openAddinfo_Route();				
			}
			if(type.equalsIgnoreCase("Local��·����ģ��")){
				MainFrame.instance().closeAdd_Info_Dialog();
				MainFrame.instance().openAddinfo_Local();				
			}
			if(type.equalsIgnoreCase("LongDistance��·����ģ��")){
				MainFrame.instance().closeAdd_Info_Dialog();
				MainFrame.instance().openAddinfo_LongDistance();				
			}
			if(type.equalsIgnoreCase("Employee����ģ��")){
				MainFrame.instance().closeAdd_Info_Dialog();
				MainFrame.instance().openAddinfo_Employee();				
			}
			if(type.equalsIgnoreCase("Manager����ģ��")){
				MainFrame.instance().closeAdd_Info_Dialog();
				MainFrame.instance().openAddinfo_Manager();				
			}
			if(type.equalsIgnoreCase("Passenger����ģ��")){
				MainFrame.instance().closeAdd_Info_Dialog();
				MainFrame.instance().openAddinfo_Passenger();				
			}
			if(type.equalsIgnoreCase("Bicycle����ģ��")){
				MainFrame.instance().closeAdd_Info_Dialog();
				MainFrame.instance().openAddinfo_Bicycle();				
			}			
		}else if(e.getSource()==cancel){
			//�رո����
			MainFrame.instance().closeAdd_Info_Dialog();
		}
	}		
}
