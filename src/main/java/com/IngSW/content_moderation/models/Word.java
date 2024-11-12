package com.IngSW.content_moderation.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/* Modello per rappresentare il testo inviato da un utente 
* e che dovrà essere controllato
* Le annotation indicano che i costruttori sono auto creati dal plugin lombok,
* e che lombok creerà anche tutti i getter e setter */

@Entity
@Table(name = "offensive_word")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Word {
    @Id /* Annotation per definire la primary key della tabella  */
    private Long id;
    private String word;

}
