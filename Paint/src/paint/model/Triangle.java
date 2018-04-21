package paint.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Triangle extends AbstractShape{

	private Map<String,Double> properties = new HashMap<>();

	public Triangle(Point position, Point positionNew, Point thirdPoint) {
		super(position, positionNew);
		properties.put("thirdPointX", thirdPoint.getX()); //Triangle needs 3 points to be drawn which are position, positionNew and third point
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
		if(canvas == null || getStartPosition()==null || getEndPosition()==null)  return;
		Graphics g2D  = (Graphics2D) canvas;
		int[] arrayXpoints = new int[3];
		int[] arrayYpoints = new int[3];
		arrayXpoints[0] = getStartPosition().x;
		arrayXpoints[1] = getEndPosition().x;
		arrayYpoints[0] = getStartPosition().y;
		arrayYpoints[1] = getEndPosition().y;
		arrayXpoints[2] = getEndPosition().x;
		arrayYpoints[2]=getStartPosition().y;
		g2D.drawPolygon(arrayXpoints, arrayYpoints , 3);
		

	}
	
}
