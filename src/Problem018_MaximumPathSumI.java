/**
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.
 * 
 *      [3]
 *    [7]  4
 *   2  [4]  6
 * 8   5  [9]  3
 * 
 * That is, 3 + 7 + 4 + 9 = 23.
 * 
 * Find the maximum total from top to bottom of the triangle below:
 * 
 *                             75
 *                           95  64
 *                         17  47  82
 *                       18  35  87  10
 *                     20  04  82  47  65
 *                   19  01  23  75  03  34
 *                 88  02  77  73  07  63  67
 *               99  65  04  28  06  16  70  92
 *             41  41  26  56  83  40  80  70  33
 *           41  48  72  33  47  32  37  16  94  29
 *         53  71  44  65  25  43  91  52  97  51  14
 *       70  11  33  28  77  73  17  78  39  68  17  57
 *     91  71  52  38  17  14  91  43  58  50  27  29  48
 *   63  66  04  68  89  53  67  30  73  16  69  87  40  31
 * 04  62  98  27  23  09  70  98  73  93  38  53  60  04  23
 * 
 * NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. 
 * However, Problem 67, is the same challenge with a triangle containing one-hundred rows; 
 * it cannot be solved by brute force, and requires a clever method! ;o)
 * 
 * @author rajabatu
 *
 */
public class Problem018_MaximumPathSumI {
	
	private static Point best = null;
	
	static final String input = "75 " + 
								"95 64 " + 
								"17 47 82 " + 
								"18 35 87 10 " + 
								"20 04 82 47 65 " + 
								"19 01 23 75 03 34 " + 
								"88 02 77 73 07 63 67 " + 
								"99 65 04 28 06 16 70 92 " + 
								"41 41 26 56 83 40 80 70 33 " + 
								"41 48 72 33 47 32 37 16 94 29 " + 
								"53 71 44 65 25 43 91 52 97 51 14 " + 
								"70 11 33 28 77 73 17 78 39 68 17 57 " + 
								"91 71 52 38 17 14 91 43 58 50 27 29 48 " + 
								"63 66 04 68 89 53 67 30 73 16 69 87 40 31 " + 
								"04 62 98 27 23 09 70 98 73 93 38 53 60 04 23 ";
	
	static final int height = 15;

	public static void main(String[] args) {
		
		Object[] data = parsingData(input, height);
		
		printData(data);
		
		Problem018_MaximumPathSumI soal = new Problem018_MaximumPathSumI();
		
		soal.searchBestRoute(data);
		
		System.out.println("Best route:");
		for (int i = 0; i < best.route.length; i++) 
		{
			System.out.println("row " + i + " col " + best.route[i] + " => " + ((int[])(data[i]))[best.route[i]]);
		}
		
		System.out.println("Maximum total is " + best.total);
		
	}
	
	/**
	 * Parsing input
	 * @param input
	 * @return
	 */
	public static Object[] parsingData(String input, int height) 
	{
		String[] inputs = input.split(" ");
		
		Object[] data = new Object[height];
		
		int row = 1;
		int col = 0;
		
		for (String s : inputs) 
		{
			if (col == 0) 
			{
				data[row - 1] = new int[row];
			}
			
			int[] d = (int[]) data[row - 1];
			
			d[col] = Integer.valueOf(s);
			
			col++;
			
			if (col == row) 
			{
				row++;
				col = 0;
			}
			
		}
		
		return data;
	}
	
	/**
	 * Print data
	 * @param data
	 */
	public static void printData(Object[] data) 
	{
		int space = data.length - 1;
		
		for (Object object : data) 
		{
			for (int i = 0; i < space; i++) 
			{
				System.out.printf("  ");
			}
			space --;
			
			for (int i : (int[]) object) 
			{
				System.out.printf("  %02d", i);
			}
			
			System.out.println();
		}
	}
	
	/**
	 * Search for the best route
	 * @param data
	 * @return
	 */
	public void searchBestRoute(Object[] data) 
	{
		Object ar = data[0];
		
		Point p = new Point(data.length);
		
		p.row = 0;
		p.col = 0;
		p.total = ((int[]) ar) [p.col];
		
		find(p, data);
	}
	
	class Point {
		
		int[] route;
		int row;
		int col;
		int total;
		
		Point(int numberOfRoute) 
		{
			route = new int[numberOfRoute];
		}
		
	}
	
	public void find(Point p, Object[] data) 
	{
		int row = p.row;
		int col = p.col;
		
		if (row == data.length - 1) 
		{
			if (best == null) 
			{
				best = p;
			}
			
			if (p.total > Problem018_MaximumPathSumI.best.total) 
			{
				best = p;
			}
			
			return;
		}
		
		Object ar = data[row + 1];
		
		Point left = new Point(data.length);
		Point right = new Point(data.length);
		
		left.row = row + 1;
		left.col = col;
		left.total = p.total + ((int[]) ar) [left.col];
		left.route = p.route.clone();
		left.route[left.row] = left.col;
		find(left, data);
		
		right.row = row + 1;
		right.col = col + 1;
		right.total = p.total + ((int[]) ar) [right.col];
		right.route = p.route.clone();
		right.route[right.row] = right.col;
		find(right, data);
	}
	
}
