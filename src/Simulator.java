import java.util.InputMismatchException;
import java.util.Scanner;

public class Simulator {

    private static Zebra[] zebror;
    private static Gepard[] geparder;
    private Rutplan plan;

    public Simulator() {
        plan = new Rutplan();
    }
    public static void setZebror(Zebra[] newVektor){
        zebror = newVektor;
    }
    public static Zebra[] getZebror(){

        return zebror;
    }

    public void run() {
        inputGeparder();
        inputZebror();
        plan.write();
        plan.print();

        int loop = 0;
        while(zebror.length > 0) {

            for(int g = 0; g < getGeparder().length; g++){
                if(!geparder[g].hunt(plan)){
                    geparder[g].move(plan);}

                plan.write();

            }
            for(int z = 0; z < getZebror().length; z++){
                zebror[z].move(plan);
                plan.write();
            }
            System.out.printf("Runda #%d%n",++loop);
            plan.print();
        }


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
