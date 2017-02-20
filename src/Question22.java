
/*
 * Names scores
Problem 22
Using names.txt (right click and 'Save Link/Target As...'), a 46K text 
file containing over five-thousand first names, begin by sorting it 
into alphabetical order. Then working out the alphabetical value 
for each name, multiply this value by its alphabetical position 
in the list to obtain a name score.

For example, when the list is sorted into alphabetical order, 
COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name 
in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

What is the total of all the name scores in the file?
 * 
 */

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;

public class Question22 {

	public static void main(String[] args) {

		final long start = System.nanoTime();
		int result = namesScores();
		final long end = System.nanoTime();
		System.out.println("Took: " + ((end - start) / 1000000) + "ms. Result : " + result);
	}

	private static int namesScores() {

		HashMap<String, Integer> letterValue = new HashMap<String, Integer>();
		letterValue.put("A", 1);
		letterValue.put("B", 2);
		letterValue.put("C", 3);
		letterValue.put("D", 4);
		letterValue.put("E", 5);
		letterValue.put("F", 6);
		letterValue.put("G", 7);
		letterValue.put("H", 8);
		letterValue.put("I", 9);
		letterValue.put("J", 10);
		letterValue.put("K", 11);
		letterValue.put("L", 12);
		letterValue.put("M", 13);
		letterValue.put("N", 14);
		letterValue.put("O", 15);
		letterValue.put("P", 16);
		letterValue.put("Q", 17);
		letterValue.put("R", 18);
		letterValue.put("S", 19);
		letterValue.put("T", 20);
		letterValue.put("U", 21);
		letterValue.put("V", 22);
		letterValue.put("W", 23);
		letterValue.put("X", 24);
		letterValue.put("Y", 25);
		letterValue.put("Z", 26);

		String text = null;
		try {
			File file = new File("names.txt");
			FileInputStream fis = new FileInputStream(file);
			byte[] data = new byte[(int) file.length()];
			fis.read(data);
			fis.close();

			text = new String(data, "UTF-8");
		} catch (Exception ex) {
			ex.printStackTrace();
			return -1;
		}

		if (text != null && text != "") {
			String[] names = text.split(",");
			// sorting names in alphabetical order
			Arrays.sort(names);

			int wordScore = 0;
			int sum = 0;
			for (int i = 0; i < names.length; i++) {
				wordScore = 0;
				// calculating score of each word
				for (char ch : names[i].toCharArray()) {
					if (ch != '\"') // skipping quotation mark
						wordScore += letterValue.get(String.valueOf(ch));
				}
				sum += (wordScore * (i + 1));
			}
			return sum;
		} else {
			return -1;
		}
	}
}
