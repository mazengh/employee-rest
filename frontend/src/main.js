import Vue from "vue";
import App from "@/App";

import router from "@/router";

import "@/assets/styles/main.css";

Vue.config.productionTip = false;

new Vue({
  router,
  render: h => h(App)
}).$mount("#app");
