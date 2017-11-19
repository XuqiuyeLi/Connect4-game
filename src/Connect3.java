package com.company;

public class Connect3 {

    private final static int size = 3;
    private final static int stonesToWin = 3;
    private int[][] board = new int[size][size];
    private int firstWin = 0;
    private int secondWin = 0;
    private int calls = 0;


    public static void main(String[] args) {
        for(int i = 0 ; i < size; i++) {
            Connect3 connect3 = new Connect3();

            System.out.println("NetWins for column " + i + ": " + connect3.play(1, connect3.board, i));

            System.out.println("Number of recursion calls: "+ connect3.calls+"\n"
                    +"Red Wins: "+ connect3.firstWin+"\t Blue Wins:"+ connect3.secondWin);

            System.out.println("————————————————————————————");
        }
    }

    public int play(int player, int board[][], int column) {
        calls++;
        board[getHeight(column, board)][column] = player;
       // printBoard(board);
        if(checkWin(board,player)) {
            if(player == 1) {
             //   System.out.println("First won");
                firstWin++;
                return 1;
            } else {
            //    System.out.println("Second won");
                secondWin++;
                return -1;
            }
        } else if(isBoardFull(board)) {
        //    System.out.println("Tie");
            return 0;
        } else {
            int sum = 0;

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

    private int getHeight(int column, int board[][]) {
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

        for (int j = 0; j<size-2; j++ ){
            for (int i = 0; i<size; i++){
                if (board[i][j] == player && board[i][j+1] == player && board[i][j+2] == player){
                    return true;
                }
            }
        }


        for (int i = 0; i<size-2 ; i++ ){
            for (int j = 0; j<size; j++){
                if (board[i][j] == player && board[i+1][j] == player && board[i+2][j] == player){
                    return true;
                }
            }
        }


        for (int i=2; i<size; i++){
            for (int j=0; j<size-2; j++){
                if (board[i][j] == player && board[i-1][j+1] == player && board[i-2][j+2] == player)
                    return true;
            }
        }


        for (int i=2; i<size; i++){
            for (int j=2; j<size; j++){
                if (board[i][j] == player && board[i-1][j-1] == player && board[i-2][j-2] == player)
                    return true;
            }
        }
        return false;
    }


    public boolean isColumnFull(int board[][], int column) {
        return board[size-1][column] > 0;
    }

    public int next(int player) {
        return (player == 1) ? 2 : 1;
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
