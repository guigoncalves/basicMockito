package com.in28minutes.unitTestsWithMockito.business;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static org.mockito.Mockito.*;

import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ListMockTest {

	List<String> mock = mock(List.class);

	@Test
	public void calculateSize() {
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}
	
	@Test
	public void calculateSizeTwice() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}
	
	@Test
	public void firstItem() {
		when(mock.get(0)).thenReturn("Dummy data");
		assertEquals("Dummy data", mock.get(0));
		assertEquals(null, mock.get(1));
	}

	@Test
	public void anyItem() {
		when(mock.get(anyInt())).thenReturn("Dummy data");
		assertEquals("Dummy data", mock.get(0));
		assertEquals("Dummy data", mock.get(1));
	}
	
	@Test
	public void verifyTimes() {
		mock.get(0);
		mock.get(1);
		
		verify(mock).get(0);
		verify(mock, atLeast(1)).get(anyInt());
		verify(mock, atLeastOnce()).get(anyInt());
		verify(mock, atMost(2)).get(anyInt());
		verify(mock, times(2)).get(anyInt());
		verify(mock, never()).get(2);
	}
	
	@Test
	public void argumentCapture() {
		mock.add("Some String");
	
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
		
		assertEquals("Some String", captor.getValue());
	}
	
	@Test
	public void argumentCaptureMultiple() {
		mock.add("Some String1");
		mock.add("Some String2");
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock, times(2)).add(captor.capture());

		assertEquals("Some String1", captor.getAllValues().get(0));
		assertEquals("Some String2", captor.getAllValues().get(1));
	}

	//Spy uses real object.
	@Test
	public void mockAndSpy() {
		ArrayList arrayMock = mock(ArrayList.class);
		ArrayList arraySpy = spy(ArrayList.class);
		
		arrayMock.add("Some String");	
		arraySpy.add("Some String");

		assertEquals(0, arrayMock.size());
		assertEquals(1, arraySpy.size());
		
	}
}
