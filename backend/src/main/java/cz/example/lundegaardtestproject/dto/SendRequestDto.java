package cz.example.lundegaardtestproject.dto;

import lombok.Data;

import java.util.Objects;

@Data
public class SendRequestDto {
    private String requestType;
    private String policyNumber;
    private String name;
    private String surname;
    private String requestText;

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRequestText() {
        return requestText;
    }

    public void setRequestText(String requestText) {
        this.requestText = requestText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SendRequestDto that = (SendRequestDto) o;
        return Objects.equals(requestType, that.requestType) && Objects.equals(policyNumber, that.policyNumber) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(requestText, that.requestText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestType, policyNumber, name, surname, requestText);
    }
}
