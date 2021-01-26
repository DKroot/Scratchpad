import Vue from "vue";
import VueRouter from "vue-router";
import { AxiosError } from "axios";

//region Lazy-loading routing components
const MessageComponent = () => import("./messageComponent-pure-vue");
//endregion

Vue.use(VueRouter);

const routes = [
  {
    path: "/message",
    component: MessageComponent
  }
];

const router = new VueRouter({
  routes
});

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
    },

    onNavigate() {
      // noinspection JSIgnoredPromiseFromCall // it works fine
      router.push({ path: "/message" });
    }
  }
};

new Vue(appOptions).$mount("#app");