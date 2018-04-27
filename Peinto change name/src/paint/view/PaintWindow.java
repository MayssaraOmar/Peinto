package paint.view;

import paint.controller.ControlDrawingEngine;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

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
		frame.setBounds(100, 100, 1900, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		canvas.setLocation(143, 98);
		frame.getContentPane().add(canvas);
		lblLine.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblLine.addMouseListener(viewController.getDrawShapeMouseAdapter());
		lblLine.setBounds(21, 193, 65, 37);
		lblLine.setName("Line");

		frame.getContentPane().add(lblLine);
		lblPeinto.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPeinto.setBounds(21, 13, 65, 33);
		frame.getContentPane().add(lblPeinto);
		lblRectangle.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblRectangle.addMouseListener(viewController.getDrawShapeMouseAdapter());
		lblRectangle.setName("rectangle");
		lblRectangle.setBounds(21, 229, 83, 37);
		frame.getContentPane().add(lblRectangle);
		lblCircle.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblCircle.addMouseListener(viewController.getDrawShapeMouseAdapter());
		lblCircle.setName("circle");
		lblCircle.setBounds(15, 315, 71, 33);
		frame.getContentPane().add(lblCircle);
		lblSquare.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblSquare.addMouseListener(viewController.getDrawShapeMouseAdapter());
		lblSquare.setName("square");
		lblSquare.setBounds(21, 361, 65, 33);
		frame.getContentPane().add(lblSquare);
		lblEllipse.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblEllipse.addMouseListener(viewController.getDrawShapeMouseAdapter());
		lblEllipse.setName("Ellipse");
		lblEllipse.setBounds(21, 405, 83, 33);
		frame.getContentPane().add(lblEllipse);
		lblTriangle.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblTriangle.addMouseListener(viewController.getDrawShapeMouseAdapter());
		lblTriangle.setName("triangle");
		lblTriangle.setBounds(21, 265, 71, 37);
		frame.getContentPane().add(lblTriangle);
		lblRedo.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblRedo.addMouseListener(viewController.getBasicCommandsMouseAdapter());
		lblRedo.setName("redo");
		lblRedo.setBounds(21, 64, 56, 16);
		frame.getContentPane().add(lblRedo);
		lblUndo.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblUndo.addMouseListener(viewController.getBasicCommandsMouseAdapter());
		lblUndo.setName("undo");
		lblUndo.setBounds(77, 64, 56, 16);
		frame.getContentPane().add(lblUndo);
		lblStrokeColor.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblStrokeColor.setBounds(21, 451, 94, 33);
		lblStrokeColor.addMouseListener(viewController.getColorLabelMouseAdapter());
		lblStrokeColor.setName("stroke color");
		frame.getContentPane().add(lblStrokeColor);
		lblfillColor.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblfillColor.setBounds(21, 508, 94, 43);
		lblfillColor.addMouseListener(viewController.getColorLabelMouseAdapter());
		lblfillColor.setName("fill color");
		frame.getContentPane().add(lblfillColor);
		lblSelect.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblSelect.addMouseListener(viewController.getBasicCommandsMouseAdapter());
		lblSelect.setName("select");
		lblSelect.setBounds(21, 564, 65, 30);
		frame.getContentPane().add(lblSelect);
		lblDeselect.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblDeselect.addMouseListener(viewController.getBasicCommandsMouseAdapter());
		lblDeselect.setName("deselect");
		lblDeselect.setBounds(21, 607, 65, 35);
		frame.getContentPane().add(lblDeselect);
		lblMove.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblMove.addMouseListener(viewController.getEditMouseAdapter());
		lblMove.setBounds(21, 693, 65, 33);
		lblMove.setName("move");
		frame.getContentPane().add(lblMove);
		lblCopy.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblCopy.addMouseListener(viewController.getEditMouseAdapter());
		lblCopy.setBounds(21, 655, 65, 33);
		lblCopy.setName("copy");
		frame.getContentPane().add(lblCopy);
		lblResize.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblResize.addMouseListener(viewController.getEditMouseAdapter());
		lblResize.setBounds(21, 148, 65, 32);
		lblResize.setName("resize");
		frame.getContentPane().add(lblResize);
		lblDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblDelete.addMouseListener(viewController.getEditMouseAdapter());
		lblDelete.setName("delete");
		lblDelete.setBounds(21, 739, 71, 33);
		frame.getContentPane().add(lblDelete);

		JLabel lbldeselectAll = new JLabel("deselect all");
		lbldeselectAll.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbldeselectAll.setName("deselectAll");
		lbldeselectAll.setBounds(21, 113, 94, 33);
		lbldeselectAll.addMouseListener(viewController.getBasicCommandsMouseAdapter());
		frame.getContentPane().add(lbldeselectAll);

		JButton btnSave = new JButton("Save");
		btnSave.setName("Save");
		btnSave.addActionListener(viewController.getSaveAndLoadActionListener());
		btnSave.setBounds(241, 34, 89, 23);
		frame.getContentPane().add(btnSave);

		JButton btnLoad = new JButton("Load");
		btnLoad.setName("Load");
		btnLoad.addActionListener(viewController.getSaveAndLoadActionListener());
		btnLoad.setBounds(129, 34, 89, 23);
		frame.getContentPane().add(btnLoad);

	}

	JFrame getFrame() {
		return this.frame;
	}
}
