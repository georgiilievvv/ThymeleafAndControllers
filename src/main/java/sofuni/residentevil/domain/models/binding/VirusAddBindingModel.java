package sofuni.residentevil.domain.models.binding;

import net.bytebuddy.implementation.bind.annotation.Empty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

public class VirusAddBindingModel {

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

    private VirusAddBindingModel() {
    }

    @NotEmpty(message = "Cannot be empty")
    @Size(min = 3, max = 10, message = "Invalid name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotEmpty(message = "Cannot be empty")
    @Size(min = 5, max = 100, message = "Invalid description length")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    @Size(max = 50, message = "Should have a maximum of 50 symbols.")
    public Integer getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(Integer sideEffects) {
        this.sideEffects = sideEffects;
    }

    @NotEmpty(message = "Cannot be null")
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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
