package sofuni.residentevil.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "capitals")
public class Capital extends BaseEntity {

    private String name;
    private Double latitude;
    private Double longitude;
    private List<Virus> viruses;

    public Capital() {
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "latitude")
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Column(name = "longitude")
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @ManyToMany(mappedBy = "capitals", cascade = CascadeType.ALL)
    public List<Virus> getViruses() {
        return viruses;
    }

    public void setViruses(List<Virus> viruses) {
        this.viruses = viruses;
    }
}
