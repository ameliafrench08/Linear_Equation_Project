Design Document

LinearEquation class

Instance Variables:
private int x1 - This variable represents the first x-coordinate
private int x2 - This variable represents the second x-coordinate
private int y1 - This variable represents the first y-coordinate
private int y2 - This variable represents the second y-coordinate

Constructor
	public LinearEquation(int x1, int x2, int y1, int y2)

Methods
	
public String toString()
This method will display all relevant information about this instance including:
X and Y coordinate information
Slope Intercept Form equation

public double distance()
This method will find the distance between (x1, y1) and (x2, y2) using the distance formula: d = sqrt((x2-x1)^2 + (y2-y1)^2). It will return the distance rounded to the nearest 100th.

public double slope()
This method will find the slope containing (x1, y1) and (x2, y2) by calculating (y2-y1)/(x2-x1). Returns slope rounded to the nearest 100th

public double yIntercept()
This method will find the y-intercept of the equation of the two points by plugging in the slope, and x1/y1 to find the y-intercept. Will return the y-intercept rounded to the nearest 100th.

public String equation()
This method will return y = mx + b with the m (slope) in fraction form. If:
The slope is 1
Slope won’t be shown
The slope is -1
The slope will be shown as just “-”
Y-intercept is 0
Won’t be shown

public double thirdValue()
This method will return a y-value that corresponds to the x-value inputted. It will run the x-value though y = mx + b to find y. It will return this in a coordinate point that can be printed.





EquationRunner.java

Step 1: Ask user to enter first coordinate point
Step 2: Ask user to enter second coordinate point
Step 3: Output the first pair, second pair, slope, y-intercept, distance, and equation
Step 4: Ask for a third x-value
Step 5: Output the y-value for the x-value

