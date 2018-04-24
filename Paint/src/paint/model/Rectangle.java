package paint.model;


import java.util.Map;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Rectangle extends AbstractShape {
	
	/*public Rectangle(Point position, Point positionNew,  Double length, Double width) {
		super(position, positionNew);
		properties.put("length", length);
		properties.put("width", width);
		super.setProperties(properties);
	}*/
	

	 public Rectangle() {
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
		int width =  Math.abs(getPosition().x - properties.get("EndPositionX").intValue());
		int height =   Math.abs(getPosition().y - properties.get("EndPositionY").intValue());
	    g2D.drawRect(x, y, width, height);

		properties.put("Width", (double) width);
		properties.put("Height", (double) height);
		setProperties(properties);
		//((Graphics2D) g2D).draw(new Rectangle2D.Double( Math.min(getStartPosition().x , getEndPosition().x),  Math.min(getStartPosition().y ,getEndPosition().y), width, height));

/*
 * public int getWidth() {
    return (Math.abs(x2 - x1));
}

public int getHeight() {
    return (Math.abs(y2 - y1));
}

public int getUpperLeftX() {
    return (Math.min(x1, x2));
}

public int getUpperLeftY() {
    return (Math.min(y1, y2));
}*/
	   

	 
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
