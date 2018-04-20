package paint.model;

import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Triangle extends AbstractShape{

	private Map<String,Double> properties = new HashMap<>();

	public Triangle(Point position, Point positionNew, Point thirdPoint) {
		super(position, positionNew);
		properties.put("thirdPoitX", thirdPoint.getX()); //Triangle needs 3 points to be drawn which are position, positionNew and third point
		properties.put("thirdPointY", thirdPoint.getY());
		this.properties = properties;
	}

	public Triangle() {
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
