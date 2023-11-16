package File;

import Player.LuminosityVolume;

import java.util.Objects;

public class Image extends LuminosityVolume implements File{
    private final byte duration = 1;

    private final String type = "Image";

    private final String name;

    //costruttore


    public Image(String name){
        this.name = name;
    }




    //getters
    public int getDuration() {
        return this.duration;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return "Immagine" ;
    }


    public void play(){
        System.out.println("errore");
    }
    public void show(){
        System.out.print("immagine " + this.name + " ");
        for (int i = 0 ; i < luminosita() ; i++){
            System.out.print("*");
        }
        System.out.println(" ");

    }


    @Override
    public int hashCode() {
        return Objects.hash(duration);
    }
}
