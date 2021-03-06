package practica4.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import practica4.app.FogueService;
import practica4.app.Melodia;
import practica4.gui.components.JLabelDuracionNota;
import practica4.gui.components.JPanelPentagrama;

import javax.swing.JTextField;
import javax.swing.BoxLayout;

import java.awt.BorderLayout;

public class JCompositor extends JFrame {

	private static final String SIN_NOTA_SELECCIONADA = "_";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnlSeleccionDuracion;
	private JLabelDuracionNota jLabelRedonda;
	private JLabelDuracionNota jLabelBlanca;
	private JLabelDuracionNota jLabelNegra;
	private JLabelDuracionNota jLabelCorchea;
	private JLabelDuracionNota jLabelSemicorchea;
	private JLabelDuracionNota jLabelFusa;
	private JLabelDuracionNota jLabelSemifusa;
	private JLabel jLabelMelodiaGenerada;
	private JLabel jLabelClaveSol;
	private JLabel jLabelTituloFigura;
	private JLabel jLabelTituloPentagrama;
	private JPanel panel;
	private JPanelPentagrama panelPentagramaFa5;
	private JPanelPentagrama panelPentagramaMi5;
	private JLabel lblNotaActual;
	private JPanelPentagrama panelPentagramaRe5;
	private JPanelPentagrama panelPentagramaSi4;
	private JPanelPentagrama panelPentagramaSol4;
	private JPanelPentagrama panelPentagramaMi4;
	private JPanelPentagrama panelPentagramaDo5;
	private JPanelPentagrama panelPentagramaLa4;
	private JPanelPentagrama panelPentagramaFa4;
	private JPanelPentagrama panelPentagramaRe4;
	private JPanelPentagrama panelPentagramaSol5;
	private List<JPanelPentagrama> listaPanelesPentagrama = new ArrayList<JPanelPentagrama>();
	private List<JLabelDuracionNota> listaLabelsDuracionNota = new ArrayList<JLabelDuracionNota>();
	private JPanelPentagrama panelPentagramaDo4;
	private DuracionNota duracionSeleccionada;
	private Melodia melodia;
	private EntonacionNota notaSeleccionada;
	private JLabel lblMelodiaGenerada;
	private JTextField lblMelodiaGeneradaContenido;
	private JLabel lblBotonPlay;
	private JLabel lblNewLabel;
	private JLabel lblBotonTocarMelodia;
	private JTextField lblMelodiaPegada;

	public JCompositor() {
		this.initialize();
	}

