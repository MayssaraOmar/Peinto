package paint.controller;

import java.util.ArrayList;

import paint.model.Shape;

//Command DP
public class UndoCommand implements Command {

	private CareTaker careTaker;
	private Originator originator;

	public UndoCommand(Originator originator, CareTaker careTaker) {
		this.originator = originator;
		this.careTaker = careTaker;
	}

	@Override
	public ArrayList<Shape> execute() {
		if (careTaker == null)
			return null;
		originator.getStateFromMemento(careTaker.undo());

		return originator.getState();
	}
}
