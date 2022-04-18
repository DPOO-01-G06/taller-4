package uniandes.dpoo.taller4.interfaz;

import java.awt.*;

import javax.swing.*;


public class Informacion extends JPanel{
	private JTextField txtJugadas;
	private JLabel lblJugadas;
	private JTextField txtJugador;
	private JLabel lblJugador;
	
	
	
	public Informacion() {
		setLayout(new GridLayout(1,4));
		
		lblJugadas= new JLabel("jugadas: ");
		add(lblJugadas);
		txtJugadas= new JTextField("0");
		txtJugadas.setEditable(false);
		add(txtJugadas);
		lblJugador= new JLabel("jugador: ");
		add(lblJugador);
		txtJugador= new JTextField();
		txtJugador.setEditable(false);
		add(txtJugador);
		
	}
	
	public void actualizarJugadas(String textoActualizar) {
		txtJugadas.setText(textoActualizar);
	}

	public void actualizarJugador(String textoActualizar) {
		txtJugador.setText(textoActualizar);
	}
	
	
	
}
