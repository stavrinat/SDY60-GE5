

import java.util.Scanner;
import java.util.Random;

public class ShipBoard {
	private int [][] ploia = new int[10][10];
	private int [] megethh = {5,4,3,3,2};
	private boolean [][] hit = new boolean[10][10];
	private boolean last = false;
	private int [][] theseis = new int[5][];
	private int shipsSank = 0;
	
	public ShipBoard()
	{
		int i,j;
		for(i=0;i<10;i++)
		{
			for(j=0;j<10;j++)
			{
				hit[i][j] = false;
			}
		}
		
		for(i=0;i<10;i++)
		{
			for(j=0;j<10;j++)
			{
				ploia[i][j] = 0;
			}
		}
		
		
		theseis[0] = new int[10];
		theseis[1] = new int[8];
		theseis[2] = new int[6];
		theseis[3] = new int[6];
		theseis[4] = new int[4];

		
		
	}
	 public boolean getStrike(int[] thesi)
     {
         boolean hitTF;
         int s;
         int j = 0;
         last = false;
         if(hit[thesi[0]][thesi[1]] == false)
         {
             hit[thesi[0]][thesi[1]] = true;
             if(ploia[thesi[0]][thesi[1]] == 0)
             {
            	 
                 return false;
             }
             else 
             {
            	 j=0;
                 s = ploia[thesi[0]][thesi[1]];
                 hitTF=true;
                 for(int i=1;i<=(theseis[s-1].length)/2;i++)
                 {
                	 if(hit[theseis[s-1][j]][theseis[s-1][j+1]] == false)
                	 {
                		 hitTF = false;
                	 }
                	 
                	 
                	 j=j+2;
                 }
                
                 if(hitTF == true)
                 {
                	 last = true;
                	 shipsSank ++ ;
                	 System.out.println("Vithistike to ploio "+s);
                 }
                 return true;
             }
         }
         else
         {
             return false;
         }
     }
	
	 public boolean allShipsSank()
	 {
		 if(shipsSank==5)
			 return true;
		 else
			 return false;
	 }
	 
	 
	 public boolean lastStrikeSankShip()
	 {
		 if(last==true)
			 return true;
		 else
			 return false;
	 }
	 
