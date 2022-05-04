package com.worthen.cody.mockitonotes;

public class SomeBusinessImpl {

	private DataService dataService;

	public SomeBusinessImpl(DataService dataService) {
		this.dataService = dataService;
	}

	public int findMaxFromAllData() {
		int[] data = dataService.retrieveAllData();

		int max = 0;
		for (int value : data) {
			if (value > max) {
				max = value;
			}
		}

		return max;
	}

}
