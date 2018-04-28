package paint.controller;

import java.util.ArrayList;

import paint.model.Shape;

//Command DP
public class RedoCommand implements Command {

	private CareTaker careTaker;
	private Originator originator;

	public RedoCommand(Originator originator, CareTaker careTaker) {
		this.originator = originator;
		this.careTaker = careTaker;
	}

	@Override
	public ArrayList<Shape> execute() {
		originator.getStateFromMemento(careTaker.redo());
		return originator.getState();
	}

}
