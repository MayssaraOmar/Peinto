package paint.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JColorChooser;

import paint.view.Canvas;

import java.awt.Color;

public class ColorLabelMouseAdapter implements  MouseListener , MouseMotionListener{
	
	private ControlDrawingEngine controlDrawingEngine;
	public ColorLabelMouseAdapter(ControlDrawingEngine controlDrawingEngine){
		this.controlDrawingEngine = controlDrawingEngine;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		String colorType = e.getComponent().getName();
		int flagFill=0, flagStroke=0;
		if( colorType.equalsIgnoreCase("stroke color") )
		{
			controlDrawingEngine.setStrokeColor( JColorChooser.showDialog(null, "Pick Stroke Color", controlDrawingEngine.getStrokeColor()));
			flagStroke = 1;
			if( controlDrawingEngine.getStrokeColor() == null) {
				controlDrawingEngine.setStrokeColor( Color.BLACK);
				flagStroke=0;
			}
		} else if( colorType.equalsIgnoreCase("fill color"))
		{
			controlDrawingEngine.setFillColor(JColorChooser.showDialog(null, "Pick Fill Color", controlDrawingEngine.getFillColor()) );
			flagFill=1;
			if( controlDrawingEngine.getFillColor() == null) {
				controlDrawingEngine.setFillColor(Color.WHITE );
				flagFill=0;
			}
		}
		if( flagStroke == 1) {
			controlDrawingEngine.changeStrokeColorOfSelectedShapes();
		}
		if( flagFill == 1) {
			controlDrawingEngine.changeFillColorOfSelectedShapes();
		}
		Canvas.getCanvas(controlDrawingEngine).repaint();
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
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
    }
}
