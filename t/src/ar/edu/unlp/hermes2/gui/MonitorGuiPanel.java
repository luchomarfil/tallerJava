package ar.edu.unlp.hermes2.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerDateModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

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

public class MonitorGuiPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8242603121100243154L;
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
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(panelContenedorFiltros, GroupLayout.PREFERRED_SIZE, 508,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panelContenedorEtiquetas, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE))
				.addComponent(panelContenedorNotificaciones, GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE, false)
								.addComponent(panelContenedorFiltros, GroupLayout.PREFERRED_SIZE, 242,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(panelContenedorEtiquetas, GroupLayout.PREFERRED_SIZE, 242,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(panelContenedorNotificaciones,
								GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)));
		panelContenedorNotificaciones.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panelContenedorNotificaciones.add(scrollPane);

		tablaNotificaciones = new JXTable();
		scrollPane.setViewportView(tablaNotificaciones);
		tablaNotificaciones.setVisibleColumnCount(1);
		tablaNotificaciones.setColumnControlVisible(true);
		tablaNotificaciones.setModel(new ModelTablaNotificaciones());
		tablaNotificaciones.getColumnModel().getColumn(0).setPreferredWidth(78);
		tablaNotificaciones.getColumnModel().getColumn(1).setPreferredWidth(78);
		tablaNotificaciones.getColumnModel().getColumn(2).setPreferredWidth(78);
		tablaNotificaciones.getColumnModel().getColumn(3).setPreferredWidth(78);
		tablaNotificaciones.getColumnModel().getColumn(4).setPreferredWidth(78);
		tablaNotificaciones.getColumnModel().getColumn(5).setPreferredWidth(78);
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

		JComboBox comboBoxEtiquetaEliminar = new JComboBox();
		panelContenedorEtiquetas.add(comboBoxEtiquetaEliminar, "cell 1 2,growx");

		btnEliminar = new JButton("Eliminar");
		panelContenedorEtiquetas.add(btnEliminar, "cell 2 2,growx");

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.GRAY);
		panelContenedorEtiquetas.add(separator_1, "cell 0 3 3 1,growx");

		JLabel lblAsignarEtiqueta = new JLabel("Asignar Etiqueta:");
		panelContenedorEtiquetas.add(lblAsignarEtiqueta, "cell 0 4,alignx trailing");

		JComboBox comboBoxEtiquetaAsignar = new JComboBox();
		panelContenedorEtiquetas.add(comboBoxEtiquetaAsignar, "cell 1 4,growx");

		btnAsignar = new JButton("Asignar");
		panelContenedorEtiquetas.add(btnAsignar, "cell 2 4,growx");

		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.GRAY);
		panelContenedorEtiquetas.add(separator_2, "cell 0 5 3 1,growx");

		JLabel lblRenombrarEtiqueta = new JLabel("Renombrar Etiqueta:");
		panelContenedorEtiquetas.add(lblRenombrarEtiqueta, "cell 0 6,alignx trailing");

		JComboBox comboBoxEtiquetaRenombrar = new JComboBox();
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

		JLabel lblCategoria = new JLabel("Categoría:");

		comboBoxCategoria = new JComboBox();

		JLabel lblNinio = new JLabel("Niñ@:");

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
		gl_panelContenedorFiltros.setHorizontalGroup(gl_panelContenedorFiltros.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelContenedorFiltros.createSequentialGroup()
						.addGroup(gl_panelContenedorFiltros.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelContenedorFiltros.createSequentialGroup().addGap(6)
										.addComponent(lblEtiqueta).addGap(21).addComponent(comboBoxEtiqueta,
												GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelContenedorFiltros.createSequentialGroup()
								.addGroup(gl_panelContenedorFiltros.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelContenedorFiltros.createSequentialGroup().addGap(92)
												.addComponent(dateTimePickerDesde, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelContenedorFiltros.createSequentialGroup().addGap(6)
										.addGroup(gl_panelContenedorFiltros.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panelContenedorFiltros.createSequentialGroup()
														.addComponent(lblFechahora).addGap(6).addComponent(lblDesde))
												.addGroup(gl_panelContenedorFiltros
														.createParallelGroup(Alignment.LEADING, false)
														.addGroup(gl_panelContenedorFiltros.createSequentialGroup()
																.addComponent(lblNinio).addGap(46)
																.addComponent(comboBoxNinios, 0, 0, Short.MAX_VALUE))
														.addGroup(gl_panelContenedorFiltros.createSequentialGroup()
																.addComponent(lblContexto).addGap(17)
																.addComponent(comboBoxContexto, 0, 0, Short.MAX_VALUE))
														.addGroup(gl_panelContenedorFiltros.createSequentialGroup()
																.addComponent(lblContenido).addGap(8).addComponent(
																		comboBoxContenido, GroupLayout.PREFERRED_SIZE,
																		142, GroupLayout.PREFERRED_SIZE))))))
								.addGap(18)
								.addGroup(gl_panelContenedorFiltros.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelContenedorFiltros.createSequentialGroup()
												.addComponent(lblCategoria).addGap(2)
												.addComponent(comboBoxCategoria, 0, 123, Short.MAX_VALUE))
										.addComponent(lblHasta).addComponent(dateTimePickerHasta,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panelContenedorFiltros.createSequentialGroup().addGap(6).addComponent(btnFiltrar,
								GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)))
						.addContainerGap()));
		gl_panelContenedorFiltros.setVerticalGroup(gl_panelContenedorFiltros.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelContenedorFiltros.createSequentialGroup().addGap(6)
						.addGroup(gl_panelContenedorFiltros.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelContenedorFiltros.createSequentialGroup().addGap(11)
										.addComponent(lblContenido))
						.addGroup(gl_panelContenedorFiltros.createSequentialGroup().addGap(6).addComponent(
								comboBoxContenido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelContenedorFiltros.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelContenedorFiltros.createSequentialGroup().addGap(5)
										.addComponent(lblContexto))
								.addGroup(gl_panelContenedorFiltros.createParallelGroup(Alignment.BASELINE)
										.addComponent(comboBoxContexto, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCategoria).addComponent(comboBoxCategoria,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panelContenedorFiltros.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelContenedorFiltros.createSequentialGroup().addGap(11)
										.addComponent(lblNinio))
								.addGroup(gl_panelContenedorFiltros.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(comboBoxNinios,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelContenedorFiltros.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFechahora)
								.addGroup(gl_panelContenedorFiltros.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblDesde).addComponent(lblHasta)))
						.addGap(13)
						.addGroup(gl_panelContenedorFiltros.createParallelGroup(Alignment.BASELINE)
								.addComponent(dateTimePickerDesde, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(dateTimePickerHasta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelContenedorFiltros.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelContenedorFiltros.createSequentialGroup().addGap(17)
										.addComponent(lblEtiqueta))
								.addGroup(gl_panelContenedorFiltros.createSequentialGroup().addGap(12).addComponent(
										comboBoxEtiqueta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnFiltrar).addContainerGap()));
		panelContenedorFiltros.setLayout(gl_panelContenedorFiltros);
		setLayout(groupLayout);
		// TODO Auto-generated constructor stub

		JSpinner timeSpinner = new JSpinner(new SpinnerDateModel());

		this.cargarDatosParaFiltros();
		this.asignarEventoBotonFiltrar();

	}

	/**
	 * Completa la informacion para el panel de filtros
	 */
	private void cargarDatosParaFiltros() {
		List<TransferObject> lista = MonitorCore.instance().getListaMensajes();
		comboBoxContenido.setModel(MonitorUtils.crearModelCombobox(lista, true));
		comboBoxContexto.setModel(MonitorUtils.crearModelCombobox(MonitorCore.instance().getListaContextos(), true));
		comboBoxNinios.setModel(MonitorUtils.crearModelCombobox(MonitorCore.instance().getListaNinios(), true));
		comboBoxCategoria.setModel(MonitorUtils.crearModelCombobox(MonitorCore.instance().getListaCategorias(), true));
		comboBoxEtiqueta.setModel(MonitorUtils.crearModelCombobox(MonitorCore.instance().getListaEtiquetas(), true));
	}

	private void asignarEventoBotonFiltrar() {
		btnFiltrar.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				//preparo el filtro
				FiltroNotificacion filtro = new FiltroNotificacion();
				filtro.setCategoria((Categoria) MonitorUtils.getSiSeleccionado(comboBoxCategoria));
				filtro.setContexto((Contexto) MonitorUtils.getSiSeleccionado(comboBoxContexto));
				filtro.setEtiqueta((Etiqueta) MonitorUtils.getSiSeleccionado(comboBoxEtiqueta));
				filtro.setNinio((Ninio)MonitorUtils.getSiSeleccionado(comboBoxNinios));
				filtro.setMensaje((Mensaje)MonitorUtils.getSiSeleccionado(comboBoxContenido));
				filtro.setFechaDesde(dateTimePickerDesde.getDate());
				filtro.setFechaHasta(dateTimePickerHasta.getDate());
				
				//realizo la accion de filtrar
				List<Notificacion> notificaciones = MonitorCore.instance().obtenerNotificacionesFiltradas(filtro);
				
				//actualizo la tabla
				tablaNotificaciones.setModel(new ModelTablaNotificaciones(notificaciones));
				
			}
		});
	}
}
