public class Gepard extends Robot {

    int restTime = 0;

    public Gepard() {
        setSpeed(1);
    }

    public void eat() {
        restTime = 3;
    }


    public void rest() {

    }

    public void run() {

    }

    public void move() {

        switch ((int) (Math.random() * 4)) { // Välj en slumpad riktning att gå mot.
            case 0:
                //System.out.println("Chose direction Right.");
                if(getPosX() == Rutplan.getSize()-1 || Rutplan.getRutplan()[getPosY()][getPosX()+1]=="G  "){
                    //System.out.println("Tries to move again.");
                    move();
                }
                else{
                    //System.out.println("Moved Right.");
                    setPosX(getPosX()+getSpeed()); // Flytta till höger
                }
                break;
            case 1:
                //System.out.println("Chose direction Left.");
                if(getPosX() == 0 || Rutplan.getRutplan()[getPosY()][getPosX()-1]=="G  "){
                    //System.out.println("Tries to move again.");
                    move();
                }
                else{
                    //System.out.println("Moved Left.");
                    setPosX(getPosX()-getSpeed()); // Flytta till vänster
                }
                break;
            case 2:
                //System.out.println("Chose direction Down.");
                if(getPosY() == Rutplan.getSize()-1 || Rutplan.getRutplan()[getPosY()+1][getPosX()]=="G  "){
                    //System.out.println("Tries to move again.");
                    move();
                }
                else{
                    //System.out.println("Moves Down.");
                    setPosY(getPosY()+getSpeed()); // Flytta ner
                }
                break;
            case 3:
                //System.out.println("Chose Direction Up");
                if(getPosY() == 0 || Rutplan.getRutplan()[getPosY()-1][getPosX()]=="G  "){
                    //System.out.println("Tries to move again");
                    move();
                }
                else{
                    //System.out.println("Moved UP");
                    setPosY(getPosY()-getSpeed()); // Flytta upp
                }
                break;
        }
    }

    @Override
    public void printInfo() {
        System.out.printf("Gepard: x:%d y:%d%n", getPosX(), getPosY());
    }
}

