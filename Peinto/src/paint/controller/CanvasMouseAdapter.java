package paint.controller;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import paint.view.Canvas;

public class CanvasMouseAdapter implements MouseListener, MouseMotionListener {
	private Point startPoint = null, endPoint = null, mousePoint = null;
	private ControlDrawingEngine controlDrawingEngine;

	public CanvasMouseAdapter(ControlDrawingEngine controlDrawingEngine) {
		this.controlDrawingEngine = controlDrawingEngine;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (controlDrawingEngine.getState() == null)
			return;
		if (controlDrawingEngine.getState().equalsIgnoreCase("Selecting")) {
			controlDrawingEngine.select(e.getX(), e.getY());
		} else if (controlDrawingEngine.getState().equalsIgnoreCase("Deselecting")) {
			controlDrawingEngine.deselect(e.getX(), e.getY());
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
	public void mousePressed(MouseEvent e) {
		if (controlDrawingEngine.getState() == null)
			return;
		if (controlDrawingEngine.getState().equalsIgnoreCase("Drawing")) {
			
			if (controlDrawingEngine.getCurrentShape() == null)
				return;
			
			startPoint = new Point(e.getPoint());
			controlDrawingEngine.getCurrentShape().setPosition(startPoint);
			endPoint = new Point(e.getPoint());
			controlDrawingEngine.getCurrentShape().getProperties().put("EndPositionX", (double) endPoint.x);
			controlDrawingEngine.getCurrentShape().getProperties().put("EndPositionY", (double) endPoint.y);
		} 
		else if (controlDrawingEngine.getState().equalsIgnoreCase("Moving")) {
	
			mousePoint = new Point(e.getPoint());
		} 
		else if (controlDrawingEngine.getState().equalsIgnoreCase("resizing")) {
			mousePoint = new Point(e.getPoint());
			controlDrawingEngine.saveState();
			controlDrawingEngine.resize(e.getX(), e.getY(), e.getX(), e.getY());
		}
		Canvas.getCanvas(controlDrawingEngine).repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		if (controlDrawingEngine.getState() == null)
			return;
		
		if (controlDrawingEngine.getState().equalsIgnoreCase("Drawing")) {

			if (controlDrawingEngine.getCurrentShape() == null)
				return;
			controlDrawingEngine.addShape(controlDrawingEngine.getCurrentShape());
			controlDrawingEngine.setCurrentShape(null);
		} 
		else if (controlDrawingEngine.getState().equalsIgnoreCase("Moving")) {
			
			if (mousePoint == null)
				return;
			
			controlDrawingEngine.move(e.getX(), e.getY(), mousePoint);
			mousePoint = e.getPoint();
			controlDrawingEngine.saveState();

		} 
		else if (controlDrawingEngine.getState().equalsIgnoreCase("resizing")) {
			
			if (mousePoint == null)
				return;
			
			controlDrawingEngine.resize(mousePoint.getX(), mousePoint.getY(), e.getX(), e.getY());
			controlDrawingEngine.saveState();
		}
		Canvas.getCanvas(controlDrawingEngine).repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (controlDrawingEngine.getState() == null)
			return;
		if (controlDrawingEngine.getState().equalsIgnoreCase("Drawing")) {

			if (controlDrawingEngine.getCurrentShape() == null)
				return;
			endPoint = new Point(e.getPoint());
			controlDrawingEngine.getCurrentShape().getProperties().put("EndPositionX", (double) endPoint.x);
			controlDrawingEngine.getCurrentShape().getProperties().put("EndPositionY", (double) endPoint.y);

		} else if (controlDrawingEngine.getState().equalsIgnoreCase("Moving")) {
			if (mousePoint == null)
				return;
			controlDrawingEngine.move(e.getX(), e.getY(), mousePoint);
			mousePoint = e.getPoint();
		} else if (controlDrawingEngine.getState().equalsIgnoreCase("resizing")) {

			if (mousePoint == null)
				return;
			controlDrawingEngine.resize(mousePoint.getX(), mousePoint.getY(), e.getX(), e.getY());
		}
		Canvas.getCanvas(controlDrawingEngine).repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
