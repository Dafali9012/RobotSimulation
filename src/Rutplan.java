public abstract class Rutplan {
    private static int size = 10;
    private static String[][] rutplan = new String[size][size];;

    public Rutplan() {

    }

    public static String[][] getRutplan() {
        return rutplan;
    }

    public static int getSize() {
        return size;
    }



    public static void print() {
        for (int y = 0; y < size; y++) {
            for(int x = 0; x < size; x++) {
                rutplan[y][x] = ".  ";
                for(Zebra z: Simulator.getZebror()){
                    rutplan[z.getPosY()][z.getPosX()] = "Z  ";
                }
                for(Gepard g : Simulator.getGeparder()) {
                    rutplan[g.getPosY()][g.getPosX()] = "G  ";
                }
                System.out.print(rutplan[y][x]);
                if(x == 9) System.out.print("\n");
            }
        }
    }
}
