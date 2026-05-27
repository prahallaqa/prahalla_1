package Medikart;

import java.util.HashMap;
import java.util.Map;

public class Class1 {

	public static void main(String args[]) {

		String input = "prahalla";
		char[] ch = input.toCharArray();
		Map<Character, Integer> obj = new HashMap<>();
		for (char ch1 : ch) {
			obj.put(ch1, obj.getOrDefault(ch1, 0) + 1);
		}
		System.out.println(obj);
	}

}
