package org.java.milestone.events;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
   
		//Si chiede all’utente di inserire un nuovo evento con tutti i parametri:
        System.out.println("Titolo dell'evento: ");
        String eventTitle = scan.nextLine();
        
        System.out.println("Data dell'evento: (YYYY-MM-DD)");
        LocalDate eventDate = LocalDate.parse(scan.nextLine());
       
        System.out.println("Numero dei posti totali: ");
        int totalPlaces = scan.nextInt();

        Evento event = new Evento(eventTitle, eventDate, totalPlaces);
        
        // Chiedere all’utente se e quante prenotazioni vuole fare e provare ad effettuarle, implementando opportuni controlli
        System.out.println("Vuoi effettuare una prenotazione? y/n");
        scan.nextLine();
        String answer = scan.nextLine();
        
        //Ciclo while per prenotazione
        while (answer.equals("y")) {
            try {
                System.out.println("Quanti posti vuoi prenotare? ");
                int reservedPlaces = scan.nextInt();
                event.book (reservedPlaces);
            } catch (IllegalArgumentException e) {
                System.out.println("Errore: " + e.getMessage());
            }
            System.out.println("Vuoi effettuare un altra prenotazione? y/n");
            scan.nextLine();
            answer = scan.nextLine();
        }
        
          //Stampare a video il numero di posti prenotati e quelli disponibili
        System.out.println("Posti prenotati: " + event.getReservedPlaces());
        System.out.println("Posti disponibili: " + (event.getTotalPlaces() - event.getReservedPlaces()));
        
          //Chiedere all’utente se e quanti posti vuole disdire
        System.out.println("Vuoi disdire delle prenotazioni? y/n");
        String unsay = scan.nextLine();
      
      //Ciclo while per disdire
        while (unsay.equals("y")) {
            try {
                System.out.println("Quanti posti vuoi disdire? ");
                int numeroDisdette = scan.nextInt();
                event.cancel(numeroDisdette);
            } catch (IllegalArgumentException e) {
                System.out.println("Errore: " + e.getMessage());
            }
            System.out.println("Vuoi disdire altre prenotazioni? y/n");
            scan.nextLine();
            unsay = scan.nextLine();
        }

     
      //Stampare a video il numero di posti prenotati e quelli disponibili
        System.out.println("Posti prenotati: " + event.getReservedPlaces());
        System.out.println("Posti disponibili: " + (event.getTotalPlaces() - event.getReservedPlaces()));
        scan.close();

	}
	
}

 