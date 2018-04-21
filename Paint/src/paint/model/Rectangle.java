package paint.model;

import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Rectangle extends AbstractShape {
	private Map<String,Double> properties = new HashMap<>();
	
	public Rectangle(Point position, Point positionNew,  Double length, Double width) {
		super(position, positionNew);
		properties.put("length", length);
		properties.put("width", width);
		super.setProperties(properties);
	}
	

	 public Rectangle() {
		super();
	}


	public void draw(Object canvas)
	 {
	    
		if(canvas == null || getStartPosition()==null || getEndPosition()==null) return;
		Graphics g2D  = (Graphics2D) canvas;
		//g2D.drawLine(getStartPosition().x, getStartPosition().y, getEndPosition().x, getEndPosition().y);
		
		//g2D.drawRect(getStartPosition().x, getStartPosition().y, width, height);
		int width =  Math.abs(getStartPosition().x - getEndPosition().x);
		int height =   Math.abs(getStartPosition().y - getEndPosition().y);
		g2D.drawRect(getStartPosition().x, getStartPosition().y, width, height);
		 //g2D.draw( new Rectangle2D.Double( );
	 
	  /* int  x1 = this.getPosition().x;
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

     //return new  Rectangle2D.Float( x, y, width, height);*/
                
       
	 }

}
