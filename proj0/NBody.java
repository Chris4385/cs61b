public class NBody{
    public static double readRadius(String fileName){
        In in = new In(fileName);
        int numberOfPlanets = in.readInt();
        double universeRadius = in.readDouble();
        return universeRadius;
    }
    public static Planet[] readPlanets(String fileName){
        In in = new In(fileName);
        int numberOfPlanets = in.readInt();
        double universeRadius = in.readDouble();
        Planet[] planetList = new Planet[5];
        for(int i = 0; i < 5; i++){
            double xPos = in.readDouble();
            double yPos = in.readDouble();
            double xVel = in.readDouble();
            double yVel = in.readDouble();
            double mass = in.readDouble();
            String image = in.readString();

            planetList[i] = new Planet(xPos, yPos,xVel,yVel,mass,image);

        }
        return planetList;
    }
    public static void drawBackground(String fileName, double universeRadius){
        StdDraw.setScale(-universeRadius, universeRadius);
        StdDraw.picture(0,0,fileName);
//        StdDraw.show();
    }
    public static void animation(double time, double dx, Planet[] planetList, String fileName, double universeRadius){
        double[] xForces = new double [planetList.length];
        double[] yForces = new double [planetList.length];

        for(int i = 0; i <= time; i+=dx) {
            for (int j = 0; j < planetList.length; j++) {

                xForces[j] = planetList[j].calcNetForceExertedByX(planetList);
                yForces[j] = planetList[j].calcNetForceExertedByY(planetList);
                planetList[j].update(dx, xForces[j], yForces[j]);
            }

            drawBackground(fileName, universeRadius);
            for (Planet p : planetList) {
                p.draw();
            }
            StdDraw.enableDoubleBuffering();
            StdDraw.show();
            StdDraw.pause(10);
        }

    }
    public static void toString(Planet[] planets, double  radius){
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String fileName = args[2];
        double universeRadius = readRadius(fileName);
        Planet[] planetList = readPlanets(fileName);
        String backgroundImageFile = "images/starfield.jpg";


        animation(T, dt, planetList, backgroundImageFile, universeRadius);
        toString(planetList,universeRadius);

    }
}
