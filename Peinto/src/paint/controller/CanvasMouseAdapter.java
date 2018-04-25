package paint.controller;


import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;
import java.util.Map;

import paint.model.Shape;
import paint.view.Canvas;




public class CanvasMouseAdapter implements  MouseListener, MouseMotionListener {
	private Point startPoint = null, endPoint = null, midPoint = null;
	private ControlDrawingEngine controlDrawingEngine;
	
	public CanvasMouseAdapter(ControlDrawingEngine controlDrawingEngine){
		this.controlDrawingEngine = controlDrawingEngine;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		//if(Control.state.equalsIgnoreCase("ChooseShapeToDraw") && e.getComponent().) Control.state = "Drawing";
		//if(Control.state.equalsIgnoreCase("Drawing")) {
		if(controlDrawingEngine.getCurrentShape() == null) 
			return;
		startPoint = new Point(e.getPoint());
		controlDrawingEngine.getCurrentShape().setPosition(startPoint);
		controlDrawingEngine.getCurrentShape().setColor(controlDrawingEngine.getStrokeColor() );
		controlDrawingEngine.getCurrentShape().setFillColor(controlDrawingEngine.getFillColor());
		endPoint = new Point(e.getPoint());
		Map<String, Double> properties = controlDrawingEngine.getCurrentShape().getProperties();
		properties.put("EndPositionX", (double) endPoint.x);
		properties.put("EndPositionY", (double) endPoint.y);
		controlDrawingEngine.getCurrentShape().setProperties(properties);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(controlDrawingEngine.getCurrentShape() == null) 
			return;
		controlDrawingEngine.addShape(controlDrawingEngine.getCurrentShape());
		controlDrawingEngine.setCurrentShape(null);
	    Canvas.getCanvas(controlDrawingEngine).repaint();
	}

	

	@Override
	public void mouseDragged(MouseEvent e) {
		if(controlDrawingEngine.getCurrentShape() == null) 
			return;
		endPoint = new Point(e.getPoint());
		Map<String, Double> properties = controlDrawingEngine.getCurrentShape().getProperties();
		properties.put("EndPositionX", (double) endPoint.x);
		properties.put("EndPositionY", (double) endPoint.y);
		controlDrawingEngine.getCurrentShape().setProperties(properties);
        Canvas.getCanvas(controlDrawingEngine).repaint();	
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
