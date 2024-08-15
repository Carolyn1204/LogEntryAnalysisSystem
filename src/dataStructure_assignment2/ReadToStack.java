package dataStructure_assignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class ReadToStack {

	public static Stack<String> readFileToStack(String filePath) {
		Stack<String> stack = new Stack<>();

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				stack.push(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return stack;

	}
}