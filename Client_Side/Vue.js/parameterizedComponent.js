var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
define(["require", "exports", "vue", "vue-property-decorator", "axios"], function (require, exports, Vue, vue_property_decorator_1, axios_1) {
    "use strict";
    Object.defineProperty(exports, "__esModule", { value: true });
    // Register the router hooks
    vue_property_decorator_1.Component.registerHooks([
        "beforeRouteEnter",
        "beforeRouteUpdate",
        "beforeRouteLeave"
    ]);
    let ParameterizedComponent = class ParameterizedComponent extends Vue {
        constructor() {
            super(...arguments);
            this.userDataSize = null;
        }
        // noinspection JSUnusedLocalSymbols
        onUserChanged(val, oldVal) {
            if (val) {
                this.load();
            }
        }
        load() {
            if (this.user) {
                this.$emit("loading");
                const serviceUrl = ".";
                axios_1.default.get(serviceUrl)
                    .then(response => {
                    this.$emit("success");
                    this.userDataSize = response.data.length;
                    console.log("Received data for", serviceUrl);
                })
                    .catch(error => {
                    this.$emit("loading-error", error, serviceUrl);
                });
            }
        }
        created() {
            // fetch the data when the view is created and the data is already being observed
            this.load();
        }
        beforeRouteEnter(to, from, next) {
            // does NOT have access to `this` component instance,
            // because it has not been created yet when this guard is called!
            console.log("Route enter from", from, "to", to);
            next();
        }
        beforeRouteUpdate(to, from, next) {
            // called when the route that renders this component has changed,
            // but this component is reused in the new route.
            // For example, for a route with dynamic params /foo/:id, when we
            // navigate between /foo/1 and /foo/2, the same Foo component instance
            // will be reused, and this hook will be called when that happens.
            // has access to `this` component instance.
            console.log("Route update from", from, "to", to);
            next();
        }
        beforeRouteLeave(to, from, next) {
            // called when the route that renders this component is about to
            // be navigated away from.
            // has access to `this` component instance.
            console.log("Route leave from", from, "to", to);
            next();
        }
    };
    __decorate([
        vue_property_decorator_1.Prop(),
        __metadata("design:type", String)
    ], ParameterizedComponent.prototype, "user", void 0);
    __decorate([
        vue_property_decorator_1.Watch("user"),
        __metadata("design:type", Function),
        __metadata("design:paramtypes", [String, String]),
        __metadata("design:returntype", void 0)
    ], ParameterizedComponent.prototype, "onUserChanged", null);
    ParameterizedComponent = __decorate([
        vue_property_decorator_1.Component({
            template: `
    <p v-if='user && userDataSize' style='border: dashed; padding: 10px'>
      Parameterized Component for user {{ user }}.<br>
      Data size = {{ userDataSize }}.<br>
      
      Parameter:<br>
      * id = {{ $route.params.id }}
    </p>
  `
        })
    ], ParameterizedComponent);
    exports.default = ParameterizedComponent;
});
//# sourceMappingURL=parameterizedComponent.js.map