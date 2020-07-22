
/*************************************************/
/*** Updated test class for Sort class         ***/
/***                                           ***/
/*** Author: Olivija Guzelyte 22/10/2017       ***/
/*************************************************/
public class TestSort {

	public static void main(String[] args) {
		/*
		 * Insert all the test files into an array. Create an instance of class 'Sort'.
		 */
		String[] file = { "test1.txt", "test2.txt", "test3.txt", "test4.txt", "test5.txt" };
		Sort sortTest = new Sort(100);

		/** BEGIN INSERTION SORT TESTING **/

		System.out.println("----- Insertion sort testing -----");

		for (int i = 0; i <= file.length - 1; i++) { // From test file 1 to 5 do.
			sortTest.readIn(file[i]); // Read in the test file.
			sortTest.insertion(); // Invoke the insertion sort method.
			sortTest.display(10, "Input Array " + (i + 1) + ", File: " + file[i] + "."); // Display sorted array in console.
			System.out.println("\nInsertion sort comparison counter: " + sortTest.compIS + ", File: " + file[i] + ".");
			// Display comparison count in console.
			sortTest.compIS = 0; // Reset the counter.
		}

		/** BEGIN QUICK SORT TESTING **/

		System.out.println("\n----- Quick sort testing -----");

		for (int i = 0; i <= file.length - 2; i++) { // From test file 1 to 4 do.
			sortTest.readIn(file[i]); // Read in the test file.
			sortTest.quick(0, sortTest.returnUsedSize() - 1); // Invoke quick sort method.
			sortTest.display(10, "Input Array " + (i + 1) + ", File: " + file[i] + "."); // Display sorted array in console.
			System.out.println("\nQuicksort comparison counter: " + sortTest.compQS + ", File: " + file[i] + ".");
			// Display comparison count in console.
			sortTest.compQS = 0; // Reset the counter.

		}
		/** BEGIN NEW SORT TESTING **/

		System.out.println("\n----- New sort testing -----");

		for (int i = 2; i <= file.length - 1; i++) { // From test file 3 to 5 do.
			sortTest.readIn(file[i]); // Read in the test file.
			sortTest.newsort(); // Invoke new sort method.
			sortTest.display(10, "Input Array " + (i - 1) + ", File: " + file[i] + "."); // Display sorted array in console.
			System.out.println("\nNewsort sort comparison counter: " + sortTest.compNewS + ", File: " + file[i] + ".");
			// Display comparison count in console.
			sortTest.compNewS = 0; // Reset the counter.
		}
	}

} /** End of Test class **/