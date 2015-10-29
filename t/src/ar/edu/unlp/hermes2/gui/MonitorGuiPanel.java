package ar.edu.unlp.hermes2.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerDateModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.JXTable;

import ar.edu.unlp.hermes2.model.Categoria;
import ar.edu.unlp.hermes2.model.Contexto;
import ar.edu.unlp.hermes2.model.Etiqueta;
import ar.edu.unlp.hermes2.model.Mensaje;
import ar.edu.unlp.hermes2.model.Ninio;
import ar.edu.unlp.hermes2.model.Notificacion;
import ar.edu.unlp.hermes2.model.TransferObject;
import ar.edu.unlp.hermes2.monitor.FiltroNotificacion;
import ar.edu.unlp.hermes2.monitor.MonitorCore;
import ar.edu.unlp.hermes2.monitor.MonitorUtils;
import net.miginfocom.swing.MigLayout;

public class MonitorGuiPanel extends JPanel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8242603121100243154L;
	private static Logger logger = Logger.getLogger(MonitorGuiPanel.class.getName());
	private JXPanel panelContenedorFiltros;
	private JXPanel panelContenedorNotificaciones;
	private JXPanel panelContenedorEtiquetas;
	private JTextField textFieldNuevoNombreEtiqueta;
	private JComboBox<TransferObject> comboBoxContenido;
	private JComboBox<TransferObject> comboBoxContexto;
	private JComboBox<TransferObject> comboBoxNinios;
	private JComboBox<TransferObject> comboBoxCategoria;
	private JXDateTimePicker dateTimePickerDesde;
	private JButton btnCrear;
	private JButton btnEliminar;
	private JButton btnAsignar;
	private JButton btnRenombrar;
	private JTextField textFieldEtiquetaNueva;
	private JComboBox<TransferObject> comboBoxEtiqueta;
	private JButton btnFiltrar;
	private JXDateTimePicker dateTimePickerHasta;
	private JXTable tablaNotificaciones;
	private JComboBox<TransferObject> comboBoxEtiquetaEliminar;
	private JComboBox<TransferObject> comboBoxEtiquetaAsignar;
	private JComboBox<TransferObject> comboBoxEtiquetaRenombrar;
	protected Etiqueta etiquetaARenombrar;

	public MonitorGuiPanel() {
		setPreferredSize(new Dimension(1024, 600));

		panelContenedorFiltros = new JXPanel();
		panelContenedorFiltros.setBackground(Color.LIGHT_GRAY);
		panelContenedorFiltros.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Filtros",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));

		panelContenedorEtiquetas = new JXPanel();
		panelContenedorEtiquetas.setBackground(Color.LIGHT_GRAY);
		panelContenedorEtiquetas.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Etiquetas",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));

		panelContenedorNotificaciones = new JXPanel();
		panelContenedorNotificaciones.setBackground(Color.LIGHT_GRAY);
		panelContenedorNotificaciones.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Notificaciones",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelContenedorFiltros, GroupLayout.PREFERRED_SIZE, 508, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelContenedorEtiquetas, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE))
				.addComponent(panelContenedorNotificaciones, GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(panelContenedorFiltros, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelContenedorEtiquetas, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelContenedorNotificaciones, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panelContenedorNotificaciones.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panelContenedorNotificaciones.add(scrollPane);

		tablaNotificaciones = new JXTable();
		scrollPane.setViewportView(tablaNotificaciones);
		tablaNotificaciones.setModel(new ModelTablaNotificaciones(new ArrayList<Notificacion>()));
		
		tablaNotificaciones.setVisibleColumnCount(1);
		tablaNotificaciones.setColumnControlVisible(true);
		tablaNotificaciones.getColumnModel().getColumn(0).setPreferredWidth(78);
		tablaNotificaciones.getColumnModel().getColumn(1).setPreferredWidth(78);
		tablaNotificaciones.getColumnModel().getColumn(2).setPreferredWidth(78);
		tablaNotificaciones.getColumnModel().getColumn(3).setPreferredWidth(78);
		tablaNotificaciones.getColumnModel().getColumn(4).setPreferredWidth(78);
		tablaNotificaciones.getColumnModel().getColumn(5).setPreferredWidth(78);
		tablaNotificaciones.setDefaultRenderer(Object.class, new TablaNotificacionesCellRenderer());
		panelContenedorEtiquetas.setLayout(new MigLayout("", "[][grow][]", "[][19.00][][14.00][][][][]"));

		JLabel lblCrearEtiqueta = new JLabel("Crear Etiqueta:");
		panelContenedorEtiquetas.add(lblCrearEtiqueta, "cell 0 0,alignx trailing");

		textFieldEtiquetaNueva = new JTextField();
		textFieldEtiquetaNueva.setColumns(10);
		panelContenedorEtiquetas.add(textFieldEtiquetaNueva, "cell 1 0,growx");

		btnCrear = new JButton("Crear");
		panelContenedorEtiquetas.add(btnCrear, "cell 2 0,growx");

		JSeparator separator = new JSeparator();
		separator.setBackground(Color.GRAY);
		panelContenedorEtiquetas.add(separator, "cell 0 1 3 1,growx");

		JLabel lblEliminarEtiqueta = new JLabel("Eliminar Etiqueta:");
		panelContenedorEtiquetas.add(lblEliminarEtiqueta, "cell 0 2,alignx trailing");

		comboBoxEtiquetaEliminar = new JComboBox();
		panelContenedorEtiquetas.add(comboBoxEtiquetaEliminar, "cell 1 2,growx");

		btnEliminar = new JButton("Eliminar");
		panelContenedorEtiquetas.add(btnEliminar, "cell 2 2,growx");

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.GRAY);
		panelContenedorEtiquetas.add(separator_1, "cell 0 3 3 1,growx");

		JLabel lblAsignarEtiqueta = new JLabel("Asignar Etiqueta:");
		panelContenedorEtiquetas.add(lblAsignarEtiqueta, "cell 0 4,alignx trailing");

		comboBoxEtiquetaAsignar = new JComboBox();
		panelContenedorEtiquetas.add(comboBoxEtiquetaAsignar, "cell 1 4,growx");

		btnAsignar = new JButton("Asignar");
		panelContenedorEtiquetas.add(btnAsignar, "cell 2 4,growx");

		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.GRAY);
		panelContenedorEtiquetas.add(separator_2, "cell 0 5 3 1,growx");

		JLabel lblRenombrarEtiqueta = new JLabel("Renombrar Etiqueta:");
		panelContenedorEtiquetas.add(lblRenombrarEtiqueta, "cell 0 6,alignx trailing");

		comboBoxEtiquetaRenombrar = new JComboBox();
		panelContenedorEtiquetas.add(comboBoxEtiquetaRenombrar, "cell 1 6,growx");

		JLabel lblNuevoNombre = new JLabel("Nuevo Nombre:");
		panelContenedorEtiquetas.add(lblNuevoNombre, "cell 0 7,alignx trailing");

		textFieldNuevoNombreEtiqueta = new JTextField();
		panelContenedorEtiquetas.add(textFieldNuevoNombreEtiqueta, "cell 1 7,grow");
		textFieldNuevoNombreEtiqueta.setColumns(10);

		btnRenombrar = new JButton("Renombrar");
		panelContenedorEtiquetas.add(btnRenombrar, "cell 2 7,growx");

		JLabel lblContenido = new JLabel("Contenido:");

		comboBoxContenido = new JComboBox();
		comboBoxContenido.setModel(new DefaultComboBoxModel(new String[] { "Entusiasmado" }));

		JLabel lblContexto = new JLabel("Contexto:");

		comboBoxContexto = new JComboBox();

		JLabel lblCategoria = new JLabel("Categor\u00EDa:");

		comboBoxCategoria = new JComboBox();

		JLabel lblNinio = new JLabel("Ni\u00F1@:");

		comboBoxNinios = new JComboBox();

		JLabel lblFechahora = new JLabel("Fecha/Hora");

		JLabel lblDesde = new JLabel("desde:");

		JLabel lblHasta = new JLabel("hasta:");

		dateTimePickerDesde = new JXDateTimePicker();
		dateTimePickerDesde.setFormats(new String[] { "dd/MM/yyyy HH:mm" });
		dateTimePickerDesde.setFormats(DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM));
		dateTimePickerDesde.setTimeFormat(DateFormat.getTimeInstance(DateFormat.MEDIUM));
		dateTimePickerDesde.setDate(new Date());

		dateTimePickerHasta = new JXDateTimePicker();
		dateTimePickerHasta.setFormats(new String[] { "dd/MM/yyyy HH:mm" });
		dateTimePickerHasta.setFormats(DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM));
		dateTimePickerHasta.setTimeFormat(DateFormat.getTimeInstance(DateFormat.MEDIUM));
		dateTimePickerHasta.setDate(new Date());

		JLabel lblEtiqueta = new JLabel("Etiqueta:");

		comboBoxEtiqueta = new JComboBox();

		btnFiltrar = new JButton("Filtrar");
		GroupLayout gl_panelContenedorFiltros = new GroupLayout(panelContenedorFiltros);
		gl_panelContenedorFiltros.setHorizontalGroup(
			gl_panelContenedorFiltros.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelContenedorFiltros.createSequentialGroup()
					.addGroup(gl_panelContenedorFiltros.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panelContenedorFiltros.createSequentialGroup()
							.addGap(6)
							.addComponent(btnFiltrar, GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_panelContenedorFiltros.createSequentialGroup()
							.addGap(6)
							.addComponent(lblEtiqueta)
							.addGap(21)
							.addComponent(comboBoxEtiqueta, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_panelContenedorFiltros.createSequentialGroup()
							.addGroup(gl_panelContenedorFiltros.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelContenedorFiltros.createSequentialGroup()
									.addGap(92)
									.addComponent(dateTimePickerDesde, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelContenedorFiltros.createSequentialGroup()
									.addGap(6)
									.addGroup(gl_panelContenedorFiltros.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelContenedorFiltros.createSequentialGroup()
											.addComponent(lblFechahora)
											.addGap(6)
											.addComponent(lblDesde))
										.addGroup(gl_panelContenedorFiltros.createParallelGroup(Alignment.LEADING, false)
											.addGroup(gl_panelContenedorFiltros.createSequentialGroup()
												.addComponent(lblNinio)
												.addGap(46)
												.addComponent(comboBoxNinios, 0, 0, Short.MAX_VALUE))
											.addGroup(gl_panelContenedorFiltros.createSequentialGroup()
												.addComponent(lblContexto)
												.addGap(17)
												.addComponent(comboBoxContexto, 0, 0, Short.MAX_VALUE))
											.addGroup(gl_panelContenedorFiltros.createSequentialGroup()
												.addComponent(lblContenido)
												.addGap(8)
												.addComponent(comboBoxContenido, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))))))
							.addGap(18)
							.addGroup(gl_panelContenedorFiltros.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelContenedorFiltros.createSequentialGroup()
									.addComponent(lblCategoria)
									.addGap(2)
									.addComponent(comboBoxCategoria, 0, 190, Short.MAX_VALUE))
								.addComponent(lblHasta)
								.addComponent(dateTimePickerHasta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_panelContenedorFiltros.setVerticalGroup(
			gl_panelContenedorFiltros.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelContenedorFiltros.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_panelContenedorFiltros.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelContenedorFiltros.createSequentialGroup()
							.addGap(11)
							.addComponent(lblContenido))
						.addGroup(gl_panelContenedorFiltros.createSequentialGroup()
							.addGap(6)
							.addComponent(comboBoxContenido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelContenedorFiltros.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelContenedorFiltros.createSequentialGroup()
							.addGap(5)
							.addComponent(lblContexto))
						.addGroup(gl_panelContenedorFiltros.createParallelGroup(Alignment.BASELINE)
							.addComponent(comboBoxContexto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblCategoria)
							.addComponent(comboBoxCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panelContenedorFiltros.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelContenedorFiltros.createSequentialGroup()
							.addGap(11)
							.addComponent(lblNinio))
						.addGroup(gl_panelContenedorFiltros.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBoxNinios, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelContenedorFiltros.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFechahora)
						.addGroup(gl_panelContenedorFiltros.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblDesde)
							.addComponent(lblHasta)))
					.addGap(13)
					.addGroup(gl_panelContenedorFiltros.createParallelGroup(Alignment.BASELINE)
						.addComponent(dateTimePickerDesde, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(dateTimePickerHasta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panelContenedorFiltros.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelContenedorFiltros.createSequentialGroup()
							.addGap(17)
							.addComponent(lblEtiqueta))
						.addGroup(gl_panelContenedorFiltros.createSequentialGroup()
							.addGap(12)
							.addComponent(comboBoxEtiqueta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnFiltrar)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelContenedorFiltros.setLayout(gl_panelContenedorFiltros);
		setLayout(groupLayout);

		JSpinner timeSpinner = new JSpinner(new SpinnerDateModel());


		
		this.cargarDatosParaFiltros();
		this.asignarEventoBotonFiltrar();
		this.asignarEventoBotonesEtiquetas();
		this.filtrarNotificaciones(new FiltroNotificacion());
		this.cargarCombosPanelEtiquetas();
		//agregar el patter observer para que funcione la actualizacion de notificaciones
		//cuando se recibe alguna
		MonitorCore.instance().addObserver(this);
		
	}



	/**
	 * Completa la informacion para el panel de filtros
	 */
	private void cargarDatosParaFiltros() {
		try{
			List<TransferObject> lista = MonitorCore.instance().getListaMensajes();
			comboBoxContenido.setModel(MonitorUtils.crearModelCombobox(lista, true));
			comboBoxContexto.setModel(MonitorUtils.crearModelCombobox(MonitorCore.instance().getListaContextos(), true));
			comboBoxNinios.setModel(MonitorUtils.crearModelCombobox(MonitorCore.instance().getListaNinios(), true));
			comboBoxCategoria.setModel(MonitorUtils.crearModelCombobox(MonitorCore.instance().getListaCategorias(), true));
			comboBoxEtiqueta.setModel(MonitorUtils.crearModelCombobox(MonitorCore.instance().getListaEtiquetas(), true));
			//seteo de manera predeterminada para el filtro de fechas para el periodo de una semana hacia atras
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_MONTH, -7);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			dateTimePickerDesde.setDate(cal.getTime());
			cal = Calendar.getInstance();
			cal.set(Calendar.HOUR_OF_DAY, 23);
			cal.set(Calendar.MINUTE, 59);
			cal.set(Calendar.SECOND, 59);
			dateTimePickerHasta.setDate(cal.getTime());
		}catch (HermesException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	private void asignarEventoBotonFiltrar() {
		btnFiltrar.addActionListener(new ActionListener() {				
			@Override
			public void actionPerformed(ActionEvent e) {
				filtrarNotificaciones();
			}			
		});
	}
	
	/**
	 * 
	 */
	private void filtrarNotificaciones() {
			FiltroNotificacion filtro = obtenerFiltroDeLoSeleccionado();
			
			filtrarNotificaciones(filtro);
		
	}



	private FiltroNotificacion obtenerFiltroDeLoSeleccionado() {
		//preparo el filtro
		FiltroNotificacion filtro = new FiltroNotificacion();
		filtro.setCategoria((Categoria) MonitorUtils.getSiSeleccionado(comboBoxCategoria));
		filtro.setContexto((Contexto) MonitorUtils.getSiSeleccionado(comboBoxContexto));
		filtro.setEtiqueta((Etiqueta) MonitorUtils.getSiSeleccionado(comboBoxEtiqueta));
		filtro.setNinio((Ninio)MonitorUtils.getSiSeleccionado(comboBoxNinios));
		filtro.setMensaje((Mensaje)MonitorUtils.getSiSeleccionado(comboBoxContenido));
		filtro.setFechaDesde(dateTimePickerDesde.getDate());
		filtro.setFechaHasta(dateTimePickerHasta.getDate());
		return filtro;
	}
	
	private void filtrarNotificaciones(FiltroNotificacion filtro){
		try{
			//realizo la accion de filtrar
			List<Notificacion> notificaciones = MonitorCore.instance().obtenerNotificacionesFiltradas(filtro);
			
			//actualizo la tabla
			((ModelTablaNotificaciones)tablaNotificaciones.getModel()).setTableData(notificaciones);
		}catch (HermesException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}
	
	
	/**
	 * Crea todos los listeners para cada una de las operaciones sobre
	 * etiquetas 
	 * 
	 */
	private void asignarEventoBotonesEtiquetas() {
		btnCrear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				agregarEtiqueta(textFieldEtiquetaNueva.getText());
				cargarCombosPanelEtiquetas();
				textFieldEtiquetaNueva.setText("");
			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(comboBoxEtiquetaEliminar.getSelectedItem()!=null){
					Object selectedItem = comboBoxEtiquetaEliminar.getSelectedItem();
					int dialogResult = JOptionPane.showConfirmDialog (null, "Desea eliminar la etiqueta \""+selectedItem+"\"?","Warning",JOptionPane.YES_NO_OPTION);
					if(dialogResult == JOptionPane.YES_OPTION){
						eliminarEtiqueta((Etiqueta) selectedItem);
						cargarCombosPanelEtiquetas();
					}
				}
			}
		});
		
		btnAsignar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(comboBoxEtiquetaAsignar.getSelectedItem()!=null){
					Object selectedItem = comboBoxEtiquetaAsignar.getSelectedItem();
					asignarEtiqueta((Etiqueta)selectedItem);					
				}
			}
		});
		
		btnRenombrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(etiquetaARenombrar!=null){
					renombrarEtiqueta(etiquetaARenombrar,textFieldNuevoNombreEtiqueta.getText());
					cargarCombosPanelEtiquetas();
					etiquetaARenombrar = null;
				}
			}

			
		});
		
		comboBoxEtiquetaRenombrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(comboBoxEtiquetaRenombrar.getSelectedItem()!=null){
					etiquetaARenombrar = (Etiqueta) comboBoxEtiquetaRenombrar.getSelectedItem();
					textFieldNuevoNombreEtiqueta.setText(etiquetaARenombrar.getNombre());
					btnRenombrar.setEnabled(false);
				}	
				
			}
		});
		
		textFieldNuevoNombreEtiqueta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				boolean vacio = textFieldNuevoNombreEtiqueta.getText().trim().equals("");
				boolean mismoNombre = etiquetaARenombrar != null
												&& etiquetaARenombrar.getNombre().equalsIgnoreCase(textFieldNuevoNombreEtiqueta.getText());
				btnRenombrar.setEnabled(!vacio && !mismoNombre);
				
			}
		});
		
	}



	/**
	 * Obtiene nuevamente la lista de etiquetas y genera un model
	 * y se lo pasa a todos los combos
	 */
	protected void cargarCombosPanelEtiquetas() {
		try{			
			comboBoxEtiquetaAsignar.setModel(MonitorUtils.crearModelCombobox(MonitorCore.instance().getListaEtiquetas()));
			comboBoxEtiquetaEliminar.setModel(MonitorUtils.crearModelCombobox(MonitorCore.instance().getListaEtiquetas()));
			comboBoxEtiquetaRenombrar.setModel(MonitorUtils.crearModelCombobox(MonitorCore.instance().getListaEtiquetas(),true));
			comboBoxEtiqueta.setModel(MonitorUtils.crearModelCombobox(MonitorCore.instance().getListaEtiquetas(),true));
		}catch (HermesException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}



	protected void agregarEtiqueta(String nombreNuevaEtiqueta) {
		try {
			MonitorCore.instance().agregarEtiqueta(nombreNuevaEtiqueta);
		} catch (HermesException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}
	

	protected void eliminarEtiqueta(Etiqueta etiqueta) {
		try {
			MonitorCore.instance().eliminarEtiqueta(etiqueta);
		} catch (HermesException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}		
	}

	protected void asignarEtiqueta(Etiqueta selectedItem) {
		try {
			int selectedRowCount = tablaNotificaciones.getSelectedRowCount();
			if(selectedRowCount>0){
				List<Long> idsNotificaciones = obtenerIdsSeleccionados();
				MonitorCore.instance().asignarEtiqueta(selectedItem,idsNotificaciones);
			}
			else{
				throw new HermesException("Debe seleccionar una o mas notificaciones");
			}	
		} catch (Exception | HermesException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
		
		
	}
	
	private void renombrarEtiqueta(Etiqueta etiqueta, String nuevoNombre) {
		try {
			MonitorCore.instance().renombrarEtiqueta(etiqueta,nuevoNombre);
		} catch (HermesException e) {
			logger.log(Level.SEVERE, e.getMessage(), e);

		}
	}



	private List<Long> obtenerIdsSeleccionados() {
		List<Long> lista = new ArrayList<Long>();
		int[] selectedRows = tablaNotificaciones.getSelectedRows();
		for (int actual : selectedRows) {
			Long id = (Long) tablaNotificaciones.getModel().getValueAt(actual,0);
			lista.add(id);			
		}
		return lista;
	}


	/**
	 * El core me esta avisando que recibio una nueva notificacion desde la red
	 * o desde un archivo
	 */
	@Override
	public void update(Observable o, Object arg) {
//		MonitorCore.instance().obtenerNotificacionesFiltradas(obtenerFiltroDeLoSeleccionado());
//		this.filtrarNotificaciones(obtenerFiltroDeLoSeleccionado());
		this.filtrarNotificaciones(new FiltroNotificacion());
	}
}
