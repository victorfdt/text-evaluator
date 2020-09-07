package nl.elros.textevaluator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nl.elros.textevaluator.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
