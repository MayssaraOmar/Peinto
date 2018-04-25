package paint.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class UndoRedoMouseAdapter implements  MouseListener, MouseMotionListener {
	private ControlDrawingEngine controlDrawingEngine;
	public UndoRedoMouseAdapter(ControlDrawingEngine controlDrawingEngine){
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
		String compName = e.getComponent().getName();
		if(compName.equalsIgnoreCase("undo")) {
			controlDrawingEngine.undo();
		}
		else if(compName.equalsIgnoreCase("redo")) {
			controlDrawingEngine.redo();
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