	private void initialize() {
		//inicializo la melodia
		this.melodia = new Melodia();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Mozart");
		this.setSize(536, 400);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 224, 264, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 199, 0, 0, 0, 20, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		jLabelTituloFigura = new JLabel("Figura");
		jLabelTituloFigura.setBounds(0, 0, 194, 30);
		jLabelTituloFigura.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelTituloFigura.setPreferredSize(new Dimension(120, 30));
		GridBagConstraints gbc_jLabelTituloFigura = new GridBagConstraints();
		gbc_jLabelTituloFigura.anchor = GridBagConstraints.NORTH;
		gbc_jLabelTituloFigura.fill = GridBagConstraints.HORIZONTAL;
		gbc_jLabelTituloFigura.insets = new Insets(0, 0, 5, 5);
		gbc_jLabelTituloFigura.gridx = 0;
		gbc_jLabelTituloFigura.gridy = 0;
		this.getContentPane().add(jLabelTituloFigura, gbc_jLabelTituloFigura);
		jLabelTituloPentagrama = new JLabel("Pentagrama");
		jLabelTituloPentagrama.setBounds(199, 0, 199, 30);
		jLabelTituloPentagrama.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelTituloPentagrama.setPreferredSize(new Dimension(120, 30));
		GridBagConstraints gbc_jLabelTituloPentagrama = new GridBagConstraints();
		gbc_jLabelTituloPentagrama.anchor = GridBagConstraints.NORTH;
		gbc_jLabelTituloPentagrama.fill = GridBagConstraints.HORIZONTAL;
		gbc_jLabelTituloPentagrama.insets = new Insets(0, 0, 5, 0);
		gbc_jLabelTituloPentagrama.gridx = 1;
		gbc_jLabelTituloPentagrama.gridy = 0;
		this.getContentPane().add(jLabelTituloPentagrama,
				gbc_jLabelTituloPentagrama);

		this.pnlSeleccionDuracion = new JPanel(new GridLayout(8, 1));

		// construimos el panel para la duracion de la nota
		jLabelRedonda = new JLabelDuracionNota(DuracionNota.REDONDA);
		jLabelBlanca = new JLabelDuracionNota(DuracionNota.BLANCA);
		jLabelNegra = new JLabelDuracionNota(DuracionNota.NEGRA);
		jLabelCorchea = new JLabelDuracionNota(DuracionNota.CORCHEA);
		jLabelSemicorchea = new JLabelDuracionNota(DuracionNota.SEMICORCHEA);
		jLabelFusa = new JLabelDuracionNota(DuracionNota.FUSA);
		jLabelSemifusa = new JLabelDuracionNota(DuracionNota.SEMIFUSA);

		inicializarEstiloJLabel(jLabelRedonda);
		inicializarEstiloJLabel(jLabelBlanca);
		inicializarEstiloJLabel(jLabelNegra);
		inicializarEstiloJLabel(jLabelCorchea);
		inicializarEstiloJLabel(jLabelSemicorchea);
		inicializarEstiloJLabel(jLabelFusa);
		inicializarEstiloJLabel(jLabelSemifusa);

		this.pnlSeleccionDuracion.add(jLabelRedonda);
		this.pnlSeleccionDuracion.add(jLabelBlanca);
		this.pnlSeleccionDuracion.add(jLabelNegra);
		this.pnlSeleccionDuracion.add(jLabelCorchea);
		this.pnlSeleccionDuracion.add(jLabelSemicorchea);
		this.pnlSeleccionDuracion.add(jLabelFusa);
		this.pnlSeleccionDuracion.add(jLabelSemifusa);
		GridBagConstraints gbc_pnlSeleccionDuracion = new GridBagConstraints();
		gbc_pnlSeleccionDuracion.fill = GridBagConstraints.BOTH;
		gbc_pnlSeleccionDuracion.insets = new Insets(0, 0, 5, 5);
		gbc_pnlSeleccionDuracion.gridx = 0;
		gbc_pnlSeleccionDuracion.gridy = 1;
		this.getContentPane().add(pnlSeleccionDuracion,
				gbc_pnlSeleccionDuracion);
		// construimos el panel para mostrar la nota
		jLabelMelodiaGenerada = new JLabel("melodiaaa");
		jLabelMelodiaGenerada.setBounds(159, 35, 74, 15);

		jLabelRedonda.setIcon(new ImageIcon(JCompositor.class.getResource("/resources/redonda.png")));
		jLabelBlanca.setIcon(new ImageIcon(JCompositor.class.getResource("/resources/blanca.png")));
		jLabelNegra.setIcon(new ImageIcon(JCompositor.class.getResource("/resources/negra.png")));
		jLabelCorchea.setIcon(new ImageIcon(JCompositor.class.getResource("/resources/corchea.png")));
		jLabelSemicorchea.setIcon(new ImageIcon(JCompositor.class.getResource("/resources/semicorchea.png")));
		jLabelFusa.setIcon(new ImageIcon(JCompositor.class.getResource("/resources/fusa.png")));
		jLabelSemifusa.setIcon(new ImageIcon(JCompositor.class.getResource("/resources/semifusa.png")));

		listaLabelsDuracionNota.add(jLabelRedonda);
		listaLabelsDuracionNota.add(jLabelBlanca);
		listaLabelsDuracionNota.add(jLabelNegra);
		listaLabelsDuracionNota.add(jLabelCorchea);
		listaLabelsDuracionNota.add(jLabelSemicorchea);
		listaLabelsDuracionNota.add(jLabelFusa);
		listaLabelsDuracionNota.add(jLabelSemifusa);
		
		panel = new JPanel();
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);

		JPanel pnlContenedorPentagrama = new JPanel();
		pnlContenedorPentagrama.setBounds(46, 53, 157, 110);
		panel.add(pnlContenedorPentagrama);
		pnlContenedorPentagrama.setLayout(null);

		// construimos el panel para la seleccion de la nota
		jLabelClaveSol = new JLabel();
		jLabelClaveSol.setBounds(0, 0, 35, 98);
		pnlContenedorPentagrama.add(jLabelClaveSol);
		jLabelClaveSol.setIcon(new ImageIcon(JCompositor.class
				.getResource("/resources/clavesol.png")));

