import java.util.ArrayList;
import java.util.List;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * 
 * What is the 10 001st prime number?
 * 
 * @author rajabatu
 *
 */
public class Problem007_10001stPrime {

	public static void main(String[] args) {
		
		List<Long> prime = new ArrayList<Long>();
		
		prime.add((long) 2);
		prime.add((long) 3);
		
		long number = 5;
		boolean isPrime = true;
		
		while (prime.size() != 10001) 
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
		
		System.out.println();
		System.out.println("10 001st Prime: " + prime.get(prime.size() - 1));;
	}

}
