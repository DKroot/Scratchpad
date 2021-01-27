import Vue from "vue";

import { Component, Prop } from "vue-property-decorator";
import axios from "axios";

import template = require("text!message.html");
/*const template = `
<p v-if='user && userDataSize' style='border: dashed; padding: 10px'>
  <b>Message Component</b><br/>
  User {{ user }}.<br/>
  Received {{ userDataSize }} bytes from an async HTTP call.
</p>
`;*/

@Component({
  template: template as any
})
export default class MessageComponent extends Vue {
  @Prop()
  user: string;

  userDataSize: number | null = null;

  // noinspection DuplicatedCode
  load() {
    if (this.user) {
      this.$emit("loading");
      const serviceUrl = ".";
      axios.get(serviceUrl)
          .then(response => {
            this.$emit("success");
            this.userDataSize = response.data.length;
            console.log("Received data for", serviceUrl);
          })
          .catch(error => {
            this.$emit("loading-error", error, serviceUrl);
          });
    }
  }

  created() {
    // fetch the data when the view is created and the data is already being observed
    this.load();
  }
}