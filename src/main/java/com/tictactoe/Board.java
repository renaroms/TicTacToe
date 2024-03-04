package com.tictactoe;

public class Board {
    private Player[][] grid;
    private boolean gameOver;

    public Board(){
        grid = new Player[3][3];
        gameOver = false;
    }

    public void mark(int row, int col, Player player){
        grid[row][col] = player;
    }

    public boolean isEmpity(int row, int col){
        return grid[row][col] == null;
    }

    public boolean isGameOver(){
        return gameOver;
    }

    public boolean checkForWin(){
        
        //check row
        for(int i = 0; i < 3; i++){
            if (grid[i][0] != null && grid[i][0] == grid[i][1] && grid[i][0] == grid[i][2]){
                gameOver = true;
                return true;
            }
        }

        //check columns
        for(int i = 0; i < 3; i++){
            if (grid[0][i] != null && grid[0][i] == grid[1][i] && grid[0][i] == grid[2][i]){
                gameOver = true;
                return true;
            }
        }

        //check diagonals
        if (grid[0][0] != null && grid[0][0] == grid[1][1] && grid[0][0] == grid[2][2]){
            gameOver = true;
            return true;
        }

        if (grid[0][2] != null && grid[0][2] == grid[1][1] && grid[0][2] == grid[2][0]){
            gameOver = true;
            return true;
        }

        return false;
        
    }

}
