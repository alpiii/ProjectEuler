package EulerHelper;

import java.util.HashMap;
import java.util.Map;

public class NumberLetterCounts {
	private Map<Integer, String> _dict;

	public NumberLetterCounts() {
		this._dict = new HashMap<Integer, String>();
		this._dict.put(-1, "and");
		this._dict.put(0, "");
		this._dict.put(1, "one");
		this._dict.put(2, "two");
		this._dict.put(3, "three");
		this._dict.put(4, "four");
		this._dict.put(5, "five");
		this._dict.put(6, "six");
		this._dict.put(7, "seven");
		this._dict.put(8, "eight");
		this._dict.put(9, "nine");
		this._dict.put(10, "ten");
		this._dict.put(11, "eleven");
		this._dict.put(12, "twelve");
		this._dict.put(13, "thirteen");
		this._dict.put(14, "fourteen");
		this._dict.put(15, "fifteen");
		this._dict.put(16, "sixteen");
		this._dict.put(17, "seventeen");
		this._dict.put(18, "eighteen");
		this._dict.put(19, "nineteen");
		this._dict.put(20, "twenty");
		this._dict.put(30, "thirty");
		this._dict.put(40, "forty");
		this._dict.put(50, "fifty");
		this._dict.put(60, "sixty");
		this._dict.put(70, "seventy");
		this._dict.put(80, "eighty");
		this._dict.put(90, "ninety");
		this._dict.put(100, "hundred");
		this._dict.put(1000, "thousand");
	}

	private int numberLetterCount(int num) {
		return this._dict.get(num).length();
	}

	public int letterCount(int num) {
		if (num < 0 || num > 1000) {
			return -1;
		} else if (num == 100 || num == 1000) {
			return numberLetterCount(1) + numberLetterCount(num);
		} else {
			if (this._dict.containsKey(num)) {
				return numberLetterCount(num);
			} else {
				if (num < 100) {
					int result = 0;
					result += numberLetterCount((num / 10) * 10);
					result += numberLetterCount(num % 10);
					return result;
				} else {
					int result = 0;
					result += numberLetterCount(num / 100);
					result += numberLetterCount(100);
					if (num % 100 != 0)
						result += numberLetterCount(-1);
					result += letterCount(num % 100);
					return result;
				}
			}
		}
	}
}
