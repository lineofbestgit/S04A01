import java.io.*;
import java.util.ArrayList;
// -------------------------------------------------------------------------

/**
 * This class contains static methods that implementing sorting of an array of
 * numbers using different sort algorithms.
 *
 * @author Saul O'Driscoll
 * @version HT 2019
 */

class SortComparison {

	/**
	 * Sorts an array of doubles using InsertionSort. This method is static, thus it
	 * can be called as SortComparison.sort(a)
	 * 
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order.
	 *
	 */
	static double[] insertionSort(double a[]) {

		double temp;

		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j] < a[j - 1]) {
					temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
				}
			}
		}
		return a;
	}

	/**
	 * Sorts an array of doubles using Quick Sort. This method is static, thus it
	 * can be called as SortComparison.sort(a)
	 * 
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	static double[] quickSort(double a[]) {
		quickSortR(a, 0, a.length - 1);
		return a;
	}// end quicksort

	private static void quickSortR(double arr[], int begin, int end) {
		if (begin < end) {
			int partitionIndex = partition(arr, begin, end);

			quickSortR(arr, begin, partitionIndex - 1);
			quickSortR(arr, partitionIndex + 1, end);
		}
	}

	private static int partition(double arr[], int begin, int end) {
		double pivot = arr[end];
		int i = (begin - 1);

		for (int j = begin; j < end; j++) {
			if (arr[j] <= pivot) {
				i++;

				double swapTemp = arr[i];
				arr[i] = arr[j];
				arr[j] = swapTemp;
			}
		}

		double swapTemp = arr[i + 1];
		arr[i + 1] = arr[end];
		arr[end] = swapTemp;

		return i + 1;
	}

	/**
	 * Sorts an array of doubles using Merge Sort. This method is static, thus it
	 * can be called as SortComparison.sort(a)
	 * 
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	/**
	 * Sorts an array of doubles using iterative implementation of Merge Sort. This
	 * method is static, thus it can be called as SortComparison.sort(a)
	 *
	 * @param a: An unsorted array of doubles.
	 * @return after the method returns, the array must be in ascending sorted
	 *         order.
	 */

	static double[] mergeSortIterative(double a[]) {
		int length = a.length;
		double[] aux = new double[length];
		for (int i = 1; i < length; i = i + i) {
			for (int low = 0; low < length - i; low += i + i) {
				merge(a, aux, low, low + i - 1, Math.min(low + i + i - 1, length - 1));
			}
		}
		return a;

	}

	/**
	 * Sorts an array of doubles using recursive implementation of Merge Sort. This
	 * method is static, thus it can be called as SortComparison.sort(a)
	 *
	 * @param a: An unsorted array of doubles.
	 * @return after the method returns, the array must be in ascending sorted
	 *         order.
	 */
	static double[] mergeSortRecursive(double a[]) {
		double[] aux = new double[a.length];
		sort(a, aux, 0, a.length - 1);
		return a;

	}

	private static void sort(double[] a, double[] aux, int low, int high) {
		if (high <= low) {
			return;
		}
		int mid = low + (high - low) / 2;
		sort(a, aux, low, mid);
		sort(a, aux, mid + 1, high);
		merge(a, aux, low, mid, high);
	}

	private static void merge(double[] a, double[] aux, int low, int mid, int high) {
		// copy
		for (int k = low; k <= high; k++) {
			aux[k] = a[k];
		}

		// merge
		int i = low, j = mid + 1;
		for (int k = low; k <= high; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > high)
				a[k] = aux[i++];
			else if (aux[j] < aux[i])
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}
	}
	// end mergeSortRecursive

	/**
	 * Sorts an array of doubles using Selection Sort. This method is static, thus
	 * it can be called as SortComparison.sort(a)
	 * 
	 * @param a: An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	static double[] selectionSort(double a[]) {

		int n = a.length;

		for (int i = 0; i < n - 1; i++) {

			int min_index = i;
			for (int j = i + 1; j < n; j++) {
				if (a[j] < a[min_index]) {
					min_index = j;
				}
			}

			double temp = a[min_index];
			a[min_index] = a[i];
			a[i] = temp;
		}

		return a;

	}// end selectionsort

	public static void main(String[] args) {
		String[] files = new String[] {
				"C:/Users/Saul O'Driscoll/Documents/001_programming/WoRkDeSk/sortingAlgs/src/assignment input data files/numbers10.txt",
				"C:/Users/Saul O'Driscoll/Documents/001_programming/WoRkDeSk/sortingAlgs/src/assignment input data files/numbers100.txt",
				"C:/Users/Saul O'Driscoll/Documents/001_programming/WoRkDeSk/sortingAlgs/src/assignment input data files/numbers1000.txt",
				"C:/Users/Saul O'Driscoll/Documents/001_programming/WoRkDeSk/sortingAlgs/src/assignment input data files/numbers1000Duplicates.txt",
				"C:/Users/Saul O'Driscoll/Documents/001_programming/WoRkDeSk/sortingAlgs/src/assignment input data files/numbers10sorted.txt",
				"C:/Users/Saul O'Driscoll/Documents/001_programming/WoRkDeSk/sortingAlgs/src/assignment input data files/numbersNearlyOrdered1000.txt",
				"C:/Users/Saul O'Driscoll/Documents/001_programming/WoRkDeSk/sortingAlgs/src/assignment input data files/numbersReverse1000.txt" };

		for (String file : files) {
			ArrayList<Double> doubles = new ArrayList<>();
			try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				String line = br.readLine();
				while (line != null) {
					line = br.readLine();
					if (line != null)
						doubles.add(Double.parseDouble(line));
				}

				double[] a = resetArray(doubles);
				double startTime = System.nanoTime();
				selectionSort(a);
				double endTime = System.nanoTime();
				double duration = (endTime - startTime) / 1000000;
				System.out.println("Selection Sort time for " + file.split("/")[file.split("/").length - 1] + ": "
						+ duration + "ms");

				a = resetArray(doubles);
				startTime = System.nanoTime();
				insertionSort(a);
				endTime = System.nanoTime();
				duration = (endTime - startTime) / 1000000;
				System.out.println("Insertion Sort time for " + file.split("/")[file.split("/").length - 1] + ": "
						+ duration + "ms");

				a = resetArray(doubles);
				startTime = System.nanoTime();
				mergeSortIterative(a);
				endTime = System.nanoTime();
				duration = (endTime - startTime) / 1000000;
				System.out.println("MergeSort Iterative time for " + file.split("/")[file.split("/").length - 1]
						+ " was " + duration + "ms");

				a = resetArray(doubles);
				startTime = System.nanoTime();
				mergeSortRecursive(a);
				endTime = System.nanoTime();
				duration = (endTime - startTime) / 1000000;
				System.out.println("MergeSort Recursive time for " + file.split("/")[file.split("/").length - 1] + ": "
						+ duration + "ms");

				a = resetArray(doubles);
				startTime = System.nanoTime();
				quickSort(a);
				endTime = System.nanoTime();
				duration = (endTime - startTime) / 1000000;
				System.out.println(
						"QuickSort time for " + file.split("/")[file.split("/").length - 1] + ": " + duration + "ms");

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private static double[] resetArray(ArrayList<Double> doubles) {
		double[] a;
		a = new double[doubles.size()];
		for (int j = 0; j < a.length; j++) {
			a[j] = doubles.get(j);
		}
		return a;
	}
}
