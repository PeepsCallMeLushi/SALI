import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';

import { MedicosRoutes } from './medicos-routing.module';
import { ListarComponent } from './listar/listar.component';
import { AdicionaComponent } from './adiciona/adiciona.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(MedicosRoutes)
  ],
  declarations: [
    ListarComponent,
    AdicionaComponent
  ]
})
export class MedicosModule { }
