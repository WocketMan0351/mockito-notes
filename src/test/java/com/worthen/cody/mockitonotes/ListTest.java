package com.worthen.cody.mockitonotes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ListTest {

	@Test
	public void testSize() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(10);

		assertEquals(10, listMock.size());
	}

	@Test
	public void testSize_multipleReturns() {
		List listMock = mock(List.class);
		// returns 10 first time it's called, 20 the second time and everytime
		// thereafter
		when(listMock.size()).thenReturn(10).thenReturn(20);

		assertEquals(10, listMock.size());
		assertEquals(20, listMock.size());
		assertEquals(20, listMock.size());
	}

	@Test
	public void testGet() {
		List listMock = mock(List.class);
		// SPECIFIC PARAMETER - returns "some string" only for get(0)
		when(listMock.get(0)).thenReturn("some string");

		assertEquals("some string", listMock.get(0));
		assertEquals(null, listMock.get(1)); // returns null for all other params
	}

	@Test
	public void testGet_genericParameter() {
		List listMock = mock(List.class);
		// GENERIC PARAMETER - returns "some string" for get(x) where x is any integer
		when(listMock.get(Mockito.anyInt())).thenReturn("some string");

		assertEquals("some string", listMock.get(777));
		assertEquals("some string", listMock.get(0));
	}

}
