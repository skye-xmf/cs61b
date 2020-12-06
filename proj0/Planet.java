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
        double dx = this.xxPos - p.xxPos;
        double dy = this.yyPos - p.yyPos;
        double dis = Math.sqrt(dx * dx + dy * dy);
        return dis;
    }

    public double calcForceExertedBy(Planet p){
        double F = G * this.mass * p.mass / (calcDistance(p) * calcDistance(p));
        return F;
    }

    public double calcForceExertedByX(Planet p){
        double Fx = this.calcForceExertedBy(p) * (p.xxPos - this.xxPos) / calcDistance(p);
        return Fx;
    }

    public double calcForceExertedByY(Planet p){
        double Fy = this.calcForceExertedBy(p) * (p.yyPos - this.yyPos) / calcDistance(p);
        return Fy;
    }

    public double calcNetForceExertedByX(Planet[] allPlanets){
        double netFx = 0;
        int i = 0;
        while (i < allPlanets.length){
            if (!this.equals(allPlanets[i])) {
                netFx += this.calcForceExertedByX(allPlanets[i]);
            }
            i = i + 1;
        }
        return netFx;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets){
        double netFy = 0;
        int i = 0;
        while (i < allPlanets.length){
            if (!this.equals(allPlanets[i])) {
                netFy += this.calcForceExertedByY(allPlanets[i]);
            }
            i = i + 1;
        }
        return netFy;
    }

    public void update(double dt, double fX, double fY){
        this.xxVel = this.xxVel + dt * fX / this.mass;
        this.yyVel = this.yyVel + dt * fY / this.mass;
        this.xxPos = this.xxPos + dt * this.xxVel;
        this.yyPos = this.yyPos + dt * this.yyVel;
    }

    public void draw(){
        StdDraw.picture(xxPos, yyPos,"images/" + imgFileName);
    }
}


