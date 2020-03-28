<template>
  <div class="add-employee">
    <add-form @added="onEmployeeAdd"></add-form>
    <div class="flex justify-center mt-6">
      <transition name="slide-fade" mode="out-in">
        <div v-if="employee" class="add-employee_div">
          <table class="add-employee__table">
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
          </table>
        </div>
      </transition>
    </div>
  </div>
</template>

<script>
import AddForm from "@/components/AddForm";

const camel2title = camelCase =>
  camelCase.replace(/([A-Z])/g, match => ` ${match}`).replace(/^./, match => match.toUpperCase());

export default {
  name: "add-employee",
  components: { AddForm },
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
  & .add-employee_div {
    @apply w-full;
    overflow: auto;
  }

  .add-employee__table {
    @apply shadow-lg rounded-lg;
    min-width: 48rem;
    border-collapse: separate;
    border-spacing: 0;
    width: 100%;
  }

  .add-employee__table td,
  .add-employee__table th {
    border: 1px solid #ddd;
    padding: 8px;
  }

  .add-employee__table tr:first-child th:first-child {
    border-top-left-radius: 0.5rem;
  }

  .add-employee__table tr:first-child th:last-child {
    border-top-right-radius: 0.5rem;
  }

  .add-employee__table tr:last-child td:first-child {
    border-bottom-left-radius: 0.5rem;
  }

  .add-employee__table tr:last-child td:last-child {
    border-bottom-right-radius: 0.5rem;
  }

  .add-employee__table tr:nth-child(even) {
    background-color: #f2f2f2;
  }

  .add-employee__table tr:hover {
    background-color: #ddd;
  }

  .add-employee__table th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: theme("colors.blue.800");
    color: white;
  }
}

@screen sm {
  .add-employee {
  }
}

@screen md {
  .add-employee {
  }
}
</style>
