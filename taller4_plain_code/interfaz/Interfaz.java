package uniandes.dpoo.taller4.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;

public class Interfaz extends JFrame{
	private Tablero tablero;
	private Top10 top10;
	private String nombreJugador;
	private Botones botones;
	private BotonesSuperior botonesSuperiores;
	private TableroPanel tableroPanel;
	private Top10Panel top10Panel;
	private Informacion informacion;
	
	@SuppressWarnings("static-access")
	public Interfaz() {
		top10= new Top10();
		nombreJugador = new JOptionPane().showInputDialog("Ingresen nombre jugador: ");
		setLayout(new BorderLayout());
		setTitle("Lights Out");
		botonesSuperiores= new BotonesSuperior();
		botonesSuperiores.setBackground(Color.BLUE);
		add(botonesSuperiores, BorderLayout.NORTH);
		informacion= new Informacion();
		informacion.actualizarJugador(nombreJugador);
		add(informacion, BorderLayout.SOUTH);
		botones= new Botones(this);
		add(botones, BorderLayout.EAST);
		// tablero = new Tablero(botonesSuperiores.obtenerTamano());
		// tableroPanel = new TableroPanel(tablero,this);
		// add(tableroPanel, BorderLayout.CENTER);
		setSize(800,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	
	}
	
	public void nuevoJuego() {
		if (tableroPanel!=null) {
			this.remove(tableroPanel);
		}
		int tamano= botonesSuperiores.obtenerTamano();
		tablero= new Tablero(tamano);
		tableroPanel= new TableroPanel(tablero, this);
		add(tableroPanel, BorderLayout.CENTER);
		tableroPanel.paintComponent(getGraphics());
	}
	public void reiniciarJuego() {
		int puntaje= tablero.calcularPuntaje();
		top10.agregarRegistro(nombreJugador, puntaje);
		int tamano= botonesSuperiores.obtenerTamano();
		tablero.reiniciar();
		informacion.actualizarJugadas("0");
		tableroPanel.repaint();
		
	}
	public void actualizarJugadas() {
		int numero= tablero.darJugadas();
		informacion.actualizarJugadas(Integer.toString(numero));
	}
	public void top10() {
		top10Panel= new Top10Panel(top10);
		top10Panel.setVisible(true);
	}
	@SuppressWarnings("static-access")
	public void cambiarJugador() {
		nombreJugador = new JOptionPane().showInputDialog("Ingresen nombre jugador: ");
		informacion.actualizarJugador(nombreJugador);
		
	}
	public static void main(String[] args) {
		Interfaz ventana= new Interfaz();
		ventana.setVisible(true);
	}
}
