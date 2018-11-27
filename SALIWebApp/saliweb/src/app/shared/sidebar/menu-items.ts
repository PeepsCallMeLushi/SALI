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
                  { path: '/forms/basicform', title: 'Listar', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
                  { path: '/forms/formvalidation', title: 'Inserir', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
              ]
          },{
              path: '', title: 'Efermeiros', icon: '', class: 'has-arrow', label: '', labelClass: '', extralink: false,
              submenu: [
                  { path: '/forms/basicform', title: 'Listar', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
                  { path: '/forms/formvalidation', title: 'Inserir', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
              ]
          },
          {
              path: '', title: 'Administração', icon: '', class: 'has-arrow', label: '', labelClass: '', extralink: false,
              submenu: [
                  { path: '/forms/basicform', title: 'Listar', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
                  { path: '/forms/formvalidation', title: 'Inserir', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
              ]
          },
        ]
    },
    {
        path: '', title: 'Ocorrencias', icon: 'mdi mdi-ambulance', class: 'has-arrow', label: '', labelClass: '', extralink: false,
        submenu: [
            { path: '/extra-component/editor', title: 'Adicionar', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
            {
                path: '', title: 'Listar', icon: '', class: 'has-arrow', label: '', labelClass: '', extralink: false,
                submenu: [
                    { path: '/forms/basicform', title: 'Individual', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
                    { path: '/forms/formvalidation', title: 'Geral', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
                ]
            },
        ]
    },{
        path: '', title: 'Inserir', icon: 'mdi mdi-needle', class: 'has-arrow', label: '', labelClass: '', extralink: false,
        submenu: [
            { path: '/extra-component/editor', title: 'Fármacos', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
            { path: '/extra-component/editor', title: 'Incidentes', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
        ]
    },
    {
        path: '', title: 'Extra', icon: 'mdi mdi-widgets', class: 'has-arrow', label: '', labelClass: '', extralink: false,
        submenu: [
            {
                path: '/widgets', title: 'Widgets', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: []
            },
            {
                path: '', title: 'Forms', icon: '', class: 'has-arrow', label: '', labelClass: '', extralink: false,
                submenu: [
                    { path: '/forms/basicform', title: 'Basic Forms', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
                    { path: '/forms/formvalidation', title: 'Form Validation', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
                    { path: '/component/typehead', title: 'Form Typehead', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
                    { path: '/component/datepicker', title: 'Datepicker', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
                ]
            },
            {
                path: '', title: 'Tables', icon: '', class: 'has-arrow', label: '', labelClass: '', extralink: false,
                submenu: [
                    { path: '/tables/basictable', title: 'Basic Tables', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
                    { path: '/tables/smarttable', title: 'Smart Tables', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
                    { path: '/tables/datatable', title: 'Data Tables', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
                ]
            },
            {
                path: '', title: 'Charts', icon: '', class: 'has-arrow', label: '', labelClass: '', extralink: false,
                submenu: [
                    { path: '/charts/chartjs', title: 'Chart Js', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
                    { path: '/charts/chartistjs', title: 'Chartist Js', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
                ]
            },
            {
                path: '', title: 'Icons', icon: '', class: 'has-arrow', label: '', labelClass: '', extralink: false,
                submenu: [
                    { path: '/icons/fontawesome', title: 'Fontawesome', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
                    { path: '/icons/simpleline', title: 'Simple Line Icons', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
                    { path: '/icons/material', title: 'Material Icons', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
                ]
            },
        ]
    },
    {
        path: '', title: 'Pages', icon: 'mdi mdi-file', class: '', label: '', labelClass: '', extralink: false,
        submenu: [
            {
                path: '', title: 'Authentication', icon: '', class: 'has-arrow', label: '', labelClass: '', extralink: false,
                submenu: [
                    { path: '/authentication/login', title: 'Login', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
                    { path: '/authentication/login2', title: 'Login 2', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
                    { path: '/authentication/signup', title: 'Register', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
                    { path: '/authentication/signup2', title: 'Register 2', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
                    { path: '/authentication/404', title: '404', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
                    { path: '/authentication/lock', title: 'Lockscreen', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
                ]
            },
            { path: '/sample-pages/timeline', title: 'Timeline', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
            { path: '/sample-pages/profile', title: 'Profile', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
            { path: '/sample-pages/pricing', title: 'Pricing', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
            { path: '/sample-pages/invoice', title: 'Invoice', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
            { path: '/sample-pages/helperclasses', title: 'Helper Classes', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
            { path: '/starter', title: 'Starter Page', icon: '', class: '', label: '', labelClass: '', extralink: false, submenu: [] },
        ]
    }
];
