<template>
  <div class="employee-search">
    <search-form @searchEnd="onSearchEnd"></search-form>
    <div class="flex justify-center mt-6">
      <transition name="slide-fade" mode="out-in">
        <results-table v-if="results">
          <thead>
            <tr>
              <th v-for="header in headers" :key="header">{{ header }}</th>
            </tr>
          </thead>
          <tr v-for="employee in results" :key="employee.id">
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
import SearchForm from "@/components/SearchForm";
import ResultsTable from "@/components/ResultsTable";

const camel2title = camelCase =>
  camelCase.replace(/([A-Z])/g, match => ` ${match}`).replace(/^./, match => match.toUpperCase());

export default {
  name: "employee-search",
  components: { SearchForm, ResultsTable },
  data() {
    return {
      results: null
    };
  },
  computed: {
    headers() {
      if (this.results && this.results.length) {
        const headerTiles = Object.keys(this.results[0]).map(header => {
          // convert camelcase to title case
          return camel2title(header);
        });
        return headerTiles;
      }
      return [];
    }
  },
  methods: {
    onSearchEnd(results) {
      this.results = results;
    }
  },
  filters: {
    format: function(value, employeeProperty) {
      if (!value) return "";
      if (employeeProperty === "startDate" || employeeProperty === "endDate") {
        let date = new Date(Date.parse(value)).toUTCString();
        return date.substring(0, date.length - 12);
      } else if (employeeProperty === "dateOfBirth") {
        let dateOfBirth = new Date(Date.parse(value));
        let birthYear = dateOfBirth.getFullYear();
        let todayDate = new Date();
        let todayYear = todayDate.getFullYear();
        return todayYear - birthYear;
      } else {
        return value;
      }
    }
  }
};
</script>

<style lang="postcss">
.employee-search {
}
</style>
