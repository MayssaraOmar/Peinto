package paint.model;

public class FactoryTesting {
	 public static void main(String[] args) {
	      ShapeFactory shapeFactory = new ShapeFactory();

	      //get an object of Circle 
	      Shape shape1 = shapeFactory.getShape("CIRCLE");

	      //get an object of Rectangle 
	      Shape shape2 = shapeFactory.getShape("RECTANGLE");

	      //get an object of Square
	      Shape shape3 = shapeFactory.getShape("SQUARE");

	      
	   }
}
