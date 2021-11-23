package org.ta.assessment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import javax.swing.event.ListSelectionEvent;

public class LikeToTimeDishes 
{
	private List<Integer> preparedDishes = null;
	private Solution solution;

	public LikeToTimeDishes() {
		solution = new Solution();
	}

    public static void main(String[] args) {
    	Integer[] input = {-2,1};

    	LikeToTimeDishes likeToTimeDishes = new LikeToTimeDishes();
    	Solution solution = likeToTimeDishes.calculateSolution(input);
    	System.out.println(solution);
    }

    public Solution calculateSolution(Integer[] input) {
    	preparedDishes = new ArrayList<>(Arrays.asList(input));
    	Vector<Integer> indexesToBeRemoved = new Vector<>();
    	Vector<Integer> newVector = new Vector<>();
    	int coefficient = 0;
    	int lastPositiveInteger = 0;
    	for(int i = 1; i <= input.length; i++) {
    		coefficient += i * input[i-1];
    		//Save last positive integer from the input array, all negative numbers from that are removed.
    		if(input[i-1] >= 0)
    			lastPositiveInteger = i;
    	}

    	System.out.println("Old coefficient: " + coefficient);
    	preparedDishes = preparedDishes.subList(0, lastPositiveInteger);

    	//Use vector in loop
    	newVector = new Vector<>(preparedDishes);

    	if(newVector.size() >= 2) {
        	Integer positiveNumbersSum = newVector.elementAt(newVector.size()-1);
        	for(int i = newVector.size()-2; i >= 0; i--) {
        		Integer currentNumber = newVector.get(i);
        		if(currentNumber >= 0) {
        			positiveNumbersSum += currentNumber;
    				continue;
    			}
    			if((i + 1) * currentNumber < 0 && Math.abs((i + 1) * currentNumber) > positiveNumbersSum) { //only calculates if the number in index position is < 0.
    				indexesToBeRemoved.add(i);
    			}
        	}
        	System.out.print("---------\nIndexes to be removed: ");
        	for(Integer i : indexesToBeRemoved)
        		System.out.print(i + " ");
        	System.out.println("\n---------");
        	removeIndexesFromList(preparedDishes, indexesToBeRemoved);
    	}
    	return calculateCoefficient();
    }

    public Solution calculateCoefficient() {
    	int coefficient = 0;
    	for(int i = 0; i < preparedDishes.size(); i++) {
    		coefficient += (i + 1) * preparedDishes.get(i);
    	}
    	solution.setCoefficient(coefficient);
    	solution.setPreparedDishes(preparedDishes);
    	return solution;
    }

    public void removeIndexesFromList(List<Integer> list, List<Integer> indexesToBeRemoved) {
    	Collections.reverse(indexesToBeRemoved);
        for (Integer indexToRemove : indexesToBeRemoved) {
        	list.remove((int)indexToRemove);
        }
    }
}
