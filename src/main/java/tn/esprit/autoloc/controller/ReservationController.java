package tn.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.service.IReservationService;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
@Tag(name = "gestion des reservations", description = "crud")
public class ReservationController {

    private final IReservationService reservationService;

    @Operation(summary = "ajouter reservation")
    @PostMapping("/ajouterReservation")
    public Reservation ajouterReservation(@RequestBody Reservation reservation) {
        return reservationService.ajouterReservation(reservation);
    }

    @Operation(summary = "modifier reservation")
    @PutMapping("/modifierReservation")
    public Reservation modifierReservation(@RequestBody Reservation reservation) {
        return reservationService.modifierReservation(reservation);
    }

    @Operation(summary = "afficher reservation par id")
    @GetMapping("/afficherReservationById/{id}")
    public Reservation afficherReservationById(@PathVariable Long id) {
        return reservationService.afficherReservationById(id);
    }

    @Operation(summary = "afficher tous les reservations")
    @GetMapping("/afficherAllReservations")
    public List<Reservation> afficherAllReservations() {
        return reservationService.afficherAllReservations();
    }

    @Operation(summary = "supprimer reservation")
    @DeleteMapping("/supprimerReservation/{id}")
    public void supprimerReservation(@PathVariable Long id) {
        reservationService.supprimerReservation(id);
    }
}
