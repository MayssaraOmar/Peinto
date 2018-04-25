package paint.model;

import java.util.Map;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class LineSegment extends AbstractShape{
	
	public LineSegment() {
		super();
	}
	
	public void draw(Object canvas){
		Map<String,Double> properties = getProperties();
		if(canvas == null || getPosition() == null || properties.get("EndPositionX") == null || properties.get("EndPositionY") == null) 
			return;
		Graphics2D g2D  = (Graphics2D) canvas;
		((Graphics2D)g2D).setStroke(new BasicStroke(3));
		g2D.setColor(this.getColor());
		g2D.drawLine(getPosition().x, getPosition().y, properties.get("EndPositionX").intValue(), properties.get("EndPositionY").intValue());
	}
	
	public boolean contains(double xx, double yy)
	{
		Line2D line = new Line2D.Double(this.getPosition().x , this.getPosition().y ,this.getProperties().get("EndPositionX").intValue(),this.getProperties().get("EndPositionY").intValue());
		double boxX = xx - 2/ 2;
		double boxY = yy- 2 / 2;

		int width = 2;
		int height = 2;
		return (line.intersects(boxX , boxY, width, height) ); 
		          
	}
	public void drawS(Object canvas)
	{
		Graphics2D g2D  = (Graphics2D) canvas;
		float dash1[] = {10.0f};
	    BasicStroke dashed = new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);

			g2D.setStroke(dashed);
		g2D.setColor(this.getColor());
		g2D.drawLine(this.getPosition().x , this.getPosition().y ,this.getProperties().get("EndPositionX").intValue(),this.getProperties().get("EndPositionY").intValue());
	   
	 
	} 

}
