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
			this.eventData = eventData;
			
		}
		
}
