import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

export default new Router({
  mode: "history",
  routes: [
    {
      path: "/",
      alias: "/search",
      name: "search",
      component: () => import("@/components/EmployeeSearch")
    },
    {
      path: "/employee/:id",
      name: "employee-details",
      component: () => import("@/components/Employee")
    },
    {
      path: "/add",
      name: "add",
      component: () => import("@/components/AddEmployee")
    }
  ]
});
