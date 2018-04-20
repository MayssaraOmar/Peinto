package paint.model;

import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.awt.Graphics;

public class Rectangle extends AbstractShape {
	private Map<String,Double> properties = new HashMap<>();
	
	public Rectangle(Point position, Point positionNew, Color color, Color fillColor, Double length, Double width) {
		super(position, color, fillColor, positionNew);
		properties.put("length", length);
		properties.put("width", width);
		super.setProperties(properties);
	}
	

	 public void draw(Object canvas)
	 {
	    
	   
	 
	   int  x1 = this.getPosition().x;
	   int x2 = this.getPositionNew().x;
	   int y1= this.getPosition().y;
	   int y2= this.getPosition().y;
       // Get the top left hand corner for the shape
       // Math.min returns the points closest to 0
                	
       int x = Math.min(x1, x2);
       int y = Math.min(y1, y2);
                        
        // Gets the difference between the coordinates and 
                        
          int width = Math.abs(x1 - x2);
          int height = Math.abs(y1 - y2);

     //return new  Rectangle2D.Float( x, y, width, height);
                
       
	 }

}
