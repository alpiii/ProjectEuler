package EulerHelper;

public class PalindromeNumbers {

	public static boolean isPalindrome(int num) {
		int result = 0;
		int temp = num;
		while (temp >= 1) {
			result = (result * 10 + temp % 10);
			temp /= 10;
		}
		if (num == result)
			return true;
		else
			return false;
	}
}
