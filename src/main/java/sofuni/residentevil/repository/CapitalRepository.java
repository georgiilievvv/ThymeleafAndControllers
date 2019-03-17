package sofuni.residentevil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sofuni.residentevil.domain.entities.Capital;

@Repository
public interface CapitalRepository extends JpaRepository<Capital, String> {
}
