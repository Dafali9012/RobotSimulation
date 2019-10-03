public class Zebra extends Robot {
    public Zebra() {
        setSpeed(1);
    } // default konstruktor sätter hastighet till 1

    @Override
    public void printInfo() {
        System.out.printf("Zebra: x:%d y:%d%n", getPosX(), getPosY());
    }
}
