package cz.example.lundegaardtestproject.repository;

import cz.example.lundegaardtestproject.entity.ContactRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRequestRepository extends JpaRepository<ContactRequest, Integer> {
}
