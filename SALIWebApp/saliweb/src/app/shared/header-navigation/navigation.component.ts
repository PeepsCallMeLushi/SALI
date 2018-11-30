import { Component, AfterViewInit } from '@angular/core';
import { NgbModal, ModalDismissReasons, NgbPanelChangeEvent, NgbCarouselConfig } from '@ng-bootstrap/ng-bootstrap';
import { PerfectScrollbarConfigInterface } from 'ngx-perfect-scrollbar';
@Component({
  selector: 'ap-navigation',
  templateUrl: './navigation.component.html'
})
export class NavigationComponent implements AfterViewInit {
	name:string;
  	public config: PerfectScrollbarConfigInterface = {};
  	constructor(private modalService: NgbModal) {

    }

    // This is for Mymessages
    mymessages: Object[] = [{
      useravatar: 'assets/images/users/d1.jpg',
      status: 'online',
      from: 'Pavan kumar',
      subject: 'Just see the my admin!',
      time: '9:30 AM'
    }, {
      useravatar: 'assets/images/users/d2.jpg',
      status: 'busy',
      from: 'Sonu Nigam',
      subject: 'I have sung a song! See you at',
      time: '9:10 AM'
    }, {
      useravatar: 'assets/images/users/d2.jpg',
      status: 'away',
      from: 'Arijit Sinh',
      subject: 'I am a singer!',
      time: '9:08 AM'
    }, {
      useravatar: 'assets/images/users/d4.jpg',
      status: 'offline',
      from: 'Pavan kumar',
      subject: 'Just see the my admin!',
      time: '9:00 AM'
    }];

    ngAfterViewInit() {

        var set = function() {
            var width = (window.innerWidth > 0) ? window.innerWidth : this.screen.width;
            var topOffset = 0;
            if (width < 1170) {
                $("#main-wrapper").addClass("mini-sidebar");
            } else {
                $("#main-wrapper").removeClass("mini-sidebar");
            }

        };
        $(window).ready(set);
        $(window).on("resize", set);


        $(".search-box a, .search-box .app-search .srh-btn").on('click', function () {
            $(".app-search").toggle(200);
        });


        $("body").trigger("resize");
    }
}
