package com.in28minutes.unitTestsWithMockito.business;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import com.in28minutes.unitTestsWithMockito.service.SomeDataService;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessImplMockTest {

	@InjectMocks
	SomeBusinessImpl business;
	
	@Mock
	SomeDataService someDataServiceMock;
	
	@Test
	public void calculateSum_3_values() {
		Mockito.when(someDataServiceMock.retrieveData()).thenReturn(new int[] {1, 2, 3});
		assertEquals(6, business.calculateSumFromDataService());
	}

	@Test
	public void calculateSum_1_value() {
		Mockito.when(someDataServiceMock.retrieveData()).thenReturn(new int[] {1});
		assertEquals(1, business.calculateSumFromDataService());
	}
	
	@Test
	public void calculateSum_empty() {
		Mockito.when(someDataServiceMock.retrieveData()).thenReturn(new int[] {1});
		assertEquals(0, business.calculateSum(new int[] {}));
	}

}
