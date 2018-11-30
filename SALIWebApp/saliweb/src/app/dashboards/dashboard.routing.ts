import { Routes } from '@angular/router';
import { Dashboard3Component } from './dashboard3/dashboard3.component';

export const DashboardRoutes: Routes = [
  {
    path: '',
    children: [
    {
      path: 'main',
      component: Dashboard3Component,
      data: {
        title: 'Painel de Controlo',
        urls: [{title: 'Dashboard',url: '/dashboard'},{title: 'Painel'}]
      }
    }]
  }
];
