<template>
  <form class="add-form" @submit.prevent="add">
    <p v-if="errors.length" class="add-form__warning">
      <b>Please correct the following error(s):</b>
      <ul class="ml-4 mt-2 mb-3">
        <li v-for="error in errors">{{ error }}</li>
      </ul>
    </p>
    <div>
      <label>Name</label>
      <input name="name" type="text" autocomplete="off" v-model="firstName" />
    </div>
    <div>
      <label>Last Name</label>
      <input name="lastName" type="text" autocomplete="off" v-model="lastName" />
    </div>
    <div>
      <label>Date of Birth</label>
      <input name="dateOfBirth" type="date" v-model="dateOfBirth" />
    </div>
    <div>
      <label>Job Title</label>
      <input name="jobTitle" type="text" autocomplete="off" v-model="jobTitle" />
    </div>
    <div>
      <label>Hire Date</label>
      <input name="hireDate" type="date" v-model="hireDate" />
    </div>
    <div>
      <label>Leave Date</label>
      <input name="leaveDate" type="date" v-model="leaveDate" />
    </div>
    <div>
      <button class="add-form__button">
        <spinner v-if="loading" />
        <span v-else>Add</span>
      </button>
    </div>
  </form>
</template>

<script>
import Api from "@/api";
import Spinner from "@/components/Spinner";

export default {
  name: "add-form",
  components: { Spinner },
  data() {
    return {
      loading: false,
      errors: [],
      firstName: "",
      lastName: "",
      dateOfBirth: "",
      jobTitle: "",
      hireDate: "",
      leaveDate: ""
    };
  },
  computed: {
    axiosParams() {
      const params = {
        "firstName": this.firstName,
        "lastName": this.lastName,
        "jobTitle": this.jobTitle,
        "dateOfBirth": this.dateOfBirth,
        "hireDate": this.hireDate,
        "leaveDate": this.leaveDate
      }
      return params;
    }
  },
  methods: {
    add() {
      this.errors = [];

      if (!this.firstName) {
        this.errors.push('First Name is required.');
      }
      if (!this.lastName) {
        this.errors.push('Last Name is required.');
      }
      if (!this.dateOfBirth) {
        this.errors.push('Date of Birth is required.');
      }
      if (!this.jobTitle) {
        this.errors.push('Job Title is required.');
      }
      if (!this.hireDate) {
        this.errors.push('Hire Date is required.');
      }

      if (!this.loading && !this.errors.length) {
        this.$emit("searchEnd", false);
        this.loading = true;
        Api.create(this.axiosParams)
          .then(response => {
            this.$emit("added", response.data);
            console.log(response.data);
          })
          .catch(error => {
            console.log("Connection failed: " + error);
          })
          .finally(() => {
            this.loading = false;
          });
      }
    }
  }
};
</script>

<style lang="postcss">
.add-form {
  @apply flex flex-wrap justify-center items-end p-8 bg-blue-800 rounded-lg shadow-lg mx-auto;

  &__warning {
    @apply text-white w-full;
  }

  & input {
    @apply rounded p-2;
  }
  & input[type="date"] {
    padding: calc(0.5rem - 1px);
  }
  & div {
    @apply flex flex-col mt-4 w-full;
  }

  & label {
    @apply text-white;
  }

  &__button {
    @apply text-white bg-orange-400 rounded-lg p-2 mt-4;
    min-width: 5rem;
  }
}

@screen sm {
  .add-form {
    & div {
      @apply w-1/2 px-2;
    }

    &__button {
      @apply mx-auto px-8;
    }
  }
}

@screen lg {
  .add-form {
    & div {
      @apply w-1/3 px-2;
    }
  }
}
</style>
