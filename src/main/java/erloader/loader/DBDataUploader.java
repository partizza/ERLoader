package erloader.loader;

import erloader.persistence.entities.*;
import erloader.persistence.repositories.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import erloader.loader.xmlparsers.XMLSourceParser;

import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;
import java.util.Map;

@Named
public class DBDataUploader implements DataUploader {

    @Inject
    private Unmarshaller xmlParser;

    @Inject
    private Map<String, CrudRepository<?, ?>> repositories;

    public void upload(File xmlSource) {
        try {
            XMLSourceParser xml = (XMLSourceParser) xmlParser.unmarshal(xmlSource);
            uploadBaseData(xml);
            uploadPos(xml);
            uploadExchRate(xml);
        } catch (Exception e) {
            throw new DataUploadException(e.getMessage(), e);
        }
    }

    @Transactional
    protected void uploadBaseData(XMLSourceParser xml) {
        List<TCurrency> currencies = xml.getCurrencyEntities();
        CurrencyRepository crp = (CurrencyRepository) repositories.get("currencyRepository");
        crp.save(currencies);

        List<TRegion> regions = xml.getRegionEntities();
        RegionRepository rrp = (RegionRepository) repositories.get("regionRepository");
        rrp.save(regions);

        List<TCity> cities = xml.getCityEntities();
        CityRepository ctrp = (CityRepository) repositories.get("cityRepository");
        ctrp.save(cities);

        List<TOrgType> orgTypes = xml.getOrgTypesEntities();
        OrgTypeRepository otrp = (OrgTypeRepository) repositories.get("orgTypeRepository");
        otrp.save(orgTypes);
    }

    @Transactional
    protected void uploadPos(XMLSourceParser xml) {
        List<Pos> poses = xml.getPosEntities();
        PosRepository prp = (PosRepository) repositories.get("posRepository");
        prp.save(poses);
    }

    @Transactional
    protected void uploadExchRate(XMLSourceParser xml) {
        List<ExchRate> rates = xml.getExchRateEntities();
        ExchRateRepository prp = (ExchRateRepository) repositories.get("exchRateRepository");
        prp.save(rates);
    }

}
