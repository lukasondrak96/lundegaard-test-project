package cz.example.lundegaardtestproject.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Entity
public class ContactRequest implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "Message is mandatory")
    private String message;

    @ManyToOne
    @JoinColumn(name = "contact_request_id")
    private ContactRequestType requestType;
}
