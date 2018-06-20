import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { MainRouting } from './main.routing';
import { MainComponent } from './main.component';

import { FlexLayoutModule } from '@angular/flex-layout';
import { MatCardModule } from '@angular/material/card';
import { PasswordModule } from './password/password.module';

@NgModule({
  imports: [
    CommonModule,
    MainRouting,
    RouterModule,
    FlexLayoutModule,
    MatCardModule,
    PasswordModule
  ],
  declarations: [
    MainComponent
  ]
})
export class MainModule { }
