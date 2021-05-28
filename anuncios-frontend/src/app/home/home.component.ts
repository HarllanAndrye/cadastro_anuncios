import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AnunciosService } from '../anuncios.service';
import { Anuncio } from '../interface/anuncio';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  anuncios: Anuncio[] = [];

  constructor(private anunciosService: AnunciosService, private route: Router) { }

  ngOnInit(): void {
    this.anunciosService.getAll().subscribe(data => {
      this.anuncios = data;
    });
  }

}
