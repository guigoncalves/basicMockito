package com.in28minutes.unitTestsWithMockito.business;

import static org.junit.Assert.*;

import org.junit.Test;

import com.in28minutes.unitTestsWithMockito.service.SomeDataService;

class SomeDataServiceStub implements SomeDataService {

	@Override
	public int[] retrieveData() {
		return new int[] {1, 2 ,3};
	}
	
}

public class SomeBusinessImplStubTest {

	@Test
	public void calculateSum_3_values() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceStub());
		
		int actualResult = business.calculateSumFromDataService();
		int expectedResult = 6;
		
		assertEquals(actualResult, expectedResult);
	}

	@Test
	public void calculateSum_1_value() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.calculateSum(new int[] {1});
		int expectedResult = 1;
		assertEquals(actualResult, expectedResult);
	}
	
	@Test
	public void calculateSum_empty() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		int actualResult = business.calculateSum(new int[] {});
		int expectedResult = 0;
		assertEquals(actualResult, expectedResult);
	}

}
