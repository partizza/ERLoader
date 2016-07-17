package main;

import erloader.config.MyConfig;
import erloader.extractor.Downloader;
import erloader.loader.DataUploader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.AbstractEnvironment;
import erloader.loader.DBDataUploader;
import erloader.loader.xmlparsers.XMLSourceParser;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Runner {

    public static void main(String[] args) throws JAXBException {

        System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "dev");
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        Downloader dwl = context.getBean(Downloader.class);
        dwl.download();

        DataUploader upl = context.getBean(DataUploader.class);
        upl.upload(dwl.getTargetFile());

    }
}
