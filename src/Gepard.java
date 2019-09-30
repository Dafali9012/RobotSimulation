public class Gepard extends Robot {

    int restTime = 0;

    public Gepard() {
        setSpeed(1);
    }

    public void eat() {
        restTime = 3;
    }

    public boolean hunt(Rutplan plan) {

        boolean foundZebra = false;

        switch ((int) (Math.random() * 4)) { // Välj en slumpad riktning att gå mot.
            case 0:
                //System.out.println("Chose direction Right.");
                if (getPosX() != plan.getSize() - 1 && plan.getRutplan()[getPosY()][getPosX() + 1] == "Z  ") {
                    setPosX(getPosX() + 1);
                    foundZebra = true;
                }
                break;
            case 1:
                //System.out.println("Chose direction Left.");
                if (getPosX() != 0 && plan.getRutplan()[getPosY()][getPosX() - 1] == "Z  ") {
                    setPosX(getPosX() - 1);
                    foundZebra = true;
                }
                break;
            case 2:
                //System.out.println("Chose direction Down.");
                if (getPosY() != plan.getSize() - 1 && plan.getRutplan()[getPosY() + 1][getPosX()] == "Z  ") {
                    setPosY(getPosY() + 1);
                    foundZebra = true;
                }
                break;
            case 3:
                //System.out.println("Chose Direction Up");
                if (getPosY() != 0 && plan.getRutplan()[getPosY() - 1][getPosX()] == "Z  ") {
                    setPosY(getPosY() - 1);
                    foundZebra = true;
                }
                break;
        }
        if(foundZebra==true){
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


        return foundZebra;
    }


    public void rest() {

    }

    public void run() {

    }


    @Override
    public void printInfo() {
        System.out.printf("Gepard: x:%d y:%d%n", getPosX(), getPosY());
    }
}

