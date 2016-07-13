package listener_2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.BikeTypeData;
import entities_2.Booking;
import entities_2.Transport_B;

import frame_2.ImageButton;
import frame_2.MainFrame_2;
import frame_2.ResultPanel;

public class BookBikeDialogListener implements ActionListener {
	
	private JTextField jtfName;
	private JTextField jtfPhoneNum;
	private JComboBox jcbRoomType;
	private ImageButton ensure ;
	private ImageButton cancel ;
	
	public BookBikeDialogListener(JTextField jtfName, JTextField jtfPhoneNum,
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
			//插入预定列表
			String name =jtfName.getText();
			String phoneNum =jtfPhoneNum.getText();
			String type =(String)jcbRoomType.getSelectedItem();
			if(name==""||name.length()==0)
				JOptionPane.showMessageDialog(null, "请输入姓名！", "提示",
						JOptionPane.ERROR_MESSAGE);
			
			else if(phoneNum==""||phoneNum.length()==0)
				JOptionPane.showMessageDialog(null, "请输入电话号码！", "提示",
						JOptionPane.ERROR_MESSAGE);
			else{			
						
			Booking book = new Booking(jtfName.getText(),jtfPhoneNum.getText(),jcbRoomType.getSelectedItem().toString());
			System.out.println("Bookroomdialog "+(String)jcbRoomType.getSelectedItem());
			try {
				book.storeToDB();
				ResultPanel.instance().showBookingData();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
				MainFrame_2.instance().closeBookRoomDialog();
			}					
		}else if(e.getSource()==cancel){
			//关闭该面板
			MainFrame_2.instance().closeBookRoomDialog();
		}
	}	
}
