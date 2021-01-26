define(["require", "exports", "vue", "vue-router"], function (require, exports, vue_1, vue_router_1) {
    "use strict";
    Object.defineProperty(exports, "__esModule", { value: true });
    //region Lazy-loading routing components
    var MessageComponent = function () { return new Promise(function (resolve_1, reject_1) { require(["./messageComponent-pure-vue"], resolve_1, reject_1); }); };
    // import MessageComponent from "./messageComponent-pure-vue";
    //endregion
    vue_1.default.use(vue_router_1.default);
    var routes = [
        {
            path: "/message",
            component: MessageComponent
        }
    ];
    var router = new vue_router_1.default({
        routes: routes
    });
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
            },
            onNavigate: function () {
                // noinspection JSIgnoredPromiseFromCall // it works fine
                router.push({ path: "/message" });
            }
        }
    };
    new vue_1.default(appOptions).$mount("#app");
});
//# sourceMappingURL=app-pure-vue.js.map