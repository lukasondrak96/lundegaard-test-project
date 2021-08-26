package cz.example.lundegaardtestproject.repository;

import cz.example.lundegaardtestproject.entity.ContactRequestType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRequestTypeRepository extends JpaRepository<ContactRequestType, Integer> {

    Optional<ContactRequestType> findByType(String type);

}
