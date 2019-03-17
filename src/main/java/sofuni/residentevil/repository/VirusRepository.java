package sofuni.residentevil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sofuni.residentevil.domain.entities.Virus;
import sofuni.residentevil.service.VirusService;

import java.text.DateFormat;
import java.time.LocalDate;

@Repository
public interface VirusRepository extends JpaRepository<Virus, String> {

    @Modifying
    @Query("update Virus v " +
            "set v.name = ?1, " +
            "v.creator = ?2, " +
            "v.curable = ?3," +
            "v.deadly = ?4, " +
            "v.description = ?5, " +
            "v.magnitude = ?6, " +
            "v.sideEffects = ?7, " +
            "v.hoursUntilTurn = ?8, " +
            "v.turnoverRate = ?9, " +
            "v.releasedOn = ?10 " +
            "where v.id = ?11")
    void updateVirus(String name, String creator, boolean curable,
                               boolean deadly, String description, String magnitude,
                               Integer sideEffects, Integer hoursUntilTurn, Integer turnoverRate,
                               LocalDate releasedOn, String userId );
}
