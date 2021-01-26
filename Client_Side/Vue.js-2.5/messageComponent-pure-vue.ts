// import template = require("text!message.html");
const template = `
<p v-if='user && userDataSize' style='border: dashed; padding: 10px'>
  <b>Lazy Loaded Message Component</b><br/>
  User {{ user }}.<br/>
  Received {{ userDataSize }} bytes from an async HTTP call.
</p>
`;


import axios from "axios";
import Vue from "vue";

const MessageComponent = Vue.extend({
  props: ["user"],
  data() {
    return {
      userDataSize: undefined
    };
  },
  template: template as any,
  methods: {
    load() {
      // noinspection DuplicatedCode
      // @ts-ignore
      if (this.user) {
        this.$emit("loading");
        const serviceUrl = ".";
        axios.get(serviceUrl)
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
    this.load();
  },
  watch: {
    user(to) {
      if (to) {
        this.load();
      }
    }
  }
});
// Vue.component("MessageComponent", MessageComponent);

export default MessageComponent;