		panelPentagramaSol5 = new JPanelPentagrama(this);
		panelPentagramaSol5.setNota(EntonacionNota.G5);
		panelPentagramaSol5.setBounds(0, 8, 154, 10);
		listaPanelesPentagrama.add(panelPentagramaSol5);
		pnlContenedorPentagrama.add(panelPentagramaSol5);

		panelPentagramaFa5 = new JPanelPentagrama(this);
		panelPentagramaFa5.setNota(EntonacionNota.F5);
		panelPentagramaFa5.setBounds(0, 19, 154, 2);
		pnlContenedorPentagrama.add(panelPentagramaFa5);
		listaPanelesPentagrama.add(panelPentagramaFa5);
		panelPentagramaFa5.setBackground(Color.BLACK);

		panelPentagramaMi5 = new JPanelPentagrama(this);
		panelPentagramaMi5.setNota(EntonacionNota.E5);
		panelPentagramaMi5.setBounds(0, 23, 154, 10);
		listaPanelesPentagrama.add(panelPentagramaMi5);
		pnlContenedorPentagrama.add(panelPentagramaMi5);

		panelPentagramaRe5 = new JPanelPentagrama(this);
		panelPentagramaRe5.setNota(EntonacionNota.D5);
		panelPentagramaRe5.setBounds(new Rectangle(0, 0, 100, 2));
		panelPentagramaRe5.setBounds(0, 35, 154, 2);
		listaPanelesPentagrama.add(panelPentagramaRe5);
		pnlContenedorPentagrama.add(panelPentagramaRe5);
		panelPentagramaRe5.setBackground(Color.BLACK);

		panelPentagramaDo5 = new JPanelPentagrama(this);
		panelPentagramaDo5.setNota(EntonacionNota.C5);
		panelPentagramaDo5.setBounds(0, 38, 154, 10);
		listaPanelesPentagrama.add(panelPentagramaDo5);
		pnlContenedorPentagrama.add(panelPentagramaDo5);

		panelPentagramaSi4 = new JPanelPentagrama(this);
		panelPentagramaSi4.setNota(EntonacionNota.B4);
		panelPentagramaSi4.setBounds(new Rectangle(0, 0, 100, 2));
		panelPentagramaSi4.setBounds(0, 51, 154, 2);
		pnlContenedorPentagrama.add(panelPentagramaSi4);
		listaPanelesPentagrama.add(panelPentagramaSi4);
		panelPentagramaSi4.setBackground(Color.BLACK);

		panelPentagramaLa4 = new JPanelPentagrama(this);
		panelPentagramaLa4.setNota(EntonacionNota.A4);
		panelPentagramaLa4.setBounds(0, 54, 154, 10);
		listaPanelesPentagrama.add(panelPentagramaLa4);
		pnlContenedorPentagrama.add(panelPentagramaLa4);

		panelPentagramaSol4 = new JPanelPentagrama(this);
		panelPentagramaSol4.setNota(EntonacionNota.G4);
		panelPentagramaSol4.setBounds(new Rectangle(0, 0, 100, 2));
		panelPentagramaSol4.setBounds(0, 67, 154, 2);
		listaPanelesPentagrama.add(panelPentagramaSol4);
		pnlContenedorPentagrama.add(panelPentagramaSol4);
		panelPentagramaSol4.setBackground(Color.BLACK);

		panelPentagramaFa4 = new JPanelPentagrama(this);
		panelPentagramaFa4.setNota(EntonacionNota.F4);
		panelPentagramaFa4.setBounds(0, 70, 154, 10);
		listaPanelesPentagrama.add(panelPentagramaFa4);
		pnlContenedorPentagrama.add(panelPentagramaFa4);

		panelPentagramaMi4 = new JPanelPentagrama(this);
		panelPentagramaMi4.setNota(EntonacionNota.E4);
		panelPentagramaMi4.setBounds(new Rectangle(0, 0, 100, 2));
		panelPentagramaMi4.setBounds(0, 83, 154, 2);
		listaPanelesPentagrama.add(panelPentagramaMi4);
		pnlContenedorPentagrama.add(panelPentagramaMi4);
		panelPentagramaMi4.setBackground(Color.BLACK);

		panelPentagramaRe4 = new JPanelPentagrama(this);
		panelPentagramaRe4.setNota(EntonacionNota.D4);
		panelPentagramaRe4.setBounds(0, 85, 154, 10);
		listaPanelesPentagrama.add(panelPentagramaRe4);
		pnlContenedorPentagrama.add(panelPentagramaRe4);

