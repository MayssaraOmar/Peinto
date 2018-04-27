package paint.model;

public class ShapeFactory {
	public Shape getShape(String shapeType) {

		if (shapeType.equalsIgnoreCase("CIRCLE")) {
			return new Circle();
		} else if (shapeType.equalsIgnoreCase("Rectangle")) {
			return new Rectangle();
		} else if (shapeType.equalsIgnoreCase("SQUARE")) {
			return new Square();
		} else if (shapeType.equalsIgnoreCase("EllIPSE")) {
			return new Ellipse();
		} else if (shapeType.equalsIgnoreCase("LineSegment")) {
			return new LineSegment();
		} else if (shapeType.equalsIgnoreCase("TRIANGLE")) {
			return new Triangle();
		}
		return null;
	}

}
