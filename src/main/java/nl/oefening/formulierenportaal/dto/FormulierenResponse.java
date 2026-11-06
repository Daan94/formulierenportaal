package nl.oefening.formulierenportaal.dto;


import nl.oefening.formulierenportaal.domain.FormulierenStatus;

public record FormulierenResponse(Long id, String title, FormulierenStatus status) {


}
