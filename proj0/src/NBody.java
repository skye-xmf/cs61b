public class NBody {
    public static double readRadius(String filename) {
        In in = new In(filename);
        int number = in.readInt();
        double Radius = in.readDouble();
        return Radius;
    }

    public static Planet[] readPlanets(String filename) {
        In in = new In(filename);
        int number = in.readInt();
        double Radius = in.readDouble();
        Planet[] planets = new Planet[number];
        for (int i = 0; i < 5; i++) {
            planets[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(),
                    in.readDouble(), in.readDouble(), in.readString());
        }
        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        double t = 0;

        double[] xForces = new double[planets.length];
        double[] yForces = new double[planets.length];

        StdDraw.enableDoubleBuffering();

        while (t <= T) {
            for (int i = 0; i < planets.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for (int i = 0; i < planets.length; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            /** set up the scale of the universe. */
            StdDraw.setScale(-radius, radius);

            /** clear the draw window. */
            StdDraw.clear();

            /** the location of the picture. */
            String background = "images/starfield.jpg";
            StdDraw.picture(0, 0, background);

            for (Planet p : planets) {
                p.draw();

                /** show the picture to the screen, and wait 2000 milliseconds. */
                StdDraw.show();
                StdDraw.pause(10);

                t += dt;

            }
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}
