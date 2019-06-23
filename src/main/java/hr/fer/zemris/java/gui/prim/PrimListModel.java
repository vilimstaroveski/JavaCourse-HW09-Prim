package hr.fer.zemris.java.gui.prim;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 * List model used by {@link PrimDemo} to calculate new prime numbers.
 * @author Vilim Staroveški
 *
 */
public class PrimListModel implements ListModel<Integer>{

	/**
	 * Last number that was calculated.
	 */
	private int currentNum;
	
	/**
	 * List of prime numbers calculated till now.
	 */
	private List<Integer> numbers;
	
	/**
	 * List of listeners that listens to changes in this class.
	 */
	private List<ListDataListener> listeners;
	
	/**
	 * Creates new {@link PrimListModel} with current number set to 1.
	 */
	public PrimListModel() {
		this.currentNum = 1;
		this.numbers = new ArrayList<Integer>();
		this.listeners = new ArrayList<ListDataListener>();
		this.numbers.add(currentNum);
	}
	
	/**
	 * Method called when {@link PrimListModel} is wanted to calculate new prime value.
	 */
	public void next() {
		
		this.currentNum++;
		while(true) {
			
			if(isPrime(currentNum)) {
				numbers.add(currentNum);
				break;
			}
			currentNum++;
		}
		for(ListDataListener listener : listeners) {
			listener.intervalAdded(new ListDataEvent(numbers, ListDataEvent.INTERVAL_ADDED, numbers.size()-2, numbers.size()-1));
		}
	}

	/**
	 * Method that checks is the number prime or not
	 * @param number number that is validated
	 * @return true if the given number is prime. False otherwise.
	 */
	private boolean isPrime(int number) {
		
		for(int i = 2; i < Math.sqrt(number)+1; i++) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int getSize() {
		
		return numbers.size();
	}

	@Override
	public Integer getElementAt(int index) {
		
		return numbers.get(index);
	}

	@Override
	public void addListDataListener(ListDataListener l) {

		this.listeners.add(l);
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		
		if(this.listeners.contains(l)) {
			this.listeners.remove(l);
		}
	}
}
