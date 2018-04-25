package paint.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.JPanel;

import paint.controller.CanvasMouseAdapter;
import paint.controller.Control;
import paint.controller.ControlDrawingEngine;
import paint.model.Shape;

public class Canvas extends JPanel {

	private ControlDrawingEngine viewController = new ControlDrawingEngine();
	 float dash1[] = {10.0f};
	    BasicStroke dashed = new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);


	// Singleton DP 
	private static Canvas canvasInstance = null;
	public static Canvas getCanvas(ControlDrawingEngine viewController) {
		if(canvasInstance == null)
			canvasInstance = new Canvas(viewController);
		return canvasInstance;
	}
	
	private Canvas(ControlDrawingEngine viewController){
		super();
		super.setBackground(Color.WHITE);
		super.setBounds(143, 105, 623, 383);
		this.viewController = viewController;
		addMouseListener(viewController.getCanvasMouseAdapter());
		addMouseMotionListener(viewController.getCanvasMouseAdapter());
		addMouseListener(viewController.getSelectMouseAdapter());
		
	}
	
	@Override 
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2D.setRenderingHints(rh);
	//	if( viewController.isSelected())
		//{
			//private final float dash1[] = {10.0f};
		    //private final BasicStroke dashed = new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);
		  //  g2D.setStroke(dashed);
	//	}
		
		viewController.refresh(g2D);
		viewController.drawCurrentShape(g2D);
		//viewController.refreshSelected(g2D);
		//viewController.drawCurrentSelectedShape(g2D);
		// draw current 
    }
	
}
