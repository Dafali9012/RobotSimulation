public class Rutplan {
    private int size; // variabel som har koll på planens storlek
    private String[][] rutplan; // variabel som innehåller representationer av våra objekt i String form på sina respektive positioner

    public Rutplan() { // default konstruktor (inga parametrar)
        size = 10; // tilldela size ett värde som är bredd och höjd av rutnätet
        rutplan = new String[size][size]; // definiera att rutplan är en 2D array med storleken vi har definierat i variabeln size
    }

    public String[][] getRutplan() {
        return rutplan;
    } // returnera rutplan

    public int getSize() {
        return size;
    } // returnera size

    public void write() { // Metod för att tilldela värden i vår rutplan array så att de ritas ut på skärmen
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) { // loopa igenom vår rutplan 2D array för x och y
                rutplan[y][x] = ".  "; // som default sätt direkt en position i arrayen till ".  " vilket vi representerar tomrum med. kanske gräs ute på savannen vad vet jag.
                for (Zebra z : Simulator.getZebror()) { // loopa igenom arrayen som lagrar zebror i simulator klassen och returnera alla objekt av klass Zebra till variabelnamn "z"
                    rutplan[z.getPosY()][z.getPosX()] = "Z  "; // skriv över koordinaterna i rutplan där zebrans position är med "Z  "
                }
                for (Gepard g : Simulator.getGeparder()) { // loopa igenom arrayen som lagrar geparder i simulator klassen och returnera alla objekt av klass Gepard till variabelnamn "g"
                    rutplan[g.getPosY()][g.getPosX()] = "G  "; // skriv över koordinaterna i rutplan där gepardens position är med "G  "
                }
            }
        }
    }

    public void print() { // metod för att rita ut planen i vårt output fönster
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) { // loopa igenom vår rutplan 2D array för x och y
                System.out.print(rutplan[y][x]); // skriv ut tecknet vid index position y,x
                if (x == size - 1) System.out.print("\n"); // och om vi har nått bredden på planen så skriver vi ut en newline character så att vi inte skriver ut allt på samma rad.
            }
        }
        System.out.print("\n");
    }
}
