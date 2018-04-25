package paint.controller;

import java.util.ArrayList;

import paint.model.Shape;

public class Memento {
	private ArrayList<Shape> shapesState = new ArrayList<Shape>(); 

	public Memento(ArrayList<Shape> shapesState) {
		// Deep copy: makes copies of dynamically allocated memory pointed to by the fields 
		for(Shape shape: shapesState)
			this.shapesState.add(shape);
	}

	public ArrayList<Shape> getState(){
		return this.shapesState;
	}	
}
