define(["require", "exports", "vue", "vue-router", "./messageComponent-pure-vue"], function (require, exports, vue_1, vue_router_1, messageComponent_pure_vue_1) {
    "use strict";
    Object.defineProperty(exports, "__esModule", { value: true });
    //endregion
    vue_1.default.use(vue_router_1.default);
    var routes = [
        {
            path: "/",
            component: messageComponent_pure_vue_1.default
        } /*,
        {
          path: "/cwp/:id",
          component: ParameterizedComponent
        }*/
    ];
    var router = new vue_router_1.default({
        routes: routes
    });
    // noinspection JSUnusedLocalSymbols
    var appOptions = {
        router: router,
        data: function () {
            return {
                user: null,
                loading: false
            };
        },
        methods: {
            onLoading: function () {
                // @ts-ignore
                this.loading = true;
                console.log("Loading...");
            },
            onLoaded: function () {
                // @ts-ignore
                this.loading = false;
                console.log("Loaded.");
            },
            onLoadingError: function (error, serviceUrl) {
                // @ts-ignore
                this.loading = false;
                console.log("Loading error for", serviceUrl, error.response);
            }
        }
    };
    //as ComponentOptions<App>;
    new vue_1.default(appOptions).$mount("#app");
});
//# sourceMappingURL=app-pure-vue.js.map