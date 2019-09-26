public abstract class Rutplan {
    private String[][] rutplan;
    private static int size;

    public Rutplan() {
        size = 10;
        rutplan = new String[size][size];
    }

    public void getPos(int x, int y) {
        //return rutplan[x][y];
    }

    public static int getSize() {
        return size;
    }

    public void print() {
        for (int y = 0; y < 10; y++) {
            for(int x = 0; x < 10; x++) {
                rutplan[y][x] = "@  ";
                System.out.print(rutplan[y][x]);
                if(x == 9) System.out.print("\n");
            }
        }
    }
}
