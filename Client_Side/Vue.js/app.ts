import Vue from "vue";
import { Component } from "vue-property-decorator";

import VueRouter from "vue-router";
import { AxiosError } from "axios";

//region Lazy-loading components
const MessageComponent = () => import("./messageComponent");
const DateInput = () => import("./dateInput");
//endregion

//region Global reusable components
Vue.component("date-input", DateInput);
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
  fromDate: string | null = "01/01/2021";
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