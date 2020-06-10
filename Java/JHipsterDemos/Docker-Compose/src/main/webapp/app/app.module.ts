import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { JhipsterDockerComposeSharedModule } from 'app/shared/shared.module';
import { JhipsterDockerComposeCoreModule } from 'app/core/core.module';
import { JhipsterDockerComposeAppRoutingModule } from './app-routing.module';
import { JhipsterDockerComposeHomeModule } from './home/home.module';
import { JhipsterDockerComposeEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ErrorComponent } from './layouts/error/error.component';

@NgModule({
  imports: [
    BrowserModule,
    JhipsterDockerComposeSharedModule,
    JhipsterDockerComposeCoreModule,
    JhipsterDockerComposeHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    JhipsterDockerComposeEntityModule,
    JhipsterDockerComposeAppRoutingModule,
  ],
  declarations: [MainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, FooterComponent],
  bootstrap: [MainComponent],
})
export class JhipsterDockerComposeAppModule {}
