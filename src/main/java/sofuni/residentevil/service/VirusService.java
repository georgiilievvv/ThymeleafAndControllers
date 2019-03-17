package sofuni.residentevil.service;

import sofuni.residentevil.domain.models.service.VirusServiceModel;

import java.time.LocalDate;
import java.util.List;

public interface VirusService {

    VirusServiceModel saveVirus(VirusServiceModel virusServiceModel);

    List<VirusServiceModel> findAllViruses();

    VirusServiceModel findById(String id);

    void deleteVirus(String id);

    void updateVirus(VirusServiceModel virusServiceModel);

}
