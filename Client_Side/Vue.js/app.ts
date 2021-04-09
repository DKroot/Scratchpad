import Vue from "vue";
import { Component } from "vue-property-decorator";

import VueRouter from "vue-router";
import { AxiosError } from "axios";

/// <reference path="vue-date-pick.d.ts"/>
import * as DatePick from "vue-date-pick";

//region Lazy-loading components
const MessageComponent = () => import("./messageComponent");
//endregion

//region Global reusable components
console.debug('Registering DatePick component', DatePick);
Vue.component('date', DatePick);
// @ts-ignore
// console.debug('Registered DatePick component', Vue.options.components);
//endregion

Vue.use(VueRouter);

@Component({
  router: new VueRouter({
    routes: [
      {
        path: "/message",
        component: MessageComponent
      }
    ]
  })
})
class App extends Vue {
  //region Reactive data fields
  /* Reactive fields must not be left `undefined`.
   See https://github.com/vuejs/vue-class-component#undefined-will-not-be-reactive.*/
  user: string | null = null;
  fromDate: string | null = null;
  toDate: string | null = null;

  loading = false;

  //endregion

  onLoading() {
    this.loading = true;
    console.log("Loading...");
  }

  onLoaded() {
    this.loading = false;
    console.log("Loaded.");
  }

  onLoadingError(error: AxiosError, serviceUrl: string) {
    this.loading = false;
    console.log("Loading error for", serviceUrl, error.response);
  }

  onNavigate() {
    // noinspection JSIgnoredPromiseFromCall: optional
    this.$router.push({path: "/message"});
  }
}

new App().$mount("#app");