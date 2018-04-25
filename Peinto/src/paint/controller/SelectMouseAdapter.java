package paint.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import paint.model.*;


import paint.model.ShapeFactory;
import paint.view.Canvas;

public class SelectMouseAdapter implements  MouseListener, MouseMotionListener {
	
	private ControlDrawingEngine controlDrawingEngine;
	  ArrayList<Shape> selectedShapesAL = new ArrayList<Shape>();
	public SelectMouseAdapter(ControlDrawingEngine controlDrawingEngine){
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
		
		if( controlDrawingEngine.isSelected() == true )
		{
			 Shape [] shapesTemp = controlDrawingEngine.getShapes();
			 
			for( int i=0; i< shapesTemp.length ; i++ )
			{
	             if(shapesTemp[i].contains(e.getX(), e.getY()) )
	             {
	            	 this.selectedShapesAL.add(shapesTemp[i]);
	            	 controlDrawingEngine.removeShape(shapesTemp[i]);
	            	controlDrawingEngine.setCurrentSelectedShape(shapesTemp[i]);
	            	 Canvas.getCanvas(controlDrawingEngine).repaint();
	             }
	                 
			}
			controlDrawingEngine.setSelectedArrayList(this.selectedShapesAL);
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
