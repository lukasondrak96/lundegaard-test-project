export class ConstantsRoutesModel {

  private static BACKEND_BASE_URL = 'http://localhost:8080/api';

  public static readonly REQUEST_TYPE_ALL_URL = `${ConstantsRoutesModel.BACKEND_BASE_URL}\\request\\type\\all`;
  public static readonly SEND_NEW_REQUEST_URL = `${ConstantsRoutesModel.BACKEND_BASE_URL}\\request\\sendrequest`;


}
