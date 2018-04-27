package paint.view;


import paint.controller.CanvasMouseAdapter;
import paint.controller.Control;
import paint.controller.ControlDrawingEngine;
import paint.model.Shape;
import paint.controller.ColorLabelMouseAdapter;

import paint.controller.ControlDrawingEngine;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PaintWindow {
	
	private ControlDrawingEngine viewController = new ControlDrawingEngine();
	private JFrame frame;
	private Canvas canvas = Canvas.getCanvas(viewController);
	private final JLabel lblLine = new JLabel("Line");
	private final JLabel lblPeinto = new JLabel("Peinto");
	private final JLabel lblRectangle = new JLabel("rectangle");
	private final JLabel lblCircle = new JLabel("circle");
	private final JLabel lblSquare = new JLabel("Square");
	private final JLabel lblEllipse = new JLabel("Ellipse");
	private final JLabel lblTriangle = new JLabel("Triangle");
	private final JLabel lblRedo = new JLabel("redo");
	private final JLabel lblUndo = new JLabel("undo");
  private final JLabel lblStrokeColor = new JLabel("set stroke color");
  private final JLabel lblfillColor = new JLabel("set fill color");
  private final JLabel lblMove = new JLabel("move");
  private final JLabel lblSelect = new JLabel("select");
  private final JLabel lblDeselect = new JLabel("deselect");
  private final JLabel lblCopy = new JLabel("copy");
  private final JLabel lblResize = new JLabel("resize");
  private final JLabel lblDelete = new JLabel("delete");
  private final JButton btnNewButton = new JButton("New button");
  private final JButton btnNewButton_1 = new JButton("New button");
    
    



	/**
	 * Create the application.
	 */
	public PaintWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 796, 559);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		canvas.setLocation(143, 98);
		frame.getContentPane().add(canvas);
		
		lblLine.addMouseListener(viewController.getDrawShapeMouseAdapter());
		lblLine.setBounds(39, 183, 56, 16);
		lblLine.setName("Line");
		
		frame.getContentPane().add(lblLine);
		lblPeinto.setBounds(77, 37, 56, 16);
		frame.getContentPane().add(lblPeinto);
		
		lblRectangle.addMouseListener(viewController.getDrawShapeMouseAdapter());
		lblRectangle.setName("rectangle");
		lblRectangle.setBounds(39, 212, 71, 16);
		frame.getContentPane().add(lblRectangle);
		
		lblCircle.addMouseListener(viewController.getDrawShapeMouseAdapter());
		lblCircle.setName("circle");
		lblCircle.setBounds(39, 270, 71, 16);
		frame.getContentPane().add(lblCircle);
		
		lblSquare.addMouseListener(viewController.getDrawShapeMouseAdapter());
		lblSquare.setName("square");
		lblSquare.setBounds(39, 297, 71, 16);
		frame.getContentPane().add(lblSquare);
		
		lblEllipse.addMouseListener(viewController.getDrawShapeMouseAdapter());
		lblEllipse.setName("Ellipse");
		lblEllipse.setBounds(39, 326, 71, 16);
		frame.getContentPane().add(lblEllipse);
		
		lblTriangle.addMouseListener(viewController.getDrawShapeMouseAdapter());
		lblTriangle.setName("triangle");
		lblTriangle.setBounds(39, 241, 71, 16);
		frame.getContentPane().add(lblTriangle);
	
		lblRedo.addMouseListener(viewController.getBasicCommandsMouseAdapter());
		lblRedo.setName("redo");
		lblRedo.setBounds(26, 88, 56, 16);
		frame.getContentPane().add(lblRedo);
		
		lblUndo.addMouseListener(viewController.getBasicCommandsMouseAdapter());
		lblUndo.setName("undo");
		lblUndo.setBounds(77, 88, 56, 16);
		frame.getContentPane().add(lblUndo);
		
		
		lblStrokeColor.setBounds(39, 351, 94, 14);
		lblStrokeColor.addMouseListener(viewController.getColorLabelMouseAdapter());
		lblStrokeColor.setName("stroke color");
		frame.getContentPane().add(lblStrokeColor);
		
		
		lblfillColor.setBounds(39, 378, 94, 14);
		lblfillColor.addMouseListener(viewController.getColorLabelMouseAdapter() );
		lblfillColor.setName("fill color");
		frame.getContentPane().add(lblfillColor);
		
		lblSelect.addMouseListener(viewController.getBasicCommandsMouseAdapter());
		lblSelect.setName("select");
		lblSelect.setBounds(39, 405, 56, 16);
		frame.getContentPane().add(lblSelect);
		
		lblDeselect.addMouseListener(viewController.getBasicCommandsMouseAdapter());
		lblDeselect.setName("deselect");
		lblDeselect.setBounds(39, 434, 56, 16);
		frame.getContentPane().add(lblDeselect);
    
    lblMove.addMouseListener(viewController.getEditMouseAdapter());
		lblMove.setBounds(39, 476, 46, 14);
		lblMove.setName("move");
		frame.getContentPane().add(lblMove);
    
    lblCopy.addMouseListener(viewController.getEditMouseAdapter());
    lblCopy.setBounds(75, 463, 46, 14);
    lblCopy.setName("copy");
		frame.getContentPane().add(lblCopy);
		
    lblResize.addMouseListener(viewController.getEditMouseAdapter());
    lblResize.setBounds(39, 158, 46, 14);
    lblResize.setName("resize");
		frame.getContentPane().add(lblResize);
		
	    lblDelete.addMouseListener(viewController.getEditMouseAdapter());
		lblDelete.setName("delete");
		lblDelete.setBounds(77, 496, 56, 16);
		frame.getContentPane().add(lblDelete);
		
		
	///////////////////////////////////////	
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jFileChooser1 = new javax.swing.JFileChooser();

				FileNameExtensionFilter jarFilter = new FileNameExtensionFilter("JAR files", "jar");
		        jFileChooser1.setFileFilter(jarFilter);
		        jFileChooser1.showOpenDialog(null);
		        File pluginFile = jFileChooser1.getSelectedFile();
		        String qualifiedClassName = javax.swing.JOptionPane.showInputDialog("Enter Qualified Class Name: ");
		        System.out.println(qualifiedClassName);
		        
		        
		       try { 	
		      /*  String pathToJar =  jFileChooser1.getSelectedFile().getAbsolutePath();
		        JarFile jarFile;
				
					jarFile = new JarFile(pathToJar);
				
		        Enumeration<JarEntry> e = jarFile.entries();

		        URL[] urls = { new URL("jar:file:" + pathToJar+"!/") };
		        URLClassLoader cl = URLClassLoader.newInstance(urls);

				while (e.hasMoreElements()) {
				    JarEntry je = e.nextElement();
				    if(je.isDirectory() || !je.getName().endsWith(".class")){
				        continue;
				    }
				    // -6 because of .class
				    String className = je.getName().substring(0,je.getName().length()-6);
				    className = className.replace('/', '.');
				    Class c = cl.loadClass(className);
		            System.out.println(viewController.getSupportedShapes().size());

				    viewController.installPluginShape(c);
		            System.out.println(viewController.getSupportedShapes().size());
 jarFile.close();*/
				
				//}

		            URL url = pluginFile.toURL();

		            URL[] urls = new URL[]{url};

		            ClassLoader loader = new URLClassLoader(urls);

		            Class myClass = Class.forName(qualifiedClassName, true, loader);
System.out.println("YARAB");
		            viewController.installPluginShape(myClass);
		            System.out.println(viewController.getSupportedShapes().size());

		            //jComboBox2.removeAllItems();
		            viewController.getSupportedShapes().forEach((supportedShape) -> {
		                //jComboBox2.addItem(supportedShape);
		            	
		            });
		          
		        } catch (MalformedURLException | ClassNotFoundException e) {}
		       catch (IOException e1) {e1.printStackTrace();}
			}
		});
		btnNewButton.setBounds(199, 33, 97, 25);
		frame.getContentPane().add(btnNewButton);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
			            Constructor<? extends Shape> constructor =  viewController.getSupportedShapes().get(0).getDeclaredConstructor();
			            constructor.setAccessible(true);
			            viewController.setCurrentShape( constructor.newInstance());
			        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e1) {
			        }
			}
		});
		btnNewButton_1.setBounds(381, 33, 97, 25);
		
		frame.getContentPane().add(btnNewButton_1);

		
	}

	JFrame getFrame(){
		return this.frame;
	}
}


