//Never have default package, always have a class under a package com.hcl.***
package com.hcl.myproject.calculator;

import java.util.InputMismatchException;
//Never have wildcard package names like java.util.* something like that
import java.util.Scanner;

public class Calculator_Old {

	public static void main(String args[]) {
		//Refactored the banner
		printSplashBanner();
		
		//Option1: operate(num1, num2, num1+num2), operate(num1, num2, num1*num2)
		//Option2: operate(num1, num2, );
		//operate(num1, num2, (num1, num2) -> dosomething);

		//try with resources
		try(Scanner myObj = new Scanner(System.in);) { // Create a Scanner object

			while (true) {
				//Created a BinaryOperation class and are getting multiple 
				//return values from a function
				BinaryOperation binaryOperation = getAllInputs(myObj);
	
				// Used Switch case and made the code more readable
				double result = 0;
				switch (binaryOperation.operation) {
				case '+':
					//add(binaryOperation.num1, binaryOperation.num2);
					//Dirtiest
					/*result = operate(binaryOperation.num1, binaryOperation.num2, 
							new AdditionMathOperation());*/
					result = operate(binaryOperation.num1, binaryOperation.num2, 
							(num1, num2) ->  num1+ num2);

					break;
				case '-':
					//substract(binaryOperation.num1, binaryOperation.num2);
					//Still dirty
					/*result = operate(binaryOperation.num1, binaryOperation.num2, 
							new MathOperation() {
								
								@Override
								public double operate(double num1, double num2) {
									return num1 - num2;
								}
							});*/
					result = operate(binaryOperation.num1, binaryOperation.num2, 
							(num1, num2) ->  num1 - num2);

					break;
				case '/':
					//divide(binaryOperation.num1, binaryOperation.num2);
					//Still not good
					/*result = operate(binaryOperation.num1, binaryOperation.num2, 
							(double num1, double num2) -> {
									return num1 / num2;
								}
							);*/
					result = operate(binaryOperation.num1, binaryOperation.num2, 
							(num1, num2) ->  num1/ num2);

					break;
				case '*':
					//multiply(binaryOperation.num1, binaryOperation.num2);
					//Still ok, it uses type inference
					/*result = operate(binaryOperation.num1, binaryOperation.num2, 
							(num1, num2) -> {
									return num1 * num2;
								}
							);*/
					result = operate(binaryOperation.num1, binaryOperation.num2, 
							(num1, num2) ->  num1* num2);

					break;
				case '^':
					//power(binaryOperation.num1, binaryOperation.num2);
					result = operate(binaryOperation.num1, binaryOperation.num2, 
							(num1, num2) ->  Math.pow(num1, num2));
					break;
				case '%':
					mod(binaryOperation.num1, binaryOperation.num2);
					break;
				default:
					invalidOperator();
					break;
				}
				System.out.println(binaryOperation.num1 + " " + binaryOperation.operation + " " + binaryOperation.num2 + " = " + result);

				//Footer with a boolean to exit
				if(footer(myObj)) {
					break;
				}
	
			}
		}
		//myObj.close();
	}

	private static BinaryOperation getAllInputs(Scanner myObj) {
		BinaryOperation binaryOperation = new BinaryOperation();
		System.out.print("\n _____________\n|             |\n|New Operation|\n|_____________|\n");
		System.out.print("\nEnter Number 1: ");
		double num1 = 0, num2 = 0;
		//try {
			num1 = myObj.nextDouble();
		
			System.out.print("\nEnter Number 2: ");
		
		
			num2 = myObj.nextDouble();

			System.out.print("\nChoose an Operation:  +, -, *, /, ^ , or % : ");
			char operator = myObj.next().charAt(0);
	
			System.out.print("\nResult: ");
			binaryOperation.operation = operator;
			binaryOperation.num1 = num1;
			binaryOperation.num2 = num2;
		//} catch(InputMismatchException e) {
		//	System.out.println("Inputs invalid, continuing");
		//}
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
	
	private static double operate(double num1, double num2, MathOperation opFn) {
		
		/*double result = num1 % num2;
		System.out.println(num1 + " % " + num2 + " = " + result);*/
		return opFn.operate(num1, num2);
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
		try {
			double result = num1 / num2;
			int x = 1/0;
			System.out.println(num1 + " / " + num2 + " = " + result);
		} catch(ArithmeticException a) {
			System.out.println("**Divide by 0 is not allowed");
		}
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

@FunctionalInterface
interface MathOperation {
	double operate(double num1, double num2);
	//double operateWithArgument(double num);
}

class AdditionMathOperation implements MathOperation {

	@Override
	public double operate(double n1, double n2) {
		// TODO Auto-generated method stub
		return n1+n2;
	}
}
