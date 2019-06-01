package EulerHelper;

import java.util.Arrays;

public class PandigitalNumbers {

	public static final String pandigitalStr = "123456789";

	public static boolean hasPandigitalProduct(int num) {
		for(int i = 1; i <= num; i++) {
			if(num % i == 0 && isPandigital("" + i + (num / i) + num))
				return true;
		}
		return false;
	}

	public static boolean isPandigital(String num) {
		if (num.length() != 9)
			return false;
		char[] charsOfNum = num.toCharArray();
		Arrays.sort(charsOfNum);
		if(pandigitalStr.equals(new String(charsOfNum)))
			return true;
		else
			return false;
	}
}
