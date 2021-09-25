package com.gl.stocker.main;

import java.util.*;

import com.gl.stocker.beans.Company;
import com.gl.stocker.services.ShareService;

public class ShareDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Company> companyList = new ArrayList<Company>();
		int totCompany = 0;
		Scanner sc = new Scanner(System.in);
		double price;
		boolean riseFlag, sortFlag;

		sortFlag = false;

		ShareService sh = new ShareService();

		System.out.println("Enter the number of companies");
		totCompany = sc.nextInt();

		double[] arr = new double[totCompany];

		for (int i = 0; i < totCompany; i++) {
			int count = i + 1;
			System.out.println("Enter the current stock price of company " + count);
			price = sc.nextDouble();
			System.out.println("Whether company's stock price rose today compared to yesterday? ");
			riseFlag = sc.nextBoolean();
			companyList.add(new Company(price, riseFlag));
		}
		// moving only the shares to an array
		arr = sh.sharesArray(companyList, totCompany);

		while (true) {
			System.out.println("\nEnter the operation you want to perform- ");
			System.out.println("1. Display the companies stock prices in ascending order \n"
					+ "2. Display the companies stock prices in descending order \n"
					+ "3. Display the total no of companies for which stock prices rose today \n"
					+ "4. Display the total  no of companies for which stock prices declined today \n"
					+ "5. Search a specific stock price \n" + "6. Enter 0 to Exit \n");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				sh.mergeSort(arr, 0, totCompany - 1);

				System.out.print("The share price in Ascending order is -\n");
				for (int j = 0; j < totCompany; j++) {
					System.out.print(arr[j] + " ");
				}
				sortFlag = true;
				break;
			case 2:
				sh.mergeSortDesc(arr, 0, totCompany - 1);

				System.out.println("The share price in Descending order is -\n");
				for (int j = 0; j < totCompany; j++) {
					System.out.print(arr[j] + " ");
				}
				sortFlag = false;
				break;
			case 3:
				System.out.print("Total no of companies whose stock price rose today : ");
				System.out.println(sh.calcStockRise(companyList));
				break;
			case 4:
				System.out.print("Total no of companies whose stock price declined today : ");
				System.out.println(sh.calcStockDrop(companyList));
				break;
			case 5:
				if (!sortFlag) {
					sh.mergeSort(arr, 0, totCompany - 1);
				}
				System.out.println("Enter the key value ");
				double key = sc.nextDouble();
				int last = totCompany - 1;
				sh.searchValue(arr, 0, last, key);
				break;
			case 6:
			case 0:
				System.out.println("Successfully Logged Out");
				System.exit(0);
			default:
				System.out.println("Please enter a valid option");
				break;

			}

		}

	}

}
