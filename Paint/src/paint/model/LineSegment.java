package paint.model;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;


import java.awt.Graphics;
import java.awt.Graphics2D;

public class LineSegment extends AbstractShape{
	private Map<String, Double> properties = new HashMap<>();
	
	

	public LineSegment() {
		super();
	}

	public LineSegment(Point startPoint, Point endPoint) 
	{
		super(startPoint,  endPoint);
		this.properties = properties;
		super.setProperties(properties);
	}
	
	public void draw(Object canvas){
		if(canvas == null || getStartPosition()==null || getEndPosition()==null) return;
		Graphics g2D  = (Graphics2D) canvas;
		g2D.drawLine(getStartPosition().x, getStartPosition().y, getEndPosition().x, getEndPosition().y);
	}

	public Map<String, Double> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Double> properties) {
		this.properties = properties;
	}

	

}
