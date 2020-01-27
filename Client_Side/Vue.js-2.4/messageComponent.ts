import * as Vue from "vue";
import { Component, Prop, Watch } from "vue-property-decorator";
import axios, { AxiosError } from "axios";
import { Route } from "vue-router";

@Component({
  template: `
    <p v-if='user && userDataSize' style='border: dashed; padding: 10px'>
      Message Component for user {{ user }}.<br>
      Data size = {{ userDataSize }}.
    </p>
  `
})
export default class MessageComponent  extends Vue {
  @Prop()
  user: string;

  userDataSize: number | null = null;

  // noinspection JSUnusedLocalSymbols
  @Watch("user")
  onUserChanged(val: string, oldVal: string) {
    if (val) {
      this.load();
    }
  }

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