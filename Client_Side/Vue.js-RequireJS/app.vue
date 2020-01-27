<template>
  <div>
    <h2>Vue + RequireJS demo (jp-d)</h2>
    <ul>
      <li v-for="i in items">
        {{i}}
      </li>
    </ul>
    <div id="dynamic-placeholder">
      <a href="#" @click.prevent="loadAnother">load dynamic component</a>
    </div>
  </div>
</template>

<style>
/* app's stylesheet */
body {
  background: grainsboro;
  color: chucknorris;
}
li {
    list-style-type: cjk-ideographic;
}
</style>

<script>
// require Vue
define(['Vue'], function(Vue){
  // create and return app instance
  // refer template as `template`
  return new Vue({
    template: template,
    
    data: {
      // sample data: Japanese numbers
      items: [
        'ichi',
        'ni',
        'san',
        'shi',
        'go',
        'roku',
        'shichi',
        'hachi'
      ]
    },
    
    methods: {
      loadAnother: function(){
        // example of dynamic Vue loading
        require(['requirejs_vue!dynamics'], function(compo){
          // mount it
          compo.$mount('#dynamic-placeholder');
        })
      }
    }
  })
});
</script>