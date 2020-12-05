public class NBody {
    public static double readRadius(String filename){
        In in = new In(filename);
        double number = in.readDouble();
        double Radius = in.readDouble();
        return Radius;
    }
}
