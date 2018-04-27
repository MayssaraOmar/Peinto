package paint.controller;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import paint.model.JSON;
import paint.model.Shape;
import paint.model.XML;
import paint.view.Canvas;

public class ControlDrawingEngine implements DrawingEngine {
	private Shape currentShape;
	private ArrayList<Shape> shapes;
	private CanvasMouseAdapter canvasMouseAdapter;
	private DrawShapeMouseAdapter drawShapeMouseAdapter;
	private BasicCommandsMouseAdapter basicCommandsMouseAdapter;
	private SaveAndLoadActionListener saveAndLoadActionListener;
	private Originator originator;
	private CareTaker careTaker;
	private ColorLabelMouseAdapter colorLabelMouseAdapter;
	private EditMouseAdapter editMouseAdapter;
	private static Color strokeColor = Color.BLACK;
	private static Color fillColor = Color.WHITE;
	private String state = null;

	public ControlDrawingEngine() {
		this.currentShape = null;
		this.shapes = new ArrayList<Shape>();
		this.setCanvasMouseAdapter(new CanvasMouseAdapter(this));
		this.setDrawShapeMouseAdapter(new DrawShapeMouseAdapter(this));
		this.setBasicCommandsMouseAdapter(new BasicCommandsMouseAdapter(this));
		this.setColorLabelMouseAdapter(new ColorLabelMouseAdapter(this));
		this.setEditMouseAdapter(new EditMouseAdapter(this));
		this.setSaveAndLoadActionListener(new SaveAndLoadActionListener(this));
		this.setOriginator(new Originator());
		this.setCareTaker(new CareTaker());
		saveState();
	}

	@Override
	public void refresh(Object canvas) {
		for (Shape shape : shapes) {
			shape.draw(canvas);
		}
	}

	public void drawCurrentShape(Object canvas) {
		if (getCurrentShape() == null)
			return;
		Map<String, Double> properties = getCurrentShape().getProperties();
		if (getCurrentShape().getPosition() == null || properties.get("EndPositionX") == null
				|| properties.get("EndPositionY") == null)
			return;
		getCurrentShape().setColor(strokeColor);
		getCurrentShape().setFillColor(fillColor);
		getCurrentShape().draw(canvas);
	}

	public void copy() {
		int flag = 0;
		if (state != null && state.equalsIgnoreCase("Copying")) {
			for (int i = 0; i < shapes.size(); i++) {
				try {
					if (shapes.get(i).getProperties().get("selected") == 1.0) {
						if (flag == 0) {
							this.saveState();
						}
						flag = 2;
						currentShape = ((Shape) shapes.get(i).clone());
						Map<String, Double> propertiesOriginal = currentShape.getProperties();
						Map<String, Double> properties = new HashMap<String, Double>();

						for (Map.Entry<String, Double> entry : propertiesOriginal.entrySet()) {
							properties.put(entry.getKey(), entry.getValue());
						}
						properties.put("selected", 0.0);
						currentShape.setProperties(properties);
						addShape(currentShape);
						currentShape = null;
						// Canvas.getCanvas(this).repaint();
					}
				} catch (Exception ex) {
					System.out.println("clone error");
				}
			}
		}
	}

	public void delete() {
		int flag = 0;
		if (state != null && state.equalsIgnoreCase("Deleting")) {
			for (int i = 0; i < shapes.size(); i++) {
				System.out.println(shapes.size());
				if (shapes.get(i).getProperties().get("selected") == 1.0) {
					if (flag == 0)
						this.saveState();
					flag = 2;
					removeShape(shapes.get(i));
					i--;
				}
			}
		}
	}

