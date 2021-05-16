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

  listar() {
    return this.httpClient.get<Anuncio[]>(this.API);
  }

  listarRelatorios() {
    return this.httpClient.get<Relatorio[]>(`${this.API}/relatorios`);
  }

  buscarPorId(id: any) {
    return this.httpClient.get<Anuncio>(`${this.API}/${id}`);
  }

  excluir(id: any) {
    return this.httpClient.delete(`${this.API}/${id}`);
  }

  inserir(anuncio: Anuncio) {
    return this.httpClient.post(this.API, anuncio);
  }

  editar(anuncio: Anuncio) {
    return this.httpClient.put(`${this.API}/${anuncio.id}`, anuncio);
  }
}
