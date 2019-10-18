package checkers;

import java.util.Date;

public class Ai {
    
	private static int line = 0;
    int playerRed = 1;
    int playerBlue = 2;
    
    int playerRedKing = 3;
    int playerBlueKing = 4;
    int empty = 0;
	
    public void main(int[][] board,int[] checkersLeft) {
        if (takeOver(board,checkersLeft)){
            return;
        }if (safeMove(board)){
            return;
        }if (randomMove(board)){
            
        }
    }
    
    public boolean takeOver(int[][] board, int[] checkersLeft){
        
        for (int r = 5; r >= 0; r--){
            for (int c = 0; c <= 7; c++){
                if (board[r][c] == playerRed){
                    if (inLimit(r+1,c-1) && board[r+1][c-1] == playerBlue){                        
                        if (inLimit(r+2,c-2) && board[r+2][c-2] == empty){
                            
                            Log.log("AI Red movement from ("+(r)+","+(c)+") to ("+(r+2)+","+(c-2)+")");
                            Log.log("AI Red took over player Blue at ("+(r+1)+","+(c-1)+")");
                            
                            board[r][c] = empty;
                            board[r+1][c-1] = empty;
                            
                            checkersLeft[1]--;
                            
                            updateBoard(board,r,c,2,2,true);
                            
                            return true;
                        }
                    }
                    
                    if (inLimit(r+1,c-1) && board[r+1][c-1] == playerBlueKing){
                        if (inLimit(r+2,c-2) && board[r+2][c-2] == empty){
                            
                            Log.log("AI Red movement from ("+(r)+","+(c)+") to ("+(r+2)+","+(c-2)+")");
                            Log.log("AI Red took over player Blue at ("+(r+1)+","+(c-1)+")");
                            
                            board[r][c] = empty;
                            board[r+1][c-1] = empty;
                            
                            checkersLeft[1]--;
                            
                            updateBoard(board,r,c,2,2,true);
                            return true;
                        }
                    }
                    
                    if (inLimit(r+1,c+1) && board[r+1][c+1] == playerBlue){
                        if (inLimit(r+2,c+2) && board[r+2][c+2] == empty){

                            Log.log("AI Red movement from ("+(r)+","+(c)+") to ("+(r+2)+","+(c+2)+")");
                            Log.log("AI Red took over player Blue at ("+(r+1)+","+(c+1)+")");
                            
                            board[r][c] = empty;
                            board[r+1][c+1] = empty;             
                            
                            checkersLeft[1]--;
                            updateBoard(board,r,c,2,2,false);
                            
                            return true;
                            
                        }
                    }
                    
                    if (inLimit(r+1,c+1) && board[r+1][c+1] == playerBlueKing){
                        if (inLimit(r+2,c+2) && board[r+2][c+2] == empty){
                            
                            Log.log("AI Red movement from ("+(r)+","+(c)+") to ("+(r+2)+","+(c+2)+")");
                            Log.log("AI Red took over player Blue at ("+(r+1)+","+(c+1)+")");
                            
                            board[r][c] = empty;
                            board[r+1][c+1] = empty;             
                            
                            checkersLeft[1]--;
                            updateBoard(board,r,c,2,2,false);
                            
                            return true;
                        }
                    }
                }
            }
        }
        
        return false;
    }
    
