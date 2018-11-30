import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';

import { AdminRoutes } from './adminrh-routing.module';
import { ListarComponent } from './listar/listar.component';
import { AdicionarComponent } from './adicionar/adicionar.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(AdminRoutes)
  ],
  declarations: [
    ListarComponent,
    AdicionarComponent
  ]
})
export class AdminrhModule { }
