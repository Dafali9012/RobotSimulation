public abstract class Robot {

    private int posX; // variabel för x position
    private int posY;// variabel för y position
    private int speed;// variabel för hastighet som vi inte använder nu för att det orkade vi inte med :) speed tilldelas 1 i alla child klasser

    public Robot() { // default konstruktor

    }
    public void move(Rutplan plan) { // Metod som kollar i alla riktningar ett steg om det finns antingen en zebra eller en gepard ivägen eller om vi står på kanten av planen

        switch ((int) (Math.random() * 4)) { // Välj en slumpad riktning att gå mot.
            case 0:
                if(getPosX() == plan.getSize()-1 || plan.getRutplan()[getPosY()][getPosX()+1]=="G  " || plan.getRutplan()[getPosY()][getPosX()+1]=="Z  "){ // om något hinder existerar så kör vi move() igen för att hitta en annan tillgänglig riktning
                    move(plan);
                }
                else{ // Om inget hinder existerar så flyttar vi oss i den här riktningen
                    setPosX(getPosX()+getSpeed()); // Flytta till höger
                }
                break;
            case 1:
                if(getPosX() == 0 ||plan.getRutplan()[getPosY()][getPosX()-1]=="G  "||plan.getRutplan()[getPosY()][getPosX()-1]=="Z  "){
                    move(plan);
                }
                else{
                    setPosX(getPosX()-getSpeed()); // Flytta till vänster
                }
                break;
            case 2:
                if(getPosY() ==plan.getSize()-1 ||plan.getRutplan()[getPosY()+1][getPosX()]=="G  "||plan.getRutplan()[getPosY()+1][getPosX()]=="Z  "){
                    move(plan);
                }
                else{
                    setPosY(getPosY()+getSpeed()); // Flytta ner
                }
                break;
            case 3:
                if(getPosY() == 0 ||plan.getRutplan()[getPosY()-1][getPosX()]=="G  "||plan.getRutplan()[getPosY()-1][getPosX()]=="Z  "){
                    move(plan);
                }
                else{
                    setPosY(getPosY()-getSpeed()); // Flytta upp
                }
                break;
        }
    }

    public void setPosX(int posX) {
        this.posX = posX;
    } // tilldela variabel posX ett värde

    public void setPosY(int posY) {
        this.posY = posY;
    }// tilldela variabel posY ett värde

    public int getPosX() {
        return posX;
    } // returnera variabel posX

    public int getPosY() {
        return posY;
    }// returnera variabel posY

    public void setSpeed(int speed) {
        this.speed = speed;
    } // tilldela variabel hastighet ett värde, som vi kanske använder någonstans, men behöver den inte alls för allt rör sig bara ett steg :)

    public int getSpeed() {
        return speed;
    } // returnera variabel hastighet

    public void printInfo() { // Metod print() för att skriva ut x och y position
        System.out.printf("x:%d y:%d%n", getPosX(), getPosY());
    }
}
