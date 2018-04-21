package paint.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.Map;

import com.sun.javafx.geom.Point2D;

public class Square extends AbstractShape {
private Map<String,Double> properties = new HashMap<>();

public Square(Point position, Point positionNew, Double sideLength)
{
	super(position, positionNew);
	properties.put("sideLength", sideLength);
	this.properties = properties;
}






	public Square() {
	super();
}






	public void draw(Object canvas)
	 {
		
		 
		if(canvas == null || getStartPosition()==null || getEndPosition()==null)  return;
		Graphics g2D  = (Graphics2D) canvas;

		int sideLength =  Math.abs(getStartPosition().x - getEndPosition().x);
	    g2D.drawRect(getStartPosition().x, getStartPosition().y, sideLength, sideLength);
	
	 /*
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
         
         */       
       
	 }
}



