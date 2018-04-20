package paint.view;

import java.awt.Color;
import java.awt.Graphics;

import java.util.ArrayList;

import javax.swing.JPanel;

import paint.controller.CanvasMouseAdapter;

public class Canvas extends JPanel {

	ArrayList shapes =new ArrayList();
	
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
		addMouseListener(new CanvasMouseAdapter());
		addMouseMotionListener(new CanvasMouseAdapter());
	}
	
	@Override 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
       
    }
	
}
