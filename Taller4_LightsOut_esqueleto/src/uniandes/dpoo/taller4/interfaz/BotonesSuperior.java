package uniandes.dpoo.taller4.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BotonesSuperior extends JPanel {
	private JLabel tamano;
	private JLabel dificultad;
	private JComboBox lista;
	private JRadioButton facil;
	private JRadioButton medio;
	private JRadioButton dificil;
	private ButtonGroup opciones;
	private int numero= 5;
	
	public BotonesSuperior() {
		setLayout(new GridLayout(1,6));
		tamano= new JLabel("tamaño: ");
		add(tamano);
		String[] lista1= new String[] {"5x5", "6x6", "4x4"};
		lista= new JComboBox<String>(lista1);
		add(lista);
		dificultad= new JLabel("dificultad: ");
		add(dificultad);
		facil= new JRadioButton("Facil");
		medio= new JRadioButton("medio");
		dificil= new JRadioButton("dificil");
		opciones= new ButtonGroup();
		opciones.add(facil);
		opciones.add(medio);
		opciones.add(dificil);
		add(facil);
		add(medio);
		add(dificil);
		
		
		
	}

	
	
	public String obtenerDificultad() {
		if (facil.isSelected()) {
			return "facil";
		}
		else if (medio.isSelected()) {
			return "medio";
		}
		else if (dificil.isSelected()) {
			return "dificil";
		}
		return "facil";
	}
	
	public int obtenerTamano() {
		if (lista.getSelectedItem().equals("4x4")){
			numero=4;
		}
		else if (lista.getSelectedItem().equals("5x5")){
			numero=5;
		}
		else if (lista.getSelectedItem().equals("6x6")){
			numero=6;
		}
		return numero;
		
	}
	
	
}
