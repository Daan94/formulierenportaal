package nl.oefening.formulierenportaal.repository;

import nl.oefening.formulierenportaal.domain.FormulierenEntity;
import nl.oefening.formulierenportaal.domain.FormulierenStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormulierenRepository extends JpaRepository<FormulierenEntity, Long> {

    List<FormulierenEntity> findByFormulierenStatus(
            FormulierenStatus status
    );
}