		panelPentagramaDo4 = new JPanelPentagrama(this);
		panelPentagramaDo4.setNota(EntonacionNota.C4);
		panelPentagramaDo4.setBounds(0, 97, 154, 3);
		listaPanelesPentagrama.add(panelPentagramaDo4);
		pnlContenedorPentagrama.add(panelPentagramaDo4);

		lblNotaActual = new JLabel(SIN_NOTA_SELECCIONADA);
		lblNotaActual.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotaActual.setBounds(91, 175, 70, 15);
		panel.add(lblNotaActual);
		
		lblMelodiaGenerada = new JLabel("Melodia Generada");
		GridBagConstraints gbc_lblMelodiaGenerada = new GridBagConstraints();
		gbc_lblMelodiaGenerada.insets = new Insets(0, 0, 5, 5);
		gbc_lblMelodiaGenerada.gridx = 0;
		gbc_lblMelodiaGenerada.gridy = 2;
		getContentPane().add(lblMelodiaGenerada, gbc_lblMelodiaGenerada);
		
		lblBotonPlay = new JLabel("");
		GridBagConstraints gbc_lblBotonPlay = new GridBagConstraints();
		gbc_lblBotonPlay.insets = new Insets(0, 0, 5, 0);
		gbc_lblBotonPlay.gridx = 1;
		gbc_lblBotonPlay.gridy = 2;
		getContentPane().add(lblBotonPlay, gbc_lblBotonPlay);
		lblBotonPlay.setIcon(new ImageIcon(JCompositor.class.getResource("/resources/play.png")));
		
		lblMelodiaGeneradaContenido = new JTextField("...");
		GridBagConstraints gbc_lblMelodiaGeneradaContenido = new GridBagConstraints();
		gbc_lblMelodiaGeneradaContenido.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblMelodiaGeneradaContenido.gridwidth = 2;
		gbc_lblMelodiaGeneradaContenido.insets = new Insets(0, 0, 5, 0);
		gbc_lblMelodiaGeneradaContenido.gridx = 0;
		gbc_lblMelodiaGeneradaContenido.gridy = 3;
		getContentPane().add(lblMelodiaGeneradaContenido, gbc_lblMelodiaGeneradaContenido);
		lblMelodiaGeneradaContenido.setEditable(false);


		
		lblNewLabel = new JLabel("Tocar Melodia");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 4;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		lblBotonTocarMelodia = new JLabel("");
		lblBotonTocarMelodia.setIcon(new ImageIcon(JCompositor.class.getResource("/resources/play.png")));
		GridBagConstraints gbc_lblBotonTocarMelodia = new GridBagConstraints();
		gbc_lblBotonTocarMelodia.insets = new Insets(0, 0, 5, 0);
		gbc_lblBotonTocarMelodia.gridx = 1;
		gbc_lblBotonTocarMelodia.gridy = 4;
		getContentPane().add(lblBotonTocarMelodia, gbc_lblBotonTocarMelodia);
		
