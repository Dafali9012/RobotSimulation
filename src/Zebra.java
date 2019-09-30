public class Zebra extends Robot {
    public Zebra() {
        setSpeed(1);
    }

    public void run() {

    }

    @Override
    public void printInfo() {
        System.out.printf("Zebra: x:%d y:%d%n", getPosX(), getPosY());
    }
}
