import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LinearEquation {
    private String point1;
    private String point2;

    public LinearEquation(String point1, String point2){
        this.point1 = point1;
        this.point2 = point2;

    }

    int[] findPoints(){
        int commaIndexP1 = point1.indexOf(",");

        int x1 = Integer.parseInt(point1.substring(1, commaIndexP1));
        int y1 = Integer.parseInt(point1.substring(commaIndexP1 + 1, point1.length()-1));

        int commaIndexP2 = point2.indexOf(",");
        int x2 = Integer.parseInt(point2.substring(1, commaIndexP2));
        int y2 = Integer.parseInt(point2.substring(commaIndexP2 + 1, point2.length()-1));

       int[] points = {x1, y1, x2, y2};

        return points;
    }

    /** Finds the distance between (x1, y1) and (x2, y2) in decimal form using the distance formula. Round to the nearest 1/100*/
    public String distance(){
        double distanceDouble = Math.sqrt(Math.pow((findPoints()[2] - findPoints()[0]), 2) + Math.pow((findPoints()[3] - findPoints()[1]), 2));
        distanceDouble = Math.round(distanceDouble * 100.0) / 100.0;
        String distance = Double.toString(distanceDouble);
        if (distance.substring(distance.length() - 2).equals(".0")){
            distance += "0";
        }
        return distance;
    }



    /** Finds the slope of the two points and rounds it to the nearest 100th decimal place*/
    public double slope(){
        double slope = (double) (findPoints()[3] - findPoints()[1]) /(findPoints()[2]-findPoints()[0]);
        return slope;
    }


    /** Finds the slope but makes it into a string. If the denominator is negative, it takes away the "-" and puts it in front of the fraction. If both the numerator and denominator are negative, it makes the fraction positive.*/
    public String slopeString(){
        String slopeString;
        String rise = Integer.toString(findPoints()[3] - findPoints()[1]);
        String run = Integer.toString(findPoints()[2] - findPoints()[0]);
        if (slope() == Math.round(slope())){
            slopeString = Double.toString(slope());
            if (slopeString.substring(slopeString.length() - 2).equals(".0")){
                slopeString = slopeString.substring(0, slopeString.length()-2);
                slopeString = slopeString + "/1";
            }
        }
        else {
            if (run.charAt(0) == '-'){
                if (rise.charAt(0) == '-'){
                    run = run.substring(1);
                    rise = rise.substring(1);
                }
                else {
                    rise = "-" + rise;
                    run = run.substring(1);
                }
            }
            slopeString = rise + "/" + run;
        }

        return slopeString;
    }


    /** Finds the y-intercept of the equation and rounds it to the nearest 100th decimal place. */
    public String yIntercept(){
        double yInterceptDouble = findPoints()[1] - (slope() * findPoints()[0]);
        yInterceptDouble = Math.round(yInterceptDouble * Math.pow(10, 2)) / Math.pow(10, 2);
        String yInterceptStr = String.valueOf(yInterceptDouble);
        if (yInterceptStr.substring(yInterceptStr.length() - 2).equals(".0")){
            yInterceptStr = yInterceptStr + "0";
        }
        return yInterceptStr;
    }


    /** This returns the equation in its full form (y = ax + b). If the y-intercept is 0, it doesn't show. If the y-intercept is negative, it doesn't write + -#, but writes x - #. If the slope is 1 it doesn't show. If the slope is -1, it will write -x. */
    public String equation(){
        String equation;
        if (slope() == 1){
            if (Objects.equals(yIntercept(), "0")) {
                equation = "y = x";
            }
            else{
                if (yIntercept().substring(0, 1).equals("-")){
                    equation = "y = x - " + yIntercept();
                }
                else {
                    equation = "y = x + " + yIntercept();
                }
            }
        }
        else if (slope() == -1.0) {
            if (Objects.equals(yIntercept(), "0")){
                equation = "y = -x";
            }
            else {
                if (yIntercept().substring(0, 1).equals("-")){
                    equation = "y = -x - " + yIntercept();
                }
                else {
                    equation = "y = -x + " + yIntercept();
                }
            }
        }
        else {
            if (Objects.equals(yIntercept(), "0")){
                equation = "y = " + slopeString() + "x";
            }
            else {
                if (yIntercept().substring(0, 1).equals("-")){
                    double yIntDouble = Double.parseDouble(yIntercept());
                    double yInt = yIntDouble;
                    String yIntString = Double.toString(yInt);
                    yIntString = yIntString.substring(1);
                    equation = "y = " + slopeString() + "x - " + yIntString;
                }
                else {
                    equation = "y = " + slopeString() + "x + " + yIntercept();
                }
            }
        }


        return equation;
    }


    /** This method finds the y-value for a third inputted x-value, rounded to the nearest 100th decimal place. */
    public String thirdValue(double x3){
        double yIntDouble = Double.parseDouble(yIntercept());
        double y3Double = (slope() * x3) + yIntDouble;
        String y3 = Double.toString(y3Double);
        if (y3.substring(y3.length() - 2).equals(".0")){
            y3 += "0";
        }
        String x3Str = Double.toString(x3);
        if (x3Str.substring(x3Str.length() - 2).equals(".0")){
            x3Str += "0";
        }
        String thirdPrint = "Third Coordinate Pair: (" + x3Str + ", " + y3 + ")";
        return thirdPrint;

    }


    /** Returns a statement with all the information (except for thirdvalue) to be printed.*/
    public String toString(){
        String toPrint = "First Pair: (" + findPoints()[0] + ", " + findPoints()[1] + ") \nSecond Pair: (" + findPoints()[2] + ", " + findPoints()[3] + ") \nSlope: " + (Math.round(slope() * 100.0)/100.0) + "\nY-intercept: " + yIntercept() + "\nSlope Intercept Form: " + equation() + "\nDistance Between Points: " + distance(); // Add the actual values
        return toPrint;
    }


}