	public void resize(double xx, double yy, double xDragged, double yDragged) {
		if (state != null && state.equalsIgnoreCase("resizing")) {
			for (int i = 0; i < shapes.size(); i++) {
				if (shapes.get(i).getProperties().get("selected") == 1.0) {
					shapes.get(i).getProperties().put("EndPositionX", xDragged);
					shapes.get(i).getProperties().put("EndPositionY", yDragged);

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
		oldShape.getProperties().putAll(newShape.getProperties());
	}

	@Override
	public Shape[] getShapes() {
		Shape[] shapesArray = shapes.toArray(new Shape[shapes.size()]);
		return shapesArray;
	}

	public void saveState() {
		System.out.println("Save State");
		if (shapes == null)
			return;

		originator.setState(shapes);
		careTaker.addCurrent(originator.saveStateToMemento());
	}

	@Override
	public void undo() {
		Invoker invoker = new Invoker(new UndoCommand(originator, careTaker));
		shapes = invoker.executeCommand();
		// originator.getStateFromMemento(careTaker.undo());
		// shapes = originator.getState();
		// Canvas.getCanvas(this).revalidate();
		// Canvas.getCanvas(this).repaint();
	}

	@Override
	public void redo() {
		Invoker invoker = new Invoker(new RedoCommand(originator, careTaker));
		shapes = invoker.executeCommand();
		// originator.getStateFromMemento(careTaker.redo());
		// shapes = (ArrayList<Shape>) originator.getState().clone();
		// shapes = originator.getState();
		// Canvas.getCanvas(this).revalidate();
		// Canvas.getCanvas(this).repaint();
	}

	public void select(int x, int y) {
		if (state != null && state.equalsIgnoreCase("Selecting")) {
			for (int i = (shapes.size() - 1); i >= 0; i--) {
				if (shapes.get(i).contains(x, y)) {
					shapes.get(i).getProperties().put("selected", 1.0);
					Canvas.getCanvas(this).repaint();
					break;
				}
			}
		}
	}

	public void selectAll() {
		if (state != null && state.equalsIgnoreCase("Selecting")) {
			for (Shape shape : shapes) {
				shape.getProperties().put("selected", 1.0);
				Canvas.getCanvas(this).repaint();
			}
		}
	}

	public void deselect(int x, int y) {
		for (Shape shape : shapes) {
			if (shape.contains(x, y)) {
				shape.getProperties().put("selected", 0.0);
				Canvas.getCanvas(this).repaint();
			}
		}

	}

	public void deselectAll() {
		for (Shape shape : shapes) {
			shape.getProperties().put("selected", 0.0);
			Canvas.getCanvas(this).repaint();
		}

	}

	public void move(int x, int y, Point mousePoint) {
		if (state != null && state.equalsIgnoreCase("moving")) {
			int dx = x - mousePoint.x;
			int dy = y - mousePoint.y;
			for (Shape shape : shapes) {
				if (shape.getProperties().get("selected") == 1.0) {
					int posX = shape.getPosition().x;
					int posY = shape.getPosition().y;
					shape.setPosition(new Point(posX + dx, posY + dy));
					Double currX = shape.getProperties().get("EndPositionX");
					Double currY = shape.getProperties().get("EndPositionY");
					shape.getProperties().put("EndPositionX", currX + dx);
					shape.getProperties().put("EndPositionY", currY + dy);
					// Canvas.getCanvas(this).repaint();
				}
			}
		}
	}

	@Override
	public void save(String path) {
		if (path == null)
			return;
		String extension = path.substring(path.lastIndexOf(".") + 1);
		if (extension == null)
			return;
		if (extension.equals("xml")) {
			XML xml = new XML();
			xml.save(path, shapes);
		} else if (extension.equals("json")) {
			JSON json = new JSON();
			json.save(path, shapes);
		}

	}

	@Override
	public void load(String path) {
		if (path == null)
			return;
		String extension = path.substring(path.lastIndexOf(".") + 1);
		if (extension == null)
			return;
		if (extension.equals("xml")) {
			XML xml = new XML();
			shapes = xml.load(path);
			careTaker.clearUndoRedo();
		} else if (extension.equals("json")) {
			JSON json = new JSON();
			shapes = json.load(path);
			careTaker.clearUndoRedo();
		}
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

	// Setters and Getters
	public ColorLabelMouseAdapter getColorLabelMouseAdapter() {
		return colorLabelMouseAdapter;
	}

	public void setColorLabelMouseAdapter(ColorLabelMouseAdapter colorLabelMouseAdapter) {
		this.colorLabelMouseAdapter = colorLabelMouseAdapter;
	}

	public Color getStrokeColor() {
		return strokeColor;
	}

	public void setStrokeColor(Color strokeColor) {
		ControlDrawingEngine.strokeColor = strokeColor;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		ControlDrawingEngine.fillColor = fillColor;
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

	public BasicCommandsMouseAdapter getBasicCommandsMouseAdapter() {
		return basicCommandsMouseAdapter;
	}

	public void setBasicCommandsMouseAdapter(BasicCommandsMouseAdapter basicCommandsMouseAdapter) {
		this.basicCommandsMouseAdapter = basicCommandsMouseAdapter;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public EditMouseAdapter getEditMouseAdapter() {
		return editMouseAdapter;
	}

	public void setEditMouseAdapter(EditMouseAdapter editMouseAdapter) {
		this.editMouseAdapter = editMouseAdapter;
	}

	public void changeStrokeColorOfSelectedShapes() {
		for (Shape shape : shapes) {
			if (shape.getProperties().get("selected") == 1.0) {
				shape.setColor(strokeColor);
			}
		}
	}

	public void changeFillColorOfSelectedShapes() {
		for (Shape shape : shapes) {
			if (shape.getProperties().get("selected") == 1.0) {
				shape.setFillColor(fillColor);
			}
		}
	}

	public SaveAndLoadActionListener getSaveAndLoadActionListener() {
		return saveAndLoadActionListener;
	}

	public void setSaveAndLoadActionListener(SaveAndLoadActionListener saveAndLoadActionListener) {
		this.saveAndLoadActionListener = saveAndLoadActionListener;
	}

}
