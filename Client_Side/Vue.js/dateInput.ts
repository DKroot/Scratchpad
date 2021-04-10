import Vue from "vue";

import { Component, Prop } from "vue-property-decorator";

/// <reference path="vue-date-pick.d.ts"/>
import * as DatePick from "vue-date-pick";

/**
 * Customized date input based on `vue-date-pick`.
 *
 * CSS styles, including the Safari fix, have to be loaded separately by consuming pages.
 */
@Component({
  /*
   Bind `value` to the child input.
   Propagate the `input` event with the changed value payload to the parent.
   See http://vuejs.org/v2/guide/components.html#Using-v-model-on-Components.
  */
  template: `<date-pick :value="value" @input="$emit('input', $event)"
    format="MM/DD/YYYY" :start-week-on-sunday="true"></date-pick>`,
  components: {
    'date-pick': DatePick as any
  }
})
export default class DateInput extends Vue {
  // The property used by `v:model`
  @Prop() value: string;
}
