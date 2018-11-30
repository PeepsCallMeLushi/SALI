
import { Routes } from '@angular/router';

import { IncidentesComponent } from './incidentes/incidentes.component';
import { FarmacosComponent } from './farmacos/farmacos.component';


export const InserirRoutes: Routes = [
  {
    path: '',
    children: [
    {
      path: 'incidentes',
      component: IncidentesComponent,
      data: {
        title: 'Inserir Incidentes',
        urls: [{title: 'Inserir',url: '/inserir'},{title: 'Incidentes'}]
      }
    },
    {
      path: 'farmacos',
      component: FarmacosComponent,
      data: {
        title: 'Inserir Farmacos',
        urls: [{title: 'Inserir',url: '/inserir'},{title: 'Farmacos'}]
      }
    }]
  }
];
