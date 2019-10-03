import java.util.InputMismatchException;
import java.util.Scanner;

public class Simulator {

    private static Zebra[] zebror; // variabel för att spara alla zebra objekt vi skapar
    private static Gepard[] geparder; // variabel för att spara alla zebra objekt vi skapar
    private Rutplan plan; // variabel för objektet av klassen Rutplan vi skapar

    public Simulator() {
        plan = new Rutplan();
    } // Default konstruktor, definierar/ skapar ett nytt objekt av Rutplan
    public static void setZebror(Zebra[] newVektor){ // Metod för att tilldela zebravektor variablen en ny vektor när vi vill ta bort en zebra
        zebror = newVektor;
    }
    public static Zebra[] getZebror(){ // returnera vektor variabeln som innehåller alla zebror

        return zebror;
    }

    public void run() { // Metod run() där vi startar programmet
        inputGeparder(); // Vi matar in antal geparder som ska skapas
        inputZebror(); // Vi matar in antal zebror som ska skapas
        plan.write(); // Objektet av Rutplan får köra sin write() metod en gång så ritar vi in ursprungspositionerna
        plan.print(); // och vi printar ut skärmen vid start innan något har hänt

        int loop = 0; // variabel för att hålla reda på hur många gånger vi har loopat så använder vi det för att skriva ut vilken "runda" det är som vi har kallat det
        while(zebror.length > 0) { // Game loopen som fortsätter så det finns zebror kvar i vår zebra vektor

            for(int g = 0; g < getGeparder().length; g++){ // loopa igenom alla geparder
                if(geparder[g].getRestTime() ==0 ) { // om restime är 0 så ska geparden inte vila så då får den försöka hitta en närliggande zebra till att börja med
                    if (!geparder[g].hunt(plan)) { // geparden letar efter en närliggande zebra, och i if satsen kollan vi om resultatet av metoden hunt är falskt
                        geparder[g].move(plan); // om metoden hunt returnerar false så finns inte någon zebra i närheten och då ska geparden försöka röra sig som vanligt istället
                        plan.write(); // varje gång något flyttar sig så vill vi uppdatera tecknen i vår rutplan array eftersom det är tecknen vi kollar för att se om något står i vägen
                    } else { // om metoden hunt() visar sig returnera true så har geparden hittat och ätit en zebra, då tilldelar vi variabeln resttime ett värde som definierar hur många loops den ska stå stilla och inte göra någonting
                        geparder[g].setRestTime(5);
                    }
                }else { // om gepardens resttime är högre än 0 så hoppar den över all kod ovan och försöker inte äta eller röra sig, isället räknar vi ner gepardens resttime den här loopen
                    geparder[g].setRestTime(geparder[g].getRestTime()-1);
                }
            }
            for(int z = 0; z < getZebror().length; z++){ // loopa igenom alla zebror
                zebror[z].move(plan); // zebror har inget annat att göra än att röra sig så det är det de gör
                plan.write(); // uppdatera rutplan
            }
            System.out.printf("%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n"); // skriver bara ut 20 radbyten så att vi bara ser en snapshot av skärmen i vår output
            System.out.printf("Runda #%d%n",++loop); // skriv ut hur många loops vi har gått igenom
            plan.print(); // kör metoden print för att skriva ut rutplanen
            try {
                Thread.sleep(350); // pausa tråden vi kör all kod på i 350 millisekunder så att allt inte händer direkt när vi kör programmet (gör animation möjligt, smooth scrolling i intellij måste avaktiveras)
            } catch (InterruptedException e) {

            }
        }
        System.out.printf("- Game Over -"); // skriv ut "Game Over" när programmet har nått sitt slut, dvs när zebra arrayen är tom
    }


    public void setAntalZebra(int i) { // metod som tar emot inmatat antal zebror och skapar zebra objekten och sparar dem i zebra vektorn
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

    public void setAntalGeparder(int i) { // metod som tar emot inmatat antal zebror och skapar zebra objekten och sparar dem i zebra vektorn
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
    } // returnera gepard vektorn

    public void inputZebror() { // skriv ut meddelande till användaren och ta emot input


        System.out.print("Välj hur många zebror: ");
        setAntalZebra(input());

    }

    public void inputGeparder() { // skriv ut meddelande till användaren och ta emot input
        System.out.print("Välj hur många geparder: ");
        setAntalGeparder(input());
    }

    public int input() { // metod som hanterar input av heltal, hanterar felinmatning och newline character när man trycker enter
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
