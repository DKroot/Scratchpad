/** vue-property-decorator verson 5.2.0 MIT LICENSE copyright 2017 kaorun343 */
(function (factory) {
    if (typeof module === "object" && typeof module.exports === "object") {
        var v = factory(require, exports);
        if (v !== undefined) module.exports = v;
    }
    else if (typeof define === "function" && define.amd) {
        define(["require", "exports", "vue", "vue-class-component", "reflect-metadata"], factory);
    }
})(function (require, exports) {
    'use strict';
    Object.defineProperty(exports, "__esModule", { value: true });
    var vue_1 = require("vue");
    exports.Vue = vue_1.default;
    var vue_class_component_1 = require("vue-class-component");
    exports.Component = vue_class_component_1.default;
    require("reflect-metadata");
    /**
     * decorator of an inject
     * @param key key
     * @return PropertyDecorator
     */
    function Inject(key) {
        return vue_class_component_1.createDecorator(function (componentOptions, k) {
            if (typeof componentOptions.inject === 'undefined') {
                componentOptions.inject = {};
            }
            if (!Array.isArray(componentOptions.inject)) {
                componentOptions.inject[k] = key || k;
            }
        });
    }
    exports.Inject = Inject;
    /**
     * decorator of a provide
     * @param key key
     * @return PropertyDecorator | void
     */
    function Provide(key) {
        return vue_class_component_1.createDecorator(function (componentOptions, k) {
            var provide = componentOptions.provide;
            if (typeof provide !== 'function' || !provide.managed) {
                var original_1 = componentOptions.provide;
                provide = componentOptions.provide = function () {
                    var rv = Object.create((typeof original_1 === 'function' ? original_1.call(this) : original_1) || null);
                    for (var i in provide.managed)
                        rv[provide.managed[i]] = this[i];
                    return rv;
                };
                provide.managed = {};
            }
            provide.managed[k] = key || k;
        });
    }
    exports.Provide = Provide;
    /**
     * decorator of model
     * @param  event event name
     * @return PropertyDecorator
     */
    function Model(event) {
        return vue_class_component_1.createDecorator(function (componentOptions, prop) {
            componentOptions.model = { prop: prop, event: event || prop };
        });
    }
    exports.Model = Model;
    /**
     * decorator of a prop
     * @param  options the options for the prop
     * @return PropertyDecorator | void
     */
    function Prop(options) {
        if (options === void 0) { options = {}; }
        return function (target, key) {
            if (!Array.isArray(options) && typeof options.type === 'undefined') {
                options.type = Reflect.getMetadata('design:type', target, key);
            }
            vue_class_component_1.createDecorator(function (componentOptions, k) {
                (componentOptions.props || (componentOptions.props = {}))[k] = options;
            })(target, key);
        };
    }
    exports.Prop = Prop;
    /**
     * decorator of a watch function
     * @param  path the path or the expression to observe
     * @param  WatchOption
     * @return MethodDecorator
     */
    function Watch(path, options) {
        if (options === void 0) { options = {}; }
        var _a = options.deep, deep = _a === void 0 ? false : _a, _b = options.immediate, immediate = _b === void 0 ? false : _b;
        return vue_class_component_1.createDecorator(function (componentOptions, handler) {
            if (typeof componentOptions.watch !== 'object') {
                componentOptions.watch = Object.create(null);
            }
            componentOptions.watch[path] = { handler: handler, deep: deep, immediate: immediate };
        });
    }
    exports.Watch = Watch;
});
