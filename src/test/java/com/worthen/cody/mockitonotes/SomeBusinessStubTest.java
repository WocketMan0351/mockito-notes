package com.worthen.cody.mockitonotes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SomeBusinessStubTest {

	@Test
	public void testFindMaxFromAllData() {
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(new DataServiceStub());

		// max should be 24
		assertEquals(24, businessImpl.findMaxFromAllData());
	}

}

class DataServiceStub implements DataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] { 24, 6, 15 };
	}

}
