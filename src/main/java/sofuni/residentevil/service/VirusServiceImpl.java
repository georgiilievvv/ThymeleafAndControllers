package sofuni.residentevil.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sofuni.residentevil.domain.entities.Capital;
import sofuni.residentevil.domain.entities.Virus;
import sofuni.residentevil.domain.models.service.VirusServiceModel;
import sofuni.residentevil.repository.CapitalRepository;
import sofuni.residentevil.repository.VirusRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class VirusServiceImpl implements VirusService {

    private final VirusRepository virusRepository;
    private final CapitalRepository capitalRepository;
    private final ModelMapper modelMapper;

    public VirusServiceImpl(VirusRepository virusRepository, CapitalRepository capitalRepository) {
        this.virusRepository = virusRepository;
        this.capitalRepository = capitalRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public VirusServiceModel saveVirus(VirusServiceModel virusServiceModel) {
        Virus virus = this.modelMapper.map(virusServiceModel, Virus.class);
        List<Capital> capitals = new ArrayList<>();

        virusServiceModel.getCapitals().forEach(capitalId -> {
            this.capitalRepository.findById(capitalId).ifPresent(capitals::add);
        });

        virus.setCapitals(capitals);

        return this.modelMapper.map(
                this.virusRepository.saveAndFlush(virus),
                VirusServiceModel.class);
    }

    @Override
    public List<VirusServiceModel> findAllViruses() {
        return this.virusRepository.findAll().stream().map(v -> this.modelMapper.map(v, VirusServiceModel.class)).collect(Collectors.toList());
    }

    @Override
    public VirusServiceModel findById(String id) {
        return this.modelMapper.map(Objects.requireNonNull(this.virusRepository.findById(id).orElse(null)), VirusServiceModel.class);
    }

    @Override
    public void deleteVirus(String id) {
        this.virusRepository.deleteById(id);
    }

    @Override
    public void updateVirus(VirusServiceModel virus) {

        this.virusRepository.updateVirus(virus.getName(), virus.getCreator(), virus.isCurable(), virus.isDeadly(),
                virus.getDescription(), virus.getMagnitude(), virus.getSideEffects(), virus.getHoursUntilTurn(), virus.getTurnoverRate(),
                virus.getReleasedOn(), virus.getId());

        int chep= 3;
    }
}
