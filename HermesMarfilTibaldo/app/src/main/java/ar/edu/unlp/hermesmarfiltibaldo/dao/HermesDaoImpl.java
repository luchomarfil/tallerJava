package ar.edu.unlp.hermesmarfiltibaldo.dao;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.hermesmarfiltibaldo.model.Alumno;
import ar.edu.unlp.hermesmarfiltibaldo.model.Categoria;
import ar.edu.unlp.hermesmarfiltibaldo.model.Notificacion;
import ar.edu.unlp.hermesmarfiltibaldo.model.Pictograma;

/**
 * Created by luciano on 14/12/15.
 */

public class HermesDaoImpl implements HermesDao {

    private static final String SEXO_MASCULINO = Alumno.MASCULINO;
    private static final String SEXO_FEMENINO = Alumno.FEMENINO;
    private static final String CONFIG_KEY_IP = "ip";
    private static final String CONFIG_KEY_PORT = "port";

    private static HermesDaoImpl instance;
    private List<Alumno> l = new ArrayList<>();

    public static synchronized HermesDaoImpl instancia(){
        if(instance==null){
            instance = new HermesDaoImpl();
        }
        return instance;
    }

    public List<Alumno> getAlumnos(){
        if(l.isEmpty()) {
            l.add(new Alumno(1, "Roberto", "Perez", SEXO_MASCULINO, Alumno.NORMAL));
            l.add(new Alumno(2, "Guillote", "Coppola", SEXO_MASCULINO, Alumno.GRANDE));
            l.add(new Alumno(3, "Diego", "Maradona", SEXO_MASCULINO, Alumno.GRANDE));
            l.add(new Alumno(4, "Dalma", "Maradona", SEXO_FEMENINO, Alumno.GRANDE));
            l.add(new Alumno(5, "Gianina", "Maradona", SEXO_FEMENINO, Alumno.GRANDE));
            l.add(new Alumno(6, "Laura", "Ubfal", SEXO_FEMENINO, Alumno.GRANDE));
            l.add(new Alumno(7, "Marcelo", "Polino", SEXO_MASCULINO, Alumno.GRANDE));
            l.add(new Alumno(8, "Carolina", "Ardohain", SEXO_FEMENINO, Alumno.GRANDE));
            l.add(new Alumno(9, "Matias", "Ale", SEXO_MASCULINO, Alumno.GRANDE));
            l.add(new Alumno(10, "Mariana", "Fabiani", SEXO_FEMENINO, Alumno.GRANDE));
            l.add(new Alumno(11, "Moria", "Casán", SEXO_FEMENINO, Alumno.GRANDE));
            l.add(new Alumno(12, "Guillermo", "Andino", SEXO_MASCULINO, Alumno.GRANDE));
        }
        return l;
    }


    public List<Categoria> getCategorias(Alumno alumno) {
        List<Categoria> cats = new ArrayList<>();
        cats.add(Categoria.getCategoriaEmociones());
        cats.add(Categoria.getCategoriaEstablo());
        cats.add(Categoria.getCategoriaNecesidades());
        cats.add(Categoria.getCategoriaPista());
        return cats;
    }

    @Override
    public List<Pictograma> getPictogramas(Categoria cat, String sexo) {
        List<Pictograma> pictogramas = new ArrayList<>();

        pictogramas.add(new Pictograma(2,"Cansada","emociones/Cansada.m4a","emociones/Cansada.png",SEXO_FEMENINO,Categoria.ID_CATEGORIA_EMOCIONES));
        pictogramas.add(new Pictograma(3,"Contenta","emociones/Contenta.m4a","emociones/Contenta.png",SEXO_FEMENINO,Categoria.ID_CATEGORIA_EMOCIONES));
        pictogramas.add(new Pictograma(4,"Dolorida","emociones/Dolorida.m4a","emociones/Dolorida.png",SEXO_FEMENINO,Categoria.ID_CATEGORIA_EMOCIONES));
        pictogramas.add(new Pictograma(5,"Enojada","emociones/Enojada.m4a","emociones/Enojada.png",SEXO_FEMENINO,Categoria.ID_CATEGORIA_EMOCIONES));

        return pictogramas;

    }

