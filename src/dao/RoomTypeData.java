package dao;

import java.util.ArrayList;
import java.util.List;


public class RoomTypeData{	
	public static RoomTypeData roomTypeData;
	
	
//����ģʽ��ֻ����һ��ʵ����������ʵ���Զ������ջ��ƻ���	
	public static RoomTypeData instance(){
		if(roomTypeData==null){
			roomTypeData=new RoomTypeData();
		}	
		return roomTypeData;
	}
	
	
	public Object[] FormatRoomTypeName(){
		List<String> tempName=new ArrayList<String>();
		tempName.add("�ɸ�");
		tempName.add("��ͨ");
		tempName.add("�ƴ�");
		tempName.add("����");
		tempName.add("���");
		tempName.add("�й�");
		tempName.add("����");
		return tempName.toArray();
	}
	public static RoomTypeData getRoomTypeData() {
		return roomTypeData;
	}
	public static void setRoomTypeData(RoomTypeData roomTypeData) {
		RoomTypeData.roomTypeData = roomTypeData;
	}
}
