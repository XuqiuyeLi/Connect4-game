


import java.util.Scanner;

public class ConnectFour {


	    static final int SIZE = 4;
	    static final int RED =1, BLUE =2;
	    int player;
	    static Scanner input = new Scanner(System.in);
	    private int[][] board = new int[SIZE][SIZE];
	    private int redWin = 0;
	    private int blueWin = 0;
	    private int calls = 0;


	    public void main(String[] args) {
	        for(int i = 0 ; i < SIZE; i++) {
	            ConnectFour connectFour = new ConnectFour();

	            System.out.println("NetWins for column " + i + ": " + connectFour.play(1, connectFour.board, i));

	            System.out.println("Number of recursion calls: "+ connectFour.calls+"\n"
	                    +"Red Wins: "+ connectFour.redWin+"\t Blue Wins:"+ connectFour.blueWin);

	            System.out.println("————————————————————————————");
	        }
	    }

	    public long play(int player, int board[][], int column) {
	        calls++;
	        player = 1;
	        board[getDepth(column, board)][column] = player;
	        // printBoard(board);
	        if(checkWin(board,player)) {
	            if(player == 1) {
	                redWin++;
	                return 1;
	            } else {
	                blueWin++;
	                return -1;
	            }
	        } else if(isBoardFull(board)) {
	            //    Tie;
	            return 0;
	        } else {
	            long sum = 0;

	            for(int i = 0 ;i < board.length; i++) {
	                if(!isColumnFull(board, i)) {
	                    sum = sum + play(next(player), copyBoard(board), i);
	                }
	            }
	            return sum;
	        }
	    }

	    private int[][] copyBoard(int[][] board) {
	        int newBoard[][] = new int[board.length][board.length];

	        for(int i = 0 ; i  < board.length;i++) {
	            for(int j = 0; j< board.length;j++) {
	                newBoard[i][j] = board[i][j];
	            }
	        }
	        return newBoard;
	    }

	    private int getDepth(int column, int board[][]) {
	        int result = 0;
	        for(int i = 0 ; i < board.length;i++) {
	            if(board[i][column] == 0) {
	                result = i;
	                break;
	            }
	        }
	        return result;
	    }

	    private boolean isBoardFull(int[][] board) {
	        for(int i = 0 ; i< board.length;i++) {
	            if(board[board.length - 1][i] == 0) {
	                return false;
	            }
	        }
	        return true;
	    }

	    public boolean checkWin(int board[][], int player) {
	        // check for row wins
	        for (int j = 0; j<SIZE-3; j++ ){
	            for (int i = 0; i<SIZE; i++){
	                if (board[i][j] == player && board[i][j+1] == player && board[i][j+2] == player && board[i][j+3] == player){
	                    return true;
	                }
	            }
	        }


	        // Check for column wins
	        for (int i = 0; i<SIZE-3; i++ ){
	            for (int j = 0; j<SIZE; j++){
	                if (board[i][j] == player && board[i+1][j] == player && board[i+2][j] == player && board[i+3][j] == player){
	                    return true;
	                }
	            }
	        }

	        // Check for bottom - up diagonal
	        for (int i=3; i<SIZE; i++){
	            for (int j=0; j<SIZE-3; j++){
	                if (board[i][j] == player && board[i-1][j+1] == player && board[i-2][j+2] == player && board[i-3][j+3] == player)
	                    return true;
	            }
	        }

	        // Check for Top - down diagonal
	        for (int i=3; i<SIZE; i++){
	            for (int j=3; j<SIZE; j++){
	                if (board[i][j] == player && board[i-1][j-1] == player && board[i-2][j-2] == player && board[i-3][j-3] == player)
	                    return true;
	            }
	        }
	        return false;
	    }


	    public boolean isColumnFull(int board[][], int column) {
	        return board[SIZE-1][column] > 0;
	    }

	    public int next(int player) {
	        return 3 - player;
	    }
	    public void printBoard(int board[][]) {
	       for(int i = 0 ; i < board.length;i++) {
	           for(int j = 0 ;j < board.length;j++) {
	               System.out.print(board[i][j] + "|");
	           }
	           System.out.println();
	       }
	       System.out.println();
	   }

	}


