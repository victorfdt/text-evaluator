package nl.elros.textevaluator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nl.elros.textevaluator.entity.Evaluation;

public interface EvaluationRepository extends JpaRepository<Evaluation, Integer>{

}
