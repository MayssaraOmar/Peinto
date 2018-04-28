package paint.model;

import java.util.Map;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class LineSegment extends AbstractShape {
	Line2D line = null;

	public LineSegment() {
		super();
		this.getProperties().put("selected", 0.0);
	}

	public void draw(Object canvas) {
		Map<String, Double> properties = getProperties();
		if (canvas == null || getPosition() == null || properties.get("EndPositionX") == null
				|| properties.get("EndPositionY") == null)
			return;
		Graphics2D g2D = (Graphics2D) canvas;
		g2D.setStroke(new BasicStroke(3));
		if (this.getProperties().get("selected") == 1.0) {
			float dash1[] = { 10.0f };
			BasicStroke dashed = new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1,
					0.0f);
			g2D.setStroke(dashed);

		}
		line = new Line2D.Double(this.getPosition().x, this.getPosition().y,
				this.getProperties().get("EndPositionX").intValue(),
				this.getProperties().get("EndPositionY").intValue());

		g2D.setColor(this.getColor());
		g2D.draw(line);
	}

	public boolean contains(double xx, double yy) {

		double boxX = xx - 3 / 2;
		double boxY = yy - 3 / 2;

		int width = 2;
		int height = 2;
		if (line == null)
			return false;
		return (line.intersects(boxX, boxY, width, height));

	}

}