    public List<Pictograma> getPictogramas(Categoria cat){
        List<Pictograma> pictogramas = new ArrayList<>();

        if(cat.getId()==Categoria.ID_CATEGORIA_EMOCIONES){
            pictogramas.add(new Pictograma(1,"Asustada","emociones/Asustada.m4a","emociones/Asustada.png",SEXO_FEMENINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(2,"Cansada","emociones/Cansada.m4a","emociones/Cansada.png",SEXO_FEMENINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(3,"Contenta","emociones/Contenta.m4a","emociones/Contenta.png",SEXO_FEMENINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(4,"Dolorida","emociones/Dolorida.m4a","emociones/Dolorida.png",SEXO_FEMENINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(5,"Enojada","emociones/Enojada.m4a","emociones/Enojada.png",SEXO_FEMENINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(6,"Sorprendida","emociones/Sorprendida.m4a","emociones/Sorprendida.png",SEXO_FEMENINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(7,"Triste","emociones/Triste.m4a","emociones/Triste Mujer.png",SEXO_FEMENINO,Categoria.ID_CATEGORIA_EMOCIONES));

            pictogramas.add(new Pictograma(9,"Asustado","emociones/Asustado.m4a","emociones/Asustado.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(10,"Cansado","emociones/Cansado.m4a","emociones/Cansdao.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(11,"Contento","emociones/Contento.m4a","emociones/Contento.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(12,"Dolorido","emociones/Dolorido.m4a","emociones/Dolorido.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(13,"Enojado","emociones/Enojado.m4a","emociones/Enojado.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(14,"Sorprendido","emociones/Sorprendido.m4a","emociones/Sorprendido.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(15,"Triste","emociones/Triste.m4a","emociones/Triste Hombre.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_EMOCIONES));
        }
        else if(cat.getId()==Categoria.ID_CATEGORIA_ESTABLO){
            pictogramas.add(new Pictograma(17,"Casco","establo/Casco.m4a","establo/Casco.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_ESTABLO));
            pictogramas.add(new Pictograma(18,"Cepillo","establo/Cepillo.m4a","establo/Cepillo.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_ESTABLO));
            pictogramas.add(new Pictograma(19,"Escarba ","establo/Escarba Vasos.m4a","establo/Escarba Vasos.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_ESTABLO));
            pictogramas.add(new Pictograma(20,"Limpieza","establo/Limpieza.m4a","establo/Limpieza.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_ESTABLO));
            pictogramas.add(new Pictograma(21,"Matra","establo/Matra.m4a","establo/Matra.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_ESTABLO));
            pictogramas.add(new Pictograma(22,"Montura","establo/Montura.m4a","establo/Montura.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_ESTABLO));
            pictogramas.add(new Pictograma(23,"Pasto","establo/Pasto.m4a","establo/Pasto.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_ESTABLO));
            pictogramas.add(new Pictograma(24,"Dolorido","establo/Dolorido.m4a","establo/Dolorido.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_ESTABLO));
            pictogramas.add(new Pictograma(25,"Rasqueta ","establo/Rasqueta Blanda.m4a","establo/Rasqueta Blanda.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_ESTABLO));
            pictogramas.add(new Pictograma(26,"Rasqueta ","establo/Rasqueta Dura.m4a","establo/Rasqueta Dura.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_ESTABLO));
            pictogramas.add(new Pictograma(27,"Riendas","establo/Riendas.m4a","establo/Riendas.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_ESTABLO));
            pictogramas.add(new Pictograma(28,"Zanahoria","establo/Zanahoria.m4a","establo/Zanahoria.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_ESTABLO));

        }
        else if(cat.getId()==Categoria.ID_CATEGORIA_NECESIDADES){
            pictogramas.add(new Pictograma(8,"Sed Mujer","necesidades/Sed Mujer.m4a","necesidades/Sed Mujer.png",SEXO_FEMENINO,Categoria.ID_CATEGORIA_NECESIDADES));
                        pictogramas.add(new Pictograma(16,"Sed HombreSed ","necesidades/Sed Hombre.m4a","necesidades/Sed Hombre.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_NECESIDADES));
        pictogramas.add(new Pictograma(29,"Banio","necesidades/Banio.m4a","necesidades/Banio.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_NECESIDADES));

        }
        else if(cat.getId()==Categoria.ID_CATEGORIA_PISTA){
        pictogramas.add(new Pictograma(30,"Aro","pista/Aro.m4a","pista/Aro.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(31,"Broches","pista/Broches.m4a","pista/Broches.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(32,"Burbujas","pista/Burbujas.m4a","pista/Burbujas.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(33,"Caballo","pista/Caballo.m4a","pista/Caballo.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(34,"Caballo ","pista/Caballo 2.m4a","pista/Caballo 2.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(35,"Caballo ","pista/Caballo 3.m4a","pista/Caballo 3.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(36,"Chapas","pista/Chapas.m4a","pista/Chapas.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(37,"Cubos","pista/Cubos.m4a","pista/Cubos.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(38,"Letras","pista/Letras.m4a","pista/Letras.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(39,"Maracas","pista/Maracas.m4a","pista/Maracas.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(40,"Palos","pista/Palos.m4a","pista/Palos.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(41,"Pato","pista/Pato.m4a","pista/Pato.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(42,"Pelota","pista/Pelota.m4a","pista/Pelota.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(43,"Tarima","pista/Tarima.m4a","pista/Tarima.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));

        }

        return pictogramas;
    }



    public List<Pictograma> getPictogramas(Alumno alumno) {
        List<Pictograma> pictogramas = new ArrayList<>();

            pictogramas.add(new Pictograma(1,"Asustada", "emociones/Asustada.m4a", "emociones/Asustada.png", SEXO_FEMENINO, Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(2,"Cansada", "emociones/Cansada.m4a", "emociones/Cansada.png", SEXO_FEMENINO, Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(3,"Contenta", "emociones/Contenta.m4a", "emociones/Contenta.png", SEXO_FEMENINO, Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(4,"Dolorida", "emociones/Dolorida.m4a", "emociones/Dolorida.png", SEXO_FEMENINO, Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(5,"Enojada", "emociones/Enojada.m4a", "emociones/Enojada.png", SEXO_FEMENINO, Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(6,"Sorprendida", "emociones/Sorprendida.m4a", "emociones/Sorprendida.png", SEXO_FEMENINO, Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(7,"Triste", "emociones/Triste.m4a", "emociones/Triste Mujer.png", SEXO_FEMENINO, Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(8,"Sed Muje", "necesidades/Sed Mujer.m4a", "necesidades/Sed Mujer.png", SEXO_FEMENINO, Categoria.ID_CATEGORIA_NECESIDADES));

            return pictogramas;
    }


    public String getPortComunicadorJSON(){
        return "8080";
    }

    public String getIP(){
        return "192.167.100.100";
    }

    @Override

    public long createNewAlumno(Alumno alumno) {
        return -1;
    }

    @Override
    public void createNewPictograma(Pictograma pictograma) {

    }

    @Override
    public void createNewCategoria(Categoria categoria) {

    }

    @Override
    public void createNewAlumnoPictograma(Alumno alumno, Pictograma pictograma) {

    }

    @Override
    public List<Categoria> getCategorias() {
        List<Categoria> cats = new ArrayList<>();
        cats.add(Categoria.getCategoriaEmociones());
        cats.add(Categoria.getCategoriaEstablo());
        cats.add(Categoria.getCategoriaNecesidades());
        cats.add(Categoria.getCategoriaPista());
        return cats;
    }

    @Override
    public List<Pictograma> getPictogramasAlumno(Alumno alumno)
    {
        List<Pictograma> pictogramas = new ArrayList<>();

            pictogramas.add(new Pictograma(1,"Asustada","emociones/Asustada.m4a","emociones/Asustada.png",SEXO_FEMENINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(2,"Cansada","emociones/Cansada.m4a","emociones/Cansada.png",SEXO_FEMENINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(3,"Contenta","emociones/Contenta.m4a","emociones/Contenta.png",SEXO_FEMENINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(4,"Dolorida","emociones/Dolorida.m4a","emociones/Dolorida.png",SEXO_FEMENINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(5,"Enojada","emociones/Enojada.m4a","emociones/Enojada.png",SEXO_FEMENINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(6,"Sorprendida","emociones/Sorprendida.m4a","emociones/Sorprendida.png",SEXO_FEMENINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(7,"Triste","emociones/Triste.m4a","emociones/Triste Mujer.png",SEXO_FEMENINO,Categoria.ID_CATEGORIA_EMOCIONES));

            pictogramas.add(new Pictograma(9,"Asustado","emociones/Asustado.m4a","emociones/Asustado.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(10,"Cansado","emociones/Cansado.m4a","emociones/Cansdao.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(11,"Contento","emociones/Contento.m4a","emociones/Contento.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_EMOCIONES));
        return pictogramas;
    }

    @Override

    public void updateConfig(String name, String value) {

    }

    @Override
    public void updateAlumno(Alumno alumno) {

    }

    @Override
    public void removeAlumno(Alumno alumno) {

    }

    @Override
    public void removeAlumnoPictograma(Alumno alumno, Pictograma pictograma) {

    }


    @Override
    public void removeAlumnoTodosPictogramas(Alumno alumno) {

    }

    @Override
    public List<Pictograma> getPictogramas(Alumno alumnoActual, Categoria categoria) {
        return null;
    }

    @Override
    public void removeAlumnoTodasCategoria(Alumno alumno) {

    }

    @Override
    public void createNewCategoriaAlumno(Categoria categoria, Alumno alumno) {

    }

    @Override
    public void createNewNotificacion(Notificacion n, boolean b) {

    }

    @Override
    public List<Notificacion> getNotificacionesNoEnviadas() {
        return null;
    }

    @Override
    public void setNotificacionToEnviada(Notificacion n) {

    }

    @Override
    public Pictograma getPictogramaPorNombre(String nombre) {
        if(nombre.contains("Si")){
            return new Pictograma(50,"si", "emociones/Si.m4a", "emociones/Si.png", Alumno.UNISEX, Categoria.ID_CATEGORIA_EMOCIONES);
        }
        else if (nombre.contains("No")){
            return new Pictograma(51,"no", "emociones/No.m4a", "emociones/No.png", Alumno.UNISEX, Categoria.ID_CATEGORIA_EMOCIONES);
        }
        return null;
    }

    @Override
    public Pictograma getPictogramaSexo(Pictograma p, String sexo) {
        return null;
    }

    public void switchSex(Alumno alumno) {}

    public Alumno getAlumnoByID(long id){return null;}

}
