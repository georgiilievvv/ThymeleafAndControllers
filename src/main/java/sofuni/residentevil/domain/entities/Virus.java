package sofuni.residentevil.domain.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "viruses")
public class Virus extends BaseEntity{

    private String name;
    private String description;
    private Integer sideEffects;
    private Creator creator;
    private boolean isDeadly;
    private boolean isCurable;
    private Mutation mutation;
    private Integer turnoverRate;
    private Integer HoursUntilTurn;
    private Magnitude magnitude;
    private LocalDate releasedOn;
    private List<Capital> capitals;

    public Virus() {
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "side_effects", nullable = false)
    public Integer getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(Integer sideEffects) {
        this.sideEffects = sideEffects;
    }

    @Column(name = "creator", nullable = false)
    @Enumerated(value = EnumType.STRING)
    public Creator getCreator() {
        return creator;
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    @Column(name = "is_deadly", nullable = false)
    public boolean isDeadly() {
        return isDeadly;
    }

    public void setDeadly(boolean deadly) {
        isDeadly = deadly;
    }

    @Column(name = "is_curable", nullable = false)
    public boolean isCurable() {
        return isCurable;
    }

    public void setCurable(boolean curable) {
        isCurable = curable;
    }

    @Column(name = "mutation", nullable = false)
    @Enumerated(value = EnumType.STRING)
    public Mutation getMutation() {
        return mutation;
    }

    public void setMutation(Mutation mutation) {
        this.mutation = mutation;
    }

    @Column(name = "turnover_rate", nullable = false)
    public Integer getTurnoverRate() {
        return turnoverRate;
    }

    public void setTurnoverRate(Integer turnoverRate) {
        this.turnoverRate = turnoverRate;
    }

    @Column(name = "hours_until_turn", nullable = false)
    public Integer getHoursUntilTurn() {
        return HoursUntilTurn;
    }

    public void setHoursUntilTurn(Integer hoursUntilTurn) {
        HoursUntilTurn = hoursUntilTurn;
    }

    @Column(name = "magnitude", nullable = false)
    @Enumerated(value = EnumType.STRING)
    public Magnitude getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(Magnitude magnitude) {
        this.magnitude = magnitude;
    }

    @Column(name = "released_on", nullable = false)
    public LocalDate getReleasedOn() {
        return releasedOn;
    }

    public void setReleasedOn(LocalDate releasedOn) {
        this.releasedOn = releasedOn;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "viruses_capitals",
            joinColumns = @JoinColumn(name = "virus_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "capital_id", referencedColumnName = "id")

    )
    public List<Capital> getCapitals() {
        return capitals;
    }

    public void setCapitals(List<Capital> capitals) {
        this.capitals = capitals;
    }
}
