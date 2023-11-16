package Player;

public abstract class LuminosityVolume {
    private static byte lightLevel = 3;
    private static byte volumeLevel = 3;

    //setters
    public static void aumentaLuminosita(byte n) {
        if (lightLevel + n <= 10) {
            lightLevel += n;
        } else {
            System.out.println("NO ,è TROPPO LUMINOSO STO BRUCIANDO");
        }
    }

    public static void diminuisciLuminosita(byte n) {
        if (lightLevel - n > 0) {
            lightLevel -= n;
        } else {
            System.out.println("è troppo buio");
        }
    }


    //setters
    public static void aumentaVolume(byte n) {
        if (volumeLevel + n <= 10) {
            volumeLevel += n;
        } else {
            System.out.println("NON SARAI MICA SORDO");
        }
    }

    public static void diminuisciVolume(byte n) {
        if (volumeLevel - n >= 0) {
            volumeLevel -= n;
        } else {
            System.out.println("non posso generare rumore negativo");
        }
    }

    //getters
    public static byte volume() {
        return volumeLevel;
    }


    public static byte luminosita() {
        return lightLevel;
    }


}
