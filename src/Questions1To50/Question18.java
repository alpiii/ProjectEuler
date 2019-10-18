package Questions1To50;
/*
 * Maximum path sum I
Problem 18
By starting at the top of the triangle below and moving to adjacent 
numbers on the row below, the maximum total from top to bottom is 23.

3
7 4
2 4 6
8 5 9 3

That is, 3 + 7 + 4 + 9 = 23.

Find the maximum total from top to bottom of the triangle below:

75
95 64
17 47 82
18 35 87 10
20 04 82 47 65
19 01 23 75 03 34
88 02 77 73 07 63 67
99 65 04 28 06 16 70 92
41 41 26 56 83 40 80 70 33
41 48 72 33 47 32 37 16 94 29
53 71 44 65 25 43 91 52 97 51 14
70 11 33 28 77 73 17 78 39 68 17 57
91 71 52 38 17 14 91 43 58 50 27 29 48
63 66 04 68 89 53 67 30 73 16 69 87 40 31
04 62 98 27 23 09 70 98 73 93 38 53 60 04 23

NOTE: As there are only 16384 routes, it is possible 
to solve this problem by trying every route. 
However, Problem 67, is the same challenge with a triangle 
containing one-hundred rows; it cannot be solved by brute force, 
and requires a clever method! ;o)
 * 
 */

public class Question18 {

	public static void main(String[] args) {

		final long start = System.nanoTime();
		String[] strNums = new String[15];

		strNums[0] = "75";
		strNums[1] = "95 64";
		strNums[2] = "17 47 82";
		strNums[3] = "18 35 87 10";
		strNums[4] = "20 04 82 47 65";
		strNums[5] = "19 01 23 75 03 34";
		strNums[6] = "88 02 77 73 07 63 67";
		strNums[7] = "99 65 04 28 06 16 70 92";
		strNums[8] = "41 41 26 56 83 40 80 70 33";
		strNums[9] = "41 48 72 33 47 32 37 16 94 29";
		strNums[10] = "53 71 44 65 25 43 91 52 97 51 14";
		strNums[11] = "70 11 33 28 77 73 17 78 39 68 17 57";
		strNums[12] = "91 71 52 38 17 14 91 43 58 50 27 29 48";
		strNums[13] = "63 66 04 68 89 53 67 30 73 16 69 87 40 31";
		strNums[14] = "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";

		int[][] nums = new int[15][15];
		String[] splitted;
		for (int i = 0; i < strNums.length; i++) {
			splitted = strNums[i].split(" ");
			for (int j = 0; j < splitted.length; j++) {
				nums[i][j] = Integer.valueOf(splitted[j]);
			}
		}
		int result = calcMaxValue(nums);
		final long end = System.nanoTime();
		System.out.println("Took: " + ((end - start) / 1000000) + "ms. Result : " + result);
	}

	private static int calcMaxValue(int[][] nums) {
		for (int i = 13; i >= 0; i--) {
			for (int j = 0; j < i + 1; j++) {
				nums[i][j] = Integer.max(nums[i][j] + nums[i + 1][j], nums[i][j] + nums[i + 1][j + 1]);
			}
		}
		return nums[0][0];
	}
}
