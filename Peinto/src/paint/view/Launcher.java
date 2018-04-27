package paint.view;

import java.awt.EventQueue;

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
//redo deep copy hahsmap memento 
// when loading bhsyl kol ely fy stacks redo w undo