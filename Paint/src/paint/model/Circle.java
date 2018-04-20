package paint.model;

import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.awt.Graphics;

public class Circle extends AbstractShape{
	private Map<String,Double> properties = new HashMap<>();

	public Circle(Point position, Point positionNew, Double radius) {
		super(position, positionNew);
		properties.put("radius", radius);
		this.properties = properties;
	}
	

	public Circle() {
		super();
	}


	public Map<String, Double> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Double> properties) {
		this.properties = properties;
	}
	
	public void draw(Object canvas)
	{
		
	}
	

}
