define(["require", "exports", "vue", "vue-router", "./messageComponent", "reflect-metadata"], function (require, exports, Vue, VueRouter, messageComponent_1) {
    "use strict";
    Object.defineProperty(exports, "__esModule", { value: true });
    // import ParameterizedComponent from "./parameterizedComponent";
    //endregion
    Vue.use(VueRouter);
    const routes = [
        {
            path: "/",
            component: messageComponent_1.MessageComponent
        } /*,
        {
          path: "/cwp/:id",
          component: ParameterizedComponent
        }*/
    ];
    const router = new VueRouter({
        routes
    });
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
            onLoadingError(error, serviceUrl) {
                this.loading = false;
                console.log("Loading error for", serviceUrl, error.response);
            }
        }
    };
    new Vue(appOptions).$mount("#app");
});
//# sourceMappingURL=app-pure-vue.js.map