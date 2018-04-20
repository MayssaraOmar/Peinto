package paint.view;

import paint.controller.CanvasMouseAdapter;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PaintWindow {

	private JFrame frame;
	Canvas canvas = Canvas.getCanvas();
	private final JLabel lblLine = new JLabel("Line");


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
		
		lblLine.addMouseListener(new CanvasMouseAdapter());
		lblLine.setBounds(39, 183, 56, 16);
		
		lblLine.setName("Line");
		
		frame.getContentPane().add(lblLine);
		
	}

	JFrame getFrame(){
		return this.frame;
	}
}

