import java.util.Scanner;

/**
 * MainApp
 */
public class MainApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GameofLife gm = new GameofLife();
        int x = 0;
        int y = 0;
        do {
            do {
                try {
                    System.out.print("X (-1 per uscire): ");
                    x=Integer.parseInt(sc.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("il valore inserito non e' un numero!");
                }
            } while (true);
            if(x<0)break;
            do {
                try {
                    System.out.print("Y (-1 per uscire): ");
                    y=Integer.parseInt(sc.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("il valore inserito non e' un numero!");
                }
            } while (true);
            if(y<0)break;
            System.out.printf("Alla posizione %s;%s sono presenti %s celle adiacenti\n",x,y,gm.checkCells(x, y));

        } while (true);
    }
}