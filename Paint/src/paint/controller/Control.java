package paint.controller;

import java.awt.Point;
import java.util.ArrayList;

import paint.model.AbstractShape;
import paint.model.ShapeFactory;

public class Control {
	// static variables only visible to this package (controller)
	static ShapeFactory shapeFactory = new ShapeFactory();
	static AbstractShape currentShape = null;
	static ArrayList<AbstractShape> shapes = new ArrayList<AbstractShape>();
	public static ControlDrawingEngine controlDrawingEngine = new ControlDrawingEngine();
	public CanvasMouseAdapter canvasMouseAdapter = new CanvasMouseAdapter ();
	public LabelMouseAdapter LabelMouseAdapter = new LabelMouseAdapter ();
	static String state = null;
}
