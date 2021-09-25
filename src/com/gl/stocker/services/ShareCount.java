package com.gl.stocker.services;

import java.util.List;

import com.gl.stocker.beans.Company;

public class ShareCount {
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

}
