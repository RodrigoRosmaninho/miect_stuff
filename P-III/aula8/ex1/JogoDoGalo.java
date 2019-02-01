package aula8.ex1;

public class JogoDoGalo {
    private int[][] grid;
    private int next;
    private int numberOfPlays;

    public JogoDoGalo(String s){
        grid = new int[3][3];
        numberOfPlays = 0;
        if(s.toLowerCase().equals("x")) next = 1;
        else if(s.toLowerCase().equals("y")) next = 2;
        else throw new IllegalArgumentException("Erro! Escolha um jogador inicial válido!");
    }

    public boolean play(int buttonID){
        if(checkVictory() != 0) return false;
        int x = buttonID / 3;
        int y = buttonID % 3;
        if(grid[x][y] != 0) return false;
        grid[x][y] = next;
        next();
        numberOfPlays ++;
        return true;
    }

    public int checkVictory(){
        for(int i = 0; i < 3; i++){
            if(grid[i][0] == grid[i][1] && grid[i][0] == grid[i][2] && grid[i][0] != 0) return grid[i][0];
            if(grid[0][i] == grid[1][i] && grid[0][i] == grid[2][i] && grid[0][i] != 0) return grid[0][i];
        }
        if(grid[0][0] == grid[1][1] && grid[0][0] == grid[2][2] && grid[0][0] != 0) return grid[0][0];
        if(grid[0][2] == grid[1][1] && grid[0][2] == grid[2][0] && grid[0][2] != 0) return grid[0][2];

        if(numberOfPlays == 9) return 3;
        return 0;
    }

    public void next(){
        if(next == 1) next = 2;
        else next = 1;
    }

    public int getNext(){
        return next;
    }

    public static String getStringFromInt(int i){
        if(i == 1) return "X";
        else if(i == 2) return "O";
        else return "";
    }
}
