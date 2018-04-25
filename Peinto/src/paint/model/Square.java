package paint.model;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Map;


public class Square extends AbstractShape {

	public Square() {
		super();
	}

	public void draw(Object canvas) {
		
		Map<String,Double> properties = getProperties();
		
		if(canvas == null || getPosition() == null || properties.get("EndPositionX") == null || properties.get("EndPositionY") == null) 
			return;
		
		Graphics2D g2D  = (Graphics2D) canvas;
		
		int x = Math.min(getPosition().x, properties.get("EndPositionX").intValue());
		int y = Math.min(getPosition().y, properties.get("EndPositionY").intValue());
		int sideLength =  Math.abs(getPosition().x - properties.get("EndPositionX").intValue());
		((Graphics2D)g2D).setStroke(new BasicStroke(3));
		g2D.setColor(this.getColor());
	    g2D.drawRect(x, y, sideLength, sideLength);
	    g2D.setColor(this.getFillColor());
	    g2D.fillRect(x, y, sideLength, sideLength);
	    
	    properties.put("SideLength", (double) sideLength);
		setProperties(properties);
	 }
	
	public boolean contains(double xx, double yy)
	{
		Double sideLength = this.getProperties().get("SideLength");
		int x = Math.min(this.getPosition().x , this.getProperties().get("EndPositionX").intValue());
		int y = Math.min( this.getPosition().y ,this.getProperties().get("EndPositionY").intValue() );
		Rectangle2D square2d = new Rectangle2D.Double(x,y,sideLength,sideLength);
		return ( square2d.contains(xx, yy));
	}
	public void drawS(Object canvas)
	{
		Double sideLength = this.getProperties().get("SideLength");
		int x = Math.min(this.getPosition().x , this.getProperties().get("EndPositionX").intValue());
		int y = Math.min( this.getPosition().y ,this.getProperties().get("EndPositionY").intValue() );
		Graphics2D g2D  = (Graphics2D) canvas;
		float dash1[] = {10.0f};
	    BasicStroke dashed = new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);

			g2D.setStroke(dashed);
		g2D.setColor(this.getColor());
	   g2D.drawRect(x, y, sideLength.intValue(), sideLength.intValue());
	   g2D.setColor(this.getFillColor());
	    g2D.fillRect(x, y, sideLength.intValue(), sideLength.intValue());
	} 
}



