/*****************************************************/
/*** Purpose: To read, display, sort an array by   ***/
/*** insertion, quick, custom new sort.            ***/
/***                                               ***/
/***     Initial Author: Jason Steggles 20/09/17   ***/
/***     Extended by: Olivija Guzelyte 22/10/17    ***/
/*****************************************************/

import java.io.*;
import java.text.*;
import java.util.*;

public class Sort {

	/** Array of integers to sort **/
	private int[] A;

	/** Size of the array **/
	private int size;

	/** Number of elements actually used in array **/
	private int usedSize;

	/** Global variables for counting sort comparisons **/
	public int compIS;
	/** Global comparison count for Insertion Sort **/
	public int compQS;
	/** Global comparison count for Quicksort **/
	public int compNewS;

	/** Global comparison count for new sort **/

	/*****************/
	/** Constructor **/
	/*****************/
	Sort(int max) {
		/** Initialize global sort count variables **/
		compIS = 0;
		compQS = 0;
		compNewS = 0;

		/** Initialize size variables **/
		usedSize = 0;
		size = max;

		/** Create Array of Integers **/
		A = new int[size];
	}

	/*********************************************/
	/*** Read a file of integers into an array ***/
	/*********************************************/
	public void readIn(String file) {
		try {
			/** Initialise loop variable **/
			usedSize = 0;

			/** Set up file for reading **/
			FileReader reader = new FileReader(file);
			@SuppressWarnings("resource")
			Scanner in = new Scanner(reader);

			/** Loop round reading in data while array not full **/
			while (in.hasNextInt() && (usedSize < size)) {
				A[usedSize] = in.nextInt();
				usedSize++;
			}

		} catch (IOException e) {
			System.out.println("Error processing file " + file);
			System.out.println(e.getMessage());
		}

	}

	/**********************/
	/*** Display array ***/
	/**********************/
	public void display(int line, String header) {
		/*** Integer Formatter - three digits ***/
		NumberFormat FI = NumberFormat.getInstance();
		FI.setMinimumIntegerDigits(3);

		/** Print header string **/
		System.out.print("\n" + header);

		/** Display array data **/
		for (int i = 0; i < usedSize; i++) {
			/** Check if new line is needed **/
			if (i % line == 0) {
				System.out.println();
			}

			/** Display an array element **/
			System.out.print(FI.format(A[i]) + " ");
		}
	}

	/*************************************/
	/*** Sort array by Insertion Sort ***/
	/*************************************/
	public void insertion() {

		for (int i = 1; i <= usedSize - 1; i++) {
			int key = A[i]; // Store next value to insert.
			int j = i; // Possible position of key to be inserted.
			while (j > 0 && key <= A[j - 1]) { // While key is smaller than previous value.
				A[j] = A[j - 1]; // Push space left.
				j -= 1; // Find the correct position for key insertion.
				compIS++; // Increment counter.
			}
			compIS++; // Increment counter.
			A[j] = key; // Put key into correct position.
		}
	}


	/*************************************/
	/*** Sort array by Quick Sort ********/
	/*************************************/
	Boolean stop = false;
	public void quick(int L, int R) { // Pass left, right array pointers and array.
		if (R > L) { // Stop if one value left.
			int p = partition(L, R); // Split array into two.				
			quick(L, p - 1); // Sort left half.
			quick(p + 1, R); // Sort right half.
		}

	}

	/*************************************/
	/*** Swap array elements *************/
	/*************************************/
	public final void swap(int pL, int pR) {

		int temp = A[pL]; // Temporary variable to store value in pointer left.
		A[pL] = A[pR]; // Replace pointer left variable with pointer right.
		A[pR] = temp; // Replace pointer right variable with temporary one.

	}

	/*************************************/
	/*** Partition for Quick Sort ********/
	/*************************************/
	private int partition(int L, int R) {

		int v = A[R]; // Select rightmost pivot.
		int pL = L, pR = R; // Initialize scanning pointers.
		while (pL < pR) { // Until scanning pointers cross.
			while (A[pL] < v) { // Move pL to left until bigger than pivot.
				pL++;
				compQS++; // Increment comparison counter.
			}
			compQS++; // Increment comparison counter.
			while (A[pR] >= v && pR > L) { // Move pR to right until smaller than pivot.
				pR--;
				compQS++; // Increment comparison counter.
			}
			compQS++; // Increment comparison counter.
			if (pL < pR) // Don't swap in last iteration.
				swap(pL, pR); // Swap values.
		}
		swap(pL, R); // Put pivot into correct position.
		return pL; // Return pivot position.

	}

	/*************************************/
	/*** New Sort ************************/
	/*************************************/	
	public void newsort() {
		int pos = 0; // Initialises starting position.
		while (pos < usedSize) { // If position index does not go over the array.
			int min = findMinFrom(pos); // Find the smallest value in array from position.
			for (int i = pos; i <= usedSize - 1; i++) {// Until the end of array.				
				if (A[i] == min) { // Find the position of smallest value.
					compNewS++; // Increment counter.
					swap(i, pos); // Swap smallest value with the value at current position.
					pos++; // Increment position by one.
				} // Keep searching for identical smallest value.
				else
					compNewS++; // Increment counter only if 'if' unsuccessful.
			}
		}
	}

	/*******************************************************************/
	/*** Finding smallest value in array after certain position ********/
	/*******************************************************************/	
	private int findMinFrom(int pos) { // Find smallest value in array from position.

		int min = A[pos]; // Initialise smallest value at index pos.
		for (int i = pos + 1; i <= usedSize - 1; i++) { // Look to the right from pos for the smallest value.
			if (A[i] < min) { // If value on right is smaller than the one at index pos.
				min = A[i]; // That value becomes the new smallest value.
				compNewS++; // Increment counter.
			}
			else
				compNewS++; // Increment counter only if 'if' unsuccessful.
		}
		return min; // Return smallest value from index pos.
	}
	
	/*******************************************************************/
	/*** Return used array size for quick sort testing *****************/
	/*******************************************************************/	
	public int returnUsedSize() {
		return usedSize;
	}
	
} /** End of Sort Class **/