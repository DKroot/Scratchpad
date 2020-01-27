import MessageComponent from "./messageComponent";

import * as Vue from "vue";
import { Component } from "vue-property-decorator";
import * as VueRouter from "vue-router";
import { AxiosError } from "axios";
import ParameterizedComponent from "./parameterizedComponent";

Vue.use(VueRouter);

@Component({
  router: new VueRouter({
    routes: [
      {
        path: "/",
        component: MessageComponent
      },
      {
        path: "/pc/:id",
        name: "parameterizedComponent",
        component: ParameterizedComponent
      }
    ]
  })
})
class App extends Vue {
  user: string | null = null;
  loading = false;

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
}

new App().$mount("#app");