define(["require", "exports", "vue", "vue-router", "./messageComponent", "reflect-metadata"], function (require, exports, vue_1, vue_router_1, messageComponent_1) {
    "use strict";
    Object.defineProperty(exports, "__esModule", { value: true });
    // import ParameterizedComponent from "./parameterizedComponent";
    //endregion
    vue_1.default.use(vue_router_1.default);
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
    const router = new vue_router_1.default({
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
    new vue_1.default(appOptions).$mount("#app");
});
//# sourceMappingURL=app-pure-vue.js.map