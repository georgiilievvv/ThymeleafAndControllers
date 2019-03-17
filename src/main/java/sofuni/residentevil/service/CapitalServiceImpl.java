package sofuni.residentevil.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sofuni.residentevil.domain.models.service.CapitalServiceModel;
import sofuni.residentevil.repository.CapitalRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CapitalServiceImpl implements CapitalService{

    private final CapitalRepository capitalRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CapitalServiceImpl(CapitalRepository capitalRepository) {
        this.capitalRepository = capitalRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<CapitalServiceModel> getAllCapitals() {
        return this.capitalRepository.findAll().stream()
                .map(c -> this.modelMapper.map(c, CapitalServiceModel.class))
                .collect(Collectors.toList());
    }
}
