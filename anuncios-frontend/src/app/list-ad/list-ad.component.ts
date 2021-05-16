import { Component, OnInit } from '@angular/core';

import { Relatorio } from '../interface/relatorio';
import { AnunciosService } from '../anuncios.service';

@Component({
  selector: 'app-list-ad',
  templateUrl: './list-ad.component.html',
  styleUrls: ['./list-ad.component.css']
})
export class ListAdComponent implements OnInit {

  showTable: boolean = false;

  anuncios: Array<Relatorio> = [];

  constructor(private anuncioService: AnunciosService) { }

  ngOnInit(): void {
    this.listarAnuncios();
  }

  listarAnuncios() {
    this.anuncioService.listarRelatorios().subscribe(data => {
      setTimeout(() => {
        this.anuncios = data
        this.showTable = true;
      }, 1000);
    });
  }

}
