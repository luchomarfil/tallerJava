package ar.edu.unlp.hermesmarfiltibaldo.model;

/**
 * Created by luciano on 15/12/15.
 */
public class Pictograma {
    public Long id;
    public String audioFilename;
    public String imageFilename;

    public Pictograma(String audio, String image) {

        this.audioFilename = audio;
        this.imageFilename = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
