package net.redcyan.repos;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import net.redcyan.domain.PlanningSummary;

public interface ShipmentSummaryRepository extends ElasticsearchRepository<PlanningSummary, String> {

	//Add custom queries in here

}
