package File;

import Player.LuminosityVolume;

public class Audio extends LuminosityVolume implements File{
    private final byte duration;
    private final String type = "Audio";
    private final String name;


    //costruttore
    public Audio(byte duration , String name){
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
        return "Audio ";
    }
    public void play(){
        for (int i = 0 ; i < this.duration ; i++){
        System.out.print("Audio " + this.name + " ");
            for (int j = 0 ; j < volume() ; j++){
                System.out.print("!");
            }
            System.out.println(" ");
        }

        }

    @Override
    public void show() {}
}


