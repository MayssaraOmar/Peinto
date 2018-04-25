package paint.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import paint.model.Shape;

public class Memento {
	private ArrayList<Shape> shapesState = new ArrayList<Shape>(); 

	public Memento(ArrayList<Shape> shapesState) {
		// Deep copy of object shape and its map: makes copies of dynamically allocated memory pointed to by the fields 
		for(Shape shape: shapesState)
			try {

				this.shapesState.add((Shape) shape.clone());
				Map<String, Double> map = new HashMap<>(shape.getProperties());
				this.shapesState.get(this.shapesState.size()-1).setProperties(map);
				//System.out.println(this.shapesState.get(this.shapesState.size()-1).getProperties().get("EndPositionX"));
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public ArrayList<Shape> getState(){
		return this.shapesState;
	}	
}
