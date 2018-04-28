package paint.model;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.Map;

public class Triangle extends AbstractShape {
	Polygon triangle2D = null;

	public Triangle() {
		super();
		this.getProperties().put("selected", 0.0);
	}

	public void draw(Object canvas) {
		Map<String, Double> properties = getProperties();
		if (canvas == null || getPosition() == null || properties.get("EndPositionX") == null
				|| properties.get("EndPositionY") == null)
			return;
		Graphics2D g2D = (Graphics2D) canvas;
		((Graphics2D) g2D).setStroke(new BasicStroke(5));
		if (this.getProperties().get("selected") == 1.0) {
			float dash1[] = { 10.0f };
			BasicStroke dashed = new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1,
					0.0f);
			g2D.setStroke(dashed);

		}

		int[] arrayXpoints = new int[3];
		int[] arrayYpoints = new int[3];
		arrayXpoints[0] = getPosition().x;
		arrayXpoints[1] = properties.get("EndPositionX").intValue();
		arrayYpoints[0] = getPosition().y;
		arrayYpoints[1] = properties.get("EndPositionY").intValue();
		arrayXpoints[2] = properties.get("EndPositionX").intValue();
		arrayYpoints[2] = getPosition().y;

		// properties.put("SideLength", (double) sideLength);
		setProperties(properties);
		triangle2D = new Polygon(arrayXpoints, arrayYpoints, 3);

		g2D.setColor(this.getColor());
		g2D.draw(triangle2D);
		g2D.setColor(this.getFillColor());
		g2D.fill(triangle2D);

	}

	public boolean contains(double xx, double yy) {
		/*
		 * int[] arrayXpoints = new int[3]; int[] arrayYpoints = new int[3];
		 * arrayXpoints[0] = getPosition().x; arrayXpoints[1] =
		 * this.getProperties().get("EndPositionX").intValue(); arrayYpoints[0] =
		 * getPosition().y; arrayYpoints[1] =
		 * this.getProperties().get("EndPositionY").intValue(); arrayXpoints[2] =
		 * this.getProperties().get("EndPositionX").intValue();
		 * arrayYpoints[2]=getPosition().y; Polygon triangle2D = new Polygon(
		 * arrayXpoints, arrayYpoints , 3); return (triangle2D.contains(xx, yy));
		 */
		if (this.triangle2D == null)
			return false;
		return (this.triangle2D.contains(xx, yy));
	}
	/*
	 * public void drawS(Object canvas) {
	 * 
	 * Graphics2D g2D = (Graphics2D) canvas; int[] arrayXpoints = new int[3]; int[]
	 * arrayYpoints = new int[3]; arrayXpoints[0] = getPosition().x; arrayXpoints[1]
	 * = this.getProperties().get("EndPositionX").intValue(); arrayYpoints[0] =
	 * getPosition().y; arrayYpoints[1] =
	 * this.getProperties().get("EndPositionY").intValue(); arrayXpoints[2] =
	 * this.getProperties().get("EndPositionX").intValue();
	 * arrayYpoints[2]=getPosition().y; float dash1[] = {10.0f}; BasicStroke dashed
	 * = new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f,
	 * dash1, 0.0f);
	 * 
	 * g2D.setStroke(dashed); g2D.setColor(this.getColor());
	 * g2D.drawPolygon(arrayXpoints, arrayYpoints , 3);
	 * g2D.setColor(this.getFillColor()); g2D.fillPolygon(arrayXpoints, arrayYpoints
	 * , 3);
	 * 
	 * }
	 */

}