	private void enterShipManually(int id)
	{
		int grammi,stili;
		int k ;
		Scanner input = new Scanner(System.in);
		do
		{
			do
			{
				do
				{
					System.out.println("Dose arxiki thesi gia to ploio,oi theseis arithmoude apo [0,0] ews [9,9]: "+id);
					grammi = input.nextInt();
					stili = input.nextInt();
					
				}
				while(grammi<0 || grammi>=10 || stili<0 || stili>9);
				
				do
				{
					System.out.println("Kateuthinsi? 1 gia katheta / 2 gia orizodia : ");
					k = input.nextInt();
				}
				while(k!=1 && k!=2);
			}
			while(ploia[grammi][stili]!=0);
		}
		while(enterShipOK(grammi,stili, id, k)==false);
	}	
		private boolean enterShipOK(int grammi, int stili, int id, int k)
	    {
	        int i;
	        boolean itsOK = true;
	        int howmany;
	        
	        if(id==1)
	            howmany=5;
	        else if(id==2)
	            howmany=4;
	        else if (id==4 || id==3)
	            howmany=3;
	        else
	            howmany=2;
	       
	        if(k==1)
	        {
	            if(grammi == 0)
	            {
	                for(i=1;i<=howmany-1;i++)
	                {
	                    if(ploia[grammi+i][stili]!=0)
	                    {
	                        itsOK = false;
	                        break;
	                    }
	                }
	                
	                if(itsOK == false)
	                    return false;
	                else
	                {
	                	int j = 0;
	                    ploia[grammi][stili] = id;
	                    theseis[id-1][j] = grammi;
	                    j++;
	                    theseis[id-1][j] = stili;
	                    j++;
	                    for(i=1;i<=howmany-1;i++)
	                    {
	                        ploia[grammi+i][stili] = id;
	                        theseis[id-1][j] = grammi+i;
		                    j++;
		                    theseis[id-1][j] = stili;
		                    j++;
	                    }
	                    
	                    return true;
	                }
	            }
	            else if (grammi == 9)
	            {
	            	for(i=1;i<=howmany-1;i++)
	                {
	                    if(ploia[grammi-i][stili]!=0)
	                    {
	                        itsOK = false;
	                        break;
	                    }
	                }
	                
	                if(itsOK == false)
	                    return false;
	                else
	                {
	                	int j = 0;
	                    ploia[grammi][stili] = id;
	                    theseis[id-1][j] = grammi;
	                    j++;
	                    theseis[id-1][j] = stili;
	                    j++;
	                    for(i=1;i<=howmany-1;i++)
	                    {
	                        ploia[grammi-i][stili] = id;
	                        theseis[id-1][j] = grammi-i;
		                    j++;
		                    theseis[id-1][j] = stili;
		                    j++;
	                    }
	                return true;
	                }
	            }
	            else
	            {
	                for(i=1;i<=howmany-1;i++)
	                {
			    
	                    if(((grammi-i<0) || (grammi-i>9)) || ploia[grammi-i][stili]!=0)
	                    {
	                        itsOK = false;
	                        break;
	                    }
	                }
	                
	                if(itsOK == false)
	                {
	                	itsOK=true;
	                    for(i=1;i<=howmany-1;i++)
	                    {
	                        if(((grammi+i<0) || (grammi+i>9)) || ploia[grammi+i][stili]!=0)
	                        {
	                            itsOK = false;
	                            break;
	                        }
	                    }
	                        
	
	                    if(itsOK == false)
	                        return false;
	                    else
	                    {
	                    	int j = 0;
		                    ploia[grammi][stili] = id;
		                    theseis[id-1][j] = grammi;
		                    j++;
		                    theseis[id-1][j] = stili;
		                    j++;
		                    for(i=1;i<=howmany-1;i++)
		                    {
		                        ploia[grammi+i][stili] = id;
		                        theseis[id-1][j] = grammi+i;
			                    j++;
			                    theseis[id-1][j] = stili;
			                    j++;
		                    }
	
	                        return true;
	                    }
	                }
	                else
	                {
	                	int j = 0;
	                    ploia[grammi][stili] = id;
	                    theseis[id-1][j] = grammi;
	                    j++;
	                    theseis[id-1][j] = stili;
	                    j++;
	                    for(i=1;i<=howmany-1;i++)
	                    {
	                        ploia[grammi-i][stili] = id;
	                        theseis[id-1][j] = grammi-i;
		                    j++;
		                    theseis[id-1][j] = stili;
		                    j++;
	                    }
	                    
	                    return true;
	                }
	            }
		        }
		        else
		        {
		             if(stili == 0)
		            {
		                for(i=1;i<=howmany-1;i++)
		                {
		                    if( ploia[grammi][stili+i]!=0)
		                    {
		                        itsOK = false;
		                        break;
		                    }
		                }
		                
		                if(itsOK == false)
		                    return false;
		                else
		                {
		                	int j = 0;
		                    ploia[grammi][stili] = id;
		                    theseis[id-1][j] = grammi;
		                    j++;
		                    theseis[id-1][j] = stili;
		                    j++;
		                    for(i=1;i<=howmany-1;i++)
		                    {
		                        ploia[grammi][stili+i] = id;
		                        theseis[id-1][j] = grammi;
			                    j++;
			                    theseis[id-1][j] = stili+i;
			                    j++;
		                    }
		                    
		                    return true;
		                }
		            }
		            else if (stili == 9)
		            {
		            	for(i=1;i<=howmany-1;i++)
		                {
		                    if(ploia[grammi][stili-i]!=0)
		                    {
		                        itsOK = false;
		                        break;
		                    }
		                }
		                
		                if(itsOK == false)
		                    return false;
		                else
		                {
		                	int j = 0;
		                    ploia[grammi][stili] = id;
		                    theseis[id-1][j] = grammi;
		                    j++;
		                    theseis[id-1][j] = stili;
		                    j++;
		                    for(i=1;i<=howmany-1;i++)
		                    {
		                        ploia[grammi][stili-i] = id;
		                        theseis[id-1][j] = grammi;
			                    j++;
			                    theseis[id-1][j] = stili-i;
			                    j++;
		                    }
		                return true;
		                }
		                
		            }
		            else
		            {
		                for(i=1;i<=howmany-1;i++)
		                {
		                    if(((stili - i<0) || (stili - i>9)) ||ploia[grammi][stili-i]!=0)
		                    {
		                        itsOK = false;
		                        break;
		                    }
		                   
		                }
		              if(itsOK == false)
		                {
		                	itsOK = true;
		                    for(i=1;i<=howmany-1;i++)
		                    {
		                        if(((stili + i<0) || (stili + i>9)) || ploia[grammi][stili+i]!=0)
		                        {
		                            itsOK = false;
		                            break;
		                        }
		                    }
		
		                    if(itsOK == false)
		                        return false;
		                    else
		                    {
		                    	int j = 0;
			                    ploia[grammi][stili] = id;
			                    theseis[id-1][j] = grammi;
			                    j++;
			                    theseis[id-1][j] = stili;
			                    j++;
			                    for(i=1;i<=howmany-1;i++)
			                    {
			                        ploia[grammi][stili+i] = id;
			                        theseis[id-1][j] = grammi;
				                    j++;
				                    theseis[id-1][j] = stili+i;
				                    j++;
			                    }
		
		                        return true;
		                    }
		                }
		                else
		                {
		                	int j = 0;
		                    ploia[grammi][stili] = id;
		                    theseis[id-1][j] = grammi;
		                    j++;
		                    theseis[id-1][j] = stili;
		                    j++;
		                    for(i=1;i<=howmany-1;i++)
		                    {
		                        ploia[grammi][stili-i] = id;
		                        theseis[id-1][j] = grammi;
			                    j++;
			                    theseis[id-1][j] = stili-i;
			                    j++;
		                    }
		                    
		                    return true;
		                }
		            }
		        }    
		    }	
				public void enterAllShipsManually()
				{
					int i;
					for(i=1;i<=5;i++)
					{
						enterShipManually(i);
						printBoard();
					}
				}
				public void printBoard()
			        {
			            int i,j;
			            
					System.out.print("\n");

			            for(i=0;i<=9;i++)
			            {
			                for(j=0;j<=9;j++)
			                {
			                    System.out.print(ploia[i][j]+" ");
			                }
			                System.out.print("\n");
			            }

				System.out.print("\n");
	
			        }


