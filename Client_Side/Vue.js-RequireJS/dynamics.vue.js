define(["require", "exports", "vue"], function (require, exports, vue_1) {
    "use strict";
    Object.defineProperty(exports, "__esModule", { value: true });
    exports.default = vue_1.default.extend({
        data: {
            date: date
        },
        created: function () {
            this.date = new Date();
        }
    });
});
//# sourceMappingURL=dynamics.vue.js.map