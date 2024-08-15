package dataStructure_assignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;


public class ReadToQueue {

	public static Queue<String> readFileToQueue(String filePath) {
		Queue<String> queue = new LinkedList<>();


		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				queue.offer(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return queue;

	}

}
