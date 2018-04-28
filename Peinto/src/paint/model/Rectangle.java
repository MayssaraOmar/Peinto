package paint.model;

import java.util.Map;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Rectangle extends AbstractShape {
	Rectangle2D rectangle2d = null;

	public Rectangle() {
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
		((Graphics2D) g2D).setStroke(new BasicStroke(3));
		if (this.getProperties().get("selected") == 1.0) {
			/*float dash1[] = { 10.0f };
			BasicStroke dashed = new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1,
					0.0f);
			g2D.setStroke(dashed);*/
			putSelectCorners(g2D, getPosition().x, getPosition().y, properties.get("EndPositionX").intValue(),
					properties.get("EndPositionY").intValue());


		}
		rectangle2d = new Rectangle2D.Double(x, y, width, height);
		g2D.setColor(this.getColor());
		g2D.draw(rectangle2d);
		// ((Graphics2D)g2D).draw(new Rectangle2D.Double(x, y, width, height));
		g2D.setColor(this.getFillColor());
		g2D.fill(rectangle2d);

		properties.put("Width", (double) width);
		properties.put("Height", (double) height);
		setProperties(properties);
	}

	public boolean contains(double xx, double yy) {
		if (rectangle2d == null)
			return false;
		return (rectangle2d.contains(xx, yy));
	}
	private void putSelectCorners(Graphics2D g2D, int x1, int y1, int x2, int y2) {
		
		
		g2D.fillRect(x1-10, y1-10, 10, 10);
		g2D.fillRect(x1-10, y2, 10, 10);
		g2D.fillRect(x2, y1-10, 10, 10);
		g2D.fillRect(x2, y2, 10, 10);

	}

}
