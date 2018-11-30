import { Routes } from '@angular/router';

import { ListarComponent } from './listar/listar.component';
import { AdicionaComponent } from './adiciona/adiciona.component';

export const MedicosRoutes: Routes = [
  {
    path: '',
    children: [
    {
      path: 'medlistar',
      component: ListarComponent,
      data: {
        title: 'Listar Medicos',
        urls: [{title: 'Médicos',url: '/dashboard'},{title: 'Listar'}]
      }
    },
    {
      path: 'medadicionar',
      component: AdicionaComponent,
      data: {
        title: 'Adicionar Medicos',
        urls: [{title: 'Médicos',url: '/dashboard'},{title: 'Adicionar'}]
      }
    }]
  }
];
