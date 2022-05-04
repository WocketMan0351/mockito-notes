package com.worthen.cody.mockitonotes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class SomeBusinessMockTest {

	@Test
	void testFindMaxFromAllData() {
		DataService dataServiceMock = mock(DataService.class);
		// when this method is called, return this (in place of the stub)
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 24, 6, 15 });

		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);

		// the max should be 24
		assertEquals(24, businessImpl.findMaxFromAllData());
	}

	@Test
	void testFindMaxFromAllData_ForOneValue() {
		DataService dataServiceMock = mock(DataService.class);
		// when this method is called, return this (in place of the stub)
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 6 });

		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);

		// the max should be 6
		assertEquals(6, businessImpl.findMaxFromAllData());
	}

}
