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

	public static boolean isPalindromeBigNumber(String num) {
		String result = "";
		String temp = num;
		while (temp.length() > 0) {
			result = BigNumbers.bigSum(result + "0", String.valueOf(temp.charAt(temp.length() - 1)));
			temp = temp.substring(0, temp.length() - 1);
		}
		if (num.equals(result))
			return true;
		else
			return false;
	}
}
