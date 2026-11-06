package nl.oefening.formulierenportaal.controller;

import nl.oefening.formulierenportaal.domain.FormulierenStatus;
import nl.oefening.formulierenportaal.dto.FormulierenResponse;
import nl.oefening.formulierenportaal.service.FormulierenService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/formulieren")
public class FormulierenController {

    private FormulierenService formulierenService;

    public FormulierenController(FormulierenService formulierenService) {
        this.formulierenService = formulierenService;
    }

    @GetMapping()
    public List<FormulierenResponse> getFormulierenResponse(@RequestParam(required = false) FormulierenStatus status){
       if (status == null){
        return formulierenService.getFormulieren();
       }
       return formulierenService.getFormulieren(status);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormulierenResponse> getFormulier(@PathVariable("id") Long formulierId){
        return ResponseEntity.of(formulierenService.getFormulier(formulierId));
    }
}
