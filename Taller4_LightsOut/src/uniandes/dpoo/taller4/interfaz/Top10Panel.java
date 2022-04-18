package uniandes.dpoo.taller4.interfaz;

import java.awt.BorderLayout;
import java.util.Collection;
import java.util.List;

import javax.swing.*;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Top10;

public class Top10Panel extends JDialog{
	private JTextArea texto;
	private Top10 top10;
	
	
	
	public Top10Panel(Top10 ptop10) {
		top10=ptop10;
		texto = new JTextArea();
		Collection<RegistroTop10> lista = top10.darRegistros();
		int i= 0;
		for (RegistroTop10 elemento: lista) {
			String contenido = texto.getText()+ (i+1)+ elemento.toString()+ "\n";
			texto.setText(contenido);
			i++;
		}
		setTitle("TOP10");
		setSize(300, 210);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		add(texto, BorderLayout.CENTER);
		
		
	}
}
