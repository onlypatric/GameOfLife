
/**
 * GameofLife
 */
public class GameofLife {

    public boolean[][] board;

    public GameofLife(int sz1,int sz2) {
        board=new boolean[sz1][sz2];
        randomAllocator();
        print();
    }

    /**
     * Allocates random boolean values to the board
     */
    public void randomAllocator() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                this.board[i][j]=Math.random()>0.5;
            }
        }
    }
    /**
     * prints the current board
     */
    public void print(){
        System.out.print("\033c");
        System.out.print("      ");
        for (int i = 0; i < board.length; i++) {
            System.out.printf("%-3s",i+1);
        }
        System.out.print("\n   "+"-".repeat(board.length*3+3)+"\n");
            
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(j==0)
                    System.out.printf("%3s|",i+1);
                if(board[i][j])
                    System.out.printf("%3s","0");
                else
                    System.out.printf("%3s",".");
                if(j==board[0].length-1)
                    System.out.print(" |");
                
            }
            System.out.println();
        }
        System.out.print("   "+"-".repeat(board.length*3+3)+"\n");
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
    public void round() {
        int r;
        print();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                r=checkCells(i, j);
                if(r<2||r>4)
                    {board[i][j]=false;}
                else
                   {board[i][j]=true;}
            }
        }
    }
}