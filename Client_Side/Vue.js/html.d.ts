/*
 Enables import of HTML modules in RequireJS, e.g.:
 import template = require("text!leave-requests.html");
 */
declare module "*.html" {
  const value: string;
  export default value;
}