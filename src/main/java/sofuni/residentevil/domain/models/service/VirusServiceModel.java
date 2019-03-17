package sofuni.residentevil.domain.models.service;

import sofuni.residentevil.domain.entities.Capital;
import sofuni.residentevil.domain.entities.Creator;
import sofuni.residentevil.domain.entities.Magnitude;
import sofuni.residentevil.domain.entities.Mutation;

import java.time.LocalDate;
import java.util.List;

public class VirusServiceModel {

    private String id;
    private String name;
    private String description;
    private Integer sideEffects;
    private String creator;
    private boolean isDeadly;
    private boolean isCurable;
    private String mutation;
    private Integer turnoverRate;
    private Integer HoursUntilTurn;
    private String magnitude;
    private LocalDate releasedOn;
    private List<String> capitals;

    public VirusServiceModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(Integer sideEffects) {
        this.sideEffects = sideEffects;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public boolean isDeadly() {
        return isDeadly;
    }

    public void setDeadly(boolean deadly) {
        isDeadly = deadly;
    }

    public boolean isCurable() {
        return isCurable;
    }

    public void setCurable(boolean curable) {
        isCurable = curable;
    }

    public String getMutation() {
        return mutation;
    }

    public void setMutation(String mutation) {
        this.mutation = mutation;
    }

    public Integer getTurnoverRate() {
        return turnoverRate;
    }

    public void setTurnoverRate(Integer turnoverRate) {
        this.turnoverRate = turnoverRate;
    }

    public Integer getHoursUntilTurn() {
        return HoursUntilTurn;
    }

    public void setHoursUntilTurn(Integer hoursUntilTurn) {
        HoursUntilTurn = hoursUntilTurn;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(String magnitude) {
        this.magnitude = magnitude;
    }

    public LocalDate getReleasedOn() {
        return releasedOn;
    }

    public void setReleasedOn(LocalDate releasedOn) {
        this.releasedOn = releasedOn;
    }

    public List<String> getCapitals() {
        return capitals;
    }

    public void setCapitals(List<String> capitals) {
        this.capitals = capitals;
    }
}
