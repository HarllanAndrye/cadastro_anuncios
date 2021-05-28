import { Component, OnInit, PipeTransform } from '@angular/core';

import { Relatorio } from '../interface/relatorio';
import { AnunciosService } from '../anuncios.service';
import { FormControl } from '@angular/forms';
import { Observable } from 'rxjs';
import { map, startWith } from 'rxjs/operators';
import { DecimalPipe } from '@angular/common';

declare var $: any;


@Component({
  selector: 'app-list-ad',
  templateUrl: './list-ad.component.html',
  styleUrls: ['./list-ad.component.css'],
  providers: [DecimalPipe]
})
export class ListAdComponent implements OnInit {
  showTable: boolean = false;

  datePeriod = {
    start: '',
    end: ''
  };

  anuncios: Observable<Relatorio[]> = new Observable;

  filter = new FormControl('');

  constructor(
    private anuncioService: AnunciosService, 
    private pipe: DecimalPipe) {
  }

  ngOnInit(): void {
    this.listarAnuncios();
  }

  REPORT: Relatorio[] = [];

  search(text: string, pipe: PipeTransform): Relatorio[] {
    return this.REPORT.filter(report => {
      const term = text.toLowerCase();
      return report.nomeCliente.toLowerCase().includes(term)
          || report.nomeAnuncio.toLowerCase().includes(term);
    });
  }

  listarAnuncios() {
    this.anuncioService.getReports().subscribe(data => {
      this.REPORT = data;
      this.showTable = true;

      this.anuncios = this.filter.valueChanges.pipe(
        startWith(''),
        map(text => this.search(text, this.pipe))
      );
    }); 
  }

  getReportByPeriod() {
    $('.collapse').collapse('hide');

    this.showTable = false;

    if (this.datePeriod.start.trim() != '' && this.datePeriod.end.trim() != '') {
      this.anuncioService.getReportByPeriod(this.datePeriod).subscribe(data => {
        this.REPORT = data;
        this.showTable = true;

        this.anuncios = this.filter.valueChanges.pipe(
          startWith(''),
          map(text => this.search(text, this.pipe))
        );
      });
    }
  }

}
