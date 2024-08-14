package vandyke.Reference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "star_type_adjacency")
public class StarTypeAdjacency {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "full_type", length = 2)
    private String fullType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullType() {
        return fullType;
    }

    public void setFullType(String fullType) {
        this.fullType = fullType;
    }

}