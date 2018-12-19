/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * 
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 * 
 * @author rajabatu
 *
 */
public class Problem005_SmallestMultiple {

	public static void main(String[] args) {
		
		long number = 1;
		long result = 0;
		
		while (result == 0) 
		{
//			System.out.println(number);
			
			if ((number % 20 == 0) && (number % 19 == 0) && (number % 18 == 0) && (number % 17 == 0) && (number % 16 == 0) && 
					(number % 15 == 0) && (number % 14 == 0) && (number % 13 == 0) && (number % 12 == 0) && (number % 11 == 0)) 
			{
				result = number;
			}
			
			number++;
		}
		
		System.out.println();
		System.out.println("Answer: " + String.valueOf(result));
	}

}
