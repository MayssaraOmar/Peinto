package paint.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import paint.model.ShapeFactory;

public class DrawShapeMouseAdapter implements MouseListener {

	private ControlDrawingEngine controlDrawingEngine;

	public DrawShapeMouseAdapter(ControlDrawingEngine controlDrawingEngine) {
		this.controlDrawingEngine = controlDrawingEngine;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		ShapeFactory shapeFactory = new ShapeFactory();
		String compName = e.getComponent().getName();
		if (compName.equalsIgnoreCase("line")) {
			controlDrawingEngine.setState("Drawing");
			controlDrawingEngine.setCurrentShape(shapeFactory.getShape("LineSegment"));
		} else if (compName.equalsIgnoreCase("rectangle")) {
			controlDrawingEngine.setState("Drawing");
			controlDrawingEngine.setCurrentShape(shapeFactory.getShape("rectangle"));
		} else if (compName.equalsIgnoreCase("square")) {
			controlDrawingEngine.setState("Drawing");
			controlDrawingEngine.setCurrentShape(shapeFactory.getShape("square"));
		} else if (compName.equalsIgnoreCase("circle")) {
			controlDrawingEngine.setState("Drawing");
			controlDrawingEngine.setCurrentShape(shapeFactory.getShape("circle"));
		} else if (compName.equalsIgnoreCase("ellipse")) {
			controlDrawingEngine.setState("Drawing");
			controlDrawingEngine.setCurrentShape(shapeFactory.getShape("ellipse"));
		} else if (compName.equalsIgnoreCase("triangle")) {
			controlDrawingEngine.setState("Drawing");
			controlDrawingEngine.setCurrentShape(shapeFactory.getShape("triangle"));
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
