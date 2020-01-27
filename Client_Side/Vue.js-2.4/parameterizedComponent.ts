import * as Vue from "vue";
import { Component, Prop, Watch } from "vue-property-decorator";
import axios, { AxiosError } from "axios";
import { Route } from "vue-router";

// Register the router hooks
Component.registerHooks([
  "beforeRouteEnter",
  "beforeRouteUpdate",
  "beforeRouteLeave"
]);

@Component({
  template: `
    <p v-if='user && userDataSize' style='border: dashed; padding: 10px'>
      Parameterized Component for user {{ user }}.<br>
      Data size = {{ userDataSize }}.<br>
      
      Parameter:<br>
      * id = {{ $route.params.id }}
    </p>
  `
})
export default class ParameterizedComponent extends Vue {
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

  beforeRouteEnter(to: Route, from: Route, next: Function) {
    // does NOT have access to `this` component instance,
    // because it has not been created yet when this guard is called!

    console.log("Route enter from", from, "to", to);
    next();
  }

  beforeRouteUpdate(to: Route, from: Route, next: Function) {
    // called when the route that renders this component has changed,
    // but this component is reused in the new route.
    // For example, for a route with dynamic params /foo/:id, when we
    // navigate between /foo/1 and /foo/2, the same Foo component instance
    // will be reused, and this hook will be called when that happens.
    // has access to `this` component instance.

    console.log("Route update from", from, "to", to);
    next();
  }

  beforeRouteLeave(to: Route, from: Route, next: Function) {
    // called when the route that renders this component is about to
    // be navigated away from.
    // has access to `this` component instance.

    console.log("Route leave from", from, "to", to);
    next();
  }
}