package cz.example.lundegaardtestproject.service;

import cz.example.lundegaardtestproject.entity.RequestSender;
import cz.example.lundegaardtestproject.exception.RequestSenderNotFoundException;
import cz.example.lundegaardtestproject.repository.RequestSenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestSenderService {

    @Autowired
    private RequestSenderRepository requestSenderRepository;

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
                        new RequestSenderNotFoundException("Request sender with id "  + id + " does not exists")
                );
    }
}