		private void enterShipRandomly(int id)
		{
		Random randomGenerator = new Random();
		int grammi,stili;
		int k ;
		Scanner input = new Scanner(System.in);
		do
		{
			do
			{
				do
				{
					grammi = randomGenerator.nextInt(10);
					stili = randomGenerator.nextInt(10);
					
				}
				while(grammi<0 || grammi>=10 || stili<0 || stili>9);
				
				do
				{
					if(randomGenerator.nextInt(2)==0)
						k = 1;
					else
						k = 2;
				}
				while(k!=1 && k!=2);
			}
			while(ploia[grammi][stili]!=0);
		}
		while(enterShipOK(grammi,stili, id, k)==false);

		}

		public void enterAllShipsRandomly()
		{
			int i;
					for(i=1;i<=5;i++)
					{
						enterShipRandomly(i);
						printBoard();
					}

		}
				
			public void printHits()
		        {
		            int i,j;
		            
		            for(i=0;i<=9;i++)
		            {
		                for(j=0;j<=9;j++)
		                {
		                    System.out.print(hit[i][j]+" ");
		                }
		                System.out.print("\n");
		            }
		        }
			





	public static void main(String[] args)
	{
		ShipBoard ship1 = new ShipBoard();
		ShipBoard ship2 = new ShipBoard();
		ShipBoard ship3 = new ShipBoard();
		Scanner input =new Scanner(System.in);
		
		int i;
		int[] thesi = new int[2];
		
		
		ship1.enterShipOK(0, 0, 1, 1);
		ship1.enterShipOK(0, 2, 2, 1);
		ship1.enterShipOK(0, 3, 3, 2);
		ship1.enterShipOK(9, 9, 4, 2);
		ship1.enterShipOK(1, 3, 5, 1);

		
		
		System.out.println("\n Telikos  Ship Board 1 \n");
		ship1.printBoard();
		
		//yparxei ploio
		thesi[0] = 2;
		thesi[1] = 2;
		ship1.getStrike(thesi);
		
		System.out.println("\n Pinakas hit meta to 1o xtipima se thesi pou uparxei ploio \n");
		ship1.printHits();
		
		//den yparxei ploio
		thesi[0] = 0;
		thesi[1] = 9;
		ship1.getStrike(thesi);
		
		System.out.println("\n Pinakas hit meta to 2o xtipima se thesi pou den uparxei ploio \n");
		ship1.printHits();
		
		//yparxei ploio
		thesi[0] = 2;
		thesi[1] = 2;
		ship1.getStrike(thesi);
		
		System.out.println("\n Pinakas hit meta to 3o xtipima se thesi pou exei idi xtipithei \n");
		ship1.printHits();
		
		//deutero ploio
		ship2.enterAllShipsManually();
		System.out.println("\n Telikos  Ship Board 2 \n");
		ship2.printBoard();
		
		for(i=1;i<=17;i++)
		{
			do
			{
				System.out.println("Dose ti thesi pou thes na xtipiseis,oi theseis arithmoude apo [0,0] ews [9,9]: ");
				thesi[0] = input.nextInt();
				thesi[1] = input.nextInt();
				
			}
			while(thesi[0]<0 || thesi[0]>=10 || thesi[1]<0 || thesi[1]>9);
			ship2.getStrike(thesi);
			if(ship2.lastStrikeSankShip()==true)
				System.out.println("Vithistike ploio!");
			else
				System.out.println("Den Vithistike ploio!");
		}
		
		if(ship2.allShipsSank()==true)
			System.out.println("Vithistikan ola ta ploia!");
		else
			System.out.println("Den Vithistikan ola ta ploia!");


		ship3.enterAllShipsRandomly();
		System.out.println("\n Telikos  Ship Board 3 \n");
		ship3.printBoard();

	}
     


}























