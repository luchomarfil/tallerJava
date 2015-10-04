package practica4.gui.components;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import practica4.gui.DuracionNota;

public class JLabelDuracionNota extends JLabel{
	private Color colorNormal;
	private DuracionNota duracion;
	private Boolean clicked = false;

	public JLabelDuracionNota() {
		this.initialize();
	}
	public JLabelDuracionNota(DuracionNota duracion){		
		super(duracion.getNombre());
		this.duracion = duracion;
		this.initialize();
		
	}

	private void initialize() {
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(!clicked){
					colorNormal = getForeground();
					setForeground(Color.white);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if(!clicked){
					setForeground(colorNormal);
				}
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				clicked = !clicked;
			}
			
		});
		
	}
	public DuracionNota getDuracion() {
		return duracion;
	}
	public void setDuracion(DuracionNota duracion) {
		this.duracion = duracion;
	}
	
	public void resetClick(){
		this.clicked = false;
		setForeground(colorNormal);
		this.repaint();
	}

}
