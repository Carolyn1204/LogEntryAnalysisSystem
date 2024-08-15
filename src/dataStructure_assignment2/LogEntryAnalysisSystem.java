package dataStructure_assignment2;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class LogEntryAnalysisSystem {

	public static void main(String[] args) {

		String filePath = "src/dummy_log_entries.txt";
		Runtime runtime = Runtime.getRuntime();
		Scanner scanner = new Scanner(System.in);
		int choice = 0;

		do {
			System.out.println("\nWELCOME TO MUSIC PLAYLIST MANAGEMENT SYSTEM");
			System.out.println("Please enter your choice: ");
			System.out.println("1. Log reversal order display and performance metrics:");
			System.out.println("2. Log original order display and performance metrics:");
			System.out.println("3. Frequency Analysis of Log Entries:");
			System.out.println("0. Exit");

			choice = scanner.nextInt();
			// scanner.nextLine();

			switch (choice) {
			case 1:

				long beforeMemory = runtime.totalMemory() - runtime.freeMemory();

				Stack<String> logStack = ReadToStack.readFileToStack(filePath);

				long afterMemory = runtime.totalMemory() - runtime.freeMemory();

				long startTime = System.currentTimeMillis();
				while (!logStack.isEmpty()) {
					System.out.println(logStack.pop());

				}
				long endTime = System.currentTimeMillis();

				System.out.println("---------------------------------");
				System.out.println("Running Time: " + (double) (endTime - startTime) / 1000 + " second");
				System.out.println("Memory used by stack: " + (afterMemory - beforeMemory) / 1024 + " KB");

				break;

			case 2:

				long beforeMemory2 = runtime.totalMemory() - runtime.freeMemory();

				Queue<String> queue = ReadToQueue.readFileToQueue(filePath);

				long afterMemory2 = runtime.totalMemory() - runtime.freeMemory();

				long startTime2 = System.currentTimeMillis();
				while (!queue.isEmpty()) {
					System.out.println(queue.poll());

				}
				long endTime2 = System.currentTimeMillis();

				System.out.println("---------------------------------");
				System.out.println("Running Time: " + (double) (endTime2 - startTime2) / 1000 + " second");
				System.out.println("Memory used by queue: " + (afterMemory2 - beforeMemory2) / 1024 + " KB");
				break;

			case 3:
				
				long beforeMemory3 = runtime.totalMemory() - runtime.freeMemory();
				long startTime3 = System.currentTimeMillis();
				
				Map<String, Integer> countMap = new HashMap<String, Integer>();
				countMap = FrequencyCount.frequencyCount(filePath);
				
				long endTime3 = System.currentTimeMillis();
				long afterMemory3 = runtime.totalMemory() - runtime.freeMemory();
				
				for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
					System.out.println(entry.getKey() + " Frequency: " + entry.getValue());
				}
				
				System.out.println("---------------------------------");
				System.out.println("Running Time: " + (double) (endTime3 - startTime3) / 1000 + " second");
				System.out.println("Memory used by hashmap: " + (afterMemory3 - beforeMemory3) / 1024 + " KB");
				break;

			case 0:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice. Please enter again");
			}
		} while (choice != 0);
		scanner.close();

	}
}
