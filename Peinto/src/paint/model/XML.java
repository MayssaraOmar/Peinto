package paint.model;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class XML implements SaveAndLoad {

	@Override
	public void save(String path, ArrayList<Shape> shapes) {
		try {
		
			FileOutputStream fos = new FileOutputStream(new File(path)); // user will write it in file chooser
			XMLEncoder encoder = new XMLEncoder(fos);
			encoder.writeObject(shapes);
			encoder.close();
			fos.close();
			//System.out.println("SAVE" + arrayOfShapes[0].getProperties().get("EndPositionX"));
			
		} catch (IOException ex) {

			ex.printStackTrace();

		}
		
	}

	@Override
	public ArrayList<Shape> load (String path) {
		ArrayList<Shape> shapes = new  ArrayList<Shape>();
		try {
			FileInputStream fis = new FileInputStream(new File(path)); //should use path here
			XMLDecoder decoder = new XMLDecoder (fis);
			shapes = (ArrayList<Shape>) decoder.readObject();
			decoder.close();

			fis.close();
			//System.out.println(shapes.size());
			//System.out.println("LOAD" + shapes.get(0).getProperties().get("EndPositionX"));
		} catch (IOException ex) {

			ex.printStackTrace();

		}
		return shapes;
	}

}
