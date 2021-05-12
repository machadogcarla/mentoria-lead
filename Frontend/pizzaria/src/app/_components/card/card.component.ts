import { Component, Input, OnInit } from '@angular/core';
import { Pizza } from 'src/app/_models/pizza';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss']
})
export class CardComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
