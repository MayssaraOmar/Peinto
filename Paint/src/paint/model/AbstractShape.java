package paint.model;

import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;


public abstract class AbstractShape implements Shape , Cloneable {
	private Point position;
	private Color color;
	private Color fillColor;
	private Map<String,Double> properties;
	@Override
	public void setPosition(Point position) {
		//if(properties.get("EndPositionX") == null || properties.get("EndPositionY") == null)
			this.position = position;
		/*else {
			this.position.x = Math.min(position.x, properties.get("EndPositionX").intValue());
			this.position.y = Math.min(position.y, properties.get("EndPositionY").intValue());
			System.out.println("GGGGGg");
		}*/
	}
	@Override
	public Point getPosition() {
		return position;
	}
	
	///////////////////////////////////
	public AbstractShape() {
		properties = new HashMap<>();
		properties.put("EndPositionX", null);
		properties.put("EndPositionY", null);
		color = Color.black;
		fillColor = Color.white;
	}
	
	/*public AbstractShape(Point position, Point positionNew) {
		this.setStartPosition(position);
		this.setEndPosition(positionNew);	
	}
	*/

	public Color getFillColor() {
		return fillColor;
	}
	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}
	public void setColor(Color color){
		 this.color = color;
	}
	public java.awt.Color getColor(){
		 return this.color;
	}
	/*public void setProperty(String propertyName, Double value) {
		properties.put(propertyName, value);
	}
	public Double getProperty(String propertyName) {
		return properties.get(propertyName);
	}*/
	public void setProperties(Map<String, Double> properties){
		this.properties = properties;
	}
	public Map<String, Double> getProperties(){
		return properties;
	}
	public Object clone() throws CloneNotSupportedException{
		return super.clone(); 
	}

	
}
