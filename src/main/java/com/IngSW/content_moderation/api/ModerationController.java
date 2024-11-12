package com.IngSW.content_moderation.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.IngSW.content_moderation.models.Content;
import com.IngSW.content_moderation.services.ModerationService;
import com.IngSW.content_moderation.services.TemplateRestConsumer;

@RestController /* Annotation per definire che la classe risponderà tramite rest */
@RequestMapping("/api/moderation") /* Annotation per definire il path della classe */
public class ModerationController {

    @Autowired
    private ModerationService moderationService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/check") /* Annotation per definire il path del metodo (relativo alla classe) */
    public ResponseEntity<Content> checkContent(@RequestBody String comment) {

        /* Controllo del testo tramite un metodo definito in ModerationService */
        boolean isAppropriate = moderationService.isContentAppropriate(comment);

        /* Invio una risposta in base alla valore della variabile isAppropriate */
        if (!isAppropriate) {
            return ResponseEntity.ok(Content.builder().text("Contenuto appropriato").build());
        } else {
            return ResponseEntity.ok(Content.builder().text("Contenuto inappropriato").build());
        }
    }

    @RequestMapping("/checkMock") /* Annotation per definire il path del metodo (relativo alla classe) */
    public ResponseEntity<String> checkMock() {

        /*
         * Istanza della classe di tipo Content passando come argomento un testo inviato
         * tramite mockoon
         */
        Content content = Content.builder().text(TemplateRestConsumer.callREST("moderate", null, true)).build();

        /* Controllo del testo tramite un metodo definito in ModerationService */
        boolean isAppropriate = moderationService.isContentAppropriate(content.getText());

        /* Invio una risposta in base alla valore della variabile isAppropriate */
        if (!isAppropriate) {
            return ResponseEntity.ok("Contenuto Appropriato");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Contenuto inappropriato");
        }
    }
}
