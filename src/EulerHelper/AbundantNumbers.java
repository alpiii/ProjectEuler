package EulerHelper;

import java.util.ArrayList;
import java.util.List;

public class AbundantNumbers {

	public static boolean isAbundant(int num) {
		int divisorSum = 0;
		for (int i = 1; i < num; i++) {
			if (num % i == 0) {
				divisorSum += i;
			}
		}
		if (divisorSum > num) {
			return true;
		}
		return false;
	}

	public static List<Integer> abundantNumberList(int min, int max) {
		List<Integer> abundantNumbers = new ArrayList<Integer>();
		for (int i = min; i <= max; i++) {
			if (isAbundant(i))
				abundantNumbers.add(i);
		}
		return abundantNumbers;
	}
}
