package com.example;

public class DeliveryDetailsPrinter {
	
	private Sorter sorter;

	public DeliveryDetailsPrinter(Sorter sorter) {
		this.sorter = sorter;
	}
	
	public void printDetails() {
		sorter.sortDetails();
		// printing the delivery details.
	}
}
