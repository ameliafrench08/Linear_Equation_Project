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
    public double distance(){
        double distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        distance = Math.round(distance * 100.0) / 100.0;
        //ROUND IT
        return distance;
    }



    /** Finds the slope of the two points and rounds it to the nearest 100th decimal place*/
    public double slope(){
        double slope = (double) (y2 - y1) /(x2-x1);
        slope = Math.round(slope * 100.0) / 100.0;
        return slope;
    }


    /** Finds the slope but makes it into a string. If the denominator is negative, it takes away the "-" and puts it in front of the fraction. If both the numerator and denominator are negative, it makes the fraction positive.*/
    public String slopeString(){
        String slopeString;
        String rise = Integer.toString(y2 - y1);
        String run = Integer.toString(x2 - x1);
        if (slope() == Math.round(slope())){
            slopeString = Double.toString(slope());
        }
        else {
            if (run.charAt(0) == '-'){
                if (rise.charAt(0) == '-'){
                    run = run.substring(1, run.length());
                    rise = rise.substring(1, rise.length());
                }
                else {
                    rise = "-" + rise;
                    run = run.substring(1, run.length());
                }
            }
            slopeString = rise + "/" + run;
        }

        return slopeString;
    }


    /** Finds the y-intercept of the equation. */
    public double yIntercept(){
        double yIntercept = y1 - (slope() * x1);
        yIntercept = Math.round(yIntercept * 100.0) / 100.0;
        return yIntercept;
    }

    public String equation(){
        String equation;
        if (slope() == 1){
            if (yIntercept() == 0) {
                equation = "y = x";
            }
            else{
                if (yIntercept() < 0){
                    equation = "y = x - " + yIntercept();
                }
                else {
                    equation = "y = x + " + yIntercept();
                }
            }
        }
        else if (slope() == -1.0) {
            if (yIntercept() == 0){
                equation = "y = -x";
            }
            else {
                if (yIntercept() < 0){
                    equation = "y = -x - " + yIntercept();
                }
                else {
                    equation = "y = -x + " + yIntercept();
                }
            }
        }
        else {
            if (yIntercept() == 0){
                equation = "y = " + slopeString() + "x";
            }
            else {
                if (yIntercept() < 0){
                    double yInt = yIntercept();
                    String yIntString = Double.toString(yInt);
                    yIntString = yIntString.substring(1, yIntString.length());
                    equation = "y = " + slopeString() + "x - " + yIntString;
                }
                else {
                    equation = "y = " + slopeString() + "x + " + yIntercept();
                }
            }
        }


        return equation;
    }

    public String thirdValue(double x3){
        double y3 = (slope() * x3) + yIntercept();
        y3 = Math.round(y3 * 100.0) / 100.0;
        String thirdPrint = "Third Coordinate Pair: (" + (Math.round(x3 * 100.0) / 100.0) + ", " + y3 + ")";
        return thirdPrint;

    }

    public String toString(){
        String toPrint = "First Pair: (" + x1 + ", " + y1 + ") \nSecond Pair: (" + x2 + ", " + y2 + ") \nSlope: " + slopeString() + "\nY-intercept: " + yIntercept() + "\nSlope Intercept Form: " + equation() + "\nDistance Between Points: " + distance(); // Add the actual values
        return toPrint;
    }


}
