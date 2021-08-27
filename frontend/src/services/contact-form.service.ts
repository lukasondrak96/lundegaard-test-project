import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ConstantsRoutesModel} from "../app/constants-routes.model";
import {ContactFormModel} from "../app/models/ContactFormModel";

@Injectable({
  providedIn: 'root'
})
export class ContactFormService {

  constructor(private http: HttpClient) {
  }

  getRequestTypesListData(): Observable<[string]> {
    return this.http.get<[string]>(ConstantsRoutesModel.REQUEST_TYPE_ALL_URL);
  }

  sendNewRequest(formValues: ContactFormModel): Observable<string> {
    const headerDict = {
      'Response-Type': 'text',
    }
    const requestOptions = {
      headers: new HttpHeaders(headerDict),
    };
    return this.http.post<string>(ConstantsRoutesModel.SEND_NEW_REQUEST_URL, formValues);
  }
}
