package vandyke.Reference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "minimum_allowable_orbit")
public class MinimumAllowableOrbit {
    @Id
    @Column(name = "star_type", nullable = false, length = 2)
    private String starType;

    @Column(name = "Ia")
    private Double Ia;

    @Column(name = "Ib")
    private Double Ib;

    @Column(name = "II")
    private Double II;

    @Column(name = "III")
    private Double III;

    @Column(name = "IV")
    private Double IV;

    @Column(name = "V")
    private Double V;

    @Column(name = "VI")
    private Double VI;

    public String getStarType() {
        return starType;
    }

    public void setStarType(String starType) {
        this.starType = starType;
    }

    public Double getIa() {
        return Ia;
    }

    public void setIa(Double ia) {
        Ia = ia;
    }

    public Double getIb() {
        return Ib;
    }

    public void setIb(Double ib) {
        Ib = ib;
    }

    public Double getII() {
        return II;
    }

    public void setII(Double II) {
        this.II = II;
    }

    public Double getIII() {
        return III;
    }

    public void setIII(Double III) {
        this.III = III;
    }

    public Double getIV() {
        return IV;
    }

    public void setIV(Double IV) {
        this.IV = IV;
    }

    public Double getV() {
        return V;
    }

    public void setV(Double v) {
        V = v;
    }

    public Double getVI() {
        return VI;
    }

    public void setVI(Double VI) {
        this.VI = VI;
    }
}