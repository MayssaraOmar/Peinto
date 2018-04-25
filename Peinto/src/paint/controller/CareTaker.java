package paint.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import paint.model.Shape;

public class CareTaker {
	 private LinkedList<Memento> undoList = new LinkedList<Memento>();
	 private LinkedList<Memento> redoList = new LinkedList<Memento>();
	 
	 public void addCurrent(Memento state){
		 redoList.clear();
		 //if(undoList.size()>1)
				//System.out.println("when adding  "+this.undoList.getLast().getState().get(0).getProperties().get("EndPositionX"));
			//System.out.println("AFTER   "+this.shapes.get(this.shapes.size()-1).getProperties().get("EndPositionX"));

		 addUndo(state);
	 }
	
	 public Memento undo(){
		 if(undoList.size() <= 1)
			 return null;
		 Memento currentState = undoList.removeLast();
		 addRedo(currentState);
		 return undoList.getLast();
	 }
	 public Memento redo(){
		 if(redoList.size() == 0)
			 return null;
		 Memento nextState = redoList.removeLast();
		 addUndo(nextState);
		 return nextState;
	 }
	 
	 public void addUndo(Memento state){
		 if(undoList.size() == 20)
			 undoList.removeFirst();
		 undoList.addLast(state);
	 }
	 public void addRedo(Memento state){
		 if(redoList.size() == 20)
			 redoList.removeFirst();
		 redoList.addLast(state);
	 }
}
