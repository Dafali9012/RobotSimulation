public class Rutplan {
    private int size;
    private String[][] rutplan;

    public Rutplan() {
    size = 20;
    rutplan = new String[size][size];
    }

    public String[][] getRutplan() {
        return rutplan;
    }

    public int getSize() {
        return size;
    }

    public void insertValue(){

    }


    public void write() {
        for (int y = 0; y < size; y++) {
            for(int x = 0; x < size; x++) {
                rutplan[y][x] = ".  ";
                for (Zebra z : Simulator.getZebror()) {
                    rutplan[z.getPosY()][z.getPosX()] = "Z  ";
                }
                for (Gepard g : Simulator.getGeparder()) {
                    rutplan[g.getPosY()][g.getPosX()] = "G  ";
                }
            }

        }
    }

    public void print() {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                System.out.print(rutplan[y][x]);
                if (x == 19) System.out.print("\n");
            }
        }
        System.out.print("\n");
    }
}
