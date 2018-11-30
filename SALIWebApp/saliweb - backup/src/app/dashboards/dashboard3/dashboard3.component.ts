import { Component, AfterViewInit } from '@angular/core';
import {NgbProgressbarConfig} from '@ng-bootstrap/ng-bootstrap';
import * as Chartist from 'chartist';
import { ChartType, ChartEvent } from "ng-chartist/dist/chartist.component";
import * as tableData from './smart-data-table';
import { LocalDataSource } from 'ng2-smart-table';
declare var require: any;

const data: any = require('./data.json');

export interface Chart {
  type: ChartType;
  data: Chartist.IChartistData;
  options?: any;
  responsiveOptions?: any;
  events?: ChartEvent;
}

@Component({
	templateUrl: './dashboard3.component.html',
    styleUrls: ['./dashboard3.component.css']
})
export class Dashboard3Component implements AfterViewInit {
	subtitle:string;
    source: LocalDataSource;	
	constructor() {
		this.subtitle = "This is some text within a card block.";
        this.source = new LocalDataSource(tableData.data);
	}
    settings2 = tableData.settings;
    // This is for the dashboar line chart
    public lineChartData: Array<any> = [
        { data: [0, 130, 80, 70, 180, 105, 250], label: 'Site A' },
        { data: [0, 100, 60, 200, 150, 90, 150], label: 'Site B' }
    ];
    public lineChartLabels: Array<any> = [
        '2010',
        '2011',
        '2012',
        '2013',
        '2014',
        '2015',
        '2016'
    ];
    public lineChartOptions: any = {
        responsive: true
    };
    public lineChartColors: Array<any> = [
        {
            // grey
            backgroundColor: 'rgba(25,118,210,0.0)',
            borderColor: 'rgba(25,118,210,1)',
            pointBackgroundColor: 'rgba(25,118,210,1)',
            pointBorderColor: '#fff',
            pointHoverBackgroundColor: '#fff',
            pointHoverBorderColor: 'rgba(25,118,210,0.5)'
        },
        {
            // dark grey
            backgroundColor: 'rgba(38,218,210,0.0)',
            borderColor: 'rgba(38,218,210,1)',
            pointBackgroundColor: 'rgba(38,218,210,1)',
            pointBorderColor: '#fff',
            pointHoverBackgroundColor: '#fff',
            pointHoverBorderColor: 'rgba(38,218,210,0.5)'
        }
        
    ];
    public lineChartLegend: boolean = false;
    public lineChartType: string = 'line';

    // This is for the donute chart
    donuteChart1: Chart = {
        type: 'Pie',
        data: data['Pie'],
        options: {
          donut: true,
          showLabel: false,
          donutWidth: 30
              
        }
        // events: {
        //   draw(data: any): boolean {
        //     return data;
        //   }
        // }
      };     
    
	ngAfterViewInit(){
        var sparklineLogin = function() { 
            (<any>$('#sparklinedash')).sparkline([ 0, 5, 6, 10, 9, 12, 4, 9], {
                type: 'bar',
                height: '50',
                barWidth: '2',
                resize: true,
                barSpacing: '5',
                barColor: '#26c6da'
            });
            (<any>$('#sparklinedash2')).sparkline([ 0, 5, 6, 10, 9, 12, 4, 9], {
                type: 'bar',
                height: '50',
                barWidth: '2',
                resize: true,
                barSpacing: '5',
                barColor: '#7460ee'
            });
            (<any>$('#sparklinedash3')).sparkline([ 0, 5, 6, 10, 9, 12, 4, 9], {
                type: 'bar',
                height: '50',
                barWidth: '2',
                resize: true,
                barSpacing: '5',
                barColor: '#03a9f3'
            });
            (<any>$('#sparklinedash4')).sparkline([ 0, 5, 6, 10, 9, 12, 4, 9], {
                type: 'bar',
                height: '50',
                barWidth: '2',
                resize: true,
                barSpacing: '5',
                barColor: '#f62d51'
            });
        }
        var sparkResize;
 
        $(window).resize(function(e) {
            clearTimeout(sparkResize);
            sparkResize = setTimeout(sparklineLogin, 500);
        });
        sparklineLogin();
    }
}