    public boolean safeMove(int[][] board){
        
        for (int r = 6; r >= 0; r--){
            for (int c = 0; c <= 7; c++){
                if (board[r][c] == playerRed){
                    if (inLimit(r+1,c-1) && board[r+1][c-1] == empty){
                        if (inLimit(r+2,c-2) && inLimit(r+2,c) && board[r+2][c-2] != playerBlue && board[r+2][c-2] != playerBlueKing
                            && board[r+2][c] != playerBlue && board[r+2][c] != playerBlueKing){
                            
                            Log.log("Ai red safe movemenet from ("+r+","+c+") to ("+(r+1)+","+(c-1)+")");
                       
                            board[r][c] = empty;
                            updateBoard(board,r,c,1,1,true);
                            
                            return true;
                        } 
                        
                        if (inLimit(r+2,c-2) && inLimit(r,c+2) && board[r+2][c-2] != playerBlue && board[r+2][c-2] != playerBlueKing
                            && board[r][c+2] != empty){
                            
                            Log.log("Ai red safe movemenet from ("+r+","+c+") to ("+(r+1)+","+(c-1)+")");
                       
                            board[r][c] = empty;
                            updateBoard(board,r,c,1,1,true);
                            
                            return true;
                        }
                        
                        if (!inLimit(r+2,c-2) && inLimit(r+2,c)){
                            
                            Log.log("Ai red safe movement from ("+r+","+c+") to ("+(r+1)+","+(c-1)+")");
                       
                            board[r][c] = empty;
                            updateBoard(board,r,c,1,1,true);
                            
                            return true;
                        }
                        
                        if (!inLimit(r+2,c-2) && !inLimit(r+2,c)){
                            
                            Log.log("Ai red safe movemenet from ("+r+","+c+") to ("+(r+1)+","+(c-1)+")");
                       
                            board[r][c] = empty;
                            updateBoard(board,r,c,1,1,true);
                            
                            return true;
                        }
                    }
                    
                    if (inLimit(r+1,c+1) && board[r+1][c+1] == empty){
                        if (inLimit(r+2,c+2) && inLimit(r+2,c) && board[r+2][c+2] != playerBlue && board[r+2][c+2] != playerBlueKing
                            && board[r+2][c] != playerBlue && board[r+2][c] != playerBlueKing){
                            
                            Log.log("Ai red safe movemenet from ("+r+","+c+") to ("+(r+1)+","+(c+1)+")");
                       
                            board[r][c] = empty;
                            updateBoard(board,r,c,1,1,false);
                            
                            return true;
                        } 
                        
                        if (inLimit(r+2,c+2) && inLimit(r,c+2) && board[r+2][c+2] != playerBlue && board[r+2][c+2] != playerBlueKing
                            && board[r][c+2] != empty){
                            
                            Log.log("Ai red safe movemenet from ("+r+","+c+") to ("+(r+1)+","+(c+1)+")");
                       
                            board[r][c] = empty;
                            updateBoard(board,r,c,1,1,false);
                            
                            return true;
                        } 
                        
                        if (!inLimit(r+2,c+2) && inLimit(r+2,c)){
                            Log.log("Ai red safe movemenet from ("+r+","+c+") to ("+(r+1)+","+(c+1)+")");
                       
                            board[r][c] = empty;
                            updateBoard(board,r,c,1,1,false);
                            
                            return true;
                            
                        }
                        
                        if (!inLimit(r+2,c+2) && !inLimit(r+2,c)){
                            Log.log("Ai red safe movemenet from ("+r+","+c+") to ("+(r+1)+","+(c+1)+")");
                       
                            board[r][c] = empty;
                            updateBoard(board,r,c,1,1,false);
                            
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public boolean randomMove(int[][] board){
        
        for (int r = 6; r >= 0; r--){
            for (int c = 0; c <= 7; c++){
                if (board[r][c] == playerRed && inLimit(r+1,c-1) && board[r+1][c-1] == empty){
                    Log.log("Ai red random movemenet from ("+r+","+c+") to ("+(r+1)+","+(c-1)+")");

                    board[r][c] = empty;

                    updateBoard(board,r,c,1,1,true);

                    return true;
                }if (board[r][c] == playerRed && inLimit(r+1,c+1) && board[r+1][c+1] == empty){
                    Log.log("Ai red random movemenet from ("+r+","+c+") to ("+(r+1)+","+(c+1)+")");

                    board[r][c] = empty;

                    updateBoard(board,r,c,1,1,false);

                    return true;
                }
            }
        }
        
        return false;
    }
    
    private void updateBoard(int[][] board, int row, int col, int r, int c, boolean add) {
    	if (row+r == 7){
            board[row+r][col + (add ? -c : c)] = playerRedKing;
        }else {
            board[row+r][col + (add ? -c : c)] = playerRed;
        }
    }
    
    public boolean inLimit(int r, int c){
        if (r >= 0 && r<= 7){
            if (c >= 0 && c <= 7){
                return true;
            }
        }
        return false;
    }    
}