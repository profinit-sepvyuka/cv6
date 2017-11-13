package cz.profinit.sep.civka6;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import cz.profinit.sep.civka6.dao.ObjektDao;
import cz.profinit.sep.civka6.model.ObjektKUlozeni;
import cz.profinit.sep.civka6.ui.VaadinUI;

@SpringBootApplication
public class App {

	private static final Logger log = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		SpringApplication.run(App.class);
	}

	@Bean
	public CommandLineRunner loadData(final ObjektDao repository) {
		return (args) -> {
			// save a couple of ObjektKUlozenis
			repository.save(new ObjektKUlozeni("IbanZdroj1", "IbanCil1", BigDecimal.ONE));
			repository.save(new ObjektKUlozeni("IbanZdroj2", "IbanCil2", BigDecimal.ONE));
			repository.save(new ObjektKUlozeni("IbanZdroj3", "IbanCil3", BigDecimal.ONE));
			repository.save(new ObjektKUlozeni("IbanZdroj4", "IbanCil4", BigDecimal.ONE));
			repository.save(new ObjektKUlozeni("IbanZdroj5", "IbanCil5", BigDecimal.ONE));

			// fetch all ObjektKUlozenis
			log.info("ObjektKUlozenis found with findAll():");
			log.info("-------------------------------");
			for (ObjektKUlozeni ObjektKUlozeni : repository.findAll()) {
				log.info(ObjektKUlozeni.toString());
			}
			log.info("");

			// fetch an individual ObjektKUlozeni by ID
			ObjektKUlozeni ObjektKUlozeni = repository.findOne(1L);
			log.info("ObjektKUlozeni found with findOne(1L):");
			log.info("--------------------------------");
			log.info(ObjektKUlozeni.toString());
			log.info("");

			// fetch ObjektKUlozenis by last name
			log.info("ObjektKUlozeni found with findByLastNameStartsWithIgnoreCase('Bauer'):");
			log.info("--------------------------------------------");
			for (ObjektKUlozeni obj1 : repository
					.findBySourceAbo("IbanZdroj1")) {
				log.info(obj1.toString());
			}
			log.info("");
		};
	}

}