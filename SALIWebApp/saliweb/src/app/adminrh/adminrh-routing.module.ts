import { Routes } from '@angular/router';

import { ListarComponent } from './listar/listar.component';
import { AdicionarComponent } from './adicionar/adicionar.component';

export const AdminRoutes: Routes = [
  {
    path: '',
    children: [
    {
      path: 'adminlistar',
      component: ListarComponent,
      data: {
        title: 'Listar Admins',
        urls: [{title: 'Admin',url: '/dashboard'},{title: 'Listar'}]
      }
    },
    {
      path: 'adminadicionar',
      component: AdicionarComponent,
      data: {
        title: 'Adicionar Admins',
        urls: [{title: 'Admin',url: '/dashboard'},{title: 'Adicionar'}]
      }
    }]
  }
];
