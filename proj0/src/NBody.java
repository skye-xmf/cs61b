public class NBody {
    public static double readRadius(String filename){
        In in = new In(filename);
        int number = in.readInt();
        double Radius = in.readDouble();
        return Radius;
    }

    public static Planet[] readPlanets(String filename){
        In in = new In(filename);
        int number = in.readInt();
        double Radius = in.readDouble();
        Planet[] planets = new Planet[number];
        for (int i = 0; i < 5; i ++){
            planets[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(),
                    in.readDouble(), in.readDouble(), in.readString());
        }
        return planets;
    }
}
