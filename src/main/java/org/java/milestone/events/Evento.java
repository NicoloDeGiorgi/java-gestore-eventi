package org.java.milestone.events;

import java.time.LocalDate;

public class Evento {

	// variabili d'istanza
		private String eventTitle;
		private LocalDate eventData;
		private int totalPlaces;
		private int reservedPlaces;
		
	// Costruttore	
		public Evento(String eventTitle, LocalDate eventData, int totalPlaces) {
			this.eventTitle = eventTitle;
			this.reservedPlaces = 0;
			
			//Controllo che la data non sia già passata
			if (!eventData.equals(LocalDate.now())) {  													
				this.eventData = eventData;		
			} else {
				System.out.println("La data che hai inserito è gia passata!");
			}
			
			// Controllo che il numero di posti totali sia positivo
			if(totalPlaces > 0) { 																	
				this.totalPlaces = totalPlaces;
			} else {																			
				System.out.println("Devi inserire un numero di posto valido!"); 	
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
			return eventData;
		}

		public void setEventData(LocalDate eventData) {
			this.eventData = eventData;
		}
         // solo in lettura
		public int getTotalPlaces() {
			return totalPlaces;
		}
        // solo in lettura
		public int getReservedPlaces() {
			return reservedPlaces;
		}
		
}
