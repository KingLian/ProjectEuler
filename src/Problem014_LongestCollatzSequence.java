/**
 * The following iterative sequence is defined for the set of positive integers:
 * 
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 * 
 * Using the rule above and starting with 13, we generate the following sequence:
 * 
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * 
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. 
 * Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 * 
 * Which starting number, under one million, produces the longest chain?
 * 
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 * 
 * @author rajabatu
 *
 */
public class Problem014_LongestCollatzSequence {

	public static void main(String[] args) {
		
		int longest = 0;
		int longestChain = 0;
		
		int startingNumber = 999999;
		
		while (startingNumber > 0) 
		{
			int chains = collatzSequence(startingNumber);
			if (chains > longestChain) 
			{
				longest = startingNumber;
				longestChain = chains;
//				System.err.println(longest);
			}
			
			startingNumber--;
		}
		
		System.out.println(longest);
		System.out.println(longestChain);
	}
	
	public static final int collatzSequence(long startingNumber) 
	{
		int chain = 1;
		
		System.out.printf("%d", startingNumber);
		
		while (startingNumber != 1) 
		{
			chain++;
			
			if ((startingNumber & 1) == 0) 
			{
				// Even
				startingNumber /= 2;
//				System.out.printf(" -> %d", startingNumber);
			}
			else 
			{
				// Odd
				startingNumber = (3 * startingNumber) + 1;
//				System.out.printf(" -> %d", startingNumber);
			}
		}
		
		System.out.printf(" [%d]\n", chain);
		
		return chain;
	}

}
