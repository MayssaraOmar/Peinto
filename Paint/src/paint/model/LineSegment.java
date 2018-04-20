package paint.model;

import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.awt.Graphics;

public class LineSegment extends AbstractShape{
	private Map<String, Double> properties = new HashMap<>();

	public LineSegment(Point position, Color color, Color fillColor, Point positionNew) 
	{
		super(position, color, fillColor, positionNew);
		this.properties = properties;
		super.setProperties(properties);
	}
	
	public void draw( Object canvas)
	{
		
	}

	public Map<String, Double> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Double> properties) {
		this.properties = properties;
	}
	

}
