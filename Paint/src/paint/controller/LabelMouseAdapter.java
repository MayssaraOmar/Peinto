package paint.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import paint.model.AbstractShape;
import paint.model.Shape;

public class LabelMouseAdapter implements  MouseListener, MouseMotionListener  {

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
		// TODO Auto-generated method stub
		//Control.state="ChooseShapeToDraw";
		String compName = e.getComponent().getName();
		if(compName.equalsIgnoreCase("line")) {
			Control.currentShape =  Control.shapeFactory.getShape("LineSegment");
		}
		if(compName.equalsIgnoreCase("square")) {
			Control.currentShape =  Control.shapeFactory.getShape("rectangle");
		}
		if(compName.equalsIgnoreCase("square")) {
			Control.currentShape =  Control.shapeFactory.getShape("square");
		}
		if(compName.equalsIgnoreCase("circle")) {
			Control.currentShape =  Control.shapeFactory.getShape("circle");
		}
		if(compName.equalsIgnoreCase("line")) {
			Control.currentShape =  Control.shapeFactory.getShape("LineSegment");
		}
		if(compName.equalsIgnoreCase("ellipse")) {
			Control.currentShape =  Control.shapeFactory.getShape("ellipse");
		}
		if(compName.equalsIgnoreCase("triangle")) {
			Control.currentShape =  Control.shapeFactory.getShape("ellipse");
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

