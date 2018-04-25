package paint.model;

import java.util.Map;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Circle extends AbstractShape{
	 
	public Circle() {
		super();
	}
	
	public void draw(Object canvas) {

		Map<String,Double> properties = getProperties();
		
		if(canvas == null || getPosition() == null || properties.get("EndPositionX") == null || properties.get("EndPositionY") == null) 
			return;
		
		Graphics2D g2D  = (Graphics2D) canvas;
		
		int x = Math.min(getPosition().x, properties.get("EndPositionX").intValue());
		int y = Math.min(getPosition().y, properties.get("EndPositionY").intValue());
		int radius =  Math.abs(getPosition().x - properties.get("EndPositionX").intValue());
		((Graphics2D)g2D).setStroke(new BasicStroke(3));
		g2D.setColor(this.getColor());
		g2D.drawOval(x, y, radius, radius);
		g2D.setColor(this.getFillColor());
		g2D.fillOval(x, y, radius, radius);
		
		properties.put("Radius", (double) radius);
		setProperties(properties);
	}
    
	public boolean contains(double xx, double yy)
	{
		int x = Math.min(this.getPosition().x , this.getProperties().get("EndPositionX").intValue());
		int y = Math.min( this.getPosition().y ,this.getProperties().get("EndPositionY").intValue() );
		Ellipse2D oval2D = new Ellipse2D.Double( x,y, this.getProperties().get("Radius"), this.getProperties().get("Radius"));
		return (oval2D.contains(xx, yy));
	}

	public void drawS(Object canvas)
	{
		int x = Math.min(this.getPosition().x , this.getProperties().get("EndPositionX").intValue());
		int y = Math.min( this.getPosition().y ,this.getProperties().get("EndPositionY").intValue() );
		Graphics2D g2D  = (Graphics2D) canvas;
		float dash1[] = {10.0f};
	    BasicStroke dashed = new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);

			g2D.setStroke(dashed);
		g2D.setColor(this.getColor());
		g2D.drawOval(x,y, this.getProperties().get("Radius").intValue(), this.getProperties().get("Radius").intValue());
		g2D.setColor(this.getFillColor());
		g2D.fillOval(x,y, this.getProperties().get("Radius").intValue(), this.getProperties().get("Radius").intValue());
		
	}
	

}
