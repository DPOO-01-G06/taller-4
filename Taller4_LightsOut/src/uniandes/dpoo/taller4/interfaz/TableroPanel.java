package uniandes.dpoo.taller4.interfaz;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

import uniandes.dpoo.taller4.modelo.Tablero;

public class TableroPanel extends JPanel implements MouseListener{
	private int tamano;
	private Tablero tablero;
	private int ultima_fila;
	private int ultima_columna;
	private Interfaz interfaz;
	
	public TableroPanel(Tablero ptablero, Interfaz pinterfaz) {
		tablero=ptablero;
		interfaz=pinterfaz;
		addMouseListener(this);

	}
	@Override
	public void paintComponent(Graphics gr) {
		ImageIcon imagen= new ImageIcon("data/luz.png");
		tamano= tablero.darTablero().length;
		int deltax= getWidth()/tamano;
		int deltay= getHeight()/tamano;
		Graphics2D g2d= (Graphics2D) gr;
		for (int i = 0; i<tamano;i++) {
			for(int j=0; j<tamano;j++) {
				if (tablero.darTablero()[i][j]) {
                    Rectangle2D fondo = new Rectangle2D.Double(i*deltax, j*deltay, deltax, deltay);
                    g2d.setColor(Color.YELLOW);
                    g2d.fill(fondo);
                    g2d.setColor(Color.BLACK);
                    g2d.draw(fondo);
					g2d.drawImage(imagen.getImage(),i*deltax,j*deltay, deltax, deltay, null);
					
				}
				else {
					Rectangle2D fondo = new Rectangle2D.Double(i*deltax, j*deltay, deltax, deltay);
                    g2d.setColor(Color.GRAY);
                    g2d.fill(fondo);
                    g2d.setColor(Color.BLACK);
                    g2d.draw(fondo);
					g2d.drawImage(imagen.getImage(),i*deltax,j*deltay, deltax, deltay, null);
				}
			}
		
		}
		updateUI();
		
	}
	
	
	private int[] convertirCoordenadasACasilla(int x, int y)
	{
	int ladoTablero = tablero.darTablero().length;
	int altoPanelTablero = getHeight();
	int anchoPanelTablero = getWidth();
	int altoCasilla = altoPanelTablero / ladoTablero;
	int anchoCasilla = anchoPanelTablero / ladoTablero;
	int fila = (int) (y / altoCasilla);
	int columna = (int) (x / anchoCasilla);
	return new int[] { fila, columna };
	}
	
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int click_x = e.getX();
		int click_y = e.getY();
		int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
		tablero.jugar(casilla[1], casilla[0]);
		interfaz.actualizarJugadas();
		this.ultima_fila = casilla[0];
		this.ultima_columna = casilla[1];
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
