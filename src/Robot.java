public abstract class Robot {

    private int posX;
    private int posY;
    private int speed;

    public Robot() {

    }

    public void move() {
        switch ((int) (Math.random() * 4)) { // Välj en slumpad riktning att gå mot.
            case 0:
                setPosX(getPosX()+getSpeed()); // Flytta till höger
                break;
            case 1:
                setPosX(getPosX()-getSpeed()); // Flytta vänster
                break;
            case 2:
                setPosY(getPosY()+getSpeed()); // Flytta ner
                break;
            case 3:
                setPosY(getPosY()-getSpeed()); // flytta upp
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
