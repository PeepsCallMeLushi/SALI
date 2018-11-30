import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';

import { OcorrenciasRoutes} from './ocorrencias-routing.module';
import { AdicionarComponent } from './adicionar/adicionar.component';
import { ListargeralComponent } from './listargeral/listargeral.component';
import { ListarindiComponent } from './listarindi/listarindi.component';

@NgModule({
  imports: [
    CommonModule,
      RouterModule.forChild(OcorrenciasRoutes)
  ],
  declarations: [
    AdicionarComponent,
    ListargeralComponent,
    ListarindiComponent
  ]
})
export class OcorrenciasModule { }
