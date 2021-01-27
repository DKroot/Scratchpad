import Vue from "vue";
import { Component } from "vue-property-decorator";
import VueRouter from "vue-router";
import { AxiosError } from "axios";

import MessageComponent from "./messageComponent";

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

  onNavigate() {
    // noinspection JSIgnoredPromiseFromCall: optional
    this.$router.push({path: "/message"});
  }
}

new App().$mount("#app");