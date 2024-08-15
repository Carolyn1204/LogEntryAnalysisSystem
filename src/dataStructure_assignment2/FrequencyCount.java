package dataStructure_assignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FrequencyCount {

	public static Map<String, Integer> frequencyCount(String filePath) {

		Map<String, Integer> freMap = new HashMap<>();
		Pattern pattern = Pattern.compile("\\[(.*?)\\]");
		String line;
		String logType;

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

			while ((line = br.readLine()) != null) {
				Matcher matcher = pattern.matcher(line);
				if (matcher.find()) {
					logType = matcher.group(1);

					if (freMap.containsKey(logType)) {

						freMap.put(logType, freMap.get(logType) + 1);
					}

					else {
						freMap.put(logType, 1);
					}

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return freMap;
	}

}
