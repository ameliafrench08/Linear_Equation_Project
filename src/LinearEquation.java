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
        //ROUND IT
        return distance;
    }
}
