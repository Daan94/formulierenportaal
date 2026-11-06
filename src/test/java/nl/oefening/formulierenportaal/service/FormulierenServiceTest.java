package nl.oefening.formulierenportaal.service;

import nl.oefening.formulierenportaal.domain.FormulierenEntity;
import nl.oefening.formulierenportaal.domain.FormulierenStatus;
import nl.oefening.formulierenportaal.dto.FormulierenResponse;
import nl.oefening.formulierenportaal.mapper.FormulierenMapper;
import nl.oefening.formulierenportaal.repository.FormulierenRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class FormulierenServiceTest {

    @Mock
    private FormulierenRepository formulierenRepository;

    @Mock
    private FormulierenMapper formulierenMapper;

    @InjectMocks
    private FormulierenService formulierenService;

    @Test
    void getFormulieren_geeftAllesTerug(){
        FormulierenEntity entiteit1 = new FormulierenEntity(1L, "test", FormulierenStatus.INGEDIEND);
        FormulierenEntity entiteit2 = new FormulierenEntity(2L, "test2", FormulierenStatus.CONCEPT);

        FormulierenResponse response = new FormulierenResponse(1L, "test", FormulierenStatus.INGEDIEND);
        FormulierenResponse response2 = new FormulierenResponse(2L, "test2", FormulierenStatus.CONCEPT);

        List<FormulierenEntity> formulierenEntities = List.of(entiteit1,entiteit2);
        Mockito.when(formulierenRepository.findAll()).thenReturn(formulierenEntities);
        Mockito.when(formulierenMapper.naarDto(entiteit1)).thenReturn(response);
        Mockito.when(formulierenMapper.naarDto(entiteit2)).thenReturn(response2);

        Assertions.assertThat(formulierenService.getFormulieren()).containsExactly(response,response2);

    }

    @Test
    void getFormulier_geeftLegeOptionalAlsFormulierNietBestaat(){
        Long id = 999L;
        Mockito.when(formulierenRepository.findById(id)).thenReturn(Optional.empty());

        Optional<FormulierenResponse> response = formulierenService.getFormulier(id);

        Assertions.assertThat(response).isEmpty();

    }




}