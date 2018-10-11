package net.redcyan.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.redcyan.domain.PlanningSummary;
import net.redcyan.repos.ShipmentSummaryRepository;

@Service
public class PlanningSummaryServiceImpl implements PlanningSummaryService {

	private ShipmentSummaryRepository shipmentSummaryRepository;

	@Autowired
	public void setBookRepository(ShipmentSummaryRepository shipmentSummaryRepository) {
		this.shipmentSummaryRepository = shipmentSummaryRepository;
	}

	public PlanningSummary save(PlanningSummary planningSummary) {
		return shipmentSummaryRepository.save(planningSummary);
	}

	public void delete(PlanningSummary planningSummary) {
		shipmentSummaryRepository.delete(planningSummary);
	}

	public Optional<PlanningSummary> findOne(String id) {
		return shipmentSummaryRepository.findById(id);
	}

	public Iterable<PlanningSummary> findAll() {
		return shipmentSummaryRepository.findAll();
	}

}