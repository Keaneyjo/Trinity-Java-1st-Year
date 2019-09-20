import javax.swing.JOptionPane;
import java.util.Scanner;

/*
 * Write a program that asks to enter three numbers, then the average of those numbers, 
 * then finds the standard deviation of those three numbers.
 */
public class AveragethenStandardDeviation {

	public static void main(String[] args) {
		
		String firstInput=JOptionPane.showInputDialog ("Enter first number");
		Scanner inputScanner = new Scanner (firstInput);
		double first = inputScanner.nextDouble ();
		inputScanner.close();
		
		String secondInput=JOptionPane.showInputDialog ("Enter second number");
		inputScanner = new Scanner (secondInput);
		double second = inputScanner.nextDouble ();
		inputScanner.close();
		
		String thirdInput=JOptionPane.showInputDialog ("Enter third number");
		inputScanner = new Scanner (thirdInput);
		double third = inputScanner.nextDouble ();
		inputScanner.close();

		double average = (first + second + third)/3;
		JOptionPane.showMessageDialog(null, "Average is " + average);

		double difffirst = first - average;
		double diffsecond = second - average;
		double diffthird = third - average;

		double squarediff = (difffirst * difffirst) + (diffsecond * diffsecond) + (diffthird * diffthird);
		double squarediffdivided = squarediff / 3;
		double SD = Math.sqrt(squarediffdivided);

		JOptionPane.showMessageDialog(null, "Standard Deviation is " + SD);

	}

}
