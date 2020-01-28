define(["require", "exports", "vue", "vue-router", "./messageComponent-pure-vue"], function (require, exports, vue_1, vue_router_1, messageComponent_pure_vue_1) {
    "use strict";
    Object.defineProperty(exports, "__esModule", { value: true });
    //endregion
    vue_1.default.use(vue_router_1.default);
    const routes = [
        {
            path: "/",
            component: messageComponent_pure_vue_1.default
        }
    ];
    const router = new vue_router_1.default({
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
            onLoadingError(error, serviceUrl) {
                // @ts-ignore
                this.loading = false;
                console.log("Loading error for", serviceUrl, error.response);
            }
        }
    };
    new vue_1.default(appOptions).$mount("#app");
});
//# sourceMappingURL=app-pure-vue.js.map