public class Planet {
    public double xxPos;
    public double xxVel;
    public double yyPos;
    public double yyVel;
    public double mass;
    public String imgFileName;
    static final double  G = 6.67 * Math.pow(10, -11);


    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }
    public double calcDistance(Planet P){
        double r_squared = ((this.xxPos - P.xxPos) * (this.xxPos - P.xxPos)) + ((this.yyPos - P.yyPos) * (this.yyPos - P.yyPos));
        return Math.sqrt(r_squared);
    }

    public double calcForceExertedBy(Planet P){
        double denominator = G * this.mass * P.mass;
        return denominator/(this.calcDistance(P) * this.calcDistance(P));
    }

    public double calcForceExertedByX(Planet P){
        double F = this.calcForceExertedBy(P);
        double dx = P.xxPos - this.xxPos;
        return (F * dx) / this.calcDistance(P);
    }

    public double calcForceExertedByY(Planet P){
        double F = this.calcForceExertedBy(P);
        double dy = P.yyPos - this.yyPos;
        return (F * dy) / this.calcDistance(P);
    }

    public double calcNetForceExertedByX(Planet[] P){
        double netX = 0;
        for(Planet p: P){
            if(this.equals(p)){
                continue;
            }
            netX += this.calcForceExertedByX(p);
        }
        return netX;

    }
    public double calcNetForceExertedByY(Planet[] P){
        double netY = 0;
        for(Planet p: P){
            if(this.equals(p)){
                continue;
            }
            netY += this.calcForceExertedByY(p);
        }
        return netY;
    }

    public void update(double time, double xForce, double yForce){
        double accelerationX = xForce/ this.mass;
        double accelerationY = yForce/ this.mass;
        xxVel = this.xxVel + (time * accelerationX);
        yyVel = this.yyVel + (time * accelerationY);
        xxPos = xxPos + (time * xxVel);
        yyPos = yyPos + (time * yyVel);
    }

    public void draw(){
        StdDraw.picture(xxPos,yyPos,"images/"+imgFileName);
    }
}
