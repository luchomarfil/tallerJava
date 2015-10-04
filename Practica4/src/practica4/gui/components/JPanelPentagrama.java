package practica4.gui.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import practica4.gui.EntonacionNota;

public class JPanelPentagrama extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EntonacionNota nota;
	private Color colorNormal;
	private Component owner;
	private Boolean clicked = false;


	public JPanelPentagrama(Component owner) {
		this.owner = owner;
		initialize();
	}

	private void initialize() {
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(!clicked){
					colorNormal = getBackground();
					setBackground(Color.LIGHT_GRAY);
					owner.repaint();
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if(!clicked){
					setBackground(colorNormal);
					owner.repaint();
				}
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {

				clicked = !clicked;
			}
		});

	}

	public EntonacionNota getNota() {
		return nota;
	}

	public void setNota(EntonacionNota nota) {
		this.nota = nota;
	}

	public void resetClick(){
		this.clicked = false;
	}

	
	
}
