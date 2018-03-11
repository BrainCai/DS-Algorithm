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
		case "ArrayList":
			System.out.println(JSON.toJSONString(message));
			break;
		}
	}

	public static void main(String[] args) {
		int a = 0;
		Object object = a;
		System.out.println(object.getClass().getSimpleName());

	}
}
