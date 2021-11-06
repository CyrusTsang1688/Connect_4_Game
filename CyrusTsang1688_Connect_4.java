//CyrusTsang1688 Connect-4 First Java Program
import java.util.Scanner;
public class AssignmentPrograming01 {
	public static void main (String[]args){
			int P1_Input = -1 ,P2_Input = -1;
			Scanner pi = new Scanner(System.in);
			int rows = 100 ,col = 100;
			int[][] mTable = new int [rows][col];
			GameTable(P1_Input ,P2_Input ,mTable);
			do{
				while(P1_Input != 9 || P1_Input < 0){ //Player 1 input
					System.out.println("\nPlayer 1 type a column <0-6> or 9 to quit current game: ");
				    P1_Input = pi.nextInt();
					    if(P1_Input == 9){
					   	System.out.print("Bye! Bye!");
					    	System.exit(0);
					    }
					    if(P1_Input > 6){
					    	System.out.println("Range of column should be 0 to 6!"); //The error message
					    	continue;
					    }
					   	if(mTable[5][P1_Input] >=1){
					   	 	System.out.println("Column " + P1_Input + " is full!"); //The error message
					   		continue;
					   	}
				   	GameTable(P1_Input ,-1 ,mTable);
				    break;
				}
				while(P2_Input != 9 || P2_Input > 0){ // Player 2 input
					System.out.println("\nPlayer 2 type a column <0-6> or 9 to quit current game: ");
				    P2_Input=pi.nextInt();
						if(P2_Input == 9){
					        System.out.print("Bye! Bye!");
					    	System.exit(0);
					    }
					    if(P2_Input > 6){
					    	System.out.println("Range of column should be 0 to 6!"); //The error message
					    	continue;
					    }
					    if(mTable[5][P2_Input] >= 1){
					   	 	System.out.println("Column " + P2_Input + " is full!"); //The error message
					   		continue;
					   	}
				    GameTable(-1 ,P2_Input ,mTable);
				    break;
				}
			}while(P1_Input != 9 || P1_Input < 0);
	}
	public static int GameTable(int P1_Input ,int P2_Input ,int mTable[][]){ //the method of the gametable 
	    int rows = 0, col = 0, Sum = 0; //print the 1&2
	    if(P1_Input != -1){ //player 1 input
			if(mTable[rows][P1_Input] == 0){ //if first row is empty, it will put P1_Input in first row
	    		mTable[rows][P1_Input] = 1;
		    }
		    else{
		    	for(rows = 5; rows > -1; rows--){ //if the Player 1 selected space is full, then the row will stack
		        	if(mTable[rows][P1_Input] >= 1){
			    		mTable[rows+1][P1_Input] = 1;
			    		break;
					}
				}
			}
		}
	    if(P2_Input != -1){  //player 2 input
	    	if(mTable[rows][P2_Input] == 0){ //if first row is empty, it will put P2_Input in first row
	    		mTable[rows][P2_Input] = 2; 
	    	}
	    	else{
		    	for(rows = 5;rows >- 1;rows--){ //if the Player 2 selected space is full, then the row will stack
		        	if(mTable[rows][P2_Input] >= 1){ //if 
			    		mTable[rows+1][P2_Input] = 2;
			    		break;
			    	}
			    }
		    }
		}
		for (rows = 5; rows>-1; rows-- ) { // print out the gametable part 1
				System.out.print(rows + " |"); 
	        for (col = 0; col < 7; col++ ){
	            System.out.print( " " + mTable[rows][col]);
	            	Sum += mTable[rows][col];
			}
			System.out.println();
		}
			GameTableP2();//gametable part 2
		for(int t = 0; t <= 5;t++){ //check each rows isnt it has 4x1 or 4x2, determining winner or draw game by below.
	    	for(int k=0;k<=7;k++){
		    	if(mTable[t][k] * mTable[t][k+1] * mTable[t][k+2] * mTable[t][k+3] == 1){//check each row is it connected 4 of player 1
					System.out.println("\nPlayer 1 won this game!");
					System.exit(0);    	
				}
				if(mTable[t][k] * mTable[t][k+1] * mTable[t][k+2] * mTable[t][k+3] == 16){ //check each row is it connected 4 of player 2
					System.out.println("\nPlayer 2 won this game!");
					System.exit(0);
		    	}
		    	if(mTable[t][k] * mTable[t+1][k] * mTable[t+2][k] * mTable[t+3][k] == 1){ //check each col is it connected 4 of player 1
					System.out.println("\nPlayer 1 won this game!");
					System.exit(0);    	
				}
				if(mTable[t][k] * mTable[t+1][k] * mTable[t+2][k] * mTable[t+3][k] == 16){ //check each col is it connected 4 of player 2
					System.out.println("\nPlayer 2 won this game!");
					System.exit(0);    	
				}
				for(int e=3;e<=5;e++){
					if(mTable[e][k] * mTable[e-1][k+1] * mTable[e-2][k+2] * mTable[e-3][k+3] == 1){ // check each row is it connected 4x\ of player 1
						System.out.println("\nPlayer 1 won this game!");
						System.exit(0);    	
					}
					if(mTable[e][k] * mTable[e-1][k+1] * mTable[e-2][k+2] * mTable[e-3][k+3] == 16){ // check each row is it connected 4x\ of player 2
						System.out.println("\nPlayer 2 won this game!");
						System.exit(0);    	
					}
						for(int j=3;j<=7;j++){
							if(mTable[e][j] * mTable[e-1][j-1] * mTable[e-2][j-2] * mTable[e-3][j-3] == 1){// check each row is it connected 4x/ of player 1 
								System.out.println("\nPlayer 1 won this game!");
								System.exit(0);
							}
							if(mTable[e][j] * mTable[e-1][j-1] * mTable[e-2][j-2] * mTable[e-3][j-3] == 16){// check each row is it connected 4x/ of player 2
								System.out.println("\nPlayer 2 won this game!");
								System.exit(0);
							}
							if(Sum == 63){ //if all the row and col was filled, then no winner, determining draw game.
								System.out.println("\nDrawn  Game!"); 
								System.exit(0); 
							}
					}
				}
			}
		}
		return 0;
	}
		public static void GameTableP2(){ //the method of print out the Gametable part 2
			System.out.println("   --------------");
			System.out.print("   ");
			for(int i = 0;i <= 6;i++){
				System.out.print(" " + i);
			}
		}
}