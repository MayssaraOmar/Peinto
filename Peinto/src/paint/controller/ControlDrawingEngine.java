package paint.controller;



import java.awt.event.MouseListener;

import java.awt.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import paint.model.Shape;
import paint.view.Canvas;
import paint.controller.*;

public class ControlDrawingEngine implements DrawingEngine {
	private Shape currentShape;
	private Shape currentSelectedShape;
	private ArrayList<Shape> shapes;
	private CanvasMouseAdapter canvasMouseAdapter;
	private DrawShapeMouseAdapter drawShapeMouseAdapter;
	private CopyMouseAdapter copyMouseAdapter;
	private DeleteMouseAdapter deleteMouseAdapter;
	

	private UndoRedoMouseAdapter undoRedoMouseAdapter;
	private Originator originator;
	private CareTaker careTaker;


	private ColorLabelMouseAdapter colorLabelMouseAdapter;
	private SelectMouseAdapter selectMouseAdapter;
	private ArrayList<Shape> selectedShapes;
	private static Color strokeColor = Color.BLACK;
	private static Color fillColor = Color.WHITE;
	private static boolean selected = false;
	private ArrayList<Shape> selectedArrayList = new ArrayList<Shape>();

	
	
	
	
	public DeleteMouseAdapter getDeleteMouseAdapter() {
		return deleteMouseAdapter;
	}
	public void setDeleteMouseAdapter(DeleteMouseAdapter deleteMouseAdapter) {
		this.deleteMouseAdapter = deleteMouseAdapter;
	}
	public ArrayList<Shape> getSelectedShapes() {
		return selectedShapes;
	}
	public void setSelectedShapes(ArrayList<Shape> selectedShapes) {
		this.selectedShapes = selectedShapes;
	}
	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}
	public ArrayList<Shape> getArrayListShapes(){
		return shapes;
	}
	public ArrayList<Shape> getSelectedArrayList() {
		return selectedArrayList;
	}
	public void setSelectedArrayList(ArrayList<Shape> selectedArrayList) {
		this.selectedArrayList = selectedArrayList;
	}

	
	public SelectMouseAdapter getSelectMouseAdapter() {
		return selectMouseAdapter;
	}
	public void setSelectMouseAdapter(SelectMouseAdapter selectMouseAdapter) {
		this.selectMouseAdapter = selectMouseAdapter;
	}

	public static boolean isSelected() {
		return selected;
	}
	public static void setSelected(boolean selected) {
		ControlDrawingEngine.selected = selected;
	}
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
	public CopyMouseAdapter getCopyMouseAdapter() {
		return copyMouseAdapter;
	}
	public void setCopyMouseAdapter(CopyMouseAdapter copyMouseAdapter) {
		this.copyMouseAdapter = copyMouseAdapter;
	}
	public ControlDrawingEngine() {
		this.currentShape = null;
		this.shapes = new ArrayList<Shape>();
		this.setCanvasMouseAdapter(new CanvasMouseAdapter (this));
		this.setDrawShapeMouseAdapter(new DrawShapeMouseAdapter (this));
		this.setCopyMouseAdapter(new CopyMouseAdapter (this));
		this.setDeleteMouseAdapter(new DeleteMouseAdapter (this));

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

		this.setColorLabelMouseAdapter(new ColorLabelMouseAdapter (this));
		this.setSelectMouseAdapter(new SelectMouseAdapter (this));

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
		if(getCurrentShape().getPosition() == null || properties.get("EndPositionX") == null || properties.get("EndPositionY") == null) 
			return;
		getCurrentShape().draw(canvas);	
	}
	
	public Shape getCurrentSelectedShape() {
		return currentSelectedShape;
	}
	public void setCurrentSelectedShape(Shape shape) {
		this.currentSelectedShape = shape;
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
	public void copy()
	{
		
		if(  state!=null && state.equalsIgnoreCase("Copying") )
		{
			for(int i=0; i< shapes.size() ; i++ )
			{
				try {
					if( shapes.get(i).getProperties().get("selected") == 1.0 )
					{
						currentShape = ((Shape)shapes.get(i).clone());
						Map<String, Double> properties = currentShape.getProperties();
						properties.put("selected", 0.0);
						currentShape.setProperties(properties);
						addShape(currentShape );
						currentShape = null;
						Canvas.getCanvas(this).repaint();
					}
			    } catch(Exception ex) {
					System.out.println("clone error");
				}
	         }
		}
	}
	public void delete() {
		if( state!=null && state.equalsIgnoreCase("Deletingw eltanya ") )
		{
			for(int i=0; i< shapes.size() ; i++ )
			{
				if( shapes.get(i).getProperties().get("selected") == 1.0)
				{
				removeShape(shapes.get(i));
				Canvas.getCanvas(this).repaint();
				}
			}
		}
	}

	@Override
	public void addShape(Shape shape) {
		shapes.add(shape);
		saveState();
	}

	@Override
	public void removeShape(Shape shape) {
		shapes.remove(shape);
		
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
