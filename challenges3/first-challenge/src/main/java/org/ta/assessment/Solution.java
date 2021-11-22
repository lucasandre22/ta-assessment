package org.ta.assessment;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	private List<Integer> preparedDishes;
	private int coefficient;

	public Solution() {
		preparedDishes = new ArrayList<>();
	}

	public void setPreparedDishes(List<Integer> preparedDishes) {
		this.preparedDishes = preparedDishes;
	}

	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}

	public String toString() {
		return "Solution {\npreparedDishes=" + preparedDishes + "\n" + "preparedDishesSize=" + preparedDishes.size()
				+ "\ncoefficient=" + coefficient + "\n}";
	}
}
