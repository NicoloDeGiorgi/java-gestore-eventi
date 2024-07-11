package org.java.milestone.events;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;

//Creare una classe Concerto che estende Evento 
public class Concerto extends Evento{
	
	//che ha anche gli attributi : ora (LocalTime) prezzo
    private LocalTime ora;
    private BigDecimal prezzo;

    //Aggiunti metodi nel costruttore
    public Concerto(String eventTitle, LocalDate eventData, int totalPlace, LocalTime ora, BigDecimal prezzo) throws IllegalArgumentException {
        super(eventTitle, eventData, totalPlace);
        this.ora = ora;
        this.prezzo = prezzo;
    }

    // GETTER E SETTER
    public LocalTime getOra() {
        return ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    public String getDataOraFormattata() {
        return getEventData().toString() + " " + ora.toString();
    }
      
    //Metodo per restituire il prezzo formattato 
    public String getPrezzoFormattato() {
        DecimalFormat df = new DecimalFormat("##,##€");
        return df.format(prezzo);
    }
        //Override del metodo  toString() dove viene restituita una stringa del tipo: 
    //data e ora formattata - titolo - prezzo formattato
    @Override
    public String toString() {
        return getDataOraFormattata() + " - " + getEventTitle() + " - " + getPrezzoFormattato();
    }
}