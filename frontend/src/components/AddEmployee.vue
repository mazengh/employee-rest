<template>
  <div class="add-employee">
    <add-form @added="onEmployeeAdd"></add-form>
    <div class="flex justify-center mt-6">
      <transition name="slide-fade" mode="out-in">
        <results-table v-if="employee">
          <thead>
            <tr>
              <th v-for="header in headers" :key="header">{{ header }}</th>
            </tr>
          </thead>
          <tr>
            <td v-for="(employeeProperty, key) in employee" :key="key">
              {{ employeeProperty | format(key) }}
            </td>
          </tr>
        </results-table>
      </transition>
    </div>
  </div>
</template>

<script>
import AddForm from "@/components/AddForm";
import ResultsTable from "@/components/ResultsTable";

const camel2title = camelCase =>
  camelCase.replace(/([A-Z])/g, match => ` ${match}`).replace(/^./, match => match.toUpperCase());

export default {
  name: "add-employee",
  components: { AddForm, ResultsTable },
  data() {
    return {
      employee: null
    };
  },
  computed: {
    headers() {
      if (this.employee) {
        const headerTiles = Object.keys(this.employee).map(header => {
          // convert camelcase to title case
          return camel2title(header);
        });
        return headerTiles;
      }
      return [];
    }
  },
  methods: {
    onEmployeeAdd(employee) {
      this.employee = employee;
    }
  },
  filters: {
    format: function(value, employeeProperty) {
      if (!value) return "";
      if (
        employeeProperty === "startDate" ||
        employeeProperty === "endDate" ||
        employeeProperty === "dateOfBirth"
      ) {
        let date = new Date(Date.parse(value)).toUTCString();
        return date.substring(0, date.length - 12);
      } else {
        return value;
      }
    }
  }
};
</script>

<style lang="postcss">
.add-employee {
}
</style>
