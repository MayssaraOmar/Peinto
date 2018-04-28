package paint.model;

import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSON implements SaveAndLoad {

	//public JSON() {
	//}

	@Override
	public void save(String path, ArrayList<Shape> shapes) {

		
		JSONObject jsonBigObject = new JSONObject();
		JSONObject JSONShape = new JSONObject();
		jsonBigObject.put("ShapesSize", Integer.toString(shapes.size()));
		
		 
		for (int i=0;i<shapes.size();i++) {
			Shape Oneshape=shapes.get(i);
          JSONShape= new JSONObject();
		JSONShape.put("Name", Oneshape.getClass().getCanonicalName());
		JSONShape.put("PositionX", Oneshape.getPosition().getX());
		JSONShape.put("PositionY", Oneshape.getPosition().getY());
		JSONShape.put("FillColor", (Oneshape.getFillColor() == null) ? null : Oneshape.getFillColor().getRGB());
		JSONShape.put("Color", (Oneshape.getColor() == null) ? null : Oneshape.getColor().getRGB());
		JSONShape.put("Properties", Oneshape.getProperties());
        jsonBigObject.put("" + i, JSONShape);

		}
		//jsonBigObject.put("" , JSONShape); // adding one json object to a larger json object "nested JSON object"

		try {
			FileWriter fileWriter = new FileWriter(path);
			fileWriter.write(jsonBigObject.toJSONString());
			fileWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	@Override
	public ArrayList<Shape> load(String path) {

		ArrayList<Shape> shapes = new ArrayList<Shape>();
		JSONParser jsonParser = new JSONParser();
		try {
			File file = new File(path);
			Object object = jsonParser.parse(new FileReader(file));
			JSONObject jsonObject = (JSONObject) object;
			int shapesSize = Integer.parseInt(((String) jsonObject.get("ShapesSize")));

			for (int i = 0; i < shapesSize; i++) {
				JSONObject JSONShape = (JSONObject) jsonObject.get(Integer.toString(i));
				Class<?> c = null;
				try {
					c = Class.forName((String) JSONShape.get("Name"));
				} catch (Exception e) {
				}
				if (c != null) {
					shapes.add(getShape(c, JSONShape));

				}
			}
		} catch (Exception e) {
		}
		return shapes;
	}

	Shape getShape(Class<?> c, JSONObject JSONShape) {
		Shape shape = null;
		try {
			shape = (Shape) c.newInstance();

			shape.setFillColor((JSONShape.get("FillColor") == null) ? null
					: new Color(((Number) JSONShape.get("FillColor")).intValue()));
			shape.setColor(
					(JSONShape.get("Color") == null) ? null : new Color(((Number) JSONShape.get("Color")).intValue()));
			shape.setProperties((Map<String, Double>) JSONShape.get("Properties"));
			shape.setPosition(new Point(((Number) JSONShape.get("PositionX")).intValue(),
					((Number) JSONShape.get("PositionY")).intValue()));
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return shape;

	}
}
	
