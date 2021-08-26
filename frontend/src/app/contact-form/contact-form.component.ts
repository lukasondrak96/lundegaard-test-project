import {Component, OnInit} from '@angular/core';
import {ContactFormService} from "../../services/contact-form.service";
import {ContactFormModel} from "../models/ContactFormModel";

@Component({
  selector: 'app-contact-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.css']
})
export class ContactFormComponent implements OnInit {

  requestTypes: string[] = [];
  formValues: ContactFormModel = {
    requestType: "",
    policyNumber: "",
    name: "",
    surname: "",
    requestText: ""
  }
  public readonly REQUIRED_FIELD = 'This field is required';


  dataLoaded = false;
  errorWhileLoadingData = false;

  constructor(private contactFormService: ContactFormService) { }

  ngOnInit(): void {
    this.getAllRequestTypes();
  }

  getAllRequestTypes() {
    this.contactFormService.getRequestTypesListData().subscribe(
      res => {
        this.requestTypes = res;
        if(this.requestTypes.length != 0) {
            this.dataLoaded = true;
            this.formValues.requestType = this.requestTypes[0];
        } else {
          alert("There are no request types in database");
        }
      },
      () => {
         this.errorWhileLoadingData = true;
         alert("Request types were not loaded properly. Reason: Backend server does not responding or database was not created!");
      }
    );
  }

  sendNewRequest() {
    (document.getElementById('submitButton') as HTMLButtonElement).disabled = true;
    this.contactFormService.sendNewRequest(this.formValues).subscribe(
      () => {
        window.location.reload();
        alert("Request submitted successfully!");
      },
      () => {
        alert("Request was not submitted successfully!");
        (document.getElementById('submitButton') as HTMLButtonElement).disabled = false;
      }
    );
  }
}
