package paint.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.JPanel;

import paint.controller.CanvasMouseAdapter;
import paint.controller.Control;
import paint.controller.ControlDrawingEngine;
import paint.model.Shape;

public class Canvas extends JPanel {

	
	// Singleton DP 
	private static Canvas canvasInstance = null;
	public static Canvas getCanvas() {
		if(canvasInstance == null)
			canvasInstance = new Canvas();
		return canvasInstance;
	}
	
	private Canvas(){
		super();
		super.setBackground(Color.WHITE);
		super.setBounds(143, 105, 623, 383);
		addMouseListener(ControlView.control.canvasMouseAdapter);
		addMouseMotionListener( ControlView.control.canvasMouseAdapter);
		
	}
	
	@Override 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		
		ControlView.control.controlDrawingEngine.refresh(g2D);
		ControlView.control.controlDrawingEngine.drawCurrentShape(g2D);
		// draw current 
    }
	
}
