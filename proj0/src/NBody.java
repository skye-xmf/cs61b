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

    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        readRadius(filename);
        readPlanets(filename);
        drawbackground();
    }
    public static String image = "starfield.jpg";

    public static void drawbackground(){
        /** set up the scale of the universe. */
        In in = new In("./src/planet.txt");
        int number = in.readInt();
        Double Radius = in.readDouble();
        StdDraw.setScale(-Radius, Radius);

        /** clear the draw window. */
        StdDraw.clear();

        /** the location of the picture. */
        StdDraw.picture(0, 0, "./images/starfield.jpg");

        /** show the picture to the screen, and wait 2000 milliseconds. */
        StdDraw.show();
        StdDraw.pause(2000);
    }
}
