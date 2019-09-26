import java.util.Scanner;

public class Simulator {
    Scanner scan = new Scanner(System.in);
    private int[ ] zebra ;
    private int [] geopard;

    public void setZebra(int[] zebra) {
        this.zebra = zebra;
    }

    public int[] getZebra() {
        return zebra;
    }
    public void setGeopard(int[] geopard) {
        this.geopard = geopard;
    }
    public int[] getGeopard() {
        return geopard;
    }

    public void inData() {
        System.out.println("Välja hur många zebra ");

    }
}
