<template>
  <h1>Vue.js Scratchpad</h1>

  <label>
    <input v-model="user" autofocus="true" placeholder="Enter any user name">
  </label>
  <!--<button @click.prevent="onRenderComponent">Render</button>-->

  <p v-show="loading">Loading...</p>
  <router-view v-show="!loading" :user="user"
      @loading="onLoading" @success="onLoaded"
      @loading-error="onLoadingError"></router-view>
</template>

<script lang="ts">
  import Vue from "vue";
  import { AxiosError } from "axios";
  import VueRouter from "vue-router";
  //region App components
  import MessageComponent from "./messageComponent-pure-vue";
  //endregion

  Vue.use(VueRouter);

  const routes = [{
    path: "/", component: MessageComponent
    // path: "/cwp/:id", component: ParameterizedComponent
  }];

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
    router, data() {
      return {
        user: null, loading: false
      };
    }, methods: {
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
  }; //as ComponentOptions<App>;
  const app = new Vue(appOptions);

  export default app;
</script>