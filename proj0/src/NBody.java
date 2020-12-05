public class NBody {
    public void readRadius(String filename){
        In in = new In(filename);
        double Radius = in.readDouble();
        System.out.println("The radius of the universe is " + Radius + " .");
    }
}
