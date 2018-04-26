package paint.model;

import java.util.ArrayList;

public interface SaveAndLoad {
	public void save (String path, ArrayList<Shape> shapes);
	public ArrayList<Shape> load (String path);
}