		lblMelodiaPegada = new JTextField();
		lblMelodiaPegada.setText("Cq Dq Gq F#q Dq Ch Cq Dq Gq F#q Dq Ch Cq Dq Gq F#q Dq Bminw Bh");
		GridBagConstraints gbc_lblMelodiaPegada = new GridBagConstraints();
		gbc_lblMelodiaPegada.gridwidth = 2;
		gbc_lblMelodiaPegada.insets = new Insets(0, 0, 0, 5);
		gbc_lblMelodiaPegada.fill = GridBagConstraints.BOTH;
		gbc_lblMelodiaPegada.gridx = 0;
		gbc_lblMelodiaPegada.gridy = 5;
		getContentPane().add(lblMelodiaPegada, gbc_lblMelodiaPegada);
		lblMelodiaPegada.setColumns(10);
		
		
		inicializarListenersHintNotaActual(listaPanelesPentagrama);
		inicializarListenersDuracionSeleccionada(listaLabelsDuracionNota);
		inicializarListenersEntonacionNotaSeleccionada(listaPanelesPentagrama);
		inicializarListenerPlayMelodia(lblBotonPlay);
		inicializarListenerPlayMelodiaPegada(lblBotonTocarMelodia);
		
	}

	private void inicializarListenerPlayMelodiaPegada(JLabel lblBotonPlay2) {
		lblBotonPlay2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FogueService.instancia().ejecutarMelodia(lblMelodiaPegada.getText());
			}
		});
	}

	private void inicializarListenerPlayMelodia(JLabel lblBotonPlay2) {
		lblBotonPlay2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FogueService.instancia().ejecutarMelodia(melodia.getMelodia());
			}
		});
		
	}

	private void inicializarListenersEntonacionNotaSeleccionada(
			final List<JPanelPentagrama> listaPaneles) {
		MouseAdapter mouseAdapterClick = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanelPentagrama lSeleccionado = (JPanelPentagrama) e.getSource();
				resetearPanelsClickeados(lSeleccionado,listaPaneles);
				agregarNotaEnMelodia(lSeleccionado.getNota(),lSeleccionado);
				
			}
		};
		for (JPanelPentagrama jPanel : listaPaneles) {
			jPanel.addMouseListener(mouseAdapterClick);
		}
		
	}

	protected void agregarNotaEnMelodia(EntonacionNota nota, JPanelPentagrama lSeleccionado) {
		this.notaSeleccionada = nota;
		if(this.duracionSeleccionada!=null  && this.notaSeleccionada != null){
			this.melodia.agregarNota(this.notaSeleccionada, this.duracionSeleccionada);
			this.duracionSeleccionada = null;			
			this.notaSeleccionada = null;
			resetearLabelsClickeados(null,listaLabelsDuracionNota);
			resetearPanelsClickeados(null, listaPanelesPentagrama);
			//repinto la melodia
			this.lblMelodiaGeneradaContenido.setText(this.melodia.getMelodia());
		}

	}


	protected void resetearPanelsClickeados(JPanelPentagrama pSeleccionado,
			List<JPanelPentagrama> listaPaneles) {
		
		for (JPanelPentagrama jPanel : listaPaneles) {
			if(!jPanel.equals(pSeleccionado)){
				jPanel.resetClick();
			}
		}
		
		
	}

	private void inicializarListenersDuracionSeleccionada(
			final List<JLabelDuracionNota> listaLabels) {
		MouseAdapter mouseAdapterClick = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabelDuracionNota lSeleccionado = (JLabelDuracionNota) e.getSource();
				setearDuracionNota(lSeleccionado.getDuracion());
				resetearLabelsClickeados(lSeleccionado,listaLabels);
			}
		};
		for (JLabelDuracionNota jLabelDuracionNota : listaLabels) {
			jLabelDuracionNota.addMouseListener(mouseAdapterClick);
		}
	}

	/**
	 * Resetea el estado click de todos los labels, excepto el pasado como parametro
	 * @param lSeleccionado
	 * @param listaLabels 
	 */
	protected void resetearLabelsClickeados(JLabelDuracionNota lSeleccionado, List<JLabelDuracionNota> listaLabels) {
		
		for (JLabelDuracionNota jLabelDuracionNota : listaLabels) {
			if(!jLabelDuracionNota.equals(lSeleccionado)){
				jLabelDuracionNota.resetClick();
			}
		}
		
	}

	protected void setearDuracionNota(DuracionNota duracion) {
		this.duracionSeleccionada = duracion;
	}

	/**
	 * Le agrego a todos los elementos de la lista, el mismo listener para que
	 * actualicen el label de la nota actual
	 * 
	 * @param lista
	 */
	private void inicializarListenersHintNotaActual(List<JPanelPentagrama> lista) {
		MouseAdapter mouseListenerActualizarEstadoNota = new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				JPanelPentagrama jp = (JPanelPentagrama) e.getSource();
				lblNotaActual.setText(jp.getNota().name());
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNotaActual.setText(SIN_NOTA_SELECCIONADA);
			}
			
		};
		for (JPanelPentagrama jPanelPentagrama : lista) {
			jPanelPentagrama.addMouseListener(mouseListenerActualizarEstadoNota);
		}
	}

	private void inicializarEstiloJLabel(JLabel jLabelRedonda) {
		jLabelRedonda.setHorizontalAlignment(JLabel.RIGHT);
		jLabelRedonda.setVerticalAlignment(JLabel.BOTTOM);
		jLabelRedonda.setBackground(Color.lightGray);
		jLabelRedonda.setOpaque(true);
		jLabelRedonda.setHorizontalTextPosition(SwingConstants.LEFT);
	}
}
