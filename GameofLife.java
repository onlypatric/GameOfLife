
/**
 * GameofLife
 */
public class GameofLife {

    public boolean[][] board;

    public GameofLife() {
        board=new boolean[10][10];
        randomAllocator();
        print();
    }

    /**
     * Allocates random boolean values to the board
     */
    public void randomAllocator() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                this.board[i][j]=Math.random()>0.50;
            }
        }
    }
    /**
     * prints the current board
     */
    public void print(){
        System.out.println("\033c");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j])
                    System.out.printf("%2s","0");
                else
                    System.out.printf("%2s","-");
            }
            System.out.println();
        }
    }

    /**
     * Safely get value given x,y (for GameofLife.checkCells)
     * 
     * @param x
     * @param y
     * @return
     */
    private int getCell_S(int x,int y) {
        try {
            if(this.board[x][y])
                return 1;
        } catch (Exception e) {}
        return 0;
    }

    /**
     * @param x
     * @param y
     * @return amount of active cells close to x,y
     */
    public int checkCells(int x,int y) {
        int top    = x-1;
        int bottom = x+1;
        int count  =   0;

        for (int i = top; i <= bottom; i++) {
            System.out.printf("%s %s\n",i,y-1);
            System.out.printf("%s %s\n",i,y);
            System.out.printf("%s %s\n",i,y+1);
            if(i==x)continue;
            count+=getCell_S(i, y);
        }
        for (int i = top; i <= bottom; i++) {
            count+=getCell_S(i, y-1);
        }
        for (int i = top; i <= bottom; i++) {
            count+=getCell_S(i, y+1);
        }
        
        return count;
    }
}