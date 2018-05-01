

public class StrikeBoard {
	private int [][] strikes=new int[10][10];
	
	public StrikeBoard()
	{
		int i,j;
		
		for(i=0;i<10;i++)
		{
			for(j=0;j<10;j++)
			{
				strikes[i][j]=0;
			}
		}
	}
	
	public void addStrike(int [] thesi,boolean sf)
	{
		
		if(sf==true)
			strikes[thesi[0]][thesi[1]] = 1;
		else
			strikes[thesi[0]][thesi[1]] = -1;
	}
	
	public void printBoard()
    {
        int i,j;
        
        for(i=0;i<=9;i++)
        {
            for(j=0;j<=9;j++)
            {
                System.out.print(strikes[i][j]+" ");
            }
            System.out.print("\n");
        }
    }

}
