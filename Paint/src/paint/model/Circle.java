package paint.model;

import java.util.Map;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Circle extends AbstractShape{
	 

	/*public Circle(Point position, Point positionNew, Double radius) {
		super(position, positionNew);
		properties.put("radius", radius);
		this.properties = properties;
	}*/

	public Circle() {
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
		int radius =  Math.abs(getPosition().x - properties.get("EndPositionX").intValue());
		g2D.drawOval(x, y, radius, radius);
		
		properties.put("Radius", (double) radius);
		setProperties(properties);
	}


	
	

}
