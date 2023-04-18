import java.util.Scanner;

/**
 * MainApp
 */
public class MainApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int righe=0,colonne=0;
        do {
            try {
                System.out.print("Inserisci quantita di righe: ");
                righe=Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Reinserisci");
            }
        } while (righe<5);
        do {
            try {
                System.out.print("Inserisci quantita di colonne: ");
                colonne=Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Reinserisci");
            }
        } while (colonne<5);
        GameofLife gm = new GameofLife(righe,colonne);
        int x = 0;
        int y = 0;
/*         while (true) {
            gm.round();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } */
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
            System.out.printf("Alla posizione %s;%s sono presenti %s celle adiacenti\n",x,y,gm.checkCells(x-1, y-1));

        } while (true); 
    }
}