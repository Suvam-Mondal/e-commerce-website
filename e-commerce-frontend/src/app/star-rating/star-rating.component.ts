import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-star-rating',
  templateUrl: './star-rating.component.html',
  styleUrl: './star-rating.component.css'
})
export class StarRatingComponent implements OnInit {
  @Input() rating: number = 0;
  starsArray: string[] = [];

  constructor() { }

  ngOnInit(): void {
    this.fillStars();
  }

  fillStars(): void {
    const roundedRating = Math.round(this.rating);
    this.starsArray = Array(5).fill('star_border');
    for (let i = 0; i < roundedRating; i++) {
      this.starsArray[i] = 'star';
    }
  }
}
