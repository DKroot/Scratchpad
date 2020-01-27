define(["require", "exports", "vue", "axios"], function (require, exports, vue_1, axios_1) {
    "use strict";
    Object.defineProperty(exports, "__esModule", { value: true });
    exports.MessageComponent = vue_1.default.extend({
        props: ["user"],
        data() {
            return {
                userDataSize: undefined
            };
        },
        template: `
    <p v-if='user && userDataSize' style='border: dashed; padding: 10px'>
      Message Component for user {{ user }}.<br>
      Data size = {{ userDataSize }}.
    </p>
  `,
        methods: {
            load() {
                // noinspection DuplicatedCode
                // @ts-ignore
                if (this.user) {
                    this.$emit("loading");
                    const serviceUrl = ".";
                    axios_1.default.get(serviceUrl)
                        .then(response => {
                        this.$emit("success");
                        // @ts-ignore
                        this.userDataSize = response.data.length;
                        console.log("Received data for", serviceUrl);
                    })
                        .catch(error => {
                        this.$emit("loading-error", error, serviceUrl);
                    });
                }
            }
        },
        created() {
            // fetch the data when the view is created and the data is already being observed
            // @ts-ignore
            this.load();
        },
        watch: {
            user(to) {
                if (to) {
                    // @ts-ignore
                    this.load();
                }
            }
        }
    });
});
// Vue.component("MessageComponent", MessageComponent);
//# sourceMappingURL=messageComponent.js.map