package File;
import Player.LuminosityVolume;

public class Video extends LuminosityVolume implements File {
    int duration;

    private final String type = "Video";

    private final String  name;



    //costruttori

    public Video(int duration , String name ){
        this.duration = duration;
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
        return "Video ";
    }
    public void play(){
        for (int i = 0 ; i < this.duration ; i++){
        System.out.print("video " + this.name + " ");
        for (int j = 0 ; j < volume() ; j++){
        System.out.print("!");
        }
        System.out.print(" ");
        for (int n = 0 ; n < luminosita() ; n++){
            System.out.print("*");
        }
        System.out.println(" ");
    }
    }

    @Override
    public void show() {

    }
}
