package com.gl.stocker.services;

import java.util.*;

import com.gl.stocker.beans.Company;

public class ShareService {

	public double[] sharesArray(List<Company> companyList, int totCompany) {
		double[] arr = new double[totCompany];
		int i = 0;
		for (Company c : companyList) {
			arr[i] = c.getSharePrice();
			i++;
		}

		return arr;
	}

	// count stocks that rose today
	public int calcStockRise(List<Company> companyInfo) {
		int riseCount = 0;
		for (Company c : companyInfo) {
			if (c.isShareRise())
				riseCount++;
		}
		return riseCount;
	}

	// count stocks that drop today
	public int calcStockDrop(List<Company> companyInfo) {
		int dropCount = 0;
		for (Company c : companyInfo) {
			if (!c.isShareRise())
				dropCount++;
		}
		return dropCount;
	}

	// merge stock in ascending order
	public void mergeSort(double[] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);

			merge(arr, left, mid, right);
		}

	}

	// merge the two arrays in ascending order
	public void merge(double[] arr, int left, int mid, int right) {
		int len1 = (mid - left) + 1;
		int len2 = right - mid;

		double[] leftArr = new double[len1];
		double[] rightArr = new double[len2];

		for (int i = 0; i < len1; i++) {
			leftArr[i] = arr[left + i];
		}
		for (int j = 0; j < len2; j++) {
			rightArr[j] = arr[mid + 1 + j];
		}

		int i, j, k;
		i = 0;
		j = 0;
		k = left;
		while (i < len1 && j < len2) {
			if (leftArr[i] <= rightArr[j]) {
				arr[k] = leftArr[i];
				i++;
			} else {
				arr[k] = rightArr[j];
				j++;
			}
			k++;
		}
		while (i < len1) {
			arr[k] = leftArr[i];
			i++;
			k++;
		}
		while (j < len2) {
			arr[k] = rightArr[j];
			j++;
			k++;
		}
	}

	// merge stock in descending order
	public void mergeSortDesc(double[] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSortDesc(arr, left, mid);
			mergeSortDesc(arr, mid + 1, right);

			mergeDesc(arr, left, mid, right);
		}

	}

	// merge the two arrays in descending order
	public void mergeDesc(double[] arr, int left, int mid, int right) {
		int len1 = (mid - left) + 1;
		int len2 = right - mid;

		double[] leftArr = new double[len1];
		double[] rightArr = new double[len2];

		for (int i = 0; i < len1; i++) {
			leftArr[i] = arr[left + i];
		}
		for (int j = 0; j < len2; j++) {
			rightArr[j] = arr[mid + 1 + j];
		}

		int i, j, k;
		i = 0;
		j = 0;
		k = left;
		while (i < len1 && j < len2) {
			if (leftArr[i] > rightArr[j]) {
				arr[k] = leftArr[i];
				i++;
			} else {
				arr[k] = rightArr[j];
				j++;
			}
			k++;
		}
		while (i < len1) {
			arr[k] = leftArr[i];
			i++;
			k++;
		}
		while (j < len2) {
			arr[k] = rightArr[j];
			j++;
			k++;
		}
	}

//Searching key values
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
