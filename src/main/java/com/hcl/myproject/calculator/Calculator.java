//Never have default package, always have a class under a package com.hcl.***
package com.hcl.myproject.calculator;

//Never have wildcard package names like java.util.* something like that
import java.util.Scanner;

public class Calculator {

	public static void main(String args[]) {
		//Refactored the banner
		printSplashBanner();

		Scanner myObj = new Scanner(System.in); // Create a Scanner object

		while (true) {
			//Created a BinaryOperation class and are getting multiple 
			//return values from a function
			BinaryOperation binaryOperation = getAllInputs(myObj);

			// Used Switch case and made the code more readable
			switch (binaryOperation.operation) {
			case '*':
				multiply(binaryOperation.num1, binaryOperation.num2);
				break;
			case '+':
				add(binaryOperation.num1, binaryOperation.num2);
				break;
			case '-':
				substract(binaryOperation.num1, binaryOperation.num2);
				break;
			case '/':
				divide(binaryOperation.num1, binaryOperation.num2);
				break;
			case '^':
				power(binaryOperation.num1, binaryOperation.num2);
				break;
			case '%':
				mod(binaryOperation.num1, binaryOperation.num2);
				break;
			default:
				invalidOperator();
				break;
			}

			//Footer with a boolean to exit
			if(footer(myObj)) {
				break;
			}

		}
	}

	private static BinaryOperation getAllInputs(Scanner myObj) {
		System.out.print("\n _____________\n|             |\n|New Operation|\n|_____________|\n");
		System.out.print("\nEnter Number 1: ");
		double num1 = myObj.nextDouble();

		System.out.print("\nEnter Number 2: ");
		double num2 = myObj.nextDouble();

		System.out.print("\nChoose an Operation:  +, -, *, /, ^ , or % : ");
		char operator = myObj.next().charAt(0);

		System.out.print("\nResult: ");
		BinaryOperation binaryOperation = new BinaryOperation();
		binaryOperation.operation = operator;
		binaryOperation.num1 = num1;
		binaryOperation.num2 = num2;
		return binaryOperation;
	}

	private static void invalidOperator() {
		System.out.println("Invalid Operator!");
	}

	private static boolean footer(Scanner myObj) {
		System.out.print("\nWould you like to continue? (Y/N): ");
		char doneKey = myObj.next().charAt(0);

		if (doneKey == 'N') {
			System.out.println(" ____________________________________");
			System.out.println("|                                    | ");
			System.out.println("|Thank you for using Java Calculator!|");
			System.out.println("|____________________________________| ");

			return true;
		}
		return false;
	}

	private static void mod(double num1, double num2) {
		double result = num1 % num2;
		System.out.println(num1 + " % " + num2 + " = " + result);
	}

	private static void power(double num1, double num2) {
		double result = Math.pow(num1, num2);
		System.out.println(num1 + " ^ " + num2 + " = " + result);
	}

	private static void divide(double num1, double num2) {
		double result = num1 / num2;
		System.out.println(num1 + " / " + num2 + " = " + result);
	}

	private static void substract(double num1, double num2) {
		double result = num1 - num2;
		System.out.println(num1 + " - " + num2 + " = " + result);
	}

	private static void add(double num1, double num2) {
		double result = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + result);
	}

	private static void multiply(double num1, double num2) {
		double result = num1 * num2;
		System.out.println(num1 + " * " + num2 + " = " + result);
	}

	private static void printSplashBanner() {
		System.out.println(" _____________________________ ");
		System.out.println("|                             | ");
		System.out.println("| Welcome to Java Calculator! |");
		System.out.println("|_____________________________|");
	}

}

class BinaryOperation {
	char operation;
	double num1;
	double num2;
}
