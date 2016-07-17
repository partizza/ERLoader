package erloader.loader.xmlparsers;

import erloader.loader.xmlparsers.organization.Organization;
import erloader.persistence.entities.*;
import erloader.loader.xmlparsers.adapters.DateAdapter;
import erloader.loader.xmlparsers.organization.ExchangeRate;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "source")
public class XMLSourceParser {

    private String id;
    private LocalDateTime localDateTime;
    private List<City> cities;
    private List<Region> regions;
    private List<Currency> currencies;
    private List<OrgType> orgTypes;
    private List<Organization> organizations;

    @XmlAttribute
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElementWrapper
    @XmlElement(name = "city")
    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    @XmlElementWrapper
    @XmlElement(name = "region")
    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    @XmlElementWrapper
    @XmlElement(name = "c")
    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    @XmlElementWrapper(name = "org_types")
    @XmlElement(name = "org_type")
    public List<OrgType> getOrgTypes() {
        return orgTypes;
    }

    public void setOrgTypes(List<OrgType> orgTypes) {
        this.orgTypes = orgTypes;
    }

    @XmlJavaTypeAdapter(DateAdapter.class)
    @XmlAttribute(name = "date")
    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @XmlElementWrapper
    @XmlElement(name = "organization")
    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }

    public List<TCurrency> getCurrencyEntities() {
        List<TCurrency> lst = new ArrayList<>();
        for (Currency e : currencies) {
            lst.add(new TCurrency(e.getId(), e.getTitle()));
        }
        return lst;
    }

    public List<TCity> getCityEntities() {
        List<TCity> lst = new ArrayList<>();
        for (City e : cities) {
            lst.add(new TCity(e.getId(), e.getTitle()));
        }
        return lst;
    }

    public List<TRegion> getRegionEntities() {
        List<TRegion> lst = new ArrayList<>();
        for (Region e : regions) {
            lst.add(new TRegion(e.getId(), e.getTitle()));
        }
        return lst;
    }

    public List<TOrgType> getOrgTypesEntities() {
        List<TOrgType> lst = new ArrayList<>();
        for (OrgType e : orgTypes) {
            lst.add(new TOrgType(e.getId(), e.getTitle()));
        }
        return lst;
    }

    public List<Pos> getPosEntities() {
        List<Pos> lst = new ArrayList<>();
        for (Organization e : organizations) {
            lst.add(new Pos(e));
        }
        return lst;
    }

    public List<ExchRate> getExchRateEntities(){
        List<ExchRate> lst = new ArrayList<>();
        for(Organization e : organizations){
            for(ExchangeRate r : e.getExchangeRates()) {
                lst.add(new ExchRate(localDateTime, e.getId(),r));
            }
        }
        return lst;
    }

    @Override
    public String toString() {
        return "XMLSourceParser{" +
                "id='" + id + '\'' +
                ", date='" + localDateTime + '\'' +
                ", cities=" + cities +
                ", regions=" + regions +
                ", currencies=" + currencies +
                ", orgTypes=" + orgTypes +
                ", organization=" + organizations +
                '}';
    }
}
