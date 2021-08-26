package cz.example.lundegaardtestproject.dto;

import lombok.Data;

@Data
public class SendRequestDto {

    private String kindOfRequest;
    private String policyNumber;
    private String name;
    private String surname;
    private String request;
}
