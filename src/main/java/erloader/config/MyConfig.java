package erloader.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import erloader.loader.xmlparsers.XMLSourceParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

@Configuration
@ComponentScan({"erloader"})
@ImportResource("classpath:beans.xml")
@EnableJpaRepositories(basePackages={"erloader.persistence.repositories"})
public class MyConfig {

    @Bean
    public Unmarshaller unmarshaller() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(XMLSourceParser.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return unmarshaller;
    }
}
