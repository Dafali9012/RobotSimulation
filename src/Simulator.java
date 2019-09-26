import java.util.Scanner;

public class Simulator {

    private int [] zebra;
    private int [] gepard;

    public void inData() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Välja hur många zebra ");

    }

    public void setZebra(int[] zebra) {
        this.zebra = zebra;
    }

    public int[] getZebra() {
        return zebra;
    }
    public void setGepard(int[] gepard) {
        this.gepard = gepard;
    }
    public int[] getGepard() {
        return gepard;
    }

}
