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
}
