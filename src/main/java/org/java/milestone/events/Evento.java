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
	        this.eventTitle = eventTitle;
	        this.eventDate = eventDate;
	        this.totalPlaces = totalPlaces;
	        this.reservedPlaces = 0;

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
		
	    public void setData(LocalDate newDate) throws IllegalArgumentException {
	        if (newDate.isBefore(LocalDate.now())) {
	            throw new IllegalArgumentException("La data non può essere passata");
	        }
	        this.eventDate = newDate;
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
		  public void book(int numeroPosti) throws IllegalArgumentException {
		        if (eventDate.isBefore(LocalDate.now()) || numeroPosti <= 0) {
		            throw new IllegalArgumentException("Non si può prenotare");
		        }
		        int postiDisponibili = totalPlaces - reservedPlaces;
		        if (numeroPosti > postiDisponibili) {
		            throw new IllegalArgumentException("Posti esauriti");
		        }
		        reservedPlaces += numeroPosti;
		    }
		
		// Metodo per la disdetta
		   public void cancel (int numeroPosti) throws IllegalArgumentException {
		        if (eventDate.isBefore(LocalDate.now()) || numeroPosti <= 0) {
		            throw new IllegalArgumentException("Non puoi effettuare la disdetta");
		        }
		        if ( reservedPlaces == 0) {
		            throw new IllegalArgumentException("Non ci sono prenotazioni da cancellare");
		        }
		        if (numeroPosti >  reservedPlaces) {
		            throw new IllegalArgumentException("Il numero dei posti da cancellare è > al numero delle prenotazioni");
		        }
		        reservedPlaces -= numeroPosti;
		}
		
		
		//Override metodo 
		   @Override
		    public String toString() {
		        return eventDate.toString() + " - " + eventTitle;
		    }

		
}
