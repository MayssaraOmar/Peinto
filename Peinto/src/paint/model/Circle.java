package paint.model;

import java.util.Map;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Circle extends AbstractShape {
	Ellipse2D oval2D = null;

	public Circle() {
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
		int radius = Math.abs(getPosition().x - properties.get("EndPositionX").intValue());

		properties.put("EndPositionY",
				(double) (getPosition().y - (getPosition().x - properties.get("EndPositionX").intValue())));
		g2D.setStroke(new BasicStroke(5));
		if (this.getProperties().get("selected") == 1.0) {

			float dash1[] = { 10.0f };
			BasicStroke dashed = new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1,
					0.0f);
			g2D.setStroke(dashed);

		}

		g2D.setColor(this.getColor());
		oval2D = new Ellipse2D.Double(x, y, radius, radius);
		((Graphics2D) g2D).draw(oval2D);
		g2D.setColor(this.getFillColor());

		((Graphics2D) g2D).fill(oval2D);

		properties.put("Radius", (double) radius);
		setProperties(properties);
	}

	public boolean contains(double xx, double yy) {
		if (oval2D == null)
			return false;
		return (oval2D.contains(xx, yy));
	}
}
