define(["require", "exports", "axios", "vue"], function (require, exports, axios_1, vue_1) {
    "use strict";
    Object.defineProperty(exports, "__esModule", { value: true });
    var MessageComponent = vue_1.default.extend({
        props: ["user"],
        data: function () {
            return {
                userDataSize: undefined
            };
        },
        template: "\n    <p v-if='user && userDataSize' style='border: dashed; padding: 10px'>\n      Message Component for user {{ user }}.<br>\n      Data size = {{ userDataSize }}.\n    </p>\n  ",
        methods: {
            load: function () {
                var _this = this;
                // noinspection DuplicatedCode
                // @ts-ignore
                if (this.user) {
                    this.$emit("loading");
                    var serviceUrl_1 = ".";
                    axios_1.default.get(serviceUrl_1)
                        .then(function (response) {
                        _this.$emit("success");
                        // @ts-ignore
                        _this.userDataSize = response.data.length;
                        console.debug("Received data for", serviceUrl_1);
                    })
                        .catch(function (error) {
                        _this.$emit("loading-error", error, serviceUrl_1);
                    });
                }
            }
        },
        created: function () {
            // fetch the data when the view is created and the data is already being observed
            // @ts-ignore
            this.load();
        },
        watch: {
            user: function (to) {
                if (to) {
                    // @ts-ignore
                    this.load();
                }
            }
        }
    });
    // Vue.component("MessageComponent", MessageComponent);
    exports.default = MessageComponent;
});
//# sourceMappingURL=messageComponent-pure-vue.js.map