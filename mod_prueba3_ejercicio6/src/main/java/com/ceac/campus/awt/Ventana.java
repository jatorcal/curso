package com.ceac.campus.awt;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URISyntaxException;

public class Ventana extends Frame{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private Frame mainFrame;
	private Label headerLabel;
	private Label statusLabel;
	private Panel controlPanel;

	public Ventana() {
		initComponents();
	}

	private void initComponents() {

		prepareGUI();
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				exitForm(event);
			}
		});

		pack();

	}

	private void exitForm(WindowEvent event) {
		System.exit(0);
	}


	public static void main(String[] args) throws URISyntaxException, IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Ventana ventana = new Ventana();
				ventana.setVisible(true);
				ventana.showButtonDemo();
				
			}
		});
	}

	private void prepareGUI(){
		mainFrame = new Frame("Registro de productos");
		mainFrame.setSize(300,400);
		mainFrame.setLayout(new GridLayout(3, 1));
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}        
		});    
		headerLabel = new Label();
		headerLabel.setAlignment(Label.CENTER);
		statusLabel = new Label();        
		statusLabel.setAlignment(Label.CENTER);
		statusLabel.setSize(350,100);

		controlPanel = new Panel();
		controlPanel.setLayout(new FlowLayout());

		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);  
	}

	private void showButtonDemo(){
		headerLabel.setText("Selecciona la operación a realizar"); 

		Button introducirButton = new Button("Introducir Productos");
		Button visualizarButton = new Button("Visualizar Productos");
		Button guardarButton = new Button("Guardar productos");
		Button leerGuardadosButton = new Button("Leer productos guardados");

		introducirButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				statusLabel.setText("Ok Button clicked.");
			}
		});

		visualizarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				statusLabel.setText("Submit Button clicked.");
			}
		});

		guardarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				statusLabel.setText("Cancel Button clicked.");
			}
		});
		
		leerGuardadosButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				statusLabel.setText("Cancel Button clicked.");
			}
		});

		controlPanel.add(introducirButton);
		controlPanel.add(visualizarButton);
		controlPanel.add(guardarButton);
		controlPanel.add(leerGuardadosButton);       

		mainFrame.setVisible(true);  
	}
}

