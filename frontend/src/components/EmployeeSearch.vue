<template>
  <div class="employee-search">
    <search-form @searchEnd="onSearchEnd"></search-form>
    <div class="flex justify-center mt-6">
      <transition name="slide-fade" mode="out-in">
        <div v-if="results" class="employee-search_div">
          <table class="employee-search__table">
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
          </table>
        </div>
      </transition>
    </div>
  </div>
</template>

<script>
import SearchForm from "@/components/SearchForm";

const camel2title = camelCase =>
  camelCase.replace(/([A-Z])/g, match => ` ${match}`).replace(/^./, match => match.toUpperCase());

export default {
  name: "employee-search",
  components: { SearchForm },
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
  & .employee-search_div {
    @apply w-full;
    overflow: auto;
  }

  .employee-search__table {
    @apply shadow-lg rounded-lg;
    min-width: 48rem;
    border-collapse: separate;
    border-spacing: 0;
    width: 100%;
  }

  .employee-search__table td,
  .employee-search__table th {
    border: 1px solid #ddd;
    padding: 8px;
  }

  .employee-search__table tr:first-child th:first-child {
    border-top-left-radius: 0.5rem;
  }

  .employee-search__table tr:first-child th:last-child {
    border-top-right-radius: 0.5rem;
  }

  .employee-search__table tr:last-child td:first-child {
    border-bottom-left-radius: 0.5rem;
  }

  .employee-search__table tr:last-child td:last-child {
    border-bottom-right-radius: 0.5rem;
  }

  .employee-search__table tr:nth-child(even) {
    background-color: #f2f2f2;
  }

  .employee-search__table tr:hover {
    background-color: #ddd;
  }

  .employee-search__table th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: theme("colors.blue.800");
    color: white;
  }
}

@screen sm {
  .employee-search {
  }
}

@screen md {
  .employee-search {
  }
}
</style>
