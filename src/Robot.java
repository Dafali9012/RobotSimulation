public abstract class Robot {

    private int posX;
    private int posY;
    private int speed;

    public Robot() {

    }

    public void move() {
        switch ((int) (Math.random() * 4)) { // Välj en slumpad riktning att gå mot.
            case 0:
                if(getPosX() == Rutplan.getSize() -1 ){
                    move();
                }
                else{
                    setPosX(getPosX()+getSpeed()); // Flytta till höger
                }
                break;
            case 1:
                if(getPosX() == 0 ){
                    move();
                }
                else{
                    setPosX(getPosX()-getSpeed()); // Flytta till vänster
                }
                break;
            case 2:
                if(getPosY() == Rutplan.getSize() -1 ){
                    move();
                }
                else{
                    setPosY(getPosY()+getSpeed()); // Flytta ner
                }
                break;
            case 3:
                if(getPosY() == 0 ){
                    move();
                }
                else{
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
