package cz.example.lundegaardtestproject.service;

import cz.example.lundegaardtestproject.entity.ContactRequestType;
import cz.example.lundegaardtestproject.exception.ContactRequestTypeNotFoundException;
import cz.example.lundegaardtestproject.repository.ContactRequestTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactRequestTypeService {

    @Autowired
    private ContactRequestTypeRepository contactRequestTypeRepository;

    public ContactRequestType addContactRequestType(ContactRequestType requestType) {
        return contactRequestTypeRepository.save(requestType);
    }

    public List<String> findAllRequestTypes() {
        List<String> requestTypes = new ArrayList<>();
        contactRequestTypeRepository.findAll()
                .stream()
                .forEach(type -> requestTypes.add(type.getType()));
        return requestTypes;
    }

    public void deleteContactRequestTypeById(Integer id) {
        contactRequestTypeRepository.deleteById(id);
    }

    public ContactRequestType findContactRequestTypeById(Integer id) {
        return contactRequestTypeRepository.findById(id)
                .orElseThrow(() ->
                        new ContactRequestTypeNotFoundException("Contact request type with id "  + id + " does not exists")
                );
    }

    public ContactRequestType findContactRequestTypeByType(String type) {
        return contactRequestTypeRepository.findByType(type)
                .orElseThrow(() ->
                        new ContactRequestTypeNotFoundException("Contact request type "  + type + " does not exists")
                );
    }
}
