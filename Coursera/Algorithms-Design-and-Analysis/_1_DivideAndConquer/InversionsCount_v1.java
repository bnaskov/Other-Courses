package _1_DivideAndConquer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InversionsCount_v1 {
	private static final String FILE_DIR = "src\\_1_DivideAndConquer\\";
	private static final String FILE_NAME = "integers.txt";

	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 5, 2, 4, 6 };
		int[] arr2 = { 1, 5, 3, 2, 4 };
		int[] arr3 = { 4, 80, 70, 23, 9, 60, 68, 27, 66, 78, 12, 40, 52, 53,
				44, 8, 49, 28, 18, 46, 21, 39, 51, 7, 87, 99, 69, 62, 84, 6,
				79, 67, 14, 98, 83, 0, 96, 5, 82, 10, 26, 48, 3, 2, 15, 92, 11,
				55, 63, 97, 43, 45, 81, 42, 95, 20, 25, 74, 24, 72, 91, 35, 86,
				19, 75, 58, 71, 47, 76, 59, 64, 93, 17, 50, 56, 94, 90, 89, 32,
				37, 34, 65, 1, 73, 41, 36, 57, 77, 30, 22, 13, 29, 38, 16, 88,
				61, 31, 85, 33, 54 };

		File inputFile = new File(FILE_DIR + FILE_NAME);
		long startTime = System.currentTimeMillis();

		try {
			System.out.println("Total number of inversions: "
					+ inversionsCount(convertFileToArray(inputFile)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		final long endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime));
	}

	private static ArrayList<Integer> convertToList(int[] arr) {
		ArrayList<Integer> output = new ArrayList();

		for (int i = 0; i < arr.length; i++) {
			output.add(arr[i]);
		}

		return output;
	}

	private static ArrayList<Integer> convertFileToArray(File inputFile)
			throws FileNotFoundException {
		ArrayList<Integer> outputList = new ArrayList(100000);
		int num = 0;

		try (Scanner cs = new Scanner(new FileInputStream(inputFile))) {
			while (cs.hasNextLine()) {
				num = Integer.parseInt(cs.nextLine());
				outputList.add(num);
			}
		}

		return outputList;
	}

	private static long inversionsCount(ArrayList<Integer> arr) {
		long inversions = 0;

		for (int i = 0; i < arr.size() - 1; i++) {
			for (int j = i + 1; j < arr.size(); j++) {
				if (arr.get(j) < arr.get(i)) {
					int temp = arr.get(i);
					arr.set(i, arr.get(j));
					arr.set(j, temp);
					inversions++;
				}
			}
		}

		return inversions;
	}
}
