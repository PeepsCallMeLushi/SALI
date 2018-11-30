import { Routes } from '@angular/router';

import { AdicionarComponent } from './adicionar/adicionar.component';
import { ListargeralComponent } from './listargeral/listargeral.component';
import { ListarindiComponent } from './listarindi/listarindi.component';

export const OcorrenciasRoutes: Routes = [
  {
    path: '',
    children: [
    {
      path: 'ocoradicionar',
      component: AdicionarComponent,
      data: {
        title: 'Adicionar Ocorrencia',
        urls: [{title: 'Dashboard',url: '/dashboard'},{title: 'Analytical Dashboard'}]
      }
    },{
      path: 'ocolistarindi',
      component: ListarindiComponent,
      data: {
        title: 'Listar Individual > Ocorrencia',
        urls: [{title: 'Dashboard',url: '/dashboard'},{title: 'Analytical Dashboard'}]
      }
    },{
      path: 'ocolistargeral',
      component: ListargeralComponent,
      data: {
        title: 'Listar Geral >  Ocorrencia',
        urls: [{title: 'Dashboard',url: '/dashboard'},{title: 'Analytical Dashboard'}]
      }
    }]
  }
];
