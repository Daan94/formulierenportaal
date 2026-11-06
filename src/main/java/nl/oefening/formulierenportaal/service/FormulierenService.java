package nl.oefening.formulierenportaal.service;

import nl.oefening.formulierenportaal.domain.FormulierenEntity;
import nl.oefening.formulierenportaal.domain.FormulierenStatus;
import nl.oefening.formulierenportaal.dto.FormulierenResponse;
import nl.oefening.formulierenportaal.mapper.FormulierenMapper;
import nl.oefening.formulierenportaal.repository.FormulierenRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormulierenService {

    private final FormulierenRepository formulierenRepository;

    private final FormulierenMapper formulierenMapper;

    public FormulierenService(FormulierenRepository formulierenRepository, FormulierenMapper formulierenMapper) {
        this.formulierenRepository = formulierenRepository;
        this.formulierenMapper = formulierenMapper;
    }


    public List<FormulierenResponse> getFormulieren(){
        return formulierenRepository.findAll().stream().map(formulierenMapper::naarDto).toList();
    }

    public List<FormulierenResponse> getFormulieren(FormulierenStatus formulierenStatus){
        return formulierenRepository.findByFormulierenStatus(formulierenStatus)
                .stream()
                .map(formulierenMapper::naarDto)
                .toList();
    }

    public Optional<FormulierenResponse> getFormulier(Long id){
        return formulierenRepository.findById(id).map(formulierenMapper::naarDto);
    }


}
