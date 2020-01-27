require(
  // configuration
  {
    paths: {
      // the Vue lib
      'Vue': 'https://unpkg.com/vue@2.5.11/dist/vue.min',
      // Vue RequireJS loader
      'vue': 'https://unpkg.com/requirejs-vue@1.1.5/requirejs-vue'
    }
  },
  // load libs right now
  ['Vue', 'vue'],
  function(Vue, vue){
    // now load our single-file-component app
    // syntax: <vue loader module>!<relative path to .vue file>
    require(['vue!app'], function(theApp){
      // mount app. Voila!
      theApp.$mount('#app');
    });
  }
);