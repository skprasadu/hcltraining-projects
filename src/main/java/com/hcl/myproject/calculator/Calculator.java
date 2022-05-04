package com.hcl.myproject.calculator;

import java.util.Scanner;

/*
 * Goal of this program is to act as a calculator, and take in user inputs for
 * any 2 number problem.
 * Needs to be able to use + - / * and to the power of (^).
 */

public class Calculator {
	
    public static void main(String[] args) {

    	boolean continueCalculation = true; // changable var for our while loop.
        Scanner input = new Scanner(System.in); // set up scanner
        
        banner();
        
        while (continueCalculation) { 
        	// while true, until we declare this as false in line 48 loop.
            // the following sysouts and scanners are assigning the numbers passed to 'uX'
            // and 'uY' and the operator as 'uOp'
        	InputValuesHolder ivh = new InputValuesHolder();
        	
            getInput(input, ivh);
            
            //switch case to go through the different operators. Default case for if it isn't any of those operators.
            
            switch (ivh.operator) {
                case "+": //adds x and y then breaks
                	//**********In Java 8 this is BAD WAY****************
                	operate(ivh, new AddOperation());
                	//operate(ivh, (x, y) -> x+y);
                	//add(ivh);
                    break;
                case "-": //subtracts x from y then breaks
                	//**********In Java 8 this is SLIGHTLY BETTER WAY, but still bad 
                	//Anoynamous inner type
                	//****************
                	operate(ivh, new Operation() {
						@Override
						public double operate(double x, double y) {
							return x-y;
						}
					});
                	//substract(ivh);
                    break;
                case "*": //multiplies x and y then breaks
                	//**********In Java 8 this is SLIGHTLY BETTER WAY, better than previoud 
                	//but still bad ****************
                	// First glipse of lambda
                	operate(ivh, (double x, double y) -> {
							return x*y;
						}
					);
                	//multiply(ivh);
                    break;
                case "/": //divides x and y then breaks
                	//**********In Java 8 this is SLIGHTLY BETTER WAY, better than previoud 
                	//but still bad ****************
                	// All functional programming paradigm uses Type inference 
                	operate(ivh, (x, y) -> {
							// TODO Auto-generated method stub
							return x/y;
						}
					);
                	//divide(ivh);
                    break;
                case "^": //calls my powerMe function and breaks
                	operate(ivh, (x, y) -> powerMe( x,y));
                	//power(ivh);
                    break;
                default:
                	defaultMessage();
                	break;
            }
            /*
            following sysout checks if the user wants to continue, if so then the cont variable will continue to be true, otherwise it sets
            the cont var will be set to false and we close the scanner.
            */
            continueCalculation = checkForContinuing(input);
        }
        //thanks the user for using the calculator and then ends the main method.
        exitMessage();
    }

    private static void operate(InputValuesHolder ivh, Operation operation) {
		System.out.printf("\n%s %s %s equals: %s.\n", ivh.x, ivh.operator, ivh.y, 
				operation.operate(ivh.x,ivh.y));
    }
    
	private static void exitMessage() {
		System.out.println("\nThank you for using my calculator.");
	}

    /*
     * following sysout checks if the user wants to continue, if so then the cont 
     * variable will continue to be true, otherwise it sets
     * the cont var will be set to false and we close the scanner.
    */
	private static boolean checkForContinuing(Scanner uInput) {
		boolean cont;
		System.out.println("\nDo you want to continue? (Y/N)");
		String contCheck = uInput.next();
		if (contCheck.equalsIgnoreCase("Y")) {
		    cont = true;
		} else if( contCheck.equalsIgnoreCase("N")) {
		    cont = false;
		    uInput.close();
		}
		else{
		    System.out.println("You didn't put 'Y' or 'N', so I'm going to assume you're done with the calculator...");
		    cont = false;
		    uInput.close();
		}
		return cont;
	}

	private static void defaultMessage() {
		System.out.println("You didn't give me a valid operator! I'm not gonna calculate for you this time!");
	}
    
	private static void add(InputValuesHolder ivh) {
		System.out.printf("\n%s %s %s equals: %s.\n", ivh.x, ivh.operator, ivh.y, (ivh.x+ivh.y));
	}
	
	private static void substract(InputValuesHolder ivh) {
		System.out.printf("\n%s %s %s equals: %s.\n", ivh.x, ivh.operator, ivh.y, (ivh.x-ivh.y));
	}

	private static void multiply(InputValuesHolder ivh) {
		System.out.printf("\n%s %s %s equals: %s.\n", ivh.x, ivh.operator, ivh.y, (ivh.x*ivh.y));
	}

	private static void divide(InputValuesHolder ivh) {
		System.out.printf("\n%s %s %s equals: %s.\n", ivh.x, ivh.operator, ivh.y, (ivh.x/ivh.y));
	}

	private static void power(InputValuesHolder ivh) {
		System.out.printf("\n%s %s %s equals: %s.\n", ivh.x, ivh.operator, ivh.y, powerMe(ivh.x,ivh.y));
	}

	
	private static void getInput(Scanner uInput, InputValuesHolder ivh) {
		System.out.print("\nPlease enter your first number: ");
		ivh.x = uInput.nextDouble();
		System.out.print("\nPlease enter your second number: ");
		ivh.y = uInput.nextDouble();
		
		System.out.print("\nPlease enter the operation! '+', '-', '*', '/', '^': ");
		ivh.operator = uInput.next();
	}
//////////////////////////////////////////////////////////////////METHODS//////////////////////////////////////////////////////////////////
    /*
    Made a method for power of requests, so that I can get it to the second decimal place.
    */

	private static void banner() {
		System.out.print("Hello! Welcome to my calculator! \n");
	}

    public static double powerMe(double x, double y) {
        double result = Math.pow(x, y);
        result = Math.round(result * 100);
        result = result/100;
        return result;
    }
}

class InputValuesHolder {
	double x;
	double y;
	String operator;
}

@FunctionalInterface
interface Operation {
	double operate(double x, double y);
}

class AddOperation implements Operation {

	@Override
	public double operate(double x, double y) {
		// TODO Auto-generated method stub
		return x+y;
	}
}