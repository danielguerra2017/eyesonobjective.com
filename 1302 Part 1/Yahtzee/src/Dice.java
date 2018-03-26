public class Dice implements Comparable<Dice>{
	
	private int value = (int)(Math.random()*6+1);
	
	public int getValue()
	{
		return value;
	}
	
	public int compareTo(Dice that){
		if (this.getValue() < that.getValue()) 
			return -1;
		else if (this.getValue() > that.getValue()) 
			return 1;
		else 
			return 0;
	}
	
	
			
}
