import { Component, ElementRef, Input, QueryList, ViewChild, ViewChildren } from '@angular/core';
import { Details } from "../shared/product-details.model";

@Component({
  selector: 'app-hero-container',
  templateUrl: './hero-container.component.html',
  styleUrl: './hero-container.component.css'
})
export class HeroContainerComponent {
  @Input() item!: Details[];
  @ViewChild('widgetsContent', { read: ElementRef }) public widgetsContent: ElementRef<any>;
  isLeftDisabled: boolean;

  public scrollRight(): void {

    let offsetWidth = this.widgetsContent.nativeElement.querySelector('.info-widget').offsetWidth;
    let totalWidth = offsetWidth * 2;
    let scrollTo = (this.widgetsContent.nativeElement.scrollLeft + offsetWidth);

    if ((totalWidth - scrollTo) < offsetWidth) {
      scrollTo = scrollTo + 10 * (totalWidth - scrollTo);
    }
    if ((totalWidth - scrollTo) <= totalWidth) {
      this.widgetsContent.nativeElement.scrollTo({ left: scrollTo, behavior: 'smooth' });
    }


  }

  public scrollLeft(): void {

    let offsetWidth = this.widgetsContent.nativeElement.querySelector('.info-widget').offsetWidth;
    let scrollTo = (this.widgetsContent.nativeElement.scrollLeft - offsetWidth);

    this.widgetsContent.nativeElement.scrollTo({ left: scrollTo, behavior: 'smooth' });


  }



}
