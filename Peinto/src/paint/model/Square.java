package paint.model;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Map;

public class Square extends AbstractShape {

	Rectangle2D square2d = null;

	public Square() {
		super();
		this.getProperties().put("selected", 0.0);
	}

	public void draw(Object canvas) {

		Map<String, Double> properties = getProperties();

		if (canvas == null || getPosition() == null || properties.get("EndPositionX") == null
				|| properties.get("EndPositionY") == null)
			return;

		Graphics2D g2D = (Graphics2D) canvas;

		g2D.setStroke(new BasicStroke(5));

		int x = Math.min(getPosition().x, properties.get("EndPositionX").intValue());
		int y = Math.min(getPosition().y, properties.get("EndPositionY").intValue());
		int sideLength = Math.abs(getPosition().x - properties.get("EndPositionX").intValue());
		properties.put("EndPositionY",
				(double) (getPosition().y - (getPosition().x - properties.get("EndPositionX").intValue())));

		square2d = new Rectangle2D.Double(x, y, sideLength, sideLength);
		if (this.getProperties().get("selected") == 1.0) {
			float dash1[] = { 10.0f };
			BasicStroke dashed = new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1,
					0.0f);
			g2D.setStroke(dashed);

		}

		g2D.setColor(this.getColor());
		g2D.draw(square2d);
		g2D.setColor(this.getFillColor());
		g2D.fill(square2d);

		properties.put("SideLength", (double) sideLength);
		setProperties(properties);
	}

	public boolean contains(double xx, double yy) {

		if (square2d == null)
			return false;
		return (square2d.contains(xx, yy));
	}

}
