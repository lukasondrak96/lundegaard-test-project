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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "request_type_id", referencedColumnName = "id")
    private ContactRequestType requestType;

    @ManyToOne
    @JoinColumn(name = "request_sender_id", referencedColumnName = "id")
    private RequestSender requestSender;
}
