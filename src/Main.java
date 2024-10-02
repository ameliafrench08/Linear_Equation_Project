import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter x1: ");
        String x1String = s.nextLine();
        int x1 = Integer.parseInt(x1String);

        System.out.println();

        System.out.print("Enter x2: ");
        String x2String = s.nextLine();
        int x2 = Integer.parseInt(x2String);

        System.out.println();

        System.out.print("Enter y1: ");
        String y1String = s.nextLine();
        int y1 = Integer.parseInt(y1String);

        System.out.println();

        System.out.print("Enter y2: ");
        String y2String = s.nextLine();
        int y2 = Integer.parseInt(y2String);

        System.out.println();

        LinearEquation line1 = new LinearEquation(x1, x2, y1, y2);

        System.out.println(line1.toString());

        System.out.println();

        System.out.print("Enter x3: ");
        String x3String = s.nextLine();
        double x3 = Double.parseDouble(x3String);

        System.out.println(line1.thirdValue(x3));
    }
}
