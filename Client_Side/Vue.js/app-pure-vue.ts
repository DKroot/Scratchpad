import * as Vue from "vue";
import { Component, Prop, Watch } from "vue-property-decorator";
import * as VueRouter from "vue-router";
import { AxiosError } from "axios";

//region App components
import MessageComponent from "./messageComponent";
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
  data() {
    return {
      user: null,
      loading: false
    };
  },
  methods: {
    onLoading() {
      // @ts-ignore
      this.loading = true;
      console.log("Loading...");
    },

    onLoaded() {
      // @ts-ignore
      this.loading = false;
      console.log("Loaded.");
    },

    onLoadingError(error: AxiosError, serviceUrl: string) {
      // @ts-ignore
      this.loading = false;
      console.log("Loading error for", serviceUrl, error.response);
    }
  }
};
//as ComponentOptions<App>;

new Vue(appOptions).$mount("#app");