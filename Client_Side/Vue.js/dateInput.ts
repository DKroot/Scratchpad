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
   Bind `value` to the child input and propagate the `input` event with the changed value
   payload to the parent. See http://vuejs.org/v2/guide/components.html#Using-v-model-on-Components.

   Propagate some <date-pick> properties via `v-bind` fields.
   Propagate some <input> attributes.
  */
  template: `
    <date-pick :value="value" @input="$emit('input', $event)"
               format="MM/DD/YYYY" :start-week-on-sunday="true"
               v-bind="{selectableYearRange}"
               :inputAttributes="{id, name, tabindex}"></date-pick>`,
  components: {
    'date-pick': DatePick as any
  }
})
export default class DateInput extends Vue {
  // The property used by `v:model`
  @Prop() value: string;

  //region Propagated <date-pick> props
  /*
  Other <date-pick> props can be propagated via `v-bind` fields or in their entirety via
  `v-bind=$props` (but all of them would have to be explicitly declared as props in anyway).
  */

  @Prop(Object) selectableYearRange: object;
  //endregion

  //region Propagated <input> attributes
  @Prop() id: string;
  @Prop() name: string;
  @Prop(Number) tabindex: number;
  //endregion

  /*
  Other component attributes (`$attrs`) are to be avoided lest they are rendered internally in
  <date-pick> <div>-s.
  */
}
