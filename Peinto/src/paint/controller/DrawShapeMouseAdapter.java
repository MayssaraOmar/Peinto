package paint.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import paint.model.AbstractShape;
import paint.model.Shape;
import paint.model.ShapeFactory;

public class DrawShapeMouseAdapter implements  MouseListener, MouseMotionListener  {
	
	private ControlDrawingEngine controlDrawingEngine;
	public DrawShapeMouseAdapter(ControlDrawingEngine controlDrawingEngine){
		this.controlDrawingEngine = controlDrawingEngine;
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//Control.state="ChooseShapeToDraw";
		
		ShapeFactory shapeFactory = new ShapeFactory();
		String compName = e.getComponent().getName();
		if(compName.equalsIgnoreCase("line")) {
			controlDrawingEngine.setCurrentShape(shapeFactory.getShape("LineSegment"));
		}
		else if(compName.equalsIgnoreCase("rectangle")) {
			controlDrawingEngine.setCurrentShape(shapeFactory.getShape("rectangle"));
		}
		else if(compName.equalsIgnoreCase("square")) {
			controlDrawingEngine.setCurrentShape(shapeFactory.getShape("square"));
		}
		else if(compName.equalsIgnoreCase("circle")) {
			controlDrawingEngine.setCurrentShape(shapeFactory.getShape("circle"));
		}
		else if(compName.equalsIgnoreCase("ellipse")) {
			controlDrawingEngine.setCurrentShape(shapeFactory.getShape("ellipse"));
		}
		else if(compName.equalsIgnoreCase("triangle")) {
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

