/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number 600851475143 ?
 * 
 * @author rajabatu
 *
 */
public class Problem003_LargestPrimeFactor {

	public static void main(String[] args) {
		
		long number = Long.parseLong("600851475143");
		
		long prime = 3;
		
		while (number != 1) 
		{
			if (number % prime == 0) 
			{
				number = number / prime;
				
				System.out.println(prime);
			} 
			else 
			{
				prime += 2;
			}
		}
		
		System.out.println("Largest prime = " + prime);
	}

}
