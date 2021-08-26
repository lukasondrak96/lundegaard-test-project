package cz.example.lundegaardtestproject.controller;

import cz.example.lundegaardtestproject.service.ContactRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/request")
public class ContactRequestController {

    private ContactRequestService contactRequestService;

    @Autowired
    public ContactRequestController(ContactRequestService contactRequestService) {
        this.contactRequestService = contactRequestService;
    }

//    @PostMapping("/sendrequest")
//    public ResponseEntity<ContactRequest> sendContactRequest(@RequestBody SendRequestDto sendRequestDto) {
//        return new ResponseEntity<>();
//    }
}
