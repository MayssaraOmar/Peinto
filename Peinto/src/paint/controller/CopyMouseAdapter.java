package paint.controller;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Map;

import paint.model.Shape;
import paint.view.Canvas;

public class CopyMouseAdapter implements  MouseListener , MouseMotionListener{
		
		private ControlDrawingEngine controlDrawingEngine;
		public CopyMouseAdapter(ControlDrawingEngine controlDrawingEngine){
			this.controlDrawingEngine = controlDrawingEngine;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
		
			/* ArrayList<Shape> selectedShapesAL = controlDrawingEngine.getSelectedArrayList();
			if( controlDrawingEngine.isSelected() )
			{
				for(Shape shape: selectedShapesAL )
				{
					try {
					controlDrawingEngine.setCurrentShape((Shape)shape.clone());
					Map<String, Double> properties = controlDrawingEngine.getCurrentShape().getProperties();
					properties.put("selected", 0.0);
					controlDrawingEngine.getCurrentShape().setProperties(properties);
					controlDrawingEngine.addShape( controlDrawingEngine.getCurrentShape());
					controlDrawingEngine.setCurrentShape(null);
					Canvas.getCanvas(controlDrawingEngine).repaint();
					
					
			        
					} catch(Exception ex) {
						System.out.println("clone error");
					}
			  
				}
			} */
			controlDrawingEngine.copy();
			
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
