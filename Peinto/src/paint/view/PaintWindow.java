package paint.view;


import paint.controller.CanvasMouseAdapter;
import paint.controller.Control;
import paint.controller.ControlDrawingEngine;
import paint.controller.ColorLabelMouseAdapter;

import paint.controller.ControlDrawingEngine;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		lblRedo.setBounds(21, 64, 56, 16);
		frame.getContentPane().add(lblRedo);
		
		lblUndo.addMouseListener(viewController.getBasicCommandsMouseAdapter());
		lblUndo.setName("undo");
		lblUndo.setBounds(77, 64, 56, 16);
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
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				 JFileChooser fileChooser = new JFileChooser();
					fileChooser.setVisible(true);
			      // Demonstrate "Save" dialog:
			      int rVal = fileChooser.showSaveDialog(fileChooser);
			      String filePath =  fileChooser.getSelectedFile().getAbsolutePath();
			      System.out.println("it's the path "+filePath);
			      viewController.save(filePath);
			     /* if (rVal == JFileChooser.APPROVE_OPTION) {
			         filename.setText(c.getSelectedFile().getName());
			        dir.setText(c.getCurrentDirectory().toString());
			      }
			      if (rVal == JFileChooser.CANCEL_OPTION) {
			        filename.setText("You pressed cancel");
			        dir.setText("");
			      }*/
				//Xml trials = new Xml();
				//trials.save(viewController);
				
				//Json tries = new Json();
				//tries.save(viewController);
				//tries.load();
				
			}
		});
		btnSave.setBounds(21, 123, 89, 23);
		frame.getContentPane().add(btnSave);
		
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setVisible(true);
		      // Demonstrate "Save" dialog:
		      int rVal = fileChooser.showOpenDialog(fileChooser);
		      String filePath =  fileChooser.getSelectedFile().getAbsolutePath();
		      System.out.println("LOAD path form gui "+filePath);
		      viewController.load(filePath);
		      Canvas.getCanvas(viewController).repaint();
				/*FileChooserTest FileChooser = new FileChooserTest();
				FileChooser.setVisible(true);
				//Xml trials = new Xml();
				//trials.load(viewController);
				
				Json tries = new Json();
				//tries.save();
				tries.load(viewController);*/
				
			}
		});
		btnLoad.setBounds(21, 89, 89, 23);
		frame.getContentPane().add(btnLoad);
		
	}

	JFrame getFrame(){
		return this.frame;
	}
}


