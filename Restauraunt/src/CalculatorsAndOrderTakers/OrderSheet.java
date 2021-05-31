package CalculatorsAndOrderTakers;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderSheet {
	private ArrayList<Integer> order = new ArrayList<Integer>();

	public OrderSheet(ArrayList<Integer> order) {
		this.order = order;
	}
	
	public ArrayList<Integer> getOrder() {
		return this.order;
	}
	
	public void  setOrder(ArrayList<Integer> order){
		this.order = order;
	}
	
	@Override
	public String toString() {
		return "order is " + order;
		
	}
}
