package paint.model;

import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.awt.Graphics;

public class Ellipse extends AbstractShape {
	private Map<String,Double> properties = new HashMap<>();
	
	

	public Ellipse() {
		super();
	}

	public Ellipse(Point position, Point positionNew, Double width, Double height) {
		super(position, positionNew);
		properties.put("width", width);
		properties.put("height", height);
		this.properties = properties;
		super.setProperties(properties);
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
