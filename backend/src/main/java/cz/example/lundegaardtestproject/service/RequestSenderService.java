package cz.example.lundegaardtestproject.service;

import cz.example.lundegaardtestproject.entity.RequestSender;
import cz.example.lundegaardtestproject.exception.RequestSenderNotFoundException;
import cz.example.lundegaardtestproject.repository.RequestSenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestSenderService {

    private final RequestSenderRepository requestSenderRepository;

    @Autowired
    public RequestSenderService(RequestSenderRepository requestSenderRepository) {
        this.requestSenderRepository = requestSenderRepository;
    }

    public RequestSender addRequestSender(RequestSender sender) {
        return requestSenderRepository.save(sender);
    }

    public List<RequestSender> findAllRequestSenders() {
        return requestSenderRepository.findAll();
    }

    public void deleteRequestSenderById(Integer id) {
        requestSenderRepository.delete(findRequestSenderById(id));
    }

    public RequestSender findRequestSenderById(Integer id) {
        return requestSenderRepository.findById(id)
                .orElseThrow(() ->
                        new RequestSenderNotFoundException("Request sender with id " + id + " does not exists")
                );
    }

    public RequestSender findRequestSenderByAttributes(String name, String surname, String policyNumber) {
        List<RequestSender> foundSenders = requestSenderRepository.findRequestSenderByNameAndSurnameAndPolicyNumber(name, surname, policyNumber);
        if (foundSenders.isEmpty())
            return null;
        else if (foundSenders.size() > 1)
            throw new RuntimeException("Unexpected database state, more request senders with same attributes!");
        else
            return foundSenders.get(0);
    }
}
