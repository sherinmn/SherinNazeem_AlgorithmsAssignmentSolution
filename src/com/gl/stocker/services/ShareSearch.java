package com.gl.stocker.services;

public class ShareSearch {
	// Searching key values
	public void searchValue(double[] arr, int first, int last, double key) {
		int mid = (first + last) / 2;
		while (first <= last) {
			if (arr[mid] < key) {
				first = mid + 1;
			} else if (arr[mid] == key) {
				System.out.println("Stock of value " + key + " is present   ");
				break;
			} else {
				last = mid - 1;
			}
			mid = (first + last) / 2;
		}
		if (first > last) {
			System.out.println("Stock not found");

		}
	}

}
