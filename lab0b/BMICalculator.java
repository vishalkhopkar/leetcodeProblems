//Write your Andrew-id and name here

package lab0b;

import java.util.Scanner;

/**BMICalculator takes two inputs - weight in pounds and height in inches - from the user
 * and calculates BMI according to the formula: BMI = (weight / (height * height)) * 703.
 * It gives output in two forms: float and integer. 
 * It also tells the category to which the BMI belongs: underweight, normal, overweight, or obese
 * @author ndwivedi
 */

public class BMICalculator {

	/**calculateBMI() returns calculated BMI as a float as per the formula given above */
	//DO NOT CHANGE THE METHOD SIGNATURE
	float calculateBMI(float weight, float height) {
		return weight*703 / (height*height);
	}

	/**calculateRoundedBMI() returns the rounded value of BMI as an int. 
	 * It is calculated as per the formula given above. */
	//DO NOT CHANGE THE METHOD SIGNATURE
	int calculateRoundedBMI(float weight, float height) {
		return Math.round(calculateBMI(weight, height));
	}

	/**findBMIStatus() takes bmi value as a parameter and returns a String value that can be
	 * Underweight, Normal, Overweight, or Obese. 
	 * Note that Java's string comparison is case-sensitive by default, unless otherwise specified. 
	 * The test-case for this method also compares the output in a case-sensitive manner. */
	//DO NOT CHANGE THE METHOD SIGNATURE
	String findBMIStatus(float bmi) {
		if(bmi <= 18.5) return "Underweight";
		if(bmi < 25) return "Normal";
		if(bmi < 30) return "Overweight";
		return "Obese";

	}

	//DO NOT CHANGE THIS METHOD
	public static void main(String[] args) {
		BMICalculator bmiCalc = new BMICalculator();
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to BMI Calculator!");
		System.out.println("Please enter your weight in pounds");
		float weight = input.nextFloat();
		System.out.println("Please enter your height in inches");
		float height = input.nextFloat();
		float bmi = bmiCalc.calculateBMI(weight, height);
		System.out.println("Your BMI is: " + bmi );
		System.out.println("Your rounded BMI is: " + bmiCalc.calculateRoundedBMI(weight, height));
		System.out.println("Your weight status is: " + bmiCalc.findBMIStatus(bmi));
		input.close();
	}
}
