package Assignment9;

import java.util.*;
import java.io.*;
public class Assignment9{
	public static void main(String [] args) throws IOException{
		Scanner scan = new Scanner(new File("/Users/sebiseb/eclipse-workspace/Assignments/src/Assignment9/Assignment9in.txt"));
		PrintWriter output = new PrintWriter("Assignment9out.txt");
		
		final int Max = 50;
		int [] idNumbers = new int[Max];
		double [] donations = new double[Max];
		
		int donorCount = countDonors(idNumbers, donations, idNumbers.length, scan);// The count/size of the array lists
		
		output.println("Unsorted list of ID#s and donations:");
		printArray(idNumbers, donations, donorCount, output);// Printing the original parallel array
		
		//Printing out the Bubble sorted list
		output.println("---------------------------\n");
		output.println("Sorted by donations amount:(Bubble sort)");
		bubSort(idNumbers, donations, donorCount);// Sorts the donations using a Bubble sort
		printArray(idNumbers, donations, donorCount, output);// Prints Bubble sorted array
		
		//Printing out the Selection sorted list
		output.println("---------------------------\n");
		output.println("Sorted by ID number:(Selection Sort)");
		selectSort(idNumbers, donations, donorCount);// Sorts the donations using a Selection sort
		printArray(idNumbers, donations, donorCount, output);// Prints Selection sorted array
		
		output.close();// closes the PrintWriter
	}// End of the main
	public static int countDonors(int [] idNumbers, double [] donations, int size, Scanner scan) {
		
		int cnt = 0;
		while (scan.hasNext()) {
			idNumbers[cnt] = scan.nextInt();
			donations[cnt] = scan.nextDouble();
			cnt++;
		}// End of the while loop
		return cnt;
	}// End of the countDonors method
	
	public static void printArray(int [] idNumbers, double [] donations, int size, PrintWriter output) {
		output.println("ID#\t\tDonation amount");
		output.println("---------------------------");
		for (int i = 0; i < size; i++) {
			output.println(idNumbers[i] + "\t\t " + donations[i]);
		}// End of the for loop
	}// End of the printArray method
	
	public static void selectSort(int [] idNumbers, double [] donations, int size) {
		int temp;
		double temp2;
		int lowestIndex;
		
		for (int i = 0; i < size - 1; i++) {
			lowestIndex = i;
			for (int j = i + 1; j < size; j++) {
				if (idNumbers[lowestIndex] > idNumbers[j]) {
					lowestIndex = j;
				}// End of the if statement	
			}// End of the bottom for loop	
						temp = idNumbers[i];
						idNumbers[i] = idNumbers[lowestIndex];
						idNumbers[lowestIndex] = temp;
						
						temp2 = donations[i];
						donations[i] = donations[lowestIndex];
						donations[lowestIndex] = temp2;
						
		}// End of the top for loop
	}// End of the selectSort method
	
	public static void bubSort(int [] idNumbers, double [] donations, int size) {
		double temp; 
		int temp2;
		boolean swapped;
		
		do {
			swapped = false;
			
			for (int i = 0; i < size - 1; i++) {
				if (donations[i] > donations[i + 1]) {
					
					temp = donations[i];
					donations[i] = donations[i + 1];
					donations[i + 1] = temp;
					
					temp2 = idNumbers[i];
					idNumbers[i] = idNumbers[i + 1];
					idNumbers[i + 1] = temp2;
					swapped = true;
					
				}// End of the if statement
			}// End of the for loop
		}while(swapped);
		
	}// End of the bubSort method
}// End of the class