package paint.model;

import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractShape implements Shape {
	private Point position = new Point();
	private Point positionNew = new Point();
	private Color color,fillColor;
	private Map<String,Double> properties = new HashMap<>();
	
	
	public AbstractShape(Point position, Color color, Color fillColor, Point positionNew) {
		this.position = position;
		this.color = color;
		this.fillColor = fillColor;
		this.positionNew = positionNew;
	
		
	}

	public Point getPositionNew() {
		return positionNew;
	}

	public void setPositionNew(Point positionNew) {
		this.positionNew = positionNew;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	public void setPosition(java.awt.Point position)
	{
		this.position = position;
	}
	
	public java.awt.Point getPosition()
	{
		return position;
	}
	public void setProperties(java.util.Map<String, Double> properties)
	{
		this.properties = properties;
	}
	public java.util.Map<String, Double> getProperties()
	{
		return properties;
	}
	
	 public void setColor(java.awt.Color color)
	 {
		 this.color = color;
	 }
	 public java.awt.Color getColor()
	 {
		 return this.color;
	 }
	 
	 
	 public Object clone() throws CloneNotSupportedException
	 {
		 return null;
	 }
	
}
