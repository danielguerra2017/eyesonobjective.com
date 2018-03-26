public class diamondShape
{
	public static void main(String [] args)
	{

		int lineCounter = 1, starCounter;

		while (lineCounter <= 5)
		{

			starCounter = 1;

			while (starCounter <= lineCounter)
			{
				System.out.print("*");
				starCounter ++;
			}

				System.out.println(" ");
				lineCounter ++;
		}
	}
}