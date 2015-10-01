package practica4.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class JPanelPentagrama extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nota;
	private Color colorNormal;
	private Component owner;

	public JPanelPentagrama(Component owner) {
		this.owner = owner;
		initialize();
	}

	private void initialize() {
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				colorNormal = getBackground();
				setBackground(Color.LIGHT_GRAY);
				owner.repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(colorNormal);
				owner.repaint();
			}
		});

	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	
	
}
