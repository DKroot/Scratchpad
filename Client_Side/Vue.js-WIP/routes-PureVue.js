define(["require", "exports", "./messageComponent", "vue", "vue-router", "./parameterizedComponent"], function (require, exports, messageComponent_1, Vue, VueRouter, parameterizedComponent_1) {
    "use strict";
    Object.defineProperty(exports, "__esModule", { value: true });
    Vue.use(VueRouter);
    const router = new VueRouter({
        routes: [
            {
                path: "/",
                component: messageComponent_1.default
            },
            {
                path: "/cwp/:id",
                component: parameterizedComponent_1.default
            }
        ]
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
//# sourceMappingURL=routes-PureVue.js.map