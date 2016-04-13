package org.sei.tl.problemset;

import java.util.HashSet;
import java.util.Iterator;

public class DeDup {

	public int[] randomNumbers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19, 1,
			18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6,
			19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

	public static void main(String[] args) {

		DeDup deDup = new DeDup();

		System.out.println("Removing Duplicates using additional Array ");
		removeDuplicatesUsingAlogirithm(deDup.randomNumbers);
		System.out.println("\nRemoving Duplicates using Shifting");
		removeDuplicatesUsingShift(deDup.randomNumbers);
		System.out.println("\nRemoving Duplicates using Collections");
		removeDuplicatesUsingSet(deDup.randomNumbers);

	}

	public static int[] removeDuplicatesUsingAlogirithm(int[] randomNumbers) {
		int len = randomNumbers.length;

		int[] arr = new int[len];

		int z = 0;
		for (int j = 0; j < len; j++) {
			boolean flag = true;
			for (int i = 0; i <= z; i++) {
				if (arr[i] == randomNumbers[j]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				arr[z] = randomNumbers[j];
				z++;
			}
		}
		int resultList[] = new int[z];
		for (int i = 0; i < z; i++) {
			System.out.print(arr[i] + " ");
			resultList[i] = arr[i];
		}
		return resultList;
	}

	public static int[] removeDuplicatesUsingShift(int[] randomNumbers) {

		int end = randomNumbers.length;

		for (int i = 0; i < end; i++) {
			for (int j = i + 1; j < end; j++) {
				if (randomNumbers[i] == randomNumbers[j]) {
					int shiftLeft = j;
					for (int k = j + 1; k < end; k++, shiftLeft++) {
						randomNumbers[shiftLeft] = randomNumbers[k];
					}
					end--;
					j--;
				}
			}
		}

		int[] resultList = new int[end];
		for (int i = 0; i < end; i++) {
			resultList[i] = randomNumbers[i];
			System.out.print(resultList[i] + " ");
		}
		return resultList;
	}

	public static int[] removeDuplicatesUsingSet(int[] randomNumbers) {
		HashSet<Integer> set = new HashSet<>();
		final int len = randomNumbers.length;
		for (int i = 0; i < len; i++) {
			set.add(randomNumbers[i]);
		}
		int[] resultArray = new int[set.size() + 1];
		int i = 0;
		Iterator it = set.iterator();
		while (it.hasNext()) {
			resultArray[i] = (int) it.next();
			i = i + 1;
		}
		for (int j = 0; j < set.size(); j++) {
			System.out.print(resultArray[j] + " ");
		}
		return resultArray;
	}
}
