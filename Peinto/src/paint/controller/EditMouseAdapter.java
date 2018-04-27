package paint.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import paint.view.Canvas;

public class EditMouseAdapter implements MouseListener {

	private ControlDrawingEngine controlDrawingEngine;

	public EditMouseAdapter(ControlDrawingEngine controlDrawingEngine) {
		this.controlDrawingEngine = controlDrawingEngine;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		String compName = e.getComponent().getName();
		if (compName == null)
			return;
		if (compName.equalsIgnoreCase("move")) {
			controlDrawingEngine.setState("Moving");
			System.out.println("move label selected");
		} 
		else if (compName.equalsIgnoreCase("delete")) {
			controlDrawingEngine.setState("Deleting");
			System.out.println("delete label selected");
			controlDrawingEngine.delete();
			Canvas.getCanvas(controlDrawingEngine).repaint();
		} 
		else if (compName.equalsIgnoreCase("copy")) {
			controlDrawingEngine.setState("Copying");
			System.out.println("copy label selected");
			controlDrawingEngine.copy();
			Canvas.getCanvas(controlDrawingEngine).repaint();
		} 
		else if (compName.equalsIgnoreCase("resize")) {
			controlDrawingEngine.setState("resizing");
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
