package erloader.persistence.entities;

import erloader.loader.xmlparsers.organization.ExchangeRate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "exch_rate")
public class ExchRate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "pos")
    private String posId;

    @Column(name = "currency")
    private String currencyId;

    @Column(name = "dtime")
    @Convert(converter = DateConverter.class)
    private LocalDateTime ldt;

    private Double br;
    private Double ar;

    public ExchRate() {
    }

    public ExchRate(LocalDateTime ldt, String posId, ExchangeRate er) {
        this.posId = posId;
        this.currencyId = er.getIdCurrency();
        this.ldt = ldt;
        this.br = er.getBid();
        this.ar = er.getAsk();
    }

    public Double getAr() {
        return ar;
    }

    public void setAr(Double ar) {
        this.ar = ar;
    }

    public Double getBr() {
        return br;
    }

    public void setBr(Double br) {
        this.br = br;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getLdt() {
        return ldt;
    }

    public void setLdt(LocalDateTime ldt) {
        this.ldt = ldt;
    }

    public String getPosId() {
        return posId;
    }

    public void setPosId(String posId) {
        this.posId = posId;
    }

    @Override
    public String toString() {
        return "ExchRate{" +
                "ar=" + ar +
                ", id=" + id +
                ", posId='" + posId + '\'' +
                ", currencyId='" + currencyId + '\'' +
                ", ldt=" + ldt +
                ", br=" + br +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExchRate exchRate = (ExchRate) o;

        if (id != null ? !id.equals(exchRate.id) : exchRate.id != null) return false;
        if (posId != null ? !posId.equals(exchRate.posId) : exchRate.posId != null) return false;
        if (currencyId != null ? !currencyId.equals(exchRate.currencyId) : exchRate.currencyId != null) return false;
        if (ldt != null ? !ldt.equals(exchRate.ldt) : exchRate.ldt != null) return false;
        if (br != null ? !br.equals(exchRate.br) : exchRate.br != null) return false;
        return !(ar != null ? !ar.equals(exchRate.ar) : exchRate.ar != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (posId != null ? posId.hashCode() : 0);
        result = 31 * result + (currencyId != null ? currencyId.hashCode() : 0);
        result = 31 * result + (ldt != null ? ldt.hashCode() : 0);
        result = 31 * result + (br != null ? br.hashCode() : 0);
        result = 31 * result + (ar != null ? ar.hashCode() : 0);
        return result;
    }
}
