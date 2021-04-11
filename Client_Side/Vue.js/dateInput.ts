import Vue from "vue";

import { Component, Prop } from "vue-property-decorator";

/// <reference path="vue-date-pick.d.ts"/>
import * as DatePick from "vue-date-pick";

/**
 * Customized date input based on `vue-date-pick`.
 *
 * CSS styles, including the Safari fix, have to be loaded separately by consuming pages.
 * Note: a corresponding tag does *not* work with self-closing: i.e. `<date-input ... />`.
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
        format="MM/DD/YYYY" :startWeekOnSunday="true"
        :editable="!disabled" :selectableYearRange="selectableYearRange"
        :inputAttributes="{disabled, id, name, tabindex, title}"></date-pick>`,
  components: {
    "date-pick": DatePick as any
  }
})
export default class DateInput extends Vue {
  // The property used by `v-model`
  @Prop() value: string;

  //region Propagated <date-pick> props

  /*
  // Disable input editing and calendar UI by setting "editable" prop to false.
  // This works, but non-editable inputs look just like enabled inputs: not good.
  @Prop() editable: boolean;
  */

  /*
   Dropdown for years can be customized (default: 40 years from and after current year).
   For example: `{from: 1985, to: 2020}`.
   */
  @Prop() selectableYearRange: { from: number; to: number };

  /*
   Other <date-pick> props can be propagated via `v-bind` fields or in their entirety via
   `v-bind=$props` (but all of them would have to be explicitly declared as props in anyway).
   */
  //endregion

  //region Propagated <input> attributes
  /*
  Disabled inputs are grayed out by a browser. Additionally, this would set `editable` to `false`
  in order to remove the clear input button.
  */
  @Prop() disabled: boolean;

  @Prop() id: string;
  @Prop() name: string;
  @Prop() tabindex: number;
  @Prop() title: string;
  //endregion

  /*
   Other component attributes (`$attrs`) are to be avoided lest they are rendered internally in
   <date-pick> <div>-s.
   */
}
