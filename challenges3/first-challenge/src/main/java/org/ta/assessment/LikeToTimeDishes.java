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

	public LikeToTimeDishes() {
		
	}

    public static void main(String[] args) {
    	Integer[] input = {1,2,3,4,-5,6,7,8,-9,10};
    	//Integer[] input = {-1,3,4};
    	//Integer[] input = {1,3,-4,4};
    	//Integer[] input = {2,-2,1,2,2,2,2};
    	LikeToTimeDishes likeToTimeDishes = new LikeToTimeDishes();
    	int solution = likeToTimeDishes.calculateSolution(input);
    	System.out.println("Coefficient: " + solution);
    }

    public int calculateSolution(Integer[] input) {
    	preparedDishes = new ArrayList<>(Arrays.asList(input));
    	List<Integer> newList = new ArrayList<>(Arrays.asList(input));
    	Vector<Integer> somatorio = new Vector<>();
    	Vector<Integer> indexesToBeRemoved = new Vector<>();
    	Vector<Integer> newVector = new Vector<>();
    	int coefficient = 0;
    	int lastPositiveInteger = 0;
    	for(int i = 1; i <= input.length; i++) {
    		coefficient += i * input[i-1];

    		//Save last positive integer from the input array, all negative numbers from that are removed.
    		if(input[i-1] >= 0)
    			lastPositiveInteger = i;
    		somatorio.add(coefficient);
    	}

    	System.out.println("Old coefficient: " + coefficient + "\n"
    			+ "Reorganized list: ");
    	newList = preparedDishes.subList(0, lastPositiveInteger);
    	System.out.println(newList);

    	//Use vector
    	newVector = new Vector<>(newList);

    	//What if input only has 1 negative number?
    	if(newVector.size() >= 2) {
        	Integer ultimoNumeroPositivo = newVector.elementAt(newVector.size()-1);
        	Integer b = ultimoNumeroPositivo;
        	boolean markedToChange = false;
        	for(int i = newVector.size()-2; i >= 0; i--) {
        		Integer a = newVector.get(i);
        		if(markedToChange) {
        			markedToChange = false;
        			ultimoNumeroPositivo = b;
        			b = a;
        			continue;
        		} //se a == 0
    			if(a > ultimoNumeroPositivo) {
    				ultimoNumeroPositivo = a;
    				b = a;
    				continue;
    			} else if(a >= 0 && a <= b) {
    				ultimoNumeroPositivo += b;
    			}
    			if((i + 1) * a < 0 && Math.abs((i + 1) * a) > ultimoNumeroPositivo) { //only calculates if the number in index position is < 0.
    				indexesToBeRemoved.add(i);
    				markedToChange = true;
    			}
        	}
        	System.out.print("----\nIndex(es) to be removed: ");
        	for(Integer i : indexesToBeRemoved)
        		System.out.print(i + " ");
        	System.out.println("\n----");
        	removeIndexesFromList(newList, indexesToBeRemoved);
            return calculateCoefficient(newList);
    	}
    	return coefficient;
    }

    public int calculateCoefficient(List<Integer> list) {
    	int coefficient = 0;
    	for(int i = 0; i < list.size(); i++) {
    		coefficient += (i + 1) * list.get(i);
    	}
    	return coefficient;
    }

    public void removeIndexesFromList(List<Integer> list, List<Integer> indexesToBeRemoved) {
    	Collections.reverse(indexesToBeRemoved);
        for (Integer indexToRemove : indexesToBeRemoved) {
        	list.remove((int)indexToRemove);
        }
    }
}
