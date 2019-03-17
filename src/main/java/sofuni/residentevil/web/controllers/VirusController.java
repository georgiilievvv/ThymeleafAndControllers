package sofuni.residentevil.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sofuni.residentevil.domain.models.binding.VirusAddBindingModel;
import sofuni.residentevil.domain.models.service.VirusServiceModel;
import sofuni.residentevil.domain.models.view.CapitalsViewModel;
import sofuni.residentevil.domain.models.view.VirusHomeViewModel;
import sofuni.residentevil.service.CapitalService;
import sofuni.residentevil.service.VirusService;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/viruses")
public class VirusController extends BaseController {

    private final CapitalService capitalService;
    private final VirusService virusService;
    private final ModelMapper modelMapper;

    @Autowired
    public VirusController(CapitalService capitalService, VirusService virusService) {
        this.capitalService = capitalService;
        this.virusService = virusService;
        this.modelMapper = new ModelMapper();
    }

    @GetMapping("/add")
    public ModelAndView add(ModelAndView modelAndView, @ModelAttribute(name = "bindingModel") VirusAddBindingModel bindingModel){
        modelAndView.addObject("bindingModel", bindingModel);
        modelAndView.addObject("capitalModels",parsedCapitalsModels());
        return this.view("add-virus", modelAndView);
    }

    @PostMapping("/add")
    public ModelAndView addConfirm(@Valid @ModelAttribute(name = "bindingModel") VirusAddBindingModel bindingModel, BindingResult bindingResult, ModelAndView modelAndView ){

        if (bindingResult.hasErrors()){
            modelAndView.addObject("bindingModel", bindingModel);
            modelAndView.addObject("capitalModels",parsedCapitalsModels());
            return this.view("add-virus", modelAndView);
        }

        this.virusService.saveVirus(this.modelMapper.map(bindingModel, VirusServiceModel.class));
        return this.redirect("/viruses/home");
    }

    @GetMapping("/home")
    public ModelAndView home(ModelAndView modelAndView){

        List<VirusHomeViewModel> virusesModels = this.virusService.findAllViruses()
                .stream().map(v -> this.modelMapper.map(v, VirusHomeViewModel.class))
                .collect(Collectors.toList());

        virusesModels.forEach(v -> v.setIndex(virusesModels.indexOf(v) + 1));

        modelAndView.addObject("virusModels", virusesModels);
        return this.view("all-viruses", modelAndView);
    }

//    @GetMapping("/home")
//    public ModelAndView homeDelete(@RequestParam("id") String virusId, ModelAndView modelAndView) {
//
//        this.virusService.deleteVirus(virusId);
//        return super.redirect("/home");
//    }

    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam("id") String virusId, ModelAndView modelAndView){

        VirusAddBindingModel virusModel = this.modelMapper.map(this.virusService.findById(virusId), VirusAddBindingModel.class);
        modelAndView.addObject("bindingModel", virusModel);
        modelAndView.addObject("capitalModels", parsedCapitalsModels());

        return super.view("edit-virus", modelAndView);
    }

    @PostMapping("/edit")
    public ModelAndView editConfirm(@Valid @ModelAttribute(name = "bindingModel") VirusAddBindingModel bindingModel, BindingResult bindingResult, ModelAndView modelAndView ){

        if (bindingResult.hasErrors()){
            modelAndView.addObject("bindingModel", bindingModel);
            modelAndView.addObject("capitalModels",parsedCapitalsModels());
            return this.view("edit-virus", modelAndView);
        }

        this.virusService.updateVirus(this.modelMapper.map(bindingModel, VirusServiceModel.class));
        return this.redirect("/viruses/home");
    }

    private List<CapitalsViewModel> parsedCapitalsModels() {

        return this.capitalService.getAllCapitals().stream()
                .map(c -> this.modelMapper.map(c, CapitalsViewModel.class))
                .sorted(Comparator.comparing(CapitalsViewModel::getName))
                .collect(Collectors.toList());
    }
}