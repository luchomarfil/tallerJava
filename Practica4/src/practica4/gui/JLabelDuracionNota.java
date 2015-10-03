package practica4.gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class JLabelDuracionNota extends JLabel{

	private Border borderNormal;
	private DuracionNota duracion;

	public JLabelDuracionNota() {
		this.initialize();
	}
	public JLabelDuracionNota(DuracionNota duracion){
		super(duracion.getNombre());	
		this.initialize();
	}

	private void initialize() {
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				borderNormal = getBorder();
				setBorder(new LineBorder(Color.black, 1));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				setBorder(borderNormal);

			}
		});
		
	}
	public DuracionNota getDuracion() {
		return duracion;
	}
	public void setDuracion(DuracionNota duracion) {
		this.duracion = duracion;
	}

}
