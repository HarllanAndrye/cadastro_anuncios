import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment'
import { Anuncio } from './interface/anuncio';
import { Relatorio } from './interface/relatorio';

@Injectable({
  providedIn: 'root'
})
export class AnunciosService {

  private readonly API = environment.API;

  constructor(private httpClient: HttpClient) { }

  getAll() {
    return this.httpClient.get<Anuncio[]>(this.API);
  }

  getReports() {
    return this.httpClient.get<Relatorio[]>(`${this.API}/relatorios`);
  }

  getReportByPeriod(data: any) {
    return this.httpClient.post<Relatorio[]>(`${this.API}/reports/date`, data);
  }

  findById(id: any) {
    return this.httpClient.get<Anuncio>(`${this.API}/${id}`);
  }

  deleteAd(id: any) {
    return this.httpClient.delete(`${this.API}/${id}`);
  }

  insertAd(ad: Anuncio) {
    return this.httpClient.post(this.API, ad);
  }

  updateAd(ad: Anuncio) {
    return this.httpClient.put(`${this.API}/${ad.id}`, ad);
  }
}
