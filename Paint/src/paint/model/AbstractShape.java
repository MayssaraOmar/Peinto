package paint.model;

import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import com.sun.javafx.geom.Point2D;

public abstract class AbstractShape implements Shape , Cloneable {
	private Point startPosition = null;
	private Point endPosition = null;
	private Color color = Color.black;
	private Color fillColor = Color.white;
	private Map<String,Double> properties = new HashMap<>();
	///////////////////////////////////
	@Override
	public void setPosition(Point Position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return null;
	}
	
	///////////////////////////////////
	public AbstractShape() {
		super();
	}
	public AbstractShape(Point position, Point positionNew) {
		this.setStartPosition(position);
		this.setEndPosition(positionNew);	
	}
	public Point getStartPosition() {
		return startPosition;
	}

	public void setStartPosition(Point startPoint) {
		this.startPosition = startPoint;
	}

	public Point getEndPosition() {
		return endPosition;
	}

	public void setEndPosition(Point positionNew) {
		this.endPosition = positionNew;
	}
	

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
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
		 return super.clone(); 

	 }

	
}
