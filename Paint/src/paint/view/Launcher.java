package paint.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Launcher {


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaintWindow paintWindow = new PaintWindow();
					paintWindow.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
