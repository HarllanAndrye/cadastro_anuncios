import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { RegisterAdComponent } from './register-ad/register-ad.component';
import { ListAdComponent } from './list-ad/list-ad.component'


const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'relatorio', component: ListAdComponent},
  {path: 'cadastro', component: RegisterAdComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
