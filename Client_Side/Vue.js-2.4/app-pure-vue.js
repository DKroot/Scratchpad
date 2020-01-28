define(["require", "exports", "vue", "vue-router", "./messageComponent-pure-vue"], function (require, exports, Vue, VueRouter, messageComponent_pure_vue_1) {
    "use strict";
    Object.defineProperty(exports, "__esModule", { value: true });
    //endregion
    Vue.use(VueRouter);
    const routes = [
        {
            path: "/",
            component: messageComponent_pure_vue_1.default
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
            onLoadingError(error, serviceUrl) {
                // @ts-ignore
                this.loading = false;
                console.log("Loading error for", serviceUrl, error.response);
            }
        }
    };
    new Vue(appOptions).$mount("#app");
});
//# sourceMappingURL=app-pure-vue.js.map