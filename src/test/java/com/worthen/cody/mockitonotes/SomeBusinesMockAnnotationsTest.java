package com.worthen.cody.mockitonotes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Any time we are using Mockito annotations, we need to use the following
 * annotation:
 */
@ExtendWith(MockitoExtension.class)
public class SomeBusinesMockAnnotationsTest {

	/**
	 * We do this manually in SomeBusinessMockTest with Mockito.mock()
	 * 
	 * These annotations will do the same thing automatically.
	 */

	@Mock // use this because DataService doesn't have any dependencies
	private DataService dataServiceMock;

	@InjectMocks // use this because SomeBusinessImpl has dependencies that need injected
	private SomeBusinessImpl businessImpl;

	@Test
	public void testFindMaxFromAllData() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 24, 6, 15 });

		// the max should be 24
		assertEquals(24, businessImpl.findMaxFromAllData());
	}

	@Test
	public void testFindMaxFromAllData_ForOneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 6 });

		// the max should be 6
		assertEquals(6, businessImpl.findMaxFromAllData());
	}
}
