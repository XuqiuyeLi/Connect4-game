# Connect4-game
The project is to help determine the best moves for an abbreviated game of Connect4. A game is won if 4 discs of the same color appear in a column , row or diagonal.

## Logistics
1. The program will explore making its first move in each of the four columns. The first action will be to make a move in one of the four columns. 
2. The program will then pass the Board, and the next player to a Play method. 
3. The Play method will analyze the board and call itself up to 4 times, representing the possible number of next moves. At times the Play method may call itself less than four times due to the condition that a column is full. 
4. The Play method will return a 1 if the game is won by the first player, -1 if won by the second player, and zero, if that moves leads to a tie.  Hence Play method gives you the Net wins for first player, given the board position represented by board, and the next move is to be taken.
