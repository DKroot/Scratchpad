define(["require", "exports", "vue"], function (require, exports, vue_1) {
    "use strict";
    Object.defineProperty(exports, "__esModule", { value: true });
    exports.default = vue_1.default.extend({
        data: {
            // sample data: Japanese numbers
            items: ['ichi', 'ni', 'san', 'shi', 'go', 'roku', 'shichi', 'hachi']
        },
        methods: {
            loadAnother: function () {
                // example of dynamic Vue loading
                // noinspection TypeScriptUnresolvedFunction
                require(['requirejs_vue!dynamics'], function (compo) {
                    // mount it
                    compo.$mount('#dynamic-placeholder');
                });
            }
        }
    });
});
//# sourceMappingURL=app.vue.js.map