import java.util.Objects;

public class LinearEquation {
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public LinearEquation(int x1, int x2, int y1, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    /** Finds the distance between (x1, y1) and (x2, y2) in decimal form using the distance formula. Round to the nearest 1/100*/
    public String distance(){
        double distanceDouble = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        distanceDouble = Math.round(distanceDouble * 100.0) / 100.0;
        String distance = Double.toString(distanceDouble);
        if (distance.substring(distance.length() - 2).equals(".0")){
            distance += "0";
        }
        return distance;
    }



    /** Finds the slope of the two points and rounds it to the nearest 100th decimal place*/
    public double slope(){
        double slope = (double) (y2 - y1) /(x2-x1);
        return slope;
    }


    /** Finds the slope but makes it into a string. If the denominator is negative, it takes away the "-" and puts it in front of the fraction. If both the numerator and denominator are negative, it makes the fraction positive.*/
    public String slopeString(){
        String slopeString;
        String rise = Integer.toString(y2 - y1);
        String run = Integer.toString(x2 - x1);
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
        double yInterceptDouble = y1 - (slope() * x1);
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
        double y3 = (slope() * x3) + yIntDouble;
        y3 = Math.round(y3 * 100.0) / 100.0;
        String thirdPrint = "Third Coordinate Pair: (" + (Math.round(x3 * 100.0) / 100.0) + ", " + y3 + ")";
        return thirdPrint;

    }


    /** Returns a statement with all the information (except for thirdvalue) to be printed.*/
    public String toString(){
        String toPrint = "First Pair: (" + x1 + ", " + y1 + ") \nSecond Pair: (" + x2 + ", " + y2 + ") \nSlope: " + slopeString() + "\nY-intercept: " + yIntercept() + "\nSlope Intercept Form: " + equation() + "\nDistance Between Points: " + distance(); // Add the actual values
        return toPrint;
    }


}
