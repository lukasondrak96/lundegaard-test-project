package cz.example.lundegaardtestproject.service;

import cz.example.lundegaardtestproject.entity.ContactRequest;
import cz.example.lundegaardtestproject.exception.ContactRequestNotFoundException;
import cz.example.lundegaardtestproject.repository.ContactRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactRequestService {

    private final ContactRequestRepository contactRequestRepository;

    @Autowired
    public ContactRequestService(ContactRequestRepository contactRequestRepository) {
        this.contactRequestRepository = contactRequestRepository;
    }

    public ContactRequest addContactRequest(ContactRequest contactRequest) {
        return contactRequestRepository.save(contactRequest);
    }

    public List<ContactRequest> findAllRequests() {
        return contactRequestRepository.findAll();
    }

    public void deleteContactRequestById(Integer id) {
        contactRequestRepository.deleteById(id);
    }

    public ContactRequest findContactRequestById(Integer id) {
        return contactRequestRepository.findById(id)
                .orElseThrow(() ->
                        new ContactRequestNotFoundException("Contact request with id "  + id + " does not exists")
                );
    }

}
