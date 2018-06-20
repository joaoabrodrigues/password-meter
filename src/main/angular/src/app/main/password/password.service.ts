import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PasswordRequest, PasswordResponse } from './model/model';

@Injectable()
export class PasswordService {

  constructor(private _httpClient: HttpClient) { }

  checkPassword(password) {
    var ip = window.location.origin;
    const url = ip + '/api/v1/password/meter';
    var request = new PasswordRequest();
    request.password = password;
    return this._httpClient.post<PasswordResponse>(url, request);
  }
}
