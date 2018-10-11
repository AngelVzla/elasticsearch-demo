package net.redcyan;

import java.util.Map;

import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

import net.redcyan.domain.PlanningSummary;
import net.redcyan.repos.ShipmentSummaryRepository;
import net.redcyan.services.PlanningSummaryService;

@SpringBootApplication
public class ElasticDataDemoApplication implements CommandLineRunner {

	@Autowired
	private ElasticsearchOperations es;

	@Autowired
	private PlanningSummaryService planningSummaryService;

	@Autowired
	private ShipmentSummaryRepository bookRepo;

	public static void main(String[] args) {
		SpringApplication.run(ElasticDataDemoApplication.class, args);
		ElasticDataDemoApplication elk = new ElasticDataDemoApplication();
		System.out.println("done");
	}

	@Override
	public void run(String... args) throws Exception {

//		printElasticSearchInfo();

		try {

			planningSummaryService.save(new PlanningSummary("0001", "5"));
			planningSummaryService.save(new PlanningSummary("0002", "10"));
			planningSummaryService.save(new PlanningSummary("0003", "100"));


			planningSummaryService.findAll().forEach(System.out::println);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

//	private void printElasticSearchInfo() {
//
//		System.out.println("--ElasticSearch-->");
//		Client client = es.getClient();
//		Map<String, String> asMap = client.settings().getAsMap();
//
//		asMap.forEach((k, v) -> {
//			System.out.println(k + " = " + v);
//		});
//		System.out.println("<--ElasticSearch--");
//	}
}
