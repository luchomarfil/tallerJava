package ar.edu.unlp.hermesmarfiltibaldo.dao;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.hermesmarfiltibaldo.model.Alumno;
import ar.edu.unlp.hermesmarfiltibaldo.model.Categoria;
import ar.edu.unlp.hermesmarfiltibaldo.model.Pictograma;

/**
 * Created by luciano on 14/12/15.
 */
<<<<<<< HEAD
public class HermesDaoImpl implements HermesDao {
=======
public class HermesDaoImpl implements HermesDao{
>>>>>>> d51c4f29a2b56665f7da177746ee804f7c19c4c5

    private static final String SEXO_MASCULINO = "M";
    private static final String SEXO_FEMENINO = "F";
    private static final String CONFIG_KEY_IP = "ip";
    private static final String CONFIG_KEY_PORT = "port";

<<<<<<< HEAD
    private static HermesDaoImpl instance;

    public static synchronized HermesDaoImpl instancia(){
        if(instance==null){
            instance = new HermesDaoImpl();
        }
        return instance;
    }

    public List<Alumno> getAlumnos(){
        List<Alumno> l = new ArrayList<Alumno>();
        l.add(new Alumno(1, "Roberto", "Perez", SEXO_MASCULINO, Alumno.GRANDE));
        l.add(new Alumno(2,"Guillote","Coppola", SEXO_MASCULINO,Alumno.GRANDE));
        l.add(new Alumno(3,"Diego","Maradona",   SEXO_MASCULINO,Alumno.GRANDE));
        l.add(new Alumno(4,"Dalma","Maradona",   SEXO_FEMENINO,Alumno.GRANDE));
        l.add(new Alumno(5,"Gianina","Maradona", SEXO_FEMENINO,Alumno.GRANDE));
        l.add(new Alumno(6,"Laura", "Ubfal",     SEXO_FEMENINO,Alumno.GRANDE));
        l.add(new Alumno(7,"Marcelo", "Polino",  SEXO_MASCULINO,Alumno.GRANDE));
        l.add(new Alumno(8,"Carolina", "Ardohain", SEXO_FEMENINO,Alumno.GRANDE));
        l.add(new Alumno(9,"Matias", "Ale",        SEXO_MASCULINO,Alumno.GRANDE));
        l.add(new Alumno(10,"Mariana", "Fabiani",   SEXO_FEMENINO,Alumno.GRANDE));
        l.add(new Alumno(11,"Moria", "Casán",       SEXO_FEMENINO,Alumno.GRANDE));
        l.add(new Alumno(12,"Guillermo", "Andino",  SEXO_MASCULINO,Alumno.GRANDE));
        return l;
    }

