var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
define(["require", "exports", "vue", "vue-property-decorator", "axios"], function (require, exports, Vue, vue_property_decorator_1, axios_1) {
    "use strict";
    Object.defineProperty(exports, "__esModule", { value: true });
    let MessageComponent = class MessageComponent extends Vue {
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
    };
    __decorate([
        vue_property_decorator_1.Prop()
    ], MessageComponent.prototype, "user", void 0);
    __decorate([
        vue_property_decorator_1.Watch("user")
    ], MessageComponent.prototype, "onUserChanged", null);
    MessageComponent = __decorate([
        vue_property_decorator_1.Component({
            template: `
    <p v-if='user && userDataSize' style='border: dashed; padding: 10px'>
      Message Component for user {{ user }}.<br>
      Data size = {{ userDataSize }}.
    </p>
  `
        })
    ], MessageComponent);
    exports.default = MessageComponent;
});
//# sourceMappingURL=messageComponent.js.map