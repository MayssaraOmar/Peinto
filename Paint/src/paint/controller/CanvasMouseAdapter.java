package paint.controller;


import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import paint.model.Shape;
import paint.view.Canvas;




public class CanvasMouseAdapter implements  MouseListener, MouseMotionListener {
	static Shape s;

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
		Control.startPoint = new Point(e.getPoint());
	
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
   	 	Control.startPoint = null;
   	 	Control.endPoint = null;

        //Canvas.getCanvas().repaint();	
	}

	

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		Control.endPoint = new Point(e.getPoint());
		 //Control.endPoint.setLocation();
         Canvas.getCanvas().repaint();
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
