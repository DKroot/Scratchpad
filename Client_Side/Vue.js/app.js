var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
define(["require", "exports", "vue", "vue-property-decorator", "vue-router", "./messageComponent"], function (require, exports, Vue, vue_property_decorator_1, VueRouter, messageComponent_1) {
    "use strict";
    Object.defineProperty(exports, "__esModule", { value: true });
    //endregion
    Vue.use(VueRouter);
    let App = class App extends Vue {
        constructor() {
            super(...arguments);
            this.user = null;
            this.loading = false;
        }
        onLoading() {
            this.loading = true;
            console.log("Loading...");
        }
        onLoaded() {
            this.loading = false;
            console.log("Loaded.");
        }
        onLoadingError(error, serviceUrl) {
            this.loading = false;
            console.log("Loading error for", serviceUrl, error.response);
        }
    };
    App = __decorate([
        vue_property_decorator_1.Component({
            router: new VueRouter({
                routes: [
                    {
                        path: "/",
                        component: messageComponent_1.default
                    }
                ]
            })
        })
    ], App);
    new App().$mount("#app");
});
//# sourceMappingURL=app.js.map