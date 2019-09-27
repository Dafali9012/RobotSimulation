import java.util.InputMismatchException;
import java.util.Scanner;

public class Simulator {

    private static Zebra[] zebror;
    private static Gepard[] geparder;

    public Simulator() {

    }

    public void run() {
        inputGeparder();
        inputZebror();

        gameLoop(10);
    }

    public void gameLoop(int rundor) {
        int i = rundor;

        System.out.print("Runda " + i + ":\n");
        Rutplan.print();

        gepardActions(geparder.length);
        zebraActions(zebror.length);

        i--;
        if(rundor>0) gameLoop(i);
    }

    public void gepardActions(int antal) {
        int antalGeparder = antal;
        geparder[antalGeparder-1].move();
        antalGeparder--;
        if(antalGeparder>0) gepardActions(antalGeparder);
    }

    public void zebraActions(int antal) {
        int antalZebror = antal;
        zebror[antalZebror-1].move();
        antalZebror--;
        if(antalZebror>0) zebraActions(antalZebror);
    }

    public void removeZebraCheck() {
        for (int i = 0; i < geparder.length; i++) {
            for (int j = 0; j < zebror.length; j++) {
                if (geparder[i].getPosX() == zebror[j].getPosX() && geparder[i].getPosY() == zebror[j].getPosY()) {

                    zebror[j] = null;
                }
            }
        }
    }


    public void setAntalZebra(int i) {
        if (i < geparder.length || i > 10) {
            inputZebror();
            return;
        }

        zebror = new Zebra[i];
        while (i > 0) {
            Zebra z = new Zebra();
            z.setPosX((int) (Math.random() * 10));
            z.setPosY((int) (Math.random() * 10));
            zebror[i - 1] = z;
            System.out.print(zebror[i - 1].getPosX() + "  ");
            System.out.println(zebror[i - 1].getPosY());
            i--;
        }
    }

    public static Zebra[] getZebror() {
        return zebror;
    }

    public void setAntalGeparder(int i) {
        if (i < 1 || i > 10) {
            inputGeparder();
            return;
        }

        geparder = new Gepard[i];
        while (i > 0) {
            Gepard g = new Gepard();
            g.setPosX((int) (Math.random() * 10));
            g.setPosY((int) (Math.random() * 10));
            geparder[i - 1] = g;
            System.out.print(geparder[i - 1].getPosX() + "  ");
            System.out.println(geparder[i - 1].getPosY());
            i--;
        }
    }

    public static Gepard[] getGeparder() {
        return geparder;
    }

    public void inputZebror() {


        System.out.print("Välj hur många zebror: ");
        setAntalZebra(input());

    }

    public void inputGeparder() {
        System.out.print("Välj hur många geparder: ");
        setAntalGeparder(input());
    }

    public int input() {
        boolean success = false; // Så länge success inte är true, då fortsätter loopen att loopa.
        int input = 0;
        Scanner scan = new Scanner(System.in);
        do {
            try {
                input = scan.nextInt();
                success = true;
            } catch (InputMismatchException e) {
                System.out.print("Illegal input: ");
                scan.nextLine();
            }
        }
        while (!success);
        scan.nextLine();
        return input;
    }
}
