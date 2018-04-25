package paint.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class EditMouseAdapter implements  MouseListener{
	
	private ControlDrawingEngine controlDrawingEngine;
	
	public EditMouseAdapter(ControlDrawingEngine controlDrawingEngine){
		this.controlDrawingEngine = controlDrawingEngine;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		String compName = e.getComponent().getName();
		if(compName == null)
			return;
		if(compName.equalsIgnoreCase("move")) {
			controlDrawingEngine.setState("Moving");
			System.out.println("moooove");
		}
		else if(compName.equalsIgnoreCase("delete")) {
			controlDrawingEngine.setState("Deleting");

		}
		else if(compName.equalsIgnoreCase("copy")) {
			controlDrawingEngine.setState("Copying");
		}
		else if(compName.equalsIgnoreCase("resize")) {
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
