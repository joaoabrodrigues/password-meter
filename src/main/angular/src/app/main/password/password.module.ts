import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PasswordComponent } from './password.component';
import { PasswordService } from './password.service';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MatInputModule } from '@angular/material/input';
import { MatChipsModule } from '@angular/material/chips';

@NgModule({
  imports: [
    CommonModule,
    FlexLayoutModule,
    HttpClientModule,
    MatInputModule,
    MatChipsModule
  ],
  declarations: [
    PasswordComponent
  ],
  providers: [
    HttpClient,
    PasswordService
  ],
  exports: [
    PasswordComponent
  ]
})
export class PasswordModule { }
