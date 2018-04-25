package paint.view;


import paint.controller.ControlDrawingEngine;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
		lblRectangle.setBounds(39, 215, 71, 16);
		frame.getContentPane().add(lblRectangle);
		
		lblCircle.addMouseListener(viewController.getDrawShapeMouseAdapter());
		lblCircle.setName("circle");
		lblCircle.setBounds(39, 268, 71, 16);
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
		lblTriangle.setBounds(39, 244, 71, 16);
		frame.getContentPane().add(lblTriangle);
	
		lblRedo.addMouseListener(viewController.getUndoRedoMouseAdapter());
		lblRedo.setName("redo");
		lblRedo.setBounds(26, 88, 56, 16);
		frame.getContentPane().add(lblRedo);
		
		lblUndo.addMouseListener(viewController.getUndoRedoMouseAdapter());
		lblUndo.setName("undo");
		lblUndo.setBounds(77, 88, 56, 16);
		frame.getContentPane().add(lblUndo);
		
	}

	JFrame getFrame(){
		return this.frame;
	}
}

