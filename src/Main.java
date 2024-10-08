
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);


        System.out.print("Enter point 1, (x1,y1): ");
        String point1 = s.nextLine();

        System.out.println();

        System.out.print("Enter point 2, (x2,y2): ");
        String point2 = s.nextLine();

        LinearEquation line1 = new LinearEquation(point1, point2);

        System.out.println(line1.toString());

        System.out.println();

        System.out.print("Enter x3: ");
        String x3String = s.nextLine();
        double x3 = Double.parseDouble(x3String);

        System.out.println(line1.thirdValue(x3));


    }
}
