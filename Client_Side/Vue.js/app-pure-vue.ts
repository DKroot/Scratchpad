import Vue from "vue";
import { AxiosError } from "axios";
import VueRouter from "vue-router";
//region App components
import MessageComponent from "./messageComponent-pure-vue";
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