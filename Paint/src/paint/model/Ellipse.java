package paint.model;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.util.HashMap;
import java.util.Map;
import java.awt.Graphics;
import java.awt.Graphics2D;

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
		if(canvas == null || getStartPosition()==null || getEndPosition()==null) return;
		Graphics g2D  = (Graphics2D) canvas;
		int width =  Math.abs(getStartPosition().x - getEndPosition().x);
		int height =   Math.abs(getStartPosition().y - getEndPosition().y);
		g2D.drawOval(getStartPosition().x, getStartPosition().y,
                width,
                height);
	}

}
