/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * 
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * @author rajabatu
 *
 */
public class Problem004_LargestPalindromeProduct {

	public static void main(String[] args) {
		
		long max = 0;
		
		for (int i = 100; i <= 999; i++) 
		{
			for (int j = 100; j <= 999; j++) 
			{
				long res = i * j;
				if (isPalindrom(res)) 
				{
					System.out.println(i + " * " + j + " = " + res);
					
					if (res > max) 
					{
						max = res;
					}
				}
			}
		}
		
		System.out.println("Max Palindrom = " + max);
	}
	
	static boolean isPalindrom(long number) 
	{
		String palindrom = "";
		
		for (char c : String.valueOf(number).toCharArray()) 
		{
			palindrom = c + palindrom;
		}
		
		return palindrom.equals(String.valueOf(number));
	}
	
}
