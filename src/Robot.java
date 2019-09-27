public abstract class Robot {

    private int posX;
    private int posY;
    private int speed;

    public Robot() {

    }

    public void move() {

        switch ((int) (Math.random() * 4)) { // Välj en slumpad riktning att gå mot.
            case 0:
                System.out.println("Chose direction Right.");
                if(getPosX() == 9 ){
                    System.out.println("Tries to move again.");
                    move();
                }
                else{
                    System.out.println("Moved Right.");
                    setPosX(getPosX()+getSpeed()); // Flytta till höger
                }
                break;
            case 1:
                System.out.println("Chose direction Left.");
                if(getPosX() == 0 ){
                    System.out.println("Tries to move again.");
                    move();
                }
                else{
                    System.out.println("Moved Left.");
                    setPosX(getPosX()-getSpeed()); // Flytta till vänster
                }
                break;
            case 2:
                System.out.println("Chose direction Down.");
                if(getPosY() == 9 ){
                    System.out.println("Tries to move again.");
                    move();
                }
                else{
                    System.out.println("Moves Down.");
                    setPosY(getPosY()+getSpeed()); // Flytta ner
                }
                break;
            case 3:
                System.out.println("Chose Direction Up");
                if(getPosY() == 0 ){
                    System.out.println("Tries to move again");
                    move();
                }
                else{
                    System.out.println("Moved UP");
                    setPosY(getPosY()-getSpeed()); // Flytta upp
                }
                break;
        }
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void printInfo() {
        System.out.printf("x:%d y:%d%n", getPosX(), getPosY());
    }
}
