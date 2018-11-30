import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { FullComponent } from './layouts/full/full.component';
import { BlankComponent } from './layouts/blank/blank.component';

export const routes: Routes = [
{
    path: '',
    component: FullComponent,
    children: [
        { path: '', redirectTo: '/dashboard/main', pathMatch: 'full' },
        { path: 'dashboard', loadChildren: './dashboards/dashboard.module#DashboardModule' },
        { path: 'medicos', loadChildren: './medicos/medicos.module#MedicosModule' },
        { path: 'enfermeiros', loadChildren: './enfermeiros/enfermeiros.module#EnfermeirosModule' },
        { path: 'adminrh', loadChildren: './adminrh/adminrh.module#AdminrhModule' },
        { path: 'ocorrencias', loadChildren: './ocorrencias/ocorrencias.module#OcorrenciasModule' },
        { path: 'inserir', loadChildren: './inserir/inserir.module#InserirModule' },
        { path: 'starter', loadChildren: './starter/starter.module#StarterModule' },
        { path: 'component', loadChildren: './component/component.module#ComponentsModule' },
        { path: 'icons', loadChildren: './icons/icons.module#IconsModule' },
        { path: 'forms', loadChildren: './form/forms.module#FormModule' },
        { path: 'tables', loadChildren: './table/tables.module#TablesModule' },
        { path: 'charts', loadChildren: './charts/charts.module#ChartModule' },
        { path: 'widgets', loadChildren: './widgets/widgets.module#WidgetsModule' },
    ]
},
{
    path: '',
    component: BlankComponent,
    children: [
        {
            path: 'authentication',
            loadChildren: './authentication/authentication.module#AuthenticationModule'
        }
    ]
},
{
    path: '**',
    redirectTo: '404'
}];

@NgModule({
    imports: [RouterModule.forRoot(routes), NgbModule.forRoot()],
    exports: [RouterModule]
})

export class AppRoutingModule { }
