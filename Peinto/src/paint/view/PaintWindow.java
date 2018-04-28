package paint.view;

import paint.controller.ControlDrawingEngine;


import javax.swing.ImageIcon;

import paint.model.Shape;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class PaintWindow {

	private ControlDrawingEngine viewController = new ControlDrawingEngine();
	private JFrame frame;
	private Canvas canvas = Canvas.getCanvas(viewController);
	private final JLabel lblLine = new JLabel("");
	private final JLabel lblPeinto = new JLabel("");
	private final JLabel lblRectangle = new JLabel("");
	private final JLabel lblCircle = new JLabel("");
	private final JLabel lblSquare = new JLabel("");
	private final JLabel lblEllipse = new JLabel("");
	private final JLabel lblTriangle = new JLabel("");
	private final JLabel lblRedo = new JLabel("");
	private final JLabel lblUndo = new JLabel("");
	private final JLabel lblStrokeColor = new JLabel("");
	private final JLabel lblfillColor = new JLabel("");
	private final JLabel lblMove = new JLabel("move");
	private final JLabel lblSelect = new JLabel("");
	private final JLabel lblDeselect = new JLabel("");
	private final JLabel lblCopy = new JLabel("copy");
	private final JLabel lblResize = new JLabel("");
	private final JLabel lblDelete = new JLabel("");
	private final JLabel lblDeleteAll = new JLabel("");

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
		frame.getContentPane().setBackground(new Color(139, 0, 139));
		frame.setBounds(100, 100, 1386, 743);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		canvas.setLocation(143, 98);
		frame.getContentPane().add(canvas);
		lblPeinto.setIcon(new ImageIcon(PaintWindow.class.getResource("/paint/view/icons/Peinto-logo (12).png")));
		lblPeinto.setForeground(new Color(255, 255, 255));
		lblPeinto.setBackground(new Color(102, 51, 102));
		lblPeinto.setFont(new Font("Segoe UI Light", Font.PLAIN, 63));
		lblPeinto.setBounds(98, -23, 374, 137);
		frame.getContentPane().add(lblPeinto);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(211, 211, 211));
		panel.setBounds(0, 0, 144, 704);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnLoad = new JButton("");
		btnLoad.setBounds(13, 11, 50, 58);
		panel.add(btnLoad);
		btnLoad.setBackground(new Color(255, 255, 255));
		btnLoad.setIcon(new ImageIcon(PaintWindow.class.getResource("/paint/view/icons/icons8-refresh-64.png")));
		btnLoad.setName("Load");
		btnLoad.setToolTipText("Load");

		JButton btnSave = new JButton("");
		btnSave.setBackground(new Color(255, 255, 255));
		btnSave.setBounds(73, 11, 50, 58);
		panel.add(btnSave);
		btnSave.setIcon(new ImageIcon(PaintWindow.class.getResource("/paint/view/icons/icons8-save-as-64.png")));
		btnSave.setName("Save");
		btnSave.setToolTipText("Save");
		lblTriangle.setBackground(new Color(255, 255, 255));
		lblTriangle.setBounds(13, 107, 50, 50);
		lblTriangle.setToolTipText("Triangle");
		panel.add(lblTriangle);
		lblTriangle
				.setIcon(new ImageIcon(PaintWindow.class.getResource("/paint/view/icons/icons8-trigonometry-26.png")));
		lblTriangle.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblTriangle.addMouseListener(viewController.getDrawShapeMouseAdapter());
		lblTriangle.setName("triangle");
		lblCircle.setBackground(new Color(255, 255, 255));
		lblCircle.setToolTipText("Circle");
		lblCircle.setIcon(new ImageIcon(PaintWindow.class.getResource("/paint/view/icons/icons8-circle-32.png")));
		lblCircle.setBounds(65, 107, 50, 50);
		panel.add(lblCircle);
		lblCircle.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblCircle.addMouseListener(viewController.getDrawShapeMouseAdapter());
		lblCircle.setName("circle");
		lblSquare.setBounds(13, 157, 50, 50);
		panel.add(lblSquare);
		lblSquare.setBackground(new Color(255, 255, 255));
		lblSquare.setToolTipText("Square");
		lblSquare.setIcon(
				new ImageIcon(PaintWindow.class.getResource("/paint/view/icons/icons8-unchecked-checkbox-32.png")));
		lblSquare.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblSquare.addMouseListener(viewController.getDrawShapeMouseAdapter());
		lblSquare.setName("square");
		lblLine.setBackground(new Color(255, 255, 255));
		lblLine.setIcon(new ImageIcon(PaintWindow.class.getResource("/paint/view/icons/icons8-line-30.png")));
		lblLine.setBounds(65, 157, 58, 50);
		lblLine.setToolTipText("Line");
		panel.add(lblLine);
		lblLine.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblLine.addMouseListener(viewController.getDrawShapeMouseAdapter());
		lblLine.setName("Line");
		lblEllipse.setIcon(new ImageIcon(PaintWindow.class.getResource("/paint/view/icons/icons8-oval-26.png")));
		lblEllipse.setBackground(new Color(255, 255, 255));
		lblEllipse.setBounds(13, 200, 50, 50);
		lblEllipse.setToolTipText("Ellipse");
		panel.add(lblEllipse);
		lblEllipse.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblEllipse.addMouseListener(viewController.getDrawShapeMouseAdapter());
		lblEllipse.setName("Ellipse");
		lblRectangle
				.setIcon(new ImageIcon(PaintWindow.class.getResource("/paint/view/icons/icons8-rectangular-32.png")));
		lblRectangle.setBackground(new Color(255, 255, 255));
		lblRectangle.setBounds(65, 200, 58, 50);
		lblRectangle.setToolTipText("Rectangle");
		panel.add(lblRectangle);
		lblRectangle.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblRectangle.addMouseListener(viewController.getDrawShapeMouseAdapter());
		lblRectangle.setName("rectangle");
		lblUndo.setBackground(new Color(255, 255, 255));
		lblUndo.setIcon(new ImageIcon(PaintWindow.class.getResource("/paint/view/icons/icons8-undo-6444.png")));
		lblUndo.setBounds(65, 330, 58, 58);
		lblUndo.setToolTipText("Undo");
		panel.add(lblUndo);
		lblUndo.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblUndo.addMouseListener(viewController.getBasicCommandsMouseAdapter());
		lblUndo.setName("undo");
		lblRedo.setBackground(new Color(255, 255, 255));
		lblRedo.setIcon(new ImageIcon(PaintWindow.class.getResource("/paint/view/icons/icons8-redo-64.png")));
		lblRedo.setBounds(5, 330, 58, 58);
		lblRedo.setToolTipText("Redo");
		panel.add(lblRedo);
		lblRedo.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblRedo.addMouseListener(viewController.getBasicCommandsMouseAdapter());
		lblRedo.setName("redo");
		lblfillColor.setBounds(5, 468, 69, 58);
		lblfillColor.setToolTipText("Fill Color");
		panel.add(lblfillColor);
		lblfillColor.setBackground(new Color(255, 255, 255));
		lblfillColor
				.setIcon(new ImageIcon(PaintWindow.class.getResource("/paint/view/icons/icons8-fill-color-64.png")));
		lblfillColor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblfillColor.addMouseListener(viewController.getColorLabelMouseAdapter());
		lblfillColor.setName("fill color");
		lblStrokeColor.setBackground(new Color(255, 255, 255));
		lblStrokeColor.setBounds(73, 468, 58, 58);
		lblStrokeColor.setToolTipText("Stroke Color");
		panel.add(lblStrokeColor);
		lblStrokeColor
				.setIcon(new ImageIcon(PaintWindow.class.getResource("/paint/view/icons/icons8-paint-palette-64.png")));
		lblStrokeColor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStrokeColor.addMouseListener(viewController.getColorLabelMouseAdapter());
		lblStrokeColor.setName("stroke color");
		lblSelect.setBounds(5, 399, 58, 58);
		lblSelect.setToolTipText("Select a Shape");
		panel.add(lblSelect);
		lblSelect.setBackground(new Color(255, 255, 255));
		lblSelect.setIcon(new ImageIcon(PaintWindow.class.getResource("/paint/view/icons/icons8-cursor-64.png")));
		lblSelect.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblSelect.addMouseListener(viewController.getBasicCommandsMouseAdapter());
		lblSelect.setName("select");
		lblCopy.setBounds(73, 606, 64, 58);
		lblCopy.setToolTipText("Copy");
		panel.add(lblCopy);
		lblCopy.setBackground(new Color(255, 255, 255));
		lblCopy.setIcon(new ImageIcon(PaintWindow.class.getResource("/paint/view/icons/icons8-copy-64 (1).png")));
		lblCopy.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblCopy.addMouseListener(viewController.getEditMouseAdapter());
		lblCopy.setName("copy");
		lblDeselect.setBounds(13, 261, 50, 52);
		panel.add(lblDeselect);
		lblDeselect.setBackground(new Color(255, 255, 255));
		lblDeselect.setIcon(new ImageIcon(PaintWindow.class.getResource("/paint/view/icons/icons8-cancel-24.png")));
		lblDeselect.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDeselect.setToolTipText("Deselect a shape");
		lblDeselect.addMouseListener(viewController.getBasicCommandsMouseAdapter());
		lblDeselect.setName("deselect");
		lblMove.setForeground(new Color(255, 255, 255));
		lblMove.setIcon(new ImageIcon(PaintWindow.class.getResource("/paint/view/icons/icons8-move-64.png")));
		lblMove.setBounds(5, 537, 61, 58);
		lblMove.setToolTipText("Move a Shaoe");
		panel.add(lblMove);
		lblMove.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblMove.addMouseListener(viewController.getEditMouseAdapter());
		lblMove.setName("move");
		lblResize.setIcon(new ImageIcon(PaintWindow.class.getResource("/paint/view/icons/icons8-resize-64.png")));
		lblResize.setForeground(new Color(255, 255, 255));
		lblResize.setBounds(73, 537, 58, 58);
		lblResize.setToolTipText("Resize");
		panel.add(lblResize);
		lblResize.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblResize.addMouseListener(viewController.getEditMouseAdapter());
		lblResize.setName("resize");
		lblDelete.setIcon(new ImageIcon(PaintWindow.class.getResource("/paint/view/icons/icons8-erase-64.png")));
		lblDelete.setBackground(new Color(255, 255, 255));
		lblDelete.setBounds(3, 606, 71, 58);
		lblDelete.setToolTipText("Delete");
		panel.add(lblDelete);
		lblDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblDelete.addMouseListener(viewController.getEditMouseAdapter());
		lblDelete.setName("delete");

		lblDeleteAll.setBounds(73, 399, 69, 58);
		panel.add(lblDeleteAll);
		lblDeleteAll.setBackground(new Color(255, 255, 255));
		lblDeleteAll.setToolTipText("Clear Canvas");
		lblDeleteAll.setIcon(
				new ImageIcon(PaintWindow.class.getResource("/paint/view/icons/icons8-cancel-64.png")));
		lblDeleteAll.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblDeleteAll.addMouseListener( viewController.getEditMouseAdapter());
		lblDeleteAll.setName("DeleteAll");

		JLabel lblNewLabel = new JLabel("Shapes");
		lblNewLabel.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblNewLabel.setBounds(23, 80, 78, 29);
		panel.add(lblNewLabel);

		JLabel lbldeselectAll = new JLabel("");
		lbldeselectAll.setBackground(new Color(255, 255, 255));
		lbldeselectAll
				.setIcon(new ImageIcon(PaintWindow.class.getResource("/paint/view/icons/icons8-uncheck-all-50.png")));
		lbldeselectAll.setBounds(65, 261, 58, 58);
		lbldeselectAll.setToolTipText("Deselect All Shapes");
		panel.add(lbldeselectAll);
		lbldeselectAll.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbldeselectAll.setName("deselectAll");

		JSeparator separator = new JSeparator();
		separator.setBounds(2, 261, 127, 2);
		panel.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(255, 255, 255));
		separator_1.setBounds(2, 323, 127, 2);
		panel.add(separator_1);
		lbldeselectAll.addMouseListener(viewController.getBasicCommandsMouseAdapter());
		btnSave.addActionListener(viewController.getSaveAndLoadActionListener());
		btnLoad.addActionListener(viewController.getSaveAndLoadActionListener());


	}

	JFrame getFrame() {
		return this.frame;
	}
}
