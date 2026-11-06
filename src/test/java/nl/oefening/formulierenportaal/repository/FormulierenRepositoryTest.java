package nl.oefening.formulierenportaal.repository;

import nl.oefening.formulierenportaal.domain.FormulierenEntity;
import nl.oefening.formulierenportaal.domain.FormulierenStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class FormulierenRepositoryTest {

    @Autowired
    private FormulierenRepository formulierenRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void formulierKanWordenOpgeslagenEnOpgehaald() {
        FormulierenEntity entiteit = new FormulierenEntity(
                "titel",
                FormulierenStatus.INGEDIEND
        );
        FormulierenEntity opgeslagen =
                formulierenRepository.saveAndFlush(entiteit);

        Long id = opgeslagen.getId();

        entityManager.clear();

        Optional<FormulierenEntity> resultaat =
                formulierenRepository.findById(id);

        // Assert
        assertThat(resultaat).isPresent();

        FormulierenEntity gevonden = resultaat.orElseThrow();

        assertThat(gevonden.getId()).isEqualTo(id);
        assertThat(gevonden.getTitle()).isEqualTo("titel");
        assertThat(gevonden.getFormulierenStatus())
                .isEqualTo(FormulierenStatus.INGEDIEND);
    }
}
