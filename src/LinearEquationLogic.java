import java.util.Scanner;
public class LinearEquationLogic {
    private Scanner scan;
    private String cord1;
    private String cord2;
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private double slope;
    private double b;
    private double distance;
    private double x;
    private double y;


    public LinearEquationLogic(){
        scan = new Scanner(System.in);
        cord1 = null;
        cord2 = null;
    }
    public void start(){
        getCoordinates();
        LinearEquation();
        lineInfo();
        LinearEquation();
        coordinateForX();
        System.out.print("Would you like to enter another pair of coordinates? y/n: ");
        String startAgain = scan.nextLine();
        while (!startAgain.equals("n")) {
            if(startAgain.equals("y")) {
                getCoordinates();
                LinearEquation();
                lineInfo();
                LinearEquation();
                coordinateForX();
                System.out.print("Would you like to enter another pair of coordinates? y/n: ");
                startAgain = scan.nextLine();
            }
        }
    }
    public void LinearEquation(){
        parsingLogic();
        slope = Math.round(( double) (y2 - y1) / (x2 - x1) * 100) / 100.0;
        b = y1 - (slope * x1); //    b = y1 - ((double) (y2 - y1) / (x2 - x1) * x1);
        distance = Math.round(Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)) * 100) / 100.0;
        lineInfo();
        y = slope * x + b;
    }


    private void parsingLogic(){
        x1 = Integer.parseInt(cord1.substring(1, cord1.indexOf(",")));
        y1 = Integer.parseInt(cord1.substring(cord1.indexOf(",") + 2 , cord1.indexOf(")")));
        x2 = Integer.parseInt(cord2.substring(1, cord2.indexOf(",")));
        y2 = Integer.parseInt(cord2.substring(cord2.indexOf(",") + 2 , cord2.indexOf(")")));
    }
    private void getCoordinates(){ //helper
        System.out.println("Welcome to the linear equation calculator!");
        System.out.print("Enter coordinate 1:");
        cord1 = scan.nextLine();
        System.out.print("Enter coordinate 2:");
        cord2 = scan.nextLine();
        System.out.println();
    }
    private void lineInfo(){
        System.out.println("The two points are: " + cord1 + " and " + cord2);
        System.out.println("The equation of the line between these points is: y = " + (y2 - y1) + "/" + (x2 - x1) + "x" + " + " +  b);
        System.out.println("The y-intercept of the line is: " + b);
        System.out.println("The slope of this line is: " + slope);
        System.out.println("The distance between the two points is: " + distance);
        System.out.println();
        System.out.print("Enter a value for x: ");
        x = scan.nextDouble();
        System.out.println();
    }


    private void coordinateForX(){
        System.out.println("The point on the line is (" + x + ", " + y + ")");
    }
}
