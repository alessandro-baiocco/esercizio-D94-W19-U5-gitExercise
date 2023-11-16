import File.Audio;
import File.File;
import File.Image;
import File.Video;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

import static Player.LuminosityVolume.*;

public class Main {
    public static void main(String[] args) {

        //variabili

        Scanner input = new Scanner(System.in);
        File[] arrayDiFile = new File[5];
        String[] nomi = new String[5];

        //creazione file

        esternoPrimo:
        for (byte i = 0; i < 5; i++) {
            System.out.println("che tipo di file vuoi creare? img, audio o video (inserire :q per uscire) ");
            String tipoFile = input.next().toLowerCase().trim();
            switch (tipoFile) {
                case "img": {
                    System.out.println("nome ?");
                    String nomeFile = input.next();
                    nomi[i] = nomeFile;
                    arrayDiFile[i] = new Image(nomeFile);
                    break;
                }
                case "audio": {
                    System.out.println("nome ?");
                    String nomeFile = input.next();
                    System.out.println("durata?(in s)");
                    if (input.hasNextByte()) {
                        arrayDiFile[i] = new Audio((byte) Math.abs(Byte.parseByte(input.next())), nomeFile);
                        nomi[i] = nomeFile;
                    } else {
                        System.out.println("non è un numero intero");
                    }
                    break;
                }
                case "video": {
                    System.out.println("nome ?");
                    String nomeFile = input.next();
                    System.out.println("durata?(in s)");
                    if (input.hasNextInt()) {
                        arrayDiFile[i] = new Video(Math.abs(Integer.parseInt(input.next())), nomeFile);
                        nomi[i] = nomeFile;
                    } else {
                        System.out.println("non è un numero intero");
                    }
                    break;
                }
                case ":q": {
                    System.out.println("finito?");
                    break esternoPrimo;
                }
                case "makemeacoffee": {
                    System.out.println("error 418");
                    System.out.println("the server refuses to brew coffee because it is, permanently, a teapot. A combined coffee/tea pot that is temporarily out of coffee");
                    i--;
                    break;
                }
                default: {
                    System.out.println("eh ? cosa vorresti creare ?");
                    i--;
                }
            }
        }

        //riproduci
        esternoSecondo:
        while (true) {
            //--------------------------------------------------------leggere files---------------------------------------------
            System.out.println(Arrays.toString(nomi));
            System.out.print("che file vuoi Riprodurre? da 1 a 5 ");
            System.out.print("(0 per uscire | 6 per regolare il volume attuale : (" + volume() + ") ");
            System.out.println(" | 7 per regolare luminosità attuale : (" + luminosita() + ") )");
            if (input.hasNextByte()) {
                byte userInput = Byte.parseByte(input.next());
                if (userInput <= 5 && userInput > 0) {
                    //---------------------------------------------------------------------------------------
                    if (arrayDiFile[userInput - 1] == null) System.out.println("ops , non c'e niente li");
                        //---------------------------------------------------------------------------------------
                    else if (!Objects.equals(arrayDiFile[userInput - 1].getType(), "Image"))
                        arrayDiFile[userInput - 1].play();
                        //--------------------------------------------------------------------------------------------------
                    else arrayDiFile[userInput - 1].show();
                } else if (userInput == 6) {
                    //------------------------------------------------------------Volume------------------------------------
                    System.out.println("vuoi aumentare o diminuire il volume? (+ per aumentare , - per diminuire)");
                    switch (input.next()) {
                        case "+": {
                            System.out.println("di quanto? da 0 a 10");
                            if (input.hasNextByte()) {
                                aumentaVolume((Byte.parseByte(input.next())));
                            } else {
                                System.out.println("nope");
                            }
                            break;
                        }
                        case "-": {
                            System.out.println("di quanto? da 0 a 10");
                            if (input.hasNextByte()) {
                                diminuisciVolume(Byte.parseByte(input.next()));
                            } else {
                                System.out.println("nope");
                            }
                            break;
                        }
                        default: {
                            System.out.println("cosa ?");
                        }
                    }

                    //---------------------------------------------luminosità----------------------------------------------------
                } else if (userInput == 7) {
                    System.out.println("vuoi aumentare o diminuire la luminosità? (+ per aumentare , - per diminuire)");
                    switch (input.next()) {
                        case "+": {
                            System.out.println("di quanto? da 0 a 10");
                            if (input.hasNextByte()) {
                                aumentaLuminosita((Byte.parseByte(input.next())));
                            } else {
                                System.out.println("nope");
                            }
                            break;
                        }
                        case "-": {
                            System.out.println("di quanto? da 0 a 10");
                            if (input.hasNextByte()) {
                                diminuisciLuminosita(Byte.parseByte(input.next()));
                            } else {
                                System.out.println("nope");
                            }
                            break;
                        }
                        default: {
                            System.out.println("cosa ?");
                        }
                    }
                    //---------------------------------------uscire------------------------------------
                } else if (userInput == 0) {
                    System.out.println("finito");
                    break;
                } else {
                    System.out.println("non è un numero valido");
                }
            } else {
                System.err.println("non è validpoawnhf'p9ahwf");
                break;
            }
        }
        input.close();
    }

}