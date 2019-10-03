public class Gepard extends Robot {

    int restTime = 0;

    public Gepard() {
        setSpeed(1);
    } // // default konstruktor, hastighet sätts till 1

    public boolean hunt(Rutplan plan) { // Metod som kollar om det finns en närliggande zebra och isåfall hoppar till zebrans position

        boolean foundZebra = false; // Variabel för att ha koll på om vi hittade en zebra i närheten och flyttade geparden dit

        switch ((int) (Math.random() * 4)) { // Välj en slumpad riktning att gå mot.
            case 0:
                //System.out.println("Chose direction Right.");
                if (getPosX() != plan.getSize() - 1 && plan.getRutplan()[getPosY()][getPosX() + 1] == "Z  ") { // i case 0 testar vi gepardens x position +1 för att se ett steg åt höger
                    setPosX(getPosX() + 1);
                    foundZebra = true; // sätt variabeln till true eftersom vi flyttade geparden till en zebras position
                }
                break;
            case 1:
                //System.out.println("Chose direction Left.");
                if (getPosX() != 0 && plan.getRutplan()[getPosY()][getPosX() - 1] == "Z  ") { // i case 1 testar vi gepardens x position -1 för att se ett steg åt vänster
                    setPosX(getPosX() - 1);
                    foundZebra = true;
                }
                break;
            case 2:
                //System.out.println("Chose direction Down.");
                if (getPosY() != plan.getSize() - 1 && plan.getRutplan()[getPosY() + 1][getPosX()] == "Z  ") { // i case 2 testar vi gepardens y position +1 för att se ett steg ner
                    setPosY(getPosY() + 1);
                    foundZebra = true;
                }
                break;
            case 3:
                //System.out.println("Chose Direction Up");
                if (getPosY() != 0 && plan.getRutplan()[getPosY() - 1][getPosX()] == "Z  ") { // i case 3 testar vi gepardens y position -1 för att se ett steg upp
                    setPosY(getPosY() - 1);
                    foundZebra = true;
                }
                break;
        }
        if(foundZebra==true){ // om variablen är sann, dvs, vi hittade en zebra och flyttade geparden dit så tar vi bort zebran genom att skapa en ny array/vektor, och det gör vi på grund
                                // av att en array/vektor har en bestämd längd och vi kan inte ändra den. Så vi lägger in alla zebror som inte delar positionen med geparden så ritas zebran
                                // som delar gepardens position inte ut länge från nästa utskrift och framåt.

            Zebra[]survivingZebras = new Zebra[Simulator.getZebror().length - 1];
            int index = 0;
            for(int i = 0; i < Simulator.getZebror().length; i++){

                //System.out.println(Simulator.getZebror()[i]);
                if(!((Simulator.getZebror()[i].getPosX() == getPosX()) && (Simulator.getZebror()[i].getPosY() == getPosY()))) {
                    survivingZebras[index] = Simulator.getZebror()[i];
                    index++;
                }
            }
            Simulator.setZebror(survivingZebras);
        }


        return foundZebra; // returnera om "hunt" hände så kan den informationen användas i vår game loop
    }

    public void setRestTime(int i) {
        restTime = i;
    } // Tilldela tiden geparden ska vila

    public int getRestTime() {
        return restTime;
    } // Returnera hur lång tid geparden har kvar att vila

    @Override
    public void printInfo() { // Printa ut information om position
        System.out.printf("Gepard: x:%d y:%d%n", getPosX(), getPosY());
    }
}

