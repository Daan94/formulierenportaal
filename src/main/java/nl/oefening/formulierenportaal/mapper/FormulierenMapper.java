package nl.oefening.formulierenportaal.mapper;

import nl.oefening.formulierenportaal.domain.FormulierenEntity;
import nl.oefening.formulierenportaal.dto.FormulierenResponse;
import org.springframework.stereotype.Component;

@Component
public class FormulierenMapper {

    public FormulierenEntity vanDto(FormulierenResponse formulierenResponse){
        return new FormulierenEntity(
                formulierenResponse.id(),
                formulierenResponse.title(),
                formulierenResponse.status()
        );

    }

    public FormulierenResponse naarDto(FormulierenEntity formulierenEntity){
        return new FormulierenResponse(
                formulierenEntity.getId(),
                formulierenEntity.getTitle(),
                formulierenEntity.getFormulierenStatus()
        );
    }


}
