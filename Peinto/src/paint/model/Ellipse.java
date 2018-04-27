package paint.model;

import java.util.Map;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Ellipse extends AbstractShape {
	Ellipse2D oval2D = null;

	public Ellipse() {
		super();
		this.getProperties().put("selected", 0.0);
	}

	public void draw(Object canvas) {
		Map<String, Double> properties = getProperties();

		if (canvas == null || getPosition() == null || properties.get("EndPositionX") == null
				|| properties.get("EndPositionY") == null)
			return;

		Graphics2D g2D = (Graphics2D) canvas;

		int x = Math.min(getPosition().x, properties.get("EndPositionX").intValue());
		int y = Math.min(getPosition().y, properties.get("EndPositionY").intValue());
		int width = Math.abs(getPosition().x - properties.get("EndPositionX").intValue());
		int height = Math.abs(getPosition().y - properties.get("EndPositionY").intValue());
		g2D.setStroke(new BasicStroke(3));

		if (this.getProperties().get("selected") == 1.0) {
			float dash1[] = { 10.0f };
			BasicStroke dashed = new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1,
					0.0f);
			g2D.setStroke(dashed);

		}
		oval2D = new Ellipse2D.Double(x, y, width, height);
		g2D.setColor(this.getColor());
		g2D.draw(oval2D);
		g2D.setColor(this.getFillColor());
		g2D.fill(oval2D);

		properties.put("Width", (double) width);
		properties.put("Height", (double) height);
		setProperties(properties);
	}

	public boolean contains(double xx, double yy) {

		if (oval2D == null)
			return false;
		return (oval2D.contains(xx, yy));
	}
	/*
	 * public void drawS(Object canvas) { int x = Math.min(this.getPosition().x ,
	 * this.getProperties().get("EndPositionX").intValue()); int y = Math.min(
	 * this.getPosition().y ,this.getProperties().get("EndPositionY").intValue() );
	 * Graphics2D g2D = (Graphics2D) canvas; float dash1[] = {10.0f}; BasicStroke
	 * dashed = new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER,
	 * 10.0f, dash1, 0.0f);
	 * 
	 * g2D.setStroke(dashed); g2D.setColor(this.getColor()); g2D.drawOval(x,y,
	 * this.getProperties().get("Width").intValue(),
	 * this.getProperties().get("Height").intValue());
	 * g2D.setColor(this.getFillColor()); g2D.fillOval(x,y,
	 * this.getProperties().get("Width").intValue(),
	 * this.getProperties().get("Height").intValue());
	 * 
	 * }
	 */
}
