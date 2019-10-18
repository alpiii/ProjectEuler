package Questions1To50;
/*
 * Lattice paths
Problem 15
Starting in the top left corner of a 2×2 grid, and only 
being able to move to the right and down, there are 
exactly 6 routes to the bottom right corner.


How many such routes are there through a 20×20 grid?
 * 
 */

import java.util.HashMap;

public class Question15 {

	private static HashMap<String, Long> gridMap = new HashMap<String, Long>();

	public static void main(String[] args) {

		final long start = System.nanoTime();
		long result = calc(0, 0, 20);
		final long end = System.nanoTime();
		System.out.println("Took: " + ((end - start) / 1000000) + "ms. Result : " + result);
	}

	private static int calcGridSize(int x, int y, int gridSize) {
		return (gridSize - x) * (gridSize - y);
	}

	private static long calc(int x, int y, int gridSize) {
		long result = 0L;

		int newGridSize = calcGridSize(x, y, gridSize);
		if (newGridSize == 0)
			return 1;

		String newGrid = (gridSize - x) + "x" + (gridSize - y);

		if (!gridMap.containsKey(newGrid)) {
			if (x < gridSize)
				result += calc(x + 1, y, gridSize);
			if (y < gridSize)
				result += calc(x, y + 1, gridSize);
			if (x == gridSize && y == gridSize)
				return 1;

			gridMap.put(newGrid, result);
		}

		return gridMap.get(newGrid);
	}
}
