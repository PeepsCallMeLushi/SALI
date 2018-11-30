import { Routes } from '@angular/router';

import { NotFoundComponent } from './404/not-found.component';
import { LockComponent } from './lock/lock.component';
import { Login2Component } from './login2/login2.component';
import { Signup2Component } from './signup2/signup2.component';

export const AuthenticationRoutes: Routes = [
  {
    path: '',
    children: [{
      path: '404',
      component: NotFoundComponent
    }, {
      path: 'lock',
      component: LockComponent
    }, {
      path: 'login',
      component: Login2Component
    },{
      path: 'register',
      component: Signup2Component
    }]
  }
];
