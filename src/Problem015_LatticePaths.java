/**
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, 
 * there are exactly 6 routes to the bottom right corner.
 * 
 * How many such routes are there through a 20×20 grid?
 * 
 * @author rajabatu
 *
 */
public class Problem015_LatticePaths {
	
	public static int GRID_COL	= 20;
	public static int GRID_ROW	= 20;
	
	public static void main(String[] args) 
	{
		long[][] grid = new long[GRID_ROW + 1][GRID_COL + 1];
		
		for (int i = 0; i < GRID_COL; i++) 
		{
			grid[GRID_ROW][i] = 1;
		}
		
		for (int i = 0; i < GRID_ROW; i++) 
		{
			grid[i][GRID_COL] = 1;
		}
		
		for (int i = GRID_ROW - 1; i >= 0; i--) 
		{
			for (int j = GRID_COL - 1; j >= 0; j--) 
			{
				grid[i][j] = grid[i][j + 1] + grid[i + 1][j];
				
				if (i == j)
					System.out.println((GRID_ROW - i) + " x " + (GRID_COL - j) + " : " + grid[i][j]);
			}
		}
		
		System.out.println("Possible paths in a " + GRID_COL + " X " + GRID_ROW + " are " + grid[0][0]);
	}

}
