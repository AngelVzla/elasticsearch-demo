package net.redcyan.services;

import java.util.Optional;

import net.redcyan.domain.PlanningSummary;

public interface PlanningSummaryService {

	PlanningSummary save(PlanningSummary planningSummary);

	void delete(PlanningSummary planningSummary);

	Optional<PlanningSummary> findOne(String id);

	Iterable<PlanningSummary> findAll();

}