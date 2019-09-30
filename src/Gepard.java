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


    @Override
    public void printInfo() {
        System.out.printf("Gepard: x:%d y:%d%n", getPosX(), getPosY());
    }
}

