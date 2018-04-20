package paint.model;

import java.awt.Color;
import java.awt.Point;


public class ShapeFactory {
	public Shape getShape(String shapeType){
	      	
	      if(shapeType.equalsIgnoreCase("CIRCLE")){
	          return new Circle(); 
	      } else if( shapeType.equalsIgnoreCase("RECTANGLE")){
	         return new Rectangle();  
	      } else if(shapeType.equalsIgnoreCase("SQUARE")){
	         return new Square();
	      } else if( shapeType.equalsIgnoreCase("EllIPSE")) {
	    	  return new Ellipse();
	      } else if( shapeType.equalsIgnoreCase("LineSegment")) {
	    	  return new LineSegment();
	      }
	      return null;
	   }

}
