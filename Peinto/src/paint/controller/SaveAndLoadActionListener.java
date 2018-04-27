package paint.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import paint.view.Canvas;

public class SaveAndLoadActionListener implements ActionListener {

	private ControlDrawingEngine controlDrawingEngine;

	public SaveAndLoadActionListener(ControlDrawingEngine controlDrawingEngine) {
		this.controlDrawingEngine = controlDrawingEngine;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton o = (JButton) e.getSource();
		String name = o.getName();
		if (name.equalsIgnoreCase("Save")) {
			javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();

			FileNameExtensionFilter filter = new FileNameExtensionFilter("xml and json files", "xml", "json");
			fileChooser.setFileFilter(filter);
			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.showSaveDialog(null);
			File selectedFile = fileChooser.getSelectedFile();
			if (selectedFile == null)
				return;
			String filePath = selectedFile.getAbsolutePath();
			controlDrawingEngine.save(filePath);

		}
		if (name.equalsIgnoreCase("Load")) {
			javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();

			FileNameExtensionFilter filter = new FileNameExtensionFilter("xml and json files", "xml", "json");
			fileChooser.setFileFilter(filter);
			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.showOpenDialog(null);
			File selectedFile = fileChooser.getSelectedFile();
			if (selectedFile == null)
				return;
			String filePath = selectedFile.getAbsolutePath();
			controlDrawingEngine.load(filePath);
			Canvas.getCanvas(controlDrawingEngine).repaint();
		}
	}

}
