package ar.edu.unlp.hermesmarfiltibaldo.model;

import ar.edu.unlp.hermesmarfiltibaldo.dao.columns.HermesContract;

/**
 * Created by luciano on 15/12/15.
 */
public class Pictograma {
    public Long id;
    public static final String MASCULINO = "M";
    public static final String FEMENINO = "F";
    public static final String UNISEX = "U";
    public String sexo;
    public String audioFilename;
    public String imageFilename;
    public long categoriaID;

    public Pictograma(long id, String audio, String image, String sexo, long categoriaID) {
        this.setId(id);
        this.setSexo(sexo);
        this.setAudioFilename(audio);
        this.setImageFilename(image);
        this.setCategoriaID(categoriaID);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setSexo(String sexo)
    {
        this.sexo = sexo;
    }

    public String getSexo(){
        return this.sexo;
    }
    public String getAudioFilename() {
        return audioFilename;
    }

    public void setAudioFilename(String audioFilename) {
        this.audioFilename = audioFilename;
    }

    public String getImageFilename() {
        return imageFilename;
    }

    public void setImageFilename(String imageFilename) {
        this.imageFilename = imageFilename;
    }
    public void setCategoriaID(long id){
        this.categoriaID = id;
    }

    public void setCategoria(Categoria categoria){
        this.categoriaID = categoria.getId();
    }
    public Categoria getCategoria(Categoria categoria){
        return Categoria.getCategoriaByID(this.getCategoriaID());
    }

    public long getCategoriaID(){
        return categoriaID;
    }
}
