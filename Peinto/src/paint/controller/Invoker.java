package paint.controller;

import java.util.ArrayList;

import paint.model.Shape;

// Command DP
public class Invoker {
	private Command command;

	public Invoker(Command command) {
		this.command = command;
	}

	public ArrayList<Shape> executeCommand() {
			return command.execute();
	}

}
