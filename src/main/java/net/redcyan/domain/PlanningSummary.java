package net.redcyan.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;
import lombok.ToString;

//Keep in mind that only 1 type per index starting Elasticsearch 6
@Document(indexName = "planningsummary", type = "summary")
@Data
@ToString
public class PlanningSummary {

	@Id
	private String id;
	private String numberOfShipments;

	public PlanningSummary() {
	}

	public PlanningSummary(String id, String numberOfShipments) {
		super();
		this.id = id;
		this.numberOfShipments = numberOfShipments;
	}


}
