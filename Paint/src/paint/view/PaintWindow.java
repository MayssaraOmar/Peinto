package paint.view;

import paint.controller.CanvasMouseAdapter;
import paint.controller.LabelMouseAdapter;

import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PaintWindow {

	private JFrame frame;
	Canvas canvas = Canvas.getCanvas();
	private final JLabel lblLine = new JLabel("Line");
	private final JLabel lblPeinto = new JLabel("Peinto");
	private final JLabel lblRectangle = new JLabel("rectangle");
	private final JLabel lblCircle = new JLabel("circle");
	private final JLabel lblSquare = new JLabel("Square");
	private final JLabel lblEllipse = new JLabel("Ellipse");
	private final JLabel lblTriangle = new JLabel("Triangle");



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
		
		lblLine.addMouseListener(ControlView.control.LabelMouseAdapter);
		lblLine.setBounds(39, 183, 56, 16);
		lblLine.setName("Line");
		
		frame.getContentPane().add(lblLine);
		lblPeinto.setBounds(77, 37, 56, 16);
		frame.getContentPane().add(lblPeinto);
		
		lblRectangle.addMouseListener(ControlView.control.LabelMouseAdapter);
		lblRectangle.setName("rectangle");
		lblRectangle.setBounds(39, 215, 71, 16);
		frame.getContentPane().add(lblRectangle);
		
		lblCircle.addMouseListener(ControlView.control.LabelMouseAdapter);
		lblCircle.setName("circle");
		lblCircle.setBounds(39, 268, 71, 16);
		frame.getContentPane().add(lblCircle);
		
		lblSquare.addMouseListener(ControlView.control.LabelMouseAdapter);
		lblSquare.setName("square");
		lblSquare.setBounds(39, 297, 71, 16);
		frame.getContentPane().add(lblSquare);
		
		lblEllipse.addMouseListener(ControlView.control.LabelMouseAdapter);
		lblEllipse.setName("Ellipse");
		lblEllipse.setBounds(39, 326, 71, 16);
		frame.getContentPane().add(lblEllipse);
		
		lblTriangle.addMouseListener(ControlView.control.LabelMouseAdapter);
		lblTriangle.setName("triangle");
		lblTriangle.setBounds(39, 244, 71, 16);
		frame.getContentPane().add(lblTriangle);
		
	}

	JFrame getFrame(){
		return this.frame;
	}
}

