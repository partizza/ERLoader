package erloader.persistence.entities;

import erloader.loader.xmlparsers.organization.Organization;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pos {

    @Id
    private String id;
    private String title;
    private String address;
    @Column(name="tp")
    private String tpId;
    @Column(name="city")
    private String cityId;
    @Column(name = "region")
    private String regionId;

    public Pos() {
    }

    public Pos(Organization o) {
        this.address = o.getAddress().getAddress();
        this.cityId = o.getCity().getId();
        this.id = o.getId();
        this.regionId = o.getRegion().getId();
        this.title = o.getTitle().getValue();
        this.tpId = o.getOrgType();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTpId() {
        return tpId;
    }

    public void setTpId(String tpId) {
        this.tpId = tpId;
    }

    @Override
    public String toString() {
        return "Pos{" +
                "address='" + address + '\'' +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", tpId='" + tpId + '\'' +
                ", cityId='" + cityId + '\'' +
                ", regionId='" + regionId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pos pos = (Pos) o;

        if (id != null ? !id.equals(pos.id) : pos.id != null) return false;
        if (title != null ? !title.equals(pos.title) : pos.title != null) return false;
        if (address != null ? !address.equals(pos.address) : pos.address != null) return false;
        if (tpId != null ? !tpId.equals(pos.tpId) : pos.tpId != null) return false;
        if (cityId != null ? !cityId.equals(pos.cityId) : pos.cityId != null) return false;
        return !(regionId != null ? !regionId.equals(pos.regionId) : pos.regionId != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (tpId != null ? tpId.hashCode() : 0);
        result = 31 * result + (cityId != null ? cityId.hashCode() : 0);
        result = 31 * result + (regionId != null ? regionId.hashCode() : 0);
        return result;
    }
}
