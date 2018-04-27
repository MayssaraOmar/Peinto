package paint.model;

import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractShape implements Shape, Cloneable {
	private Point position;
	private Color color;
	private Color fillColor;
	private Map<String, Double> properties;

	public AbstractShape() {
		properties = new HashMap<>();
		properties.put("EndPositionX", null);
		properties.put("EndPositionY", null);
		color = Color.black;
		fillColor = Color.white;
	}

	@Override
	public void setPosition(Point position) {
		this.position = position;
	}

	@Override
	public Point getPosition() {
		return position;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public java.awt.Color getColor() {
		return this.color;
	}

	public void setProperties(Map<String, Double> properties) {
		this.properties = properties;
	}

	public Map<String, Double> getProperties() {
		return properties;
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
