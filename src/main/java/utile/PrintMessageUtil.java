package utile;

import com.alibaba.fastjson.JSON;

public class PrintMessageUtil {

	public static void printMsgWithoutNewLine(Object message) {

		switch (message.getClass().getSimpleName()) {
		case "String":
			System.out.print(message);
			break;
		case "Integer":
			System.out.print(String.valueOf(message));
			break;
		case "List":
			System.out.println(JSON.toJSONString(message));
			break;
		}

	}

	public static void printMsgWithNewLine(Object message) {

		switch (message.getClass().getSimpleName()) {
		case "String":
			System.out.println(message);
			break;
		case "Integer":
			System.out.println(String.valueOf(message));
			break;
		case "Boolean":
			System.out.println(message);
			break;
		case "ArrayList":
			System.out.println(JSON.toJSONString(message));
			break;
		}
	}

	public static void printIntArrayWithoutNewline(int[] nums) {
		for (int j = 0; j < nums.length; j++) {
			System.out.println(nums[j]);
		}
	}

}
