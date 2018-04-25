package paint.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Map;

import paint.model.AbstractShape;
import paint.model.Shape;
import paint.view.Canvas;

public class DeleteMouseAdapter implements  MouseListener, MouseMotionListener {
	private ControlDrawingEngine controlDrawingEngine;
	 
	public DeleteMouseAdapter(ControlDrawingEngine controlDrawingEngine){
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
		
	/*	ArrayList<Shape> selectedShapesAL = controlDrawingEngine.getSelectedArrayList();
		if( controlDrawingEngine.isSelected() )
		{
			for(Shape shape: selectedShapesAL )
			{
				controlDrawingEngine.removeShape(shape);
				Canvas.getCanvas(controlDrawingEngine).repaint();
			}
		} */
		controlDrawingEngine.delete();
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
