package erloader.loader.xmlparsers.organization;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Organization {

    private String id;
    private String orgType;
    private Title title;
    private IDRegion region;
    private IDCity city;
    private Address address;
    private List<ExchangeRate> exchangeRates;

    @XmlElement
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @XmlElement
    public IDCity getCity() {
        return city;
    }

    public void setCity(IDCity city) {
        this.city = city;
    }

    @XmlAttribute
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlAttribute(name = "org_type")
    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    @XmlElement
    public IDRegion getRegion() {
        return region;
    }

    public void setRegion(IDRegion region) {
        this.region = region;
    }

    @XmlElement
    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    @XmlElementWrapper(name = "currencies")
    @XmlElement(name = "c")
    public List<ExchangeRate> getExchangeRates() {
        return exchangeRates;
    }

    public void setExchangeRates(List<ExchangeRate> exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    @Override
    public String toString() {
        return "Organization{" +
                " " + address +
                ", id='" + id + '\'' +
                ", orgType='" + orgType + '\'' +
                ", " + title +
                ", " + region +
                ", " + city +
                ", rates=" + exchangeRates +
                '}';
    }
}
