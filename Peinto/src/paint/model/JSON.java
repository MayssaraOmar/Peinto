/*package paint.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.sun.prism.paint.Color;

public class JSON implements SaveAndLoad {

	@Override
	public void save(String path, ArrayList<Shape> shapes) {
		
			 
			 JSONObject BigShapeObj = new JSONObject();
			 BigShapeObj.put("noOfShapes",""+shapes.size()); 
			 JSONObject shapeObj = new JSONObject();
			 for (int i=0; i<shapes.size() ;i++) {
				 shapeObj.put("Name", shapes.get(i).getClass().getCanonicalName());
				 //"#"+Integer.toHexString(your_color.getRGB()).substring(2);
				 shapeObj.put("Color",  "#"+Integer.toHexString(shapes.get(i).getColor().getRGB()).substring(2) );
			 //shapeObj.put("Color",  shapes.get(i).getColor());
			 //shapeObj.put("FillColor",  shapes.get(i).getFillColor());
				 shapeObj.put("FillColor",  "#"+Integer.toHexString(shapes.get(i).getColor().getRGB()).substring(2) );
			 shapeObj.put("PositionX",  shapes.get(i).getPosition().getX());
			 shapeObj.put("PositionY",  shapes.get(i).getPosition().getY());

			 shapeObj.put("Properties",  shapes.get(i).getProperties());
			 BigShapeObj.put(""+i,shapeObj); 
			 		 
		 } 
			 
			 
			 try {
		            
		            // Writing to a file
		            File file=new File(path);
		            file.createNewFile();
		            FileWriter fileWriter = new FileWriter(file);
		            
		            fileWriter.write(shapeObj.toJSONString());
		            System.out.println(shapeObj); //Same printing
		            fileWriter.flush();
		            fileWriter.close();
		 
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		  }


///////////////////////////////////////////////////////////////////////////////////




@Override
public ArrayList<Shape> load(String path) {
	// TODO Auto-generated method stub
	 ArrayList<Shape> arr = new ArrayList<Shape>();
	 JSONParser parser = new JSONParser();
	 try {
		 File file = new File(path);
		 Object obj = parser.parse(new FileReader(file));
		 
		   JSONObject jsonObject = (JSONObject) obj;
		   int size=Integer.parseInt(((String)jsonObject.get("noOfShapes")));
		   Shape[] shape = new Shape[] {} ; //it's different here
		   
		   //hena
		   for (int i=0;i<size;i++) {
		 	   
		 	   
		 	   
		 	   JSONObject jShapes= (JSONObject)jsonObject.get(i+"");
		 	   Class o=null;
		 	   try {
		 		   
		 		   o=Class.forName((String)jShapes.get("Name"));
		 		   	   
		 	   }

		 	   catch(Exception e) {}
		 	   if(o!=null) {
		 		   Shape s= (Shape) o.newInstance();
		 		  // s.setPosition(Position);
		 		   //java.awt.Color[r=255,g=255,b=255]
		 		   System.out.println(jShapes.get("Color").toString());
		 	  // s.setColor(new Color(jShapes.get("Color")));
		 		   //if(jShapes.get("FillColor")!=null)
		 			 //  s.setFillColor(new Color(((Color)jShapes.get("FillColor")).intValue()));
		 		   //s.setProperties((java.util.Map<String, Double>)jShapes.get("Properties"));
		 		   //s.setPosition(new properties  (((Number)jShapes.get("PositionX")).intValue(),((Number)jShapes.get("PositionY")).intValue()));
		 		   //arr.add(s);
		 		   
		 	   }
		   }
		   }
		   catch (FileNotFoundException e) {
		 	   e.printStackTrace();
		 	  } catch (IOException e) {
		 	   e.printStackTrace();
		 	  } 
		  catch (InstantiationException e) {
		 		// TODO Auto-generated catch block
		 		e.printStackTrace();
		 	} catch (IllegalAccessException e) {
		 		// TODO Auto-generated catch block
		 		e.printStackTrace();
		 	} catch (org.json.simple.parser.ParseException e1) {
		 		// TODO Auto-generated catch block
		 		e1.printStackTrace();
		 	}
		   
		  return arr;

		 }
			    
}
*/

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

	public JSON() {
	}

	@Override
	public void save(String path, ArrayList<Shape> shapes) {

		JSONObject jsonBigObject = new JSONObject();
		jsonBigObject.put("ShapesSize", Integer.toString(shapes.size()));

		for (Shape shape : shapes) {
			JSONObject jsonShape = getJSONShape(shape);
			jsonBigObject.put(Integer.toString(shapes.size() - 1), jsonShape);
		}
		writeJSONObjectToFile(path, jsonBigObject);

	}

	private JSONObject getJSONShape(Shape shape) {
		JSONObject JSONShape = new JSONObject();

		JSONShape.put("Name", shape.getClass().getCanonicalName());
		JSONShape.put("PositionX", shape.getPosition().getX());
		JSONShape.put("PositionY", shape.getPosition().getY());
		JSONShape.put("FillColor", (shape.getFillColor() == null) ? null : shape.getFillColor().getRGB());
		JSONShape.put("Color", (shape.getColor() == null) ? null : shape.getColor().getRGB());
		JSONShape.put("Properties", shape.getProperties());

		return JSONShape;
	}

	private void writeJSONObjectToFile(String path, JSONObject jsonBigObject) {

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
