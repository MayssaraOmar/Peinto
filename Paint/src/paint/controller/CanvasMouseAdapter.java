package paint.controller;


import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import paint.model.Shape;
import paint.view.Canvas;




public class CanvasMouseAdapter implements  MouseListener, MouseMotionListener {
	Point startPoint = null, endPoint = null, midPoint = null;

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
		// TODO Auto-generated method stub
		//if(Control.state.equalsIgnoreCase("ChooseShapeToDraw") && e.getComponent().) Control.state = "Drawing";
		//if(Control.state.equalsIgnoreCase("Drawing")) {
		if(Control.currentShape == null) return;
		startPoint = new Point(e.getPoint());
		//System.out.println(Control.startPoint.x);
		Control.currentShape.setStartPosition(startPoint);
		endPoint = new Point(e.getPoint());
		Control.currentShape.setEndPosition(endPoint);
		//}
	
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		//if(Control.state.equalsIgnoreCase("Drawing")) {
		if(Control.currentShape == null) return;
		Control.shapes.add(Control.currentShape);
			//Control.controlDrawingEngine.addShape((Shape)Control.currentShape);
			Control.currentShape = null;
	   	 	/*startPoint = null;
	   	 	endPoint = null;
	   	 	Control.currentShape.setPosition(startPoint);
			Control.currentShape.setPositionNew(endPoint);*/
	        Canvas.getCanvas().repaint();
		//}
	}

	

	@Override
	public void mouseDragged(MouseEvent e) {
		if(Control.currentShape == null) return;
		// TODO Auto-generated method stub
		//if(Control.state.equalsIgnoreCase("Drawing")) {
		endPoint = new Point(e.getPoint());
		Control.currentShape.setEndPosition(endPoint);
		 //updateShape(Control.currentShape, new  );
         Canvas.getCanvas().repaint();
		//}
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
