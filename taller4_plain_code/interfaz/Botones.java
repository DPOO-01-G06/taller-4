package uniandes.dpoo.taller4.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Botones extends JPanel implements ActionListener{
	private JButton nuevo;
	private JButton reiniciar;
	private JButton top10;
	private JButton cambiarJugador;
	private Interfaz interfaz;
	
	public Botones(Interfaz pinterfaz){
		setLayout(new GridLayout(4,1));
		interfaz= pinterfaz;
		nuevo= new JButton("NUEVO");
		nuevo.setActionCommand("NUEVO");
		nuevo.addActionListener(this);
		add(nuevo);
		reiniciar= new JButton("REINICIAR");
		reiniciar.setActionCommand("REINICIAR");
		reiniciar.addActionListener(this);
		add(reiniciar);
		top10= new JButton("TOP10");
		top10.setActionCommand("TOP10");
		top10.addActionListener(this);
		add(top10);
		cambiarJugador= new JButton("CAMBIARJUGADOR");
		cambiarJugador.setActionCommand("CAMBIARJUGADOR");
		cambiarJugador.addActionListener(this);
		add(cambiarJugador);
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String evento = e.getActionCommand();
		if (evento.equals("NUEVO")) {
			interfaz.nuevoJuego();
		}
		else if (evento.equals("REINICIAR")) {
			interfaz.reiniciarJuego();
		}
		else if (evento.equals("TOP10")) {
			interfaz.top10();
		}
		else if (evento.equals("CAMBIARJUGADOR")) {
			interfaz.cambiarJugador();
		}
		
	}

}
