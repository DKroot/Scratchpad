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
    background: aqua;
    color: coral;
  }

  li {
    list-style-type: cjk-ideographic;
  }
</style>

<script lang="ts">
  // require Vue
  // create and return app instance
  // refer template as `template`
  import Vue from "vue";

  export default Vue.extend({
    data: {
      // sample data: Japanese numbers
      items: ['ichi', 'ni', 'san', 'shi', 'go', 'roku', 'shichi', 'hachi']
    },

    methods: {
      loadAnother: function () {
        // example of dynamic Vue loading
        // noinspection TypeScriptUnresolvedFunction
        require(['requirejs_vue!dynamics'], (compo: any) => {
          // mount it
          compo.$mount('#dynamic-placeholder');
        })
      }
    }
  });
</script>