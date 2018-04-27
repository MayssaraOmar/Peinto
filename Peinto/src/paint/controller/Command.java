package paint.controller;

import java.util.ArrayList;

import paint.model.Shape;

//Command DP
public interface Command {
	ArrayList<Shape> execute();
}
