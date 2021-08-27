package cz.example.lundegaardtestproject.dto;

import lombok.Data;

@Data
public class SendRequestDto {
    private String requestType;
    private String policyNumber;
    private String name;
    private String surname;
    private String requestText;
}