    @Override
    public void createNewAlumno(Alumno alumno) {

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
        return null;
=======
    public List<Alumno> getAlumnos(){
        List<Alumno> l = new ArrayList<Alumno>();
       /* l.add(new Alumno("Roberto","Perez",    SEXO_MASCULINO));
        l.add(new Alumno("Guillote","Coppola", SEXO_MASCULINO));
        l.add(new Alumno("Diego","Maradona",   SEXO_MASCULINO));
        l.add(new Alumno("Dalma","Maradona",   SEXO_FEMENINO));
        l.add(new Alumno("Gianina","Maradona", SEXO_FEMENINO));
        l.add(new Alumno("Laura", "Ubfal",     SEXO_FEMENINO));
        l.add(new Alumno("Marcelo", "Polino",  SEXO_MASCULINO));
        l.add(new Alumno("Carolina", "Ardohain", SEXO_FEMENINO));
        l.add(new Alumno("Matias", "Ale",        SEXO_MASCULINO));
        l.add(new Alumno("Mariana", "Fabiani",   SEXO_FEMENINO));
        l.add(new Alumno("Moria", "Casán",       SEXO_FEMENINO));
        l.add(new Alumno("Guillermo", "Andino",  SEXO_MASCULINO));
       */ return l;
>>>>>>> d51c4f29a2b56665f7da177746ee804f7c19c4c5
    }

    public List<Categoria> getCategorias(Alumno alumno) {
        List<Categoria> cats = new ArrayList<>();
        cats.add(Categoria.getCategoriaEmociones());
        cats.add(Categoria.getCategoriaEstablo());
        cats.add(Categoria.getCategoriaNecesidades());
        cats.add(Categoria.getCategoriaPista());
        return cats;
    }

    public List<Pictograma> getPictogramas(Categoria cat){
        List<Pictograma> pictogramas = new ArrayList<>();
<<<<<<< HEAD
        if(cat.getId()==Categoria.ID_CATEGORIA_EMOCIONES){
            pictogramas.add(new Pictograma(1,"emociones/Asustada.m4a","emociones/Asustada.png",SEXO_FEMENINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(2,"emociones/Cansada.m4a","emociones/Cansada.png",SEXO_FEMENINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(3,"emociones/Contenta.m4a","emociones/Contenta.png",SEXO_FEMENINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(4,"emociones/Dolorida.m4a","emociones/Dolorida.png",SEXO_FEMENINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(5,"emociones/Enojada.m4a","emociones/Enojada.png",SEXO_FEMENINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(6,"emociones/Sorprendida.m4a","emociones/Sorprendida.png",SEXO_FEMENINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(7,"emociones/Triste.m4a","emociones/Triste Mujer.png",SEXO_FEMENINO,Categoria.ID_CATEGORIA_EMOCIONES));

            pictogramas.add(new Pictograma(9,"emociones/Asustado.m4a","emociones/Asustado.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(10,"emociones/Cansado.m4a","emociones/Cansdao.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(11,"emociones/Contento.m4a","emociones/Contento.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(12,"emociones/Dolorido.m4a","emociones/Dolorido.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(13,"emociones/Enojado.m4a","emociones/Enojado.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(14,"emociones/Sorprendido.m4a","emociones/Sorprendido.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(15,"emociones/Triste.m4a","emociones/Triste Hombre.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_EMOCIONES));
        }
        else if(cat.getId()==Categoria.ID_CATEGORIA_ESTABLO){
            pictogramas.add(new Pictograma(17,"establo/Casco.m4a","establo/Casco.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_ESTABLO));
            pictogramas.add(new Pictograma(18,"establo/Cepillo.m4a","establo/Cepillo.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_ESTABLO));
            pictogramas.add(new Pictograma(19,"establo/Escarba Vasos.m4a","establo/Escarba Vasos.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_ESTABLO));
            pictogramas.add(new Pictograma(20,"establo/Limpieza.m4a","establo/Limpieza.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_ESTABLO));
            pictogramas.add(new Pictograma(21,"establo/Matra.m4a","establo/Matra.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_ESTABLO));
            pictogramas.add(new Pictograma(22,"establo/Montura.m4a","establo/Montura.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_ESTABLO));
            pictogramas.add(new Pictograma(23,"establo/Pasto.m4a","establo/Pasto.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_ESTABLO));
            pictogramas.add(new Pictograma(24,"establo/Dolorido.m4a","establo/Dolorido.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_ESTABLO));
            pictogramas.add(new Pictograma(25,"establo/Rasqueta Blanda.m4a","establo/Rasqueta Blanda.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_ESTABLO));
            pictogramas.add(new Pictograma(26,"establo/Rasqueta Dura.m4a","establo/Rasqueta Dura.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_ESTABLO));
            pictogramas.add(new Pictograma(27,"establo/Riendas.m4a","establo/Riendas.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_ESTABLO));
            pictogramas.add(new Pictograma(28,"establo/Zanahoria.m4a","establo/Zanahoria.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_ESTABLO));

        }
        else if(cat.getId()==Categoria.ID_CATEGORIA_NECESIDADES){
            pictogramas.add(new Pictograma(8,"necesidades/Sed Mujer.m4a","necesidades/Sed Mujer.png",SEXO_FEMENINO,Categoria.ID_CATEGORIA_NECESIDADES));
                        pictogramas.add(new Pictograma(16,"necesidades/Sed Hombre.m4a","necesidades/Sed Hombre.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_NECESIDADES));
        pictogramas.add(new Pictograma(29,"necesidades/Banio.m4a","necesidades/Banio.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_NECESIDADES));

        }
        else if(cat.getId()==Categoria.ID_CATEGORIA_PISTA){
        pictogramas.add(new Pictograma(30,"pista/Aro.m4a","pista/Aro.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(31,"pista/Broches.m4a","pista/Broches.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(32,"pista/Burbujas.m4a","pista/Burbujas.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(33,"pista/Caballo.m4a","pista/Caballo.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(34,"pista/Caballo 2.m4a","pista/Caballo 2.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(35,"pista/Caballo 3.m4a","pista/Caballo 3.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(36,"pista/Chapas.m4a","pista/Chapas.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(37,"pista/Cubos.m4a","pista/Cubos.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(38,"pista/Letras.m4a","pista/Letras.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(39,"pista/Maracas.m4a","pista/Maracas.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(40,"pista/Palos.m4a","pista/Palos.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(41,"pista/Pato.m4a","pista/Pato.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(42,"pista/Pelota.m4a","pista/Pelota.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(43,"pista/Tarima.m4a","pista/Tarima.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));

        }

        return pictogramas;
    }

    @Override
    public List<Pictograma> getPictogramasAlumno(Alumno alumno) {
        return null;
    }

    public List<Pictograma> getPictogramas(Alumno alumno){
        List<Pictograma> pictogramas = new ArrayList<>();

        if(alumno.getSexo()==SEXO_FEMENINO){

            pictogramas.add(new Pictograma(1,"emociones/Asustada.m4a","emociones/Asustada.png",SEXO_FEMENINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(2,"emociones/Cansada.m4a","emociones/Cansada.png",SEXO_FEMENINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(3,"emociones/Contenta.m4a","emociones/Contenta.png",SEXO_FEMENINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(4,"emociones/Dolorida.m4a","emociones/Dolorida.png",SEXO_FEMENINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(5,"emociones/Enojada.m4a","emociones/Enojada.png",SEXO_FEMENINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(6,"emociones/Sorprendida.m4a","emociones/Sorprendida.png",SEXO_FEMENINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(7,"emociones/Triste.m4a","emociones/Triste Mujer.png",SEXO_FEMENINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(8,"necesidades/Sed Mujer.m4a","necesidades/Sed Mujer.png",SEXO_FEMENINO,Categoria.ID_CATEGORIA_NECESIDADES));
=======
        /*if(cat.getId()==Categoria.ID_CATEGORIA_EMOCIONES){
            pictogramas.add(new Pictograma("emociones/Asustada.m4a","emociones/Asustada.png","F"));
            pictogramas.add(new Pictograma("emociones/Asustado.m4a","emociones/Asustado.png","M"));
            pictogramas.add(new Pictograma("emociones/Cansada.m4a","emociones/Cansada.png","F"));
            pictogramas.add(new Pictograma("emociones/Cansado.m4a","emociones/Cansado.png","M"));
            pictogramas.add(new Pictograma("emociones/Contenta.m4a","emociones/Contenta.png","F"));
            pictogramas.add(new Pictograma("emociones/Contento.m4a","emociones/Contento.png","M"));
            pictogramas.add(new Pictograma("emociones/Dolorida.m4a","emociones/Dolorida.png","F"));
            pictogramas.add(new Pictograma("emociones/Dolorido.m4a","emociones/Dolorido.png","M"));
            pictogramas.add(new Pictograma("emociones/Enojada.m4a","emociones/Enojada.png","F"));
            pictogramas.add(new Pictograma("emociones/Enojado.m4a","emociones/Enojado.png","M"));
            pictogramas.add(new Pictograma("emociones/Sorprendida.m4a","emociones/Sorprendida.png","F"));
            pictogramas.add(new Pictograma("emociones/Sorprendido.m4a","emociones/Sorprendido.png","M"));
            pictogramas.add(new Pictograma("emociones/Triste.m4a","emociones/Triste Hombre.png","M"));
            pictogramas.add(new Pictograma("emociones/Triste.m4a","emociones/Triste Mujer.png","F"));
        }
        else if(cat.getId()==Categoria.ID_CATEGORIA_ESTABLO){
            pictogramas.add(new Pictograma("establo/Casco.m4a","establo/Casco.png","U"));
            pictogramas.add(new Pictograma("establo/Cepillo.m4a","establo/Cepillo.png","U"));
            pictogramas.add(new Pictograma("establo/Escarba Vasos.m4a","establo/Escarba Vasos.png","U"));
            pictogramas.add(new Pictograma("establo/Limpieza.m4a","establo/Limpieza.png","U"));
            pictogramas.add(new Pictograma("establo/Matra.m4a","establo/Matra.png","U"));
            pictogramas.add(new Pictograma("establo/Montura.m4a","establo/Montura.png","U"));
            pictogramas.add(new Pictograma("establo/Pasto.m4a","establo/Pasto.png","U"));
            pictogramas.add(new Pictograma("establo/Rasqueta Blanda.m4a","establo/Rasqueta Blanda.png","U"));
            pictogramas.add(new Pictograma("establo/Rasqueta Dura.m4a","establo/Rasqueta Dura.png","U"));
            pictogramas.add(new Pictograma("establo/Riendas.m4a","establo/Riendas.png","U"));
            pictogramas.add(new Pictograma("establo/Zanahoria.m4a","establo/Zanahoria.png","U"));

        }
        else if(cat.getId()==Categoria.ID_CATEGORIA_NECESIDADES){
            pictogramas.add(new Pictograma("necesidades/Banio.m4a","necesidades/Banio.png","U"));
            pictogramas.add(new Pictograma("necesidades/Sed Hombre.m4a","necesidades/Sed Hombre.png","M"));
            pictogramas.add(new Pictograma("necesidades/Sed Mujer.m4a","necesidades/Sed Mujer.png","F"));

        }
        else if(cat.getId()==Categoria.ID_CATEGORIA_PISTA){
            pictogramas.add(new Pictograma("pista/Aro.m4a","pista/Aro.png","U"));
            pictogramas.add(new Pictograma("pista/Broches.m4a","pista/Broches.png","U"));
            pictogramas.add(new Pictograma("pista/Burbujas.m4a","pista/Burbujas.png","U"));
            pictogramas.add(new Pictograma("pista/Caballo.m4a","pista/Caballo.png","U"));
            pictogramas.add(new Pictograma("pista/Caballo.m4a","pista/Caballo 2.png","U"));
            pictogramas.add(new Pictograma("pista/Caballo.m4a","pista/Caballo 3.png","U"));
            pictogramas.add(new Pictograma("pista/Chapas.m4a","pista/Chapas.png","U"));
            pictogramas.add(new Pictograma("pista/Cubos.m4a","pista/Cubos.png","U"));
            pictogramas.add(new Pictograma("pista/Letras.m4a","pista/Letras.png","U"));
            pictogramas.add(new Pictograma("pista/Maracas.m4a","pista/Maracas.png","U"));
            pictogramas.add(new Pictograma("pista/Palos.m4a","pista/Palos.png","U"));
            pictogramas.add(new Pictograma("pista/Pato.m4a","pista/Pato.png","U"));
            pictogramas.add(new Pictograma("pista/Pelota.m4a","pista/Pelota.png","U"));
            pictogramas.add(new Pictograma("pista/Tarima.m4a","pista/Tarima.png","U"));

        }
*/
        return pictogramas;
    }

    public List<Pictograma> getPictogramas(Alumno alumno){
        List<Pictograma> pictogramas = new ArrayList<>();
/*
        if(alumno.getSexo()==SEXO_FEMENINO){
            pictogramas.add(new Pictograma("emociones/Asustada.m4a","emociones/Asustada.png"));
            pictogramas.add(new Pictograma("emociones/Cansada.m4a","emociones/Cansada.png"));
            pictogramas.add(new Pictograma("emociones/Contenta.m4a","emociones/Contenta.png"));
            pictogramas.add(new Pictograma("emociones/Dolorida.m4a","emociones/Dolorida.png"));
            pictogramas.add(new Pictograma("emociones/Enojada.m4a","emociones/Enojada.png"));
            pictogramas.add(new Pictograma("emociones/Sorprendida.m4a","emociones/Sorprendida.png"));
            pictogramas.add(new Pictograma("emociones/Triste.m4a","emociones/Triste Mujer.png"));
            pictogramas.add(new Pictograma("necesidades/Sed Mujer.m4a","necesidades/Sed Mujer.png"));
>>>>>>> d51c4f29a2b56665f7da177746ee804f7c19c4c5

        }
        else if(alumno.getSexo()==SEXO_MASCULINO){

<<<<<<< HEAD
            pictogramas.add(new Pictograma(9,"emociones/Asustado.m4a","emociones/Asustado.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(10,"emociones/Cansado.m4a","emociones/Cansdao.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(11,"emociones/Contento.m4a","emociones/Contento.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(12,"emociones/Dolorido.m4a","emociones/Dolorido.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(13,"emociones/Enojado.m4a","emociones/Enojado.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(14,"emociones/Sorprendido.m4a","emociones/Sorprendido.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(15,"emociones/Triste.m4a","emociones/Triste Hombre.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_EMOCIONES));
            pictogramas.add(new Pictograma(16,"necesidades/Sed Hombre.m4a","necesidades/Sed Hombre.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_NECESIDADES));

        }
        pictogramas.add(new Pictograma(17,"establo/Casco.m4a","establo/Casco.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_ESTABLO));
        pictogramas.add(new Pictograma(18,"establo/Cepillo.m4a","establo/Cepillo.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_ESTABLO));
        pictogramas.add(new Pictograma(19,"establo/Escarba Vasos.m4a","establo/Escarba Vasos.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_ESTABLO));
        pictogramas.add(new Pictograma(20,"establo/Limpieza.m4a","establo/Limpieza.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_ESTABLO));
        pictogramas.add(new Pictograma(21,"establo/Matra.m4a","establo/Matra.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_ESTABLO));
        pictogramas.add(new Pictograma(22,"establo/Montura.m4a","establo/Montura.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_ESTABLO));
        pictogramas.add(new Pictograma(23,"establo/Pasto.m4a","establo/Pasto.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_ESTABLO));
        pictogramas.add(new Pictograma(24,"establo/Dolorido.m4a","establo/Dolorido.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_ESTABLO));
        pictogramas.add(new Pictograma(25,"establo/Rasqueta Blanda.m4a","establo/Rasqueta Blanda.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_ESTABLO));
        pictogramas.add(new Pictograma(26,"establo/Rasqueta Dura.m4a","establo/Rasqueta Dura.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_ESTABLO));
        pictogramas.add(new Pictograma(27,"establo/Riendas.m4a","establo/Riendas.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_ESTABLO));
        pictogramas.add(new Pictograma(28,"establo/Zanahoria.m4a","establo/Zanahoria.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_ESTABLO));
        pictogramas.add(new Pictograma(29,"necesidades/Banio.m4a","necesidades/Banio.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_NECESIDADES));
        pictogramas.add(new Pictograma(30,"pista/Aro.m4a","pista/Aro.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(31,"pista/Broches.m4a","pista/Broches.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(32,"pista/Burbujas.m4a","pista/Burbujas.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(33,"pista/Caballo.m4a","pista/Caballo.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(34,"pista/Caballo 2.m4a","pista/Caballo 2.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(35,"pista/Caballo 3.m4a","pista/Caballo 3.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(36,"pista/Chapas.m4a","pista/Chapas.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(37,"pista/Cubos.m4a","pista/Cubos.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(38,"pista/Letras.m4a","pista/Letras.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(39,"pista/Maracas.m4a","pista/Maracas.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(40,"pista/Palos.m4a","pista/Palos.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(41,"pista/Pato.m4a","pista/Pato.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(42,"pista/Pelota.m4a","pista/Pelota.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));
        pictogramas.add(new Pictograma(43,"pista/Tarima.m4a","pista/Tarima.png",SEXO_MASCULINO,Categoria.ID_CATEGORIA_PISTA));

=======
            pictogramas.add(new Pictograma("emociones/Asustado.m4a","emociones/Asustado.png"));
            pictogramas.add(new Pictograma("emociones/Cansado.m4a","emociones/Cansdao.png"));
            pictogramas.add(new Pictograma("emociones/Contento.m4a","emociones/Contento.png"));
            pictogramas.add(new Pictograma("emociones/Dolorido.m4a","emociones/Dolorido.png"));
            pictogramas.add(new Pictograma("emociones/Enojado.m4a","emociones/Enojado.png"));
            pictogramas.add(new Pictograma("emociones/Sorprendido.m4a","emociones/Sorprendido.png"));
            pictogramas.add(new Pictograma("emociones/Triste.m4a","emociones/Triste Hombre.png"));
            pictogramas.add(new Pictograma("necesidades/Sed Hombre.m4a","necesidades/Sed Hombre.png"));

        }
        pictogramas.add(new Pictograma("establo/Casco.m4a","establo/Casco.png"));
        pictogramas.add(new Pictograma("establo/Cepillo.m4a","establo/Cepillo.png"));
        pictogramas.add(new Pictograma("establo/Escarba Vasos.m4a","establo/Escarba Vasos.png"));
        pictogramas.add(new Pictograma("establo/Limpieza.m4a","establo/Limpieza.png"));
        pictogramas.add(new Pictograma("establo/Matra.m4a","establo/Matra.png"));
        pictogramas.add(new Pictograma("establo/Montura.m4a","establo/Montura.png"));
        pictogramas.add(new Pictograma("establo/Pasto.m4a","establo/Pasto.png"));
        pictogramas.add(new Pictograma("establo/Dolorido.m4a","establo/Dolorido.png"));
        pictogramas.add(new Pictograma("establo/Rasqueta Blanda.m4a","establo/Rasqueta Blanda.png"));
        pictogramas.add(new Pictograma("establo/Rasqueta Dura.m4a","establo/Rasqueta Dura.png"));
        pictogramas.add(new Pictograma("establo/Riendas.m4a","establo/Riendas.png"));
        pictogramas.add(new Pictograma("establo/Zanahoria.m4a","establo/Zanahoria.png"));
        pictogramas.add(new Pictograma("necesidades/Banio.m4a","necesidades/Banio.png"));
        pictogramas.add(new Pictograma("pista/Aro.m4a","pista/Aro.png"));
        pictogramas.add(new Pictograma("pista/Broches.m4a","pista/Broches.png"));
        pictogramas.add(new Pictograma("pista/Burbujas.m4a","pista/Burbujas.png"));
        pictogramas.add(new Pictograma("pista/Caballo.m4a","pista/Caballo.png"));
        pictogramas.add(new Pictograma("pista/Caballo 2.m4a","pista/Caballo 2.png"));
        pictogramas.add(new Pictograma("pista/Caballo 3.m4a","pista/Caballo 3.png"));
        pictogramas.add(new Pictograma("pista/Chapas.m4a","pista/Chapas.png"));
        pictogramas.add(new Pictograma("pista/Cubos.m4a","pista/Cubos.png"));
        pictogramas.add(new Pictograma("pista/Letras.m4a","pista/Letras.png"));
        pictogramas.add(new Pictograma("pista/Maracas.m4a","pista/Maracas.png"));
        pictogramas.add(new Pictograma("pista/Palos.m4a","pista/Palos.png"));
        pictogramas.add(new Pictograma("pista/Pato.m4a","pista/Pato.png"));
        pictogramas.add(new Pictograma("pista/Pelota.m4a","pista/Pelota.png"));
        pictogramas.add(new Pictograma("pista/Tarima.m4a","pista/Tarima.png"));
*/
>>>>>>> d51c4f29a2b56665f7da177746ee804f7c19c4c5
        return pictogramas;

    }

<<<<<<< HEAD
    @Override
    public List<Pictograma> getPictogramas(Alumno alumnoActual, Categoria categoria) {
        return getPictogramas(categoria);
    }

=======
>>>>>>> d51c4f29a2b56665f7da177746ee804f7c19c4c5
    public String getPortComunicadorJSON(){
        return "8080";
    }

    public String getIP(){
        return "192.167.100.100";
    }

    @Override
<<<<<<< HEAD
=======
    public void createNewAlumno(Alumno alumno) {

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
        return null;
    }

    @Override
    public List<Pictograma> getPictogramasAlumno(Alumno alumno) {
        return null;
    }

    @Override
>>>>>>> d51c4f29a2b56665f7da177746ee804f7c19c4c5
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

<<<<<<< HEAD
=======
    @Override
    public void removeAlumnoTodosPictogramas(Alumno alumno) {

    }
>>>>>>> d51c4f29a2b56665f7da177746ee804f7c19c4c5
}
