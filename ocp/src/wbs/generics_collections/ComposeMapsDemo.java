package wbs.generics_collections;

import java.util.HashMap;
import java.util.Map;

public class ComposeMapsDemo {

	public static void main(String[] args) {
		
		String zahlAsBinaryString;
		String zahlAsHexString;
		Map<Integer, String> map1 = new HashMap<>();
		Map<String, String> map2 = new HashMap<>();
		
		for(int i = 10; i<=30;i++) {
			zahlAsBinaryString = Integer.toString(i,2);
			zahlAsHexString = Integer.toString(i,16);
			map1.put(i, zahlAsBinaryString);
			map2.put(zahlAsBinaryString, zahlAsHexString);
		}
		
		Map<Integer, String> result = MapUtil.compose(map1, map2);
		
		for(Map.Entry<Integer, String> entry: result.entrySet()){
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
		
		

	}

}
