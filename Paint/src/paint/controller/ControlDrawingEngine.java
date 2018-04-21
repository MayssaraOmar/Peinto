package paint.controller;


import java.util.List;

import paint.model.AbstractShape;
import paint.model.Shape;

public class ControlDrawingEngine implements DrawingEngine {
	
	@Override
	public void refresh(Object canvas) {
		System.out.println(Control.shapes.size());
		for(Shape shape : Control.shapes) {
			shape.draw(canvas);
		}
		
	}
	public void drawCurrentShape(Object canvas) {
		
		if(Control.currentShape == null || Control.currentShape.getStartPosition() == null || Control.currentShape.getEndPosition( )== null) return;
		
		Control.currentShape.draw(canvas);
		//Graphics g2D  = (Graphics2D) canvas;
		//g2D.drawLine(Control.startPoint.x, Control.startPoint.y, Control.endPoint.x, Control.endPoint.y);
	}

	@Override
	public void addShape(Shape shape) {
		Control.shapes.add((AbstractShape) shape);
	}

	@Override
	public void removeShape(Shape shape) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateShape(Shape oldShape, Shape newShape) {
		oldShape.getProperties().putAll( newShape.getProperties() ) ;
	}
	/*public void updateShape(Shape oldShape, Shape newShape) {
		oldShape.getProperties().putAll( newShape.getProperties() ) ;
	}*/

	@Override
	public Shape[] getShapes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(String path) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void load(String path) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Class<? extends Shape>> getSupportedShapes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void installPluginShape(String jarPath) {
		// TODO Auto-generated method stub
		
	}

}
