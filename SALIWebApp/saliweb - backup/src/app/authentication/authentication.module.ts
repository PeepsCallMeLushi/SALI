import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

import { NotFoundComponent } from './404/not-found.component';
import { LockComponent } from './lock/lock.component';

import { Login2Component } from './login2/login2.component';
import { Signup2Component } from './signup2/signup2.component';

import { AuthenticationRoutes } from './authentication.routing';


@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(AuthenticationRoutes)
  ],
  declarations: [
    NotFoundComponent,
    LockComponent,
    Login2Component,
    Signup2Component
  ]
})

export class AuthenticationModule {}
