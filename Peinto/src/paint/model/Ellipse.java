package paint.model;

import java.util.Map;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Ellipse extends AbstractShape {
		
	public Ellipse() {
		super();
	}
	
	public void draw(Object canvas) {
		Map<String,Double> properties = getProperties();
		
		if(canvas == null || getPosition() == null || properties.get("EndPositionX") == null || properties.get("EndPositionY") == null) 
			return;
		
		Graphics g2D = (Graphics2D) canvas;
		
		int x = Math.min(getPosition().x, properties.get("EndPositionX").intValue());
		int y = Math.min(getPosition().y, properties.get("EndPositionY").intValue());
		int width = Math.abs(getPosition().x - properties.get("EndPositionX").intValue());
		int height = Math.abs(getPosition().y - properties.get("EndPositionY").intValue());
		g2D.drawOval(x, y, width, height);
		
		properties.put("Width", (double) width);
		properties.put("Height", (double) height);
		setProperties(properties);
	}

}
