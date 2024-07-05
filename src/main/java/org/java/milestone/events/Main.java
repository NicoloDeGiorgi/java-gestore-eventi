package org.java.milestone.events;

import java.util.Scanner;
import java.time.LocalDate;

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
        
        // chiedere all’utente se e quante prenotazioni vuole fare e provare ad effettuarle, implementando opportuni controlli
        System.out.println("Vuoi effettuare una prenotazione? y/n");
        scan.nextLine();
        String answer = scan.nextLine();

	}
	
}

 