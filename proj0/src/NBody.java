public class NBody {
    public static double readRadius(String filename){
        In in = new In(filename);
        double number = in.readDouble();
        double Radius = in.readDouble();
        return Radius;
    }

    public static String[] readPlanets(String filename){
        In in = new In(filename);
        String[] name = new String[5];
        int i = 0;
        while (i < 4){
            String planet = in.readString();
            name[i] = planet;
            i = i + 1;
        }
        return name;
    }
}
