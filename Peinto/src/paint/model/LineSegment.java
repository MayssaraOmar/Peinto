package paint.model;

import java.util.Map;


import java.awt.Graphics;
import java.awt.Graphics2D;

public class LineSegment extends AbstractShape{
	
	public LineSegment() {
		super();
	}
	
	public void draw(Object canvas){
		Map<String,Double> properties = getProperties();
		
		if(canvas == null || getPosition() == null || properties.get("EndPositionX") == null || properties.get("EndPositionY") == null) 
			return;
		
		Graphics g2D  = (Graphics2D) canvas;
		
		g2D.drawLine(getPosition().x, getPosition().y, properties.get("EndPositionX").intValue(), properties.get("EndPositionY").intValue());
	}
	

}
