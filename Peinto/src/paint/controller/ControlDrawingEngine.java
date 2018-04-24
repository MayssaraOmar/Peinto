package paint.controller;


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import paint.model.Shape;

public class ControlDrawingEngine implements DrawingEngine {
	private Shape currentShape;
	private ArrayList<Shape> shapes;
	private CanvasMouseAdapter canvasMouseAdapter;
	private DrawShapeMouseAdapter drawShapeMouseAdapter;
	private ColorLabelMouseAdapter colorLabelMouseAdapter;
	private static Color strokeColor = Color.BLACK;
	private static Color fillColor = Color.WHITE;
	
	public ColorLabelMouseAdapter getColorLabelMouseAdapter() {
		return colorLabelMouseAdapter;
	}
	public void setColorLabelMouseAdapter(ColorLabelMouseAdapter colorLabelMouseAdapter) {
		this.colorLabelMouseAdapter = colorLabelMouseAdapter;
	}
	public static Color getStrokeColor() {
		return strokeColor;
	}
	public static void setStrokeColor(Color strokeColor) {
		ControlDrawingEngine.strokeColor = strokeColor;
	}
	public static Color getFillColor() {
		return fillColor;
	}
	public static void setFillColor(Color fillColor) {
		ControlDrawingEngine.fillColor = fillColor;
	}
	public ControlDrawingEngine() {
		this.currentShape = null;
		this.shapes = new ArrayList<Shape>();
		this.setCanvasMouseAdapter(new CanvasMouseAdapter (this));
		this.setDrawShapeMouseAdapter(new DrawShapeMouseAdapter (this));
		this.setColorLabelMouseAdapter(new ColorLabelMouseAdapter (this));
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
	@Override
	public void refresh(Object canvas) {
		System.out.println(shapes.size());
		for(Shape shape : shapes) {
			shape.draw(canvas);
		}	
	}
	@Override
	public void addShape(Shape shape) {
		shapes.add(shape);
		/*Map<String,Double> m = new HashMap<>();
		if(getCurrentShape()!=null) { 		m=getCurrentShape().getProperties();

		System.out.println(m.get("EndPositionX") + " " + m.get("EndPositionY") + " " + m.get("Radius"));}*/
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
