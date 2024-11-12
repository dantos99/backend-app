package com.IngSW.content_moderation.models;

import lombok.Builder;
import lombok.Data;


/* Modello per rappresentare il testo inviato da un utente 
* e che dovrà essere controllato
* Le annotation indicano che i costruttori sono auto creati dal plugin lombok,
* e che lombok creerà anche tutti i getter e setter */
@Data
@Builder
public class Content {

    private String text;

}
