package paint.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Triangle extends AbstractShape{


	/*public Triangle(Point position, Point positionNew, Point thirdPoint) {
		super(position, positionNew);
		properties.put("thirdPointX", thirdPoint.getX()); //Triangle needs 3 points to be drawn which are position, positionNew and third point
		properties.put("thirdPointY", thirdPoint.getY());
		this.properties = properties;
	}*/

	public Triangle() {
		super();
	}

	public void draw(Object canvas)
	{
		Map<String,Double> properties = getProperties();
		if(canvas == null || getPosition() == null || properties.get("EndPositionX") == null || properties.get("EndPositionY") == null) 
			return;
		Graphics g2D  = (Graphics2D) canvas;
		
		int[] arrayXpoints = new int[3];
		int[] arrayYpoints = new int[3];
		arrayXpoints[0] = getPosition().x;
		arrayXpoints[1] = properties.get("EndPositionX").intValue();
		arrayYpoints[0] = getPosition().y;
		arrayYpoints[1] = properties.get("EndPositionY").intValue();
		arrayXpoints[2] = properties.get("EndPositionX").intValue();
		arrayYpoints[2]=getPosition().y;
		
		//properties.put("SideLength", (double) sideLength);
		setProperties(properties);
		g2D.drawPolygon(arrayXpoints, arrayYpoints , 3);
		

	}
	
}
