package spacenews.util;

import java.util.ArrayList;
import java.util.List;

public class Observable {
	private List<Observer> observers;

	public Observable() {
		observers = new ArrayList<Observer>();
	}

	public void addObserver(Observer obs) {
		observers.add(obs);
	}

	public void notifyObservers() {
		for (Observer obs : observers)
			obs.update();
	}
}
