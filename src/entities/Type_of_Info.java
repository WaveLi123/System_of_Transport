package entities;

import java.util.ArrayList;
import java.util.List;

public class Type_of_Info{

	public static Object[] FormatInfoTypeName(){
		List<String> tempName=new ArrayList<String>();
		tempName.add("Bus����ģ��");
		tempName.add("Route��·����ģ��");
		tempName.add("Local��·����ģ��");
		tempName.add("LongDistance��·����ģ��");
		tempName.add("Employee����ģ��");
		tempName.add("Manager����ģ��");
		tempName.add("Passenger����ģ��");		
		tempName.add("Bicycle����ģ��");
		return tempName.toArray();	
	}
}
