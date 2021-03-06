package paint.controller;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import paint.view.Canvas;

public class BasicCommandsMouseAdapter implements MouseListener, MouseMotionListener {
	private ControlDrawingEngine controlDrawingEngine;
	private Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
	private Cursor defaultCursor = new Cursor(Cursor.DEFAULT_CURSOR);

	public BasicCommandsMouseAdapter(ControlDrawingEngine controlDrawingEngine) {
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
		
		if (compName.equalsIgnoreCase("select")) {
			System.out.println("select label selected");
			controlDrawingEngine.setState("Selecting");
		} 
		else if (compName.equalsIgnoreCase("deselect")) {
			System.out.println("deselect label selected");
			controlDrawingEngine.setState("Deselecting");
		} 
		else if (compName.equalsIgnoreCase("undo")) {
			controlDrawingEngine.setState("Undoing");
			System.out.println("undo label selected");
			// must deselect all shapes
			controlDrawingEngine.deselectAll();
			controlDrawingEngine.undo();
			Canvas.getCanvas(controlDrawingEngine).revalidate();
			Canvas.getCanvas(controlDrawingEngine).repaint();
		} 
		else if (compName.equalsIgnoreCase("redo")) {
			controlDrawingEngine.setState("Redoing");
			System.out.println("redo label selected");
			// must deselect all shapes
			controlDrawingEngine.deselectAll();
			controlDrawingEngine.redo();
			Canvas.getCanvas(controlDrawingEngine).revalidate();
			Canvas.getCanvas(controlDrawingEngine).repaint();
		} 
		else if (compName.equalsIgnoreCase("deselectAll")) {
			controlDrawingEngine.setState("DeselectingAll");
			controlDrawingEngine.deselectAll();
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		e.getComponent().setCursor(handCursor);

	}

	@Override
	public void mouseExited(MouseEvent e) {
		e.getComponent().setCursor(defaultCursor);

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
