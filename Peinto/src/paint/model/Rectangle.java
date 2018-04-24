package paint.model;


import java.util.Map;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Rectangle extends AbstractShape {
	
	 public Rectangle() {
		super();
	}

	public void draw(Object canvas) {
Map<String,Double> properties = getProperties();
		
		if(canvas == null || getPosition() == null || properties.get("EndPositionX") == null || properties.get("EndPositionY") == null) 
			return;
		
		Graphics g2D  = (Graphics2D) canvas;
		
		int x = Math.min(getPosition().x, properties.get("EndPositionX").intValue());
		int y = Math.min(getPosition().y, properties.get("EndPositionY").intValue());
		int width =  Math.abs(getPosition().x - properties.get("EndPositionX").intValue());
		int height =   Math.abs(getPosition().y - properties.get("EndPositionY").intValue());
		((Graphics2D)g2D).setStroke(new BasicStroke(3));
		g2D.setColor(this.getColor());
	    g2D.drawRect(x, y, width, height);
	    g2D.setColor(this.getFillColor());
	    g2D.fillRect(x, y, width, height);

		properties.put("Width", (double) width);
		properties.put("Height", (double) height);
		setProperties(properties);   
	 }

}
