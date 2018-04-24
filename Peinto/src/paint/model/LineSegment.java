package paint.model;

import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import paint.controller.CanvasMouseAdapter;

import java.awt.Graphics;

public class LineSegment extends AbstractShape{
	private Map<String, Double> properties = new HashMap<>();
	
	

	public LineSegment() {
		super();
	}

	public LineSegment(Point position, Point positionNew) 
	{
		super(position,  positionNew);
		this.properties = properties;
		super.setProperties(properties);
	}
	
	public void draw(Object canvas){
		
       // g.drawLine(CanvasMouseAdapter.start.x, CanvasMouseAdapter.start.y, CanvasMouseAdapter.end.x, CanvasMouseAdapter.end.y);

	}

	public Map<String, Double> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Double> properties) {
		this.properties = properties;
	}
	

}
