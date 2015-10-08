package wbs.nested_classes;

import java.util.ArrayList;
import java.util.List;

public class MyListDemo {

	public static void main(String[] args) {
		List<Integer> iList = new ArrayList<>();
		iList.add(1);
		iList.add(2);
		iList.add(3);
		iList.add(4);
		MyList<Integer> list = new MyList<>(iList);
		for (List<Integer> subList : list)
			System.out.println(subList);

	}

}
