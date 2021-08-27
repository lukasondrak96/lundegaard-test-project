package cz.example.lundegaardtestproject.repository;

import cz.example.lundegaardtestproject.entity.RequestSender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestSenderRepository extends JpaRepository<RequestSender, Integer> {

    List<RequestSender> findRequestSenderByNameAndSurnameAndPolicyNumber(String name, String surname, String policyNumber);
}
