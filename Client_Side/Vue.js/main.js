require(
    // configuration
    {
      // By default load required library modules from `./`
      baseUrl: '.',

      /*
      By default modules would be loaded from {module}.js files (filename = module).
      Specify {module} (or '{module}'): '{filename}' mapping if filename != module.
      Specify path fallbacks ([filenames]) for minimized / normal version consumption pattern.
      */
      paths: {
        // 'messageComponent': '../messageComponent',
        //'messageComponent-pure-vue': '../messageComponent-pure-vue',

        // All third-party libraries must be included here. Use path fallbacks
        // for minimized libs.
        axios: "lib/axios",
        // axios: ["../lib/axios.min", "../lib/axios"],
        // "js-cookie": "../lib/js.cookie",
        "reflect-metadata": "lib/Reflect",
        requirejs_vue: "lib/requirejs-vue",
        // text: "../lib/text",
        // "vee-validate": ["../lib/vee-validate.min", "../lib/vee-validate"],

        vue: "lib/vue",
        // Vue Devtools don't work with minified Vue.
//      vue: ["../lib/vue.min", "../lib/vue"],

        // "vue-class-component": ["../lib/vue-class-component.min",
        // "../lib/vue-class-component"], "vue-class-component":
        // ["../lib/vue-class-component.min", "../lib/vue-class-component"],
        // "vue-property-decorator": "../lib/vue-property-decorator.umd",
        "vue-router": "lib/vue-router"
        // "vue-router": ["../lib/vue-router.min", "../lib/vue-router"]
      }
    },
    // load libs right now
    ['vue', 'requirejs_vue'],
    function (vue, requirejs_vue) {
      // now load our single-file-component app
      // syntax: <vue loader module>!<relative path to .vue file>
      require(['requirejs_vue!app'], function (theApp) {
        // mount app
        theApp.$mount('#app');
      });
    }
);