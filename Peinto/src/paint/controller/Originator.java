package paint.controller;

import java.util.ArrayList;
import paint.model.Shape;

// Memento DP
public class Originator {
	private ArrayList<Shape> shapesState;

	public void setState(ArrayList<Shape> shapesState) {
		if (shapesState == null)
			return;

		// Shallow copy: i.e., only the memory address is copied.
		this.shapesState = shapesState;
	}

	public ArrayList<Shape> getState() {
		return this.shapesState;
	}

	public Memento saveStateToMemento() {
		return new Memento(shapesState);
	}

	public void getStateFromMemento(Memento memento) {

		if (memento == null || memento.getState() == null)
			return;
		// Shallow copy: i.e., only the memory address is copied.
		this.shapesState = memento.getState();
	}
}
