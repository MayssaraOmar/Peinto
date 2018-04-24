package paint.model;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Map;


public class Square extends AbstractShape {

	public Square() {
		super();
	}

	public void draw(Object canvas) {
		
		Map<String,Double> properties = getProperties();
		
		if(canvas == null || getPosition() == null || properties.get("EndPositionX") == null || properties.get("EndPositionY") == null) 
			return;
		
		Graphics g2D  = (Graphics2D) canvas;
		
		int x = Math.min(getPosition().x, properties.get("EndPositionX").intValue());
		int y = Math.min(getPosition().y, properties.get("EndPositionY").intValue());
		int sideLength =  Math.abs(getPosition().x - properties.get("EndPositionX").intValue());
		((Graphics2D)g2D).setStroke(new BasicStroke(3));
		g2D.setColor(this.getColor());
	    g2D.drawRect(x, y, sideLength, sideLength);
	    g2D.setColor(this.getFillColor());
	    g2D.fillRect(x, y, sideLength, sideLength);
	    
	    properties.put("SideLength", (double) sideLength);
		setProperties(properties);
	 }
}



