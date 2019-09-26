import java.util.InputMismatchException;
import java.util.Scanner;

public class Simulator {

    private Zebra[] zebror;
    private Gepard[] geparder;

    public Simulator() {

    }

    public void run() {
        inputZebror();
    }

    public void setAntalZebra(int i) {
        if (i < 1 || i > 10) {
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

    public int getzebror() {
        return zebror.length;
    }

    public void setAntalGeparder(int i) {
        if (i < 1 || i > 10) {
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
