import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { PasswordService } from './password.service';
import { Subscription } from 'rxjs';
import { PasswordResponse } from './model/model';

@Component({
  selector: 'app-password',
  templateUrl: './password.component.html',
  styleUrls: ['./password.component.css']
})
export class PasswordComponent implements OnInit {

  public response: PasswordResponse = new PasswordResponse();
  private subscription: Subscription = new Subscription();

  constructor(
    private _passwordService: PasswordService
  ) { }

  ngOnInit() {
  }

  public checkPassword(password) {
    this.subscription.add(
      this._passwordService.checkPassword(password).subscribe(suc => {
        this.response = suc;
      }, error => {
        console.log(error);
        this.response = new PasswordResponse();
      })
    );
  }

}