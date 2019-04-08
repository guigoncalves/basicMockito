package com.in28minutes.unitTestsWithMockito.business;

import com.in28minutes.unitTestsWithMockito.service.SomeDataService;

public class SomeBusinessImpl {
	
	private SomeDataService someDataService;
	
	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}
	
	public int calculateSum(int[] data) {
		int sum = 0;
		for (int i : data) {
			sum += i;
		}
		return sum;
	}
	
	public int calculateSumFromDataService() {
		int[] data = someDataService.retrieveData();
		int sum = 0;
		for (int i : data) {
			sum += i;
		}
		return sum;
	}
}
