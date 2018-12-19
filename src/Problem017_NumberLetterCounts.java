/**
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * 
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 * 
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. 
 * The use of "and" when writing out numbers is in compliance with British usage.
 * 
 * @author rajabatu
 *
 */
public class Problem017_NumberLetterCounts {

	public static void main(String[] args) {
		
		int letters = 0;
		
		String name = "";
		
		for (int i = 1; i <= 1000; i++) 
		{
			name = "";
			
			if (i == 1000) 
			{
				letters += countLetters("one thousand");
				continue;
			}
			
			if (i >= 100) 
			{
				switch (i - (i % 100)) 
				{
					case 100:
						name += "one hundred";
						break;
					case 200:
						name += "two hundred";
						break;
					case 300:
						name += "three hundred";
						break;
					case 400:
						name += "four hundred";
						break;
					case 500:
						name += "five hundred";
						break;
					case 600:
						name += "six hundred";
						break;
					case 700:
						name += "seven hundred";
						break;
					case 800:
						name += "eight hundred";
						break;
					case 900:
						name += "nine hundred";
						break;
					default:
						break;
				}
			}
			
			if (i % 100 == 0) 
			{
				letters += countLetters(name);
				continue;
			}
			
			if ((i % 100) >= 20) 
			{
				if (i >= 100) 
				{
					name += " and ";
				}
				
				switch ((i % 100) - (i % 10)) 
				{
					case 20:
						name += "twenty";
						break;
					case 30:
						name += "thirty";
						break;
					case 40:
						name += "forty";
						break;
					case 50:
						name += "fifty";
						break;
					case 60:
						name += "sixty";
						break;
					case 70:
						name += "seventy";
						break;
					case 80:
						name += "eighty";
						break;
					case 90:
						name += "ninety";
						break;
					default:
						break;
				}
			}
			
			if ((i % 100 >= 10) && (i % 100 < 20)) 
			{
				if (i >= 100) 
				{
					name += " and ";
				}
				
				switch (i % 100) 
				{
					case 10:
						name += "ten";
						break;
					case 11:
						name += "eleven";
						break;
					case 12:
						name += "twelve";
						break;
					case 13:
						name += "thirteen";
						break;
					case 14:
						name += "fourteen";
						break;
					case 15:
						name += "fifteen";
						break;
					case 16:
						name += "sixteen";
						break;
					case 17:
						name += "seventeen";
						break;
					case 18:
						name += "eighteen";
						break;
					case 19:
						name += "nineteen";
						break;
					default:
						break;
				}
			}
			else if ((i % 10 < 10) && (i % 10 != 0)) 
			{
				if ((i >= 100) && (i % 100 < 20))
				{
					name += " and ";
				}
				else if (i > 10) 
				{
					name += "-";
				}
				
				switch (i % 10) 
				{
					case 1:
						name += "one";
						break;
					case 2:
						name += "two";
						break;
					case 3:
						name += "three";
						break;
					case 4:
						name += "four";
						break;
					case 5:
						name += "five";
						break;
					case 6:
						name += "six";
						break;
					case 7:
						name += "seven";
						break;
					case 8:
						name += "eight";
						break;
					case 9:
						name += "nine";
						break;
					default:
						break;
				}
			}
			
			
			letters += countLetters(name);
			
		}
		
		System.out.println(letters);
		
	}
	
	public static int countLetters(String name) 
	{
		String s = name.replaceAll(" ", "");
		s = s.replaceAll("-", "");
		
		int length = s.length();
		
		System.out.println("[" + length + "] " + name);
		
		return length;
	}

}
