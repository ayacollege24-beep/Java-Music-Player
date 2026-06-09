package musicPlayer;

import javax.sound.sampled.*;
import java.io.*;
import java.util.Scanner;

public class musicplayer {
     public static void main(String[] args){
         String filepath = "src\\M.wav";
         File file = new File(filepath);

         try(Scanner n = new Scanner(System.in);
             AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);){

             Clip clip = AudioSystem.getClip();
             clip.open(audioStream);

             String response = "";

             while(!response.equals("Q")){

                 System.out.println("P = Play");
                 System.out.println("S = Stop");
                 System.out.println("R = Reset");
                 System.out.println("Q = Quit");
                 System.out.println("Enter your choice: ");

                 response = n.next().toUpperCase();

                 switch (response){
                     case "P" -> clip.start();
                     case "S" -> clip.stop();
                     case "R" -> clip.setMicrosecondPosition(0);
                     case "Q" -> clip.close();
                     default -> System.out.println("invalid choice");

                 }
             }
         }
         catch (FileNotFoundException e){
             System.out.println("could not locate");
         }

         catch(LineUnavailableException e){
             System.out.println("unable to access audio");
         }

         catch (UnsupportedAudioFileException e){
             System.out.println("audio not supported");
         }

         catch (IOException e){
             System.out.println("something went wrong");
         }
         finally{
             System.out.println("bye !!");
         }

     }
}
