require(
  // configuration
  {
    paths: {
      // the Vue lib
      'Vue': 'node_modules/vue/dist/vue.min',
      // Vue RequireJS loader
      'requirejs_vue': 'node_modules/requirejs-vue/requirejs-vue'
    }
  },
  // load libs right now
  ['Vue', 'requirejs_vue'],
  function(Vue, requirejs_vue){
    // now load our single-file-component app
    // syntax: <vue loader module>!<relative path to .vue file>
    require(['requirejs_vue!app'], function(theApp){
      // mount app. Voila!
      theApp.$mount('#app');
    });
  }
);