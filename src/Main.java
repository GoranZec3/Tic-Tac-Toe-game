import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		char player1 = 'X';
		char player2 = 'O';
		
		Scanner in = new Scanner(System.in);
		
		Board gameBoard = new Board(3,3);
		//gameBoard.printBoard();
		
		//making plays
		char turn = player1;
		boolean stop = false;
		
		String winner = "";
		gameBoard.printBoard();
		
		while(!stop) {
			boolean goodPlay = false;
			if(turn == player1) {
				//make sure a play is available
				if(gameBoard.spaceAvailable()) {
					//make a play
					do {
						System.out.println("Please enter row, space, col:");
						int row = in.nextInt();
						int col = in.nextInt();
						
						goodPlay = gameBoard.play(turn, row -1, col -1);
					}while(!goodPlay);
				}else {
					goodPlay = false;
				}
			}else {
				goodPlay = gameBoard.autoPlay(turn);
			}
			if(goodPlay) {
				//autoplay successfull. check for winner
				if(gameBoard.haveWinner()) {
					//we have a winner so stop playing
					winner = "Player " + turn + " is our winner!";
					System.out.println(winner);
					stop = true;
				}else {
					//we don't have a winner so switch players
					turn = (turn == player1) ? player2 : player1;
				}
			}else {
				//a player could not make a play
				winner = "We do not have a winner";
				stop = true;
			}
			gameBoard.printBoard();
		}

	}

}
