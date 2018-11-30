import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';

import { InserirRoutes } from './inserir-routing.module';
import { IncidentesComponent } from './incidentes/incidentes.component';
import { FarmacosComponent } from './farmacos/farmacos.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(InserirRoutes)
  ],
  declarations: [
    IncidentesComponent,
    FarmacosComponent
  ]
})
export class InserirModule { }
