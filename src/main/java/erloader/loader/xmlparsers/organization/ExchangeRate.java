package erloader.loader.xmlparsers.organization;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "c")
public class ExchangeRate {

    private String idCurrency;
    private double bid;
    private double ask;

    @XmlAttribute(name = "ar")
    public double getAsk() {
        return ask;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    @XmlAttribute(name = "br")
    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    @XmlAttribute(name = "id")
    public String getIdCurrency() {
        return idCurrency;
    }

    public void setIdCurrency(String idCurrency) {
        this.idCurrency = idCurrency;
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "idCurrency='" + idCurrency + '\'' +
                ", bid=" + bid +
                ", ask=" + ask +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExchangeRate that = (ExchangeRate) o;

        if (Double.compare(that.bid, bid) != 0) return false;
        if (Double.compare(that.ask, ask) != 0) return false;
        return !(idCurrency != null ? !idCurrency.equals(that.idCurrency) : that.idCurrency != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idCurrency != null ? idCurrency.hashCode() : 0;
        temp = Double.doubleToLongBits(bid);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(ask);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
