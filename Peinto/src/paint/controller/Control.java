package paint.controller;

import java.awt.Point;

import paint.model.Circle;
import paint.model.Shape;
import paint.model.ShapeFactory;

public class Control {
	// static variables only visible to this package (controller)
	static ShapeFactory shapeFactory = new ShapeFactory();
	static Point startPoint = null, endPoint = null, midPoint = null;
	static Shape currShape;
}
