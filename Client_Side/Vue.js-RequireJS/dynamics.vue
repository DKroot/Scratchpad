<template>
  <div>
    <p>It is dynamically loaded vue file</p>
    <p>Created at: date</p>
  </div>
</template>

<script lang="ts">
  import Vue from "vue";

  export default Vue.extend({
    data: {
      // date = null;
    },
    created: function () {
      // this.date = new Date();
    }
  });
</script>