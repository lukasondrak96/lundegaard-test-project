import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ConstantsRoutesModel} from "../app/constants-routes.model";
import {ContactFormModel} from "../app/models/ContactFormModel";
import {ResponseModel} from "../app/models/ResponseModel";

@Injectable({
  providedIn: 'root'
})
export class ContactFormService {

  constructor(private http: HttpClient) {
  }

  getRequestTypesListData(): Observable<[string]> {
    return this.http.get<[string]>(ConstantsRoutesModel.REQUEST_TYPE_ALL_URL);
  }

  sendNewRequest(formValues: ContactFormModel): Observable<ResponseModel> {
    const headerDict = {
      'Response-Type': 'text',
    }
    const requestOptions = {
      headers: new HttpHeaders(headerDict),
    };
    return this.http.post<ResponseModel>(ConstantsRoutesModel.SEND_NEW_REQUEST_URL, formValues);
  }
}
