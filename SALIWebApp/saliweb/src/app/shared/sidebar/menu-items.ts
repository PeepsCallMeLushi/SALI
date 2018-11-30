import { RouteInfo } from './sidebar.metadata';

export const ROUTES: RouteInfo[] = [
    {
        path: '/dashboard/main', title: 'Painel', icon: 'mdi mdi-gauge', class: '', label: '', labelClass: '', extralink: false,
        submenu: [
        ]
    },
    {
        path: '', title: 'Gestão RH', icon: 'mdi mdi-account-multiple', class: 'has-arrow', label: '', labelClass: '', extralink: false,
        submenu: [
          {
              path: '', title: 'Medicos', icon: '', class: 'has-arrow', label: '', labelClass: '', extralink: false,
              submenu: [
                  { path: '/medicos/medlistar', title: 'Listar', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
                  { path: '/medicos/medadicionar', title: 'Inserir', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
              ]
          },{
              path: '', title: 'Enfermeiros', icon: '', class: 'has-arrow', label: '', labelClass: '', extralink: false,
              submenu: [
                  { path: '/enfermeiros/enflistar', title: 'Listar', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
                  { path: '/enfermeiros/enfadicionar', title: 'Inserir', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
              ]
          },
          {
              path: '', title: 'Administração', icon: '', class: 'has-arrow', label: '', labelClass: '', extralink: false,
              submenu: [
                  { path: '/adminrh/adminlistar', title: 'Listar', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
                  { path: '/adminrh/adminadicionar', title: 'Inserir', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
              ]
          },
        ]
    },
    {
        path: '', title: 'Ocorrencias', icon: 'mdi mdi-ambulance', class: 'has-arrow', label: '', labelClass: '', extralink: false,
        submenu: [
            { path: '/ocorrencias/ocoradicionar', title: 'Adicionar', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
            {
                path: '', title: 'Listar', icon: '', class: 'has-arrow', label: '', labelClass: '', extralink: false,
                submenu: [
                    { path: '/ocorrencias/ocolistarindi', title: 'Individual', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
                    { path: '/ocorrencias/ocolistargeral', title: 'Geral', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
                ]
            },
        ]
    },{
        path: '', title: 'Inserir', icon: 'mdi mdi-needle', class: 'has-arrow', label: '', labelClass: '', extralink: false,
        submenu: [
            { path: '/inserir/farmacos', title: 'Fármacos', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
            { path: '/inserir/incidentes', title: 'Incidentes', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
        ]
    }
];
