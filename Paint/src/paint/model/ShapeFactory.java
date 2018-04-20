package paint.model;

import java.awt.Color;
import java.awt.Point;

public class ShapeFactory {
	public Shape getShape(String shapeType){
	      if(shapeType == null){
	         return null;
	      }		
	      if(shapeType.equalsIgnoreCase("CIRCLE")){
	         return new Circle(new Point(0, 0), Color.BLACK, Color.white, new Point(0,0), 1.0);
	         
	      } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
	         return new Rectangle(new Point(0,0), new Point(0,0), Color.black, Color.white, 1.0, 1.0);
	         
	      } else if(shapeType.equalsIgnoreCase("SQUARE")){
	         return new Square(new Point(0,0), Color.BLACK, Color.white, new Point(0,0) , 1.0);
	      } else if( shapeType.equalsIgnoreCase("EllIPSE")) {
	    	  return new Ellipse( new Point(0,0) , Color.black, Color.white, new Point(0,0) , 1.0, 1.0);
	      } else if( shapeType.equalsIgnoreCase("LineSegment")) {
	    	  return new LineSegment(new Point(0,0) ,Color.black, Color.white, new Point(0,0));
	      }
	      
	      return null;
	   }

}
