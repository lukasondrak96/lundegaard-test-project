package cz.example.lundegaardtestproject.controller;

import cz.example.lundegaardtestproject.dto.ResponseDto;
import cz.example.lundegaardtestproject.dto.SendRequestDto;
import cz.example.lundegaardtestproject.entity.ContactRequest;
import cz.example.lundegaardtestproject.entity.ContactRequestType;
import cz.example.lundegaardtestproject.entity.RequestSender;
import cz.example.lundegaardtestproject.service.ContactRequestService;
import cz.example.lundegaardtestproject.service.ContactRequestTypeService;
import cz.example.lundegaardtestproject.service.RequestSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/request")
public class ContactRequestController {

    private ContactRequestService contactRequestService;
    private ContactRequestTypeService contactRequestTypeService;
    private RequestSenderService requestSenderService;


    @Autowired
    public ContactRequestController(ContactRequestService contactRequestService,
                                    ContactRequestTypeService contactRequestTypeService,
                                    RequestSenderService requestSenderService) {
        this.contactRequestService = contactRequestService;
        this.contactRequestTypeService = contactRequestTypeService;
        this.requestSenderService = requestSenderService;

    }

    @PostMapping("/sendrequest")
    public ResponseEntity<ResponseDto> sendContactRequest(@RequestBody SendRequestDto sendRequestDto) {
        String policyNumber = sendRequestDto.getPolicyNumber();
        String name = sendRequestDto.getName();
        String surname = sendRequestDto.getSurname();

        if (!policyNumber.matches("[A-Za-z0-9]+"))
            return new ResponseEntity<ResponseDto>(new ResponseDto("Request was not submitted, policy number has to be alphanumeric"), HttpStatus.BAD_REQUEST);

        if (!name.matches("[A-Za-z]+"))
            return new ResponseEntity<ResponseDto>(new ResponseDto("Request was not submitted, name has to contain only letters"), HttpStatus.BAD_REQUEST);
        if (!surname.matches("[A-Za-z]+"))
            return new ResponseEntity<ResponseDto>(new ResponseDto("Request was not submitted, surname has to contain only letters"), HttpStatus.BAD_REQUEST);

        if (sendRequestDto.getRequestText().length() > 5000)
            return new ResponseEntity<ResponseDto>(new ResponseDto("Request was not submitted, request text cannot have more than 5000 sings"), HttpStatus.BAD_REQUEST);

        ContactRequestType contactRequestType = contactRequestTypeService.findContactRequestTypeByType(sendRequestDto.getRequestType());
        if (contactRequestType == null)
            return new ResponseEntity<ResponseDto>(new ResponseDto("Request was not submitted, request type does not exists in database"), HttpStatus.BAD_REQUEST);

        RequestSender sender = requestSenderService.findRequestSenderByAttributes(name, surname, policyNumber);
        if (sender == null) {
            sender = createRequestSender(name, surname, policyNumber);
            if (sender == null)
                return new ResponseEntity<ResponseDto>(new ResponseDto("Request was not submitted, request sender could not be saved"), HttpStatus.BAD_REQUEST);
        }

        ContactRequest createdContactRequest = createContactRequest(sendRequestDto, contactRequestType, sender);
        if (createdContactRequest == null)
            return new ResponseEntity<ResponseDto>(new ResponseDto("Request was not submitted, request sender could not be saved"), HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<ResponseDto>(new ResponseDto("Request saved succesfully"), HttpStatus.OK);
    }

    private ContactRequest createContactRequest(SendRequestDto sendRequestDto, ContactRequestType contactRequestType, RequestSender sender) {
        ContactRequest newContactRequest = new ContactRequest();
        newContactRequest.setMessage(sendRequestDto.getRequestText());
        newContactRequest.setRequestSender(sender);
        newContactRequest.setRequestType(contactRequestType);
        return contactRequestService.addContactRequest(newContactRequest);
    }

    private RequestSender createRequestSender(String name, String surname, String policyNumber) {
        RequestSender requestSender = new RequestSender();
        requestSender.setName(name);
        requestSender.setSurname(surname);
        requestSender.setPolicyNumber(policyNumber);
        return requestSenderService.addRequestSender(requestSender);
    }
}
