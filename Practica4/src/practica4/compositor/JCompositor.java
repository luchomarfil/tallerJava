package practica4.compositor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import practica4.compositor.components.EspacioPentagramaPanel;
import practica4.compositor.components.LineaPentagramaPanel;

public class JCompositor extends JFrame {

	private JPanel pnlSeleccionDuracion;
	private JPanel pnlSeleccionNota;
	private JPanel pnlMelodiaGenerada;
	private JLabel jLabelRedonda;
	private JLabel jLabelBlanca;
	private JLabel jLabelNegra;
	private JLabel jLabelCorchea;
	private JLabel jLabelSemicorchea;
	private JLabel jLabelFusa;
	private JLabel jLabelSemifusa;
	private String melodiaGenerada;
	private JLabel jLabelMelodiaGenerada;
	
	public JCompositor() {
		this.initialize();
	}
	
	private void initialize(){
		this.setTitle("Mozart");
		this.setSize(400, 400);
		
		this.setLayout(new BorderLayout());
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		this.pnlSeleccionDuracion = new JPanel(new GridLayout(8, 1));
		this.pnlSeleccionNota = new JPanel(new GridLayout(15, 1));
		this.pnlMelodiaGenerada = new JPanel();
		
		//construimos el panel para la duracion de la nota
		jLabelRedonda = new JLabel("Redonda");
		jLabelBlanca = new JLabel("Blanca");
		jLabelNegra = new JLabel("Negra");
		jLabelCorchea = new JLabel("Corchea");
		jLabelSemicorchea = new JLabel("SemiCorchea");
		jLabelFusa = new JLabel("Fusa");
		jLabelSemifusa = new JLabel("Semifusa");
		
		jLabelRedonda.setIcon(new ImageIcon(this.getClass().getResource("/resources/redonda.png")));
		jLabelBlanca.setIcon(new ImageIcon(this.getClass().getResource("/resources/blanca.png")));
		jLabelNegra.setIcon(new ImageIcon(this.getClass().getResource("/resources/negra.png")));
		jLabelCorchea.setIcon(new ImageIcon(this.getClass().getResource("/resources/corchea.png")));
		jLabelSemicorchea.setIcon(new ImageIcon(this.getClass().getResource("/resources/semicorchea.png")));
		jLabelFusa.setIcon(new ImageIcon(this.getClass().getResource("/resources/fusa.png")));
		jLabelSemifusa.setIcon(new ImageIcon(this.getClass().getResource("/resources/semifusa.png")));
		
		inicializarEstiloJLabel(jLabelRedonda);		
		inicializarEstiloJLabel(jLabelBlanca);		
		inicializarEstiloJLabel(jLabelNegra);		
		inicializarEstiloJLabel(jLabelCorchea);	
		inicializarEstiloJLabel(jLabelSemicorchea);
		inicializarEstiloJLabel(jLabelFusa);
		inicializarEstiloJLabel(jLabelSemifusa);
		
		
		this.pnlSeleccionDuracion.add(new JLabel("Figura"));		
		this.pnlSeleccionDuracion.add(jLabelRedonda);
		this.pnlSeleccionDuracion.add(jLabelBlanca);
		this.pnlSeleccionDuracion.add(jLabelNegra);
		this.pnlSeleccionDuracion.add(jLabelCorchea);
		this.pnlSeleccionDuracion.add(jLabelSemicorchea);
		this.pnlSeleccionDuracion.add(jLabelFusa);
		this.pnlSeleccionDuracion.add(jLabelSemifusa);
		
		
		//construimos el panel para la seleccion de la nota
		this.pnlSeleccionNota.add(new JLabel("Pentagrama"));
		this.pnlSeleccionNota.add(new EspacioPentagramaPanel());
		this.pnlSeleccionNota.add(new LineaPentagramaPanel());
		this.pnlSeleccionNota.add(new EspacioPentagramaPanel());
		this.pnlSeleccionNota.add(new LineaPentagramaPanel());
		this.pnlSeleccionNota.add(new EspacioPentagramaPanel());
		this.pnlSeleccionNota.add(new LineaPentagramaPanel());
		this.pnlSeleccionNota.add(new EspacioPentagramaPanel());
		this.pnlSeleccionNota.add(new LineaPentagramaPanel());
		this.pnlSeleccionNota.add(new EspacioPentagramaPanel());
		this.pnlSeleccionNota.add(new LineaPentagramaPanel());
		this.pnlSeleccionNota.add(new EspacioPentagramaPanel());
		
		
		//construimos el panel para mostrar la nota
		this.melodiaGenerada="No existe melodia aun";
		jLabelMelodiaGenerada = new JLabel(this.melodiaGenerada);
		this.pnlMelodiaGenerada.add(jLabelMelodiaGenerada);		
		//agregamos los paneles al frame
		this.add(this.pnlSeleccionDuracion,BorderLayout.WEST);
		this.add(this.pnlSeleccionNota,BorderLayout.CENTER);
		this.add(this.pnlMelodiaGenerada,BorderLayout.SOUTH);
		actualizarMelodiaGenerada();
	}

	private void inicializarEstiloJLabel(JLabel jLabelRedonda) {
		jLabelRedonda.setHorizontalAlignment(JLabel.RIGHT);
		jLabelRedonda.setVerticalAlignment(JLabel.BOTTOM);				
		jLabelRedonda.setBackground(Color.lightGray);
		jLabelRedonda.setOpaque(true);
		jLabelRedonda.setHorizontalTextPosition(SwingConstants.LEFT);
	}
	
	private void actualizarMelodiaGenerada(){
		this.melodiaGenerada="melodia actualizada";
		jLabelMelodiaGenerada.setText(this.melodiaGenerada);
		jLabelMelodiaGenerada.repaint();
		
	}

}
