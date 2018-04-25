package paint.controller;


import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import paint.model.Shape;
import paint.view.Canvas;

public class ControlDrawingEngine implements DrawingEngine {
	private Shape currentShape;
	private ArrayList<Shape> shapes;
	private CanvasMouseAdapter canvasMouseAdapter;
	private DrawShapeMouseAdapter drawShapeMouseAdapter;
	private UndoRedoMouseAdapter undoRedoMouseAdapter;
	private Originator originator;
	private CareTaker careTaker;

	
	public ControlDrawingEngine() {
		this.currentShape = null;
		this.shapes = new ArrayList<Shape>();
		this.setCanvasMouseAdapter(new CanvasMouseAdapter (this));
		this.setDrawShapeMouseAdapter(new DrawShapeMouseAdapter (this));
		this.setUndoRedoMouseAdapter(new UndoRedoMouseAdapter (this));
		this.setOriginator(new Originator());
		this.setCareTaker(new CareTaker());
		saveState();
	}
	public CareTaker getCareTaker() {
		return this.careTaker;
	}
	public void setCareTaker(CareTaker careTaker) {
		this.careTaker = careTaker;
	}
	public Originator getOriginator() {
		return this.originator;
	}
	public void setOriginator(Originator originator) {
		this.originator = originator;
	}
	public Shape getCurrentShape() {
		return this.currentShape;
	}
	public void setCurrentShape(Shape shape) {
		this.currentShape = shape;
	}
	public void drawCurrentShape(Object canvas) {
		if(getCurrentShape() == null ) 
			return;
		Map<String, Double> properties = getCurrentShape().getProperties();
		if(getCurrentShape().getPosition() == null || properties.get("EndPositionX") == null || properties.get("EndPositionX") == null) 
			return;
		getCurrentShape().draw(canvas);	
	}
	public CanvasMouseAdapter getCanvasMouseAdapter() {
		return canvasMouseAdapter;
	}
	public void setCanvasMouseAdapter(CanvasMouseAdapter canvasMouseAdapter) {
		this.canvasMouseAdapter = canvasMouseAdapter;
	}
	public DrawShapeMouseAdapter getDrawShapeMouseAdapter() {
		return drawShapeMouseAdapter;
	}
	public void setDrawShapeMouseAdapter(DrawShapeMouseAdapter drawShapeMouseAdapter) {
		this.drawShapeMouseAdapter = drawShapeMouseAdapter;
	}
	public UndoRedoMouseAdapter getUndoRedoMouseAdapter() {
		return undoRedoMouseAdapter;
	}
	public void setUndoRedoMouseAdapter(UndoRedoMouseAdapter undoRedoMouseAdapter) {
		this.undoRedoMouseAdapter = undoRedoMouseAdapter;
	}
	@Override
	public void refresh(Object canvas) {
		for(Shape shape : shapes) {
			shape.draw(canvas);
		}	
	}
	@Override
	public void addShape(Shape shape) {
		shapes.add(shape);
		saveState();
	}

	@Override
	public void removeShape(Shape shape) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateShape(Shape oldShape, Shape newShape) {
		oldShape.getProperties().putAll( newShape.getProperties() ) ;
	}
	
	@Override
	public Shape[] getShapes() {
		Shape[] shapesArray = shapes.toArray(new Shape[shapes.size()]);
		return shapesArray;
	}
	
	public void saveState() {
		if(shapes == null) 
			return;
		originator.setState(shapes);
		careTaker.addCurrent(originator.saveStateToMemento());
	}

	@Override
	public void undo() {
		originator.getStateFromMemento(careTaker.undo());
		shapes = (ArrayList<Shape>) originator.getState().clone();
		Canvas.getCanvas(this).revalidate();
		Canvas.getCanvas(this).repaint();
	}

	@Override
	public void redo() {
		originator.getStateFromMemento(careTaker.redo());
		shapes = (ArrayList<Shape>) originator.getState().clone();
		Canvas.getCanvas(this).revalidate();
		Canvas.getCanvas(this).repaint();
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
