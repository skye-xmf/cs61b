public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
        double dx = xxPos - p.xxPos;
        double dy = yyPos - p.yyPos;
        double dis = Math.sqrt(dx * dx + dy * dy);
        return dis;
    }

    public double calcForceExertedBy(Planet p){
        double F = G * mass * p.mass / (calcDistance(p) * calcDistance(p));
        return F;
    }

    public double calcForceExertedByX(Planet p){
        double Fx = calcForceExertedBy(p) * (p.xxPos - xxPos) / calcDistance(p);
        return Fx;
    }

    public double calcForceExertedByY(Planet p){
        double Fy = calcForceExertedBy(p) * (p.yyPos - yyPos) / calcDistance(p);
        return Fy;
    }

    public double calcNetForceExertedByx(Planet[] allPlanets){
        double netFx = 0;
        for (int i =0; i < allPlanets.length; i = i +1){
            while (this != allPlanets[i]){
                netFx += calcForceExertedByX(allPlanets[i]);
            }
        }
        return netFx;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets){
        double netFy = 0;
        for (int i =0; i < allPlanets.length; i = i + 1){
            while (this != allPlanets[i]){
                netFy += calcForceExertedByY(allPlanets[i]);
            }
        }
        return netFy;
    }
}

