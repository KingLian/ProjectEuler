/**
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * 
 * What is the sum of the digits of the number 2^1000?
 * 
 * @author rajabatu
 *
 */
public class Problem016_PowerDigitsSum {
	
	public static int POWER = 1000;
	
	public static void main(String[] args) 
	{
		byte[] numbers = new byte[POWER / 2];
		
		numbers[0] = 1;
		
		for (int i = 0; i < POWER; i++) 
		{
			int offset = 0;
			
			byte carry = 0;
			
			while (offset < POWER / 2) 
			{
				numbers[offset] *= 2;
				
				numbers[offset] += carry;
				
				carry = 0;
				
				if (numbers[offset] >= 10) 
				{
					carry += (numbers[offset] / 10);
					numbers[offset] %= 10;
				}
				
				offset++;
			}
		}
		
		boolean isTrailingZero = true;
		int digitsSum = 0;
		
		for (int i = numbers.length - 1; i >= 0; i--) 
		{
			if (numbers[i] == 0 && isTrailingZero == true) 
			{
				continue;
			}
			else 
			{
				if (isTrailingZero == true)
				{
					isTrailingZero = false;
					System.out.println((i + 1) + " Digits number");
				}
				
				System.out.printf("%d", numbers[i]);
				
				digitsSum += numbers[i];
			}
			
		}
		
		System.out.println();
		System.out.println("Digits Sum is " + digitsSum);
		
	}

}
