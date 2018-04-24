package paint.model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Map;


public class Square extends AbstractShape {
/*
public Square(Point position, Point positionNew, Double sideLength)
{
	super(position, positionNew);
	properties.put("sideLength", sideLength);
	this.properties = properties;
}*/


	public Square() {
		super();
	}

	public void draw(Object canvas)
	 {
		
		Map<String,Double> properties = getProperties();
		
		if(canvas == null || getPosition() == null || properties.get("EndPositionX") == null || properties.get("EndPositionY") == null) 
			return;
		
		Graphics g2D  = (Graphics2D) canvas;
		
		int x = Math.min(getPosition().x, properties.get("EndPositionX").intValue());
		int y = Math.min(getPosition().y, properties.get("EndPositionY").intValue());
		int sideLength =  Math.abs(getPosition().x - properties.get("EndPositionX").intValue());
	    g2D.drawRect(x, y, sideLength, sideLength);
	    
	    properties.put("SideLength", (double) sideLength);
		setProperties(properties);
	
	 /*
	  
       // Math.min returns the points closest to 0
                	
       int x = Math.min(x1, x2);
       int y = Math.min(y1, y2);
                        
        // Gets the difference between the coordinates 
                        
          int sideLength = Math.abs(x1 - x2);
         
         */       
       
	 }
}



