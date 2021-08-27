package cz.example.lundegaardtestproject.controller;

import cz.example.lundegaardtestproject.service.ContactRequestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/request/type")
public class ContactRequestTypeController {

    private ContactRequestTypeService contactRequestTypeService;

    @Autowired
    public ContactRequestTypeController(ContactRequestTypeService contactRequestTypeService) {
        this.contactRequestTypeService = contactRequestTypeService;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getAllRequestTypes() {
        return contactRequestTypeService.findAllRequestTypes();
    }

}
