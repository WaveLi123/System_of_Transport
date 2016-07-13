package entities;

import java.util.ArrayList;
import java.util.List;

public class Type_of_Info{

	public static Object[] FormatInfoTypeName(){
		List<String> tempName=new ArrayList<String>();
		tempName.add("Bus管理模块");
		tempName.add("Route线路管理模块");
		tempName.add("Local线路管理模块");
		tempName.add("LongDistance线路管理模块");
		tempName.add("Employee管理模块");
		tempName.add("Manager管理模块");
		tempName.add("Passenger管理模块");		
		tempName.add("Bicycle管理模块");
		return tempName.toArray();	
	}
}
