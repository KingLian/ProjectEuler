import java.util.ArrayList;
import java.util.List;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * 
 * Find the sum of all the primes below two million.
 * 
 * @author rajabatu
 *
 */
public class Problem010_SummationOfPrimes {

	public static void main(String[] args) {
		
		List<Long> prime = new ArrayList<Long>();
		
		prime.add((long) 2);
		prime.add((long) 3);
		
		long number = 5;
		boolean isPrime = true;
		
		while (number < 2000000) 
		{
			long sqrNumber = (long) Math.sqrt(number);
			
			for (long pr : prime) 
			{
				if (number % pr == 0) 
				{
					isPrime = false;
					break;
				}
				
				if (pr > sqrNumber) 
				{
					break;
				}
			}
			
			if (isPrime) 
			{
				prime.add(number);
				System.out.println(prime.size() + ": " + number);
			}
			
			// Check the next number
			isPrime = true;
			
			if (number % 10 == 3) 
			{
				number += 4;
			} 
			else 
			{
				number += 2;
			}
		}
		
		long sum = 0;
		
		for (Long pr : prime) 
		{
			sum += pr;
		}
		
		System.out.println();
		System.out.println("Sum of 2.000.000 primes: " + sum);
	}

}
