import { Routes } from '@angular/router';

import { ListarComponent } from './listar/listar.component';
import { AdicionarComponent } from './adicionar/adicionar.component';

export const EnfRoutes: Routes = [
  {
    path: '',
    children: [
    {
      path: 'enflistar',
      component: ListarComponent,
      data: {
        title: 'Listar Enfermeiros',
        urls: [{title: 'Enfermeiros',url: '/dashboard'},{title: 'Listar'}]
      }
    },
    {
      path: 'enfadicionar',
      component: AdicionarComponent,
      data: {
        title: 'Adicionar Enfermeiros',
        urls: [{title: 'Enfermeiros',url: '/dashboard'},{title: 'Adicionar'}]
      }
    }]
  }
];
