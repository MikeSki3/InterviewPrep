package ctci.recursionanddynamicprogramming;

import java.util.Random;

public class RobotInGrid {
	static int r = 7, c = 7;
	static int cellsToBlock = 10;
	static int[][] grid;

	public static void main(String[] args) {
		grid = new int[r][c];
		buildGrid(grid);
		findPath(grid);
		printGrid(grid);
	}

	private static void printGrid(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void findPath(int[][] grid) {
		System.out.println(findPath(grid, 0, 0));
	}

	private static boolean findPath(int[][] grid, int i, int j) {
		if(i >= grid.length || j >= grid[i].length || grid[i][j] == 1)
			return false;
		grid[i][j] = 2;
		if(i == grid.length - 1 && j == grid[i].length - 1)
			return true;
		return findPath(grid, i, j + 1) || findPath(grid, i + 1, j);
		
	}

	private static void buildGrid(int[][] grid) {
		Random rand = new Random(7);
		for (int i = 0; i < cellsToBlock; i++) {
			boolean notBlocked = true;
			while (notBlocked) {
				int currR = rand.nextInt(r);
				int currC = rand.nextInt(c);
				if (grid[currR][currC] == 0) {
					grid[currR][currC] = 1;
					notBlocked = false;
				}
			}
		}
	}
}
