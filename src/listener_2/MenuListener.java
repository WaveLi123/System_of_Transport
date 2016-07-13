package listener_2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import frame_2.ImageButton;
import frame_2.MainFrame_2;

public class MenuListener implements ActionListener {
	
	private ImageButton bt_book,bt_taken,bt_handRoom,bt_set,bt_inf,bt_search;

	public MenuListener(ImageButton bt_book, ImageButton bt_taken,
			ImageButton bt_handRoom, ImageButton bt_set, ImageButton bt_inf,
			ImageButton bt_search) {
		super();
		this.bt_book = bt_book;
		this.bt_taken = bt_taken;
		this.bt_handRoom = bt_handRoom;
		this.bt_set = bt_set;
		this.bt_inf = bt_inf;
		this.bt_search = bt_search;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if ((e.getSource() == bt_search)) {
		}
		
		else if ((e.getSource() == bt_book)) {
			MainFrame_2.instance().openBookRoomDialog();
		}
		
		else if((e.getSource() == bt_taken)){
			MainFrame_2.instance().openTakeRoomDialog();
		}
		
		else if(e.getSource()==bt_handRoom){
			MainFrame_2.instance().openHandRoomDialog();
		}else if (e.getSource()==bt_set){			
		}else if(e.getSource()==bt_inf){
			
		}
	}
	
}
