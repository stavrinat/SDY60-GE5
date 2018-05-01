

import java.util.Scanner;

public class HumanPlayer {
	private String name;
	private ShipBoard myShips;
	private StrikeBoard enemyShips;
	
	public HumanPlayer(String n)
	{
		name = n;
		myShips = new ShipBoard();
		enemyShips = new StrikeBoard();
		
		myShips.enterAllShipsManually();
	}
	
	public int [] nextStrike()
	{
		int [] thesi = new int[2];
		int grammi,stili;
		
		Scanner input = new Scanner(System.in);
		
		do
		{
			System.out.println("Dose ti thesi pou thes na xtipiseis,oi theseis arithmoude apo [0,0] ews [9,9]: ");
			grammi = input.nextInt();
			stili = input.nextInt();
			
		}
		while(grammi<0 || grammi>=10 || stili<0 || stili>9);
		
		thesi[0] = grammi;
		thesi[1] = stili;
		return thesi;
	}
	
	public void update(int [] thesi, boolean sf)
	{
		enemyShips.addStrike(thesi, sf);
	}
	
	public boolean getStrike(int [] thesi)
	{
		if(myShips.getStrike(thesi) == true)
			return true;
		else
			return false;
	}
	
	public boolean allShipsSank()
	{
		if(myShips.allShipsSank()==true)
			return true;
		else
			return false;
	}
	
	public boolean lastStrikeSankShip()
	{
		if(myShips.lastStrikeSankShip()==true)
			return true;
		else
			return false;
	}
	
	public void printStrikes()
	{
		enemyShips.printBoard();
	}
	
	public String toString()
	{
		return name;
	}
}
