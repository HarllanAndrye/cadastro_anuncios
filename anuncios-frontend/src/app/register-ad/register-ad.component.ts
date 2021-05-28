import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

import { Anuncio } from '../interface/anuncio';
import { AnunciosService } from '../anuncios.service';


@Component({
  selector: 'app-register-ad',
  templateUrl: './register-ad.component.html',
  styleUrls: ['./register-ad.component.css']
})
export class RegisterAdComponent implements OnInit {

  anuncio: Anuncio = {
    name: '',
    clientName: '',
    dataInicio: '',
    dataTermino: '',
    investimentoPorDia: 1.00
  };

  constructor(
    private anuncioService: AnunciosService,
    private route: Router) { }

  ngOnInit(): void {
  }

  saveAd() {
    
    const dados = {
      name: this.anuncio.name,
      clientName: this.anuncio.clientName,
      dataInicio: this.anuncio.dataInicio,
      dataTermino: this.anuncio.dataTermino,
      investimentoPorDia: this.anuncio.investimentoPorDia
    };

    this.anuncioService.insertAd(dados).subscribe(
      success => {
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'O anúncio foi cadastrado com sucesso.',
          showConfirmButton: false,
          timer: 2500
        })
        this.irPara('home')
      },
      error => {
        Swal.fire({
          position: 'center',
          icon: 'error',
          title: 'Não foi possível cadastrar! Tente novamente.',
          showConfirmButton: false,
          timer: 3000
        })
      },
      () => console.log("Requisição completa")
    );
  }

  irPara = (rota: string) => {
    this.route.navigate([rota]);
  }

}
