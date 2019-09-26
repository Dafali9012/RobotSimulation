import java.util.InputMismatchException;
import java.util.Scanner;

public class Simulator {

    private Zebra[] zebror;
    private Gepard[] geparder;

    public Simulator() {

    }

    public void run() {
        inputGeparder();
       for(int i = 0; i < 10; i++) {
           for(Gepard g: geparder) {
               System.out.print("Runda "+i);
               g.move();
               g.printInfo();
           }
       }
    }

    public void removeZebraCheck() {
        for(int i = 0; i < geparder.length; i++) {
            for(int j = 0 ;j < zebror.length; j++) {
                if(geparder[i].getPosX() == zebror[j].getPosX() && geparder[i].getPosY() == zebror[j].getPosY()) {

                    zebror[j]=null;
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

    public Zebra getZebra(int i) {
        return zebror[i];
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

    public int getgeparder() {
        return geparder.length;
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
