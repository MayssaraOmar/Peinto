package paint.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import paint.model.Shape;

//Memento DP
public class Memento {
	private ArrayList<Shape> shapesState = new ArrayList<Shape>();

	public Memento(ArrayList<Shape> shapesState) {
		// Deep copy of object shape and its map: makes copies of dynamically allocated
		// memory pointed to by the fields
		for (Shape shape : shapesState)
			try {
				Map<String, Double> deepCopy = new HashMap<String, Double>();
				for (Map.Entry<String, Double> entry : shape.getProperties().entrySet()) {
					deepCopy.put(entry.getKey(), entry.getValue());
				}
				this.shapesState.add((Shape) shape.clone());
				this.shapesState.get(this.shapesState.size() - 1).setProperties(deepCopy);
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
	}

	public ArrayList<Shape> getState() {
		return this.shapesState;
	}
}
