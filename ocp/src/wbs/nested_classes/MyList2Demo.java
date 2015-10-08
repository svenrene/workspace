package wbs.nested_classes;

import java.util.ArrayList;
import java.util.List;


public class MyList2Demo {

	public static void main(String[] args) {
		List<String> iList = new ArrayList<>();
		iList.add("jack");
		iList.add("mick");
		iList.add("anaximander");

		MyList2<String> list = new MyList2<>(iList);
		for (List<String> subList : list)
			System.out.println(subList);

	}

}