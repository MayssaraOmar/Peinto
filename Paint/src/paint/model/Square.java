package paint.model;

import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Square extends AbstractShape {
private Map<String,Double> properties = new HashMap<>();

public Square(Point position, Color color, Color fillColor, Point positionNew, Double sideLength)
{
	super(position, color, fillColor, positionNew);
	properties.put("sideLength", sideLength);
	this.properties = properties;
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
                        
        // Gets the difference between the coordinates 
                        
          int sideLength = Math.abs(x1 - x2);
         
                
       
	 }


}
