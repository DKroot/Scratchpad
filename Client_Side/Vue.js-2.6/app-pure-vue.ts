import "reflect-metadata";
import Vue from "vue";
// import Vue, { ComponentOptions } from "vue";
import VueRouter from "vue-router";
import { AxiosError } from "axios";
//region App imports
import { MessageComponent } from "./messageComponent";
import { ComponentOptions } from "vue";
// import ParameterizedComponent from "./parameterizedComponent";
//endregion

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    component: MessageComponent
  }/*,
  {
    path: "/cwp/:id",
    component: ParameterizedComponent
  }*/
];

const router = new VueRouter({
  routes
});

interface App extends Vue {
  user: string;
  loading: boolean;

  onLoading(): void;

  onLoaded(): void;

  onLoadingError(error: AxiosError, serviceUrl: string): void;

  // beforeRouteUpdate(to: Route, from: Route, next: Function): void;
}

// noinspection JSUnusedLocalSymbols
const appOptions = {
  router,
  data: {
    user: null,
    loading: false
  },
  methods: {
    onLoading() {
      this.loading = true;
      console.log("Loading...");
    },

    onLoaded() {
      this.loading = false;
      console.log("Loaded.");
    },

    onLoadingError(error: AxiosError, serviceUrl: string) {
      this.loading = false;
      console.log("Loading error for", serviceUrl, error.response);
    }
  }
} as ComponentOptions<App>;

new Vue(appOptions).$mount("#app");