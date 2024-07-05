package org.java.milestone.events;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Evento {

	// variabili d'istanza
		private String eventTitle;
		private LocalDate eventDate;
		private int totalPlaces;
		private int reservedPlaces;
		
	// Costruttore	
	    public Evento(String eventTitle, LocalDate eventData, int totalPlaces) throws IllegalArgumentException {
	        if (totalPlaces <= 0) {
	            throw new IllegalArgumentException("Il numero dei posti totali deve essere positivo!");
	        }

	        if (eventDate.isBefore(LocalDate.now())) {
	            throw new IllegalArgumentException("La data non può essere precedente alla data odierna");
	        }

		}	
   // GETTER E SETTER
		public String getEventTitle() {
			return eventTitle;
		}

		public void setEventTitle(String eventTitle) {
			this.eventTitle = eventTitle;
		}

		public LocalDate getEventData() {
			return eventDate;
		}

		public void setEventData(LocalDate eventData) {
			this.eventDate = eventData;
		}
         // solo in lettura
		public int getTotalPlaces() {
			return totalPlaces;
		}
        // solo in lettura
		public int getReservedPlaces() {
			return reservedPlaces;
		}
		
		// Metodo per la prenotazione
		public String reserved() {
			if (LocalDate.now().isAfter(this.eventDate)) {
				return "L'evento è già passato.";
			} else if (this.reservedPlaces == this.totalPlaces) {
				return ("Mi dispiace! Non ci sono posti disponibili.");
			} else {
				this.reservedPlaces++;
				return ("Complimenti! Prenotazione effettuata con successo.");
			}
		}
		// Metodo per la disdetta
		public String deleteReservation() {
			if (LocalDate.now().isAfter(this.eventDate)) {
				return ("Mi dispiace! L'evento è già passato.");
			} else if (this.reservedPlaces == 0) {
				return ("Mi dispiace! Non sono presenti posti prenotati da disdire.");
			} else {
				this.reservedPlaces--;
				return ("Complimenti! Prenotazione cancellata con successo.");
			}
		}
		
		// Data formattata
            protected String getDateTimeFormatter() {
	        
	        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        
	        String dataFormattata = getEventData().format(formatoData);
	        
	        return dataFormattata;
	    }
		//Override metodo 
		   @Override
		    public String toString() {
		        
		        return "L\'evento " + getEventTitle()
		        		+ " in data " + getDateTimeFormatter();
		    }

		
}
