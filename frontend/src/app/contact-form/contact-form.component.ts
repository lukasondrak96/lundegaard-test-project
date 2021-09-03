import {Component, OnInit} from '@angular/core';
import {ContactFormService} from "../../services/contact-form.service";
import {ContactFormModel} from "../models/ContactFormModel";
import {ResponseModel} from "../models/ResponseModel";

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
      (res: ResponseModel) => {
        alert(res.message)
        window.location.reload();
      },
      err => {
        alert("Server error");
        window.location.reload();
      }
    );
  }


  //that error was like this:
  // headers: HttpHeaders {normalizedNames: Map(0), lazyUpdate: null, lazyInit: ƒ}
  // message: "Http failure during parsing for http://localhost:8080/api/request/sendrequest"
  // name: "HttpErrorResponse"
  // ok: false
  // status: 200
  // statusText: "OK"
  // url: "http://localhost:8080/api/request/sendrequest"
}
