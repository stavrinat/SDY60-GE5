

public class BattleShip {

	public static void main(String args[])
	{
		HumanVsHuman();
	}
	
	private static void HumanVsHuman()
	{
		HumanPlayer one = new HumanPlayer("One");
		HumanPlayer two = new HumanPlayer("Two");
		int [] thesi1 = new int[2];
		int [] thesi2 = new int[2];
		boolean hit1 = false;
		boolean hit2 = false;
		
		while(true)
		{
			System.out.println("\n One: Strikes \n");
			one.printStrikes();
			thesi1=one.nextStrike();
			hit1 = two.getStrike(thesi1);
			one.update(thesi1, hit1);
			if(one.lastStrikeSankShip()==true)
			{
				System.out.println("One : vithisa ploio!");
			}
			
			if(two.allShipsSank()==true)
			{
				System.out.println("One : vithisa ola ta ploia!");
				break;
			}
			
			System.out.println("\n Two: Strikes \n");
			two.printStrikes();
			thesi2=one.nextStrike();
			hit2 = two.getStrike(thesi2);
			two.update(thesi2, hit2);
			if(two.lastStrikeSankShip()==true)
			{
				System.out.println("TWo : vithisa ploio!");
			}
			
			if(one.allShipsSank()==true)
			{
				System.out.println("Two : vithisa ola ta ploia!");
				break;
			}
			
		}

	}
}
