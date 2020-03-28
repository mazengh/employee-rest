<template>
  <form class="search-form" @submit.prevent="search">
    <div>
      <label>Name</label>
      <input name="name" type="text" autocomplete="off" v-model="name" />
    </div>
    <div>
      <label>Start Date</label>
      <input name="startDate" type="date" v-model="startDate" />
    </div>
    <div>
      <label>End Date</label>
      <input name="endDate" type="date" v-model="endDate" />
    </div>
    <div>
      <button class="search-form__button">
        <spinner v-if="loading" />
        <span v-else>Search</span>
      </button>
    </div>
  </form>
</template>

<script>
import Api from "@/api";
import Spinner from "@/components/Spinner";

export default {
  name: "search-form",
  components: { Spinner },
  data() {
    return {
      loading: false,
      name: "",
      startDate: "",
      endDate: ""
    };
  },
  computed: {
    axiosParams() {
      const params = new URLSearchParams();
      this.name && params.append("name", this.name);
      this.startDate && params.append("start", this.startDate);
      this.endDate && params.append("end", this.endDate);
      return params;
    }
  },
  methods: {
    search() {
      if (!this.loading) {
        this.$emit("searchEnd", false);
        this.loading = true;
        Api.find(this.axiosParams)
          .then(response => {
            this.$emit("searchEnd", response.data);
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
.search-form {
  @apply flex flex-wrap justify-center items-end p-8 bg-blue-800 rounded-lg shadow-lg mx-auto;

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
    @apply text-white bg-orange-400 rounded-lg py-2 px-4 mt-4;
    min-width: 5rem;
  }
}

@screen sm {
  .search-form {
    & div:first-of-type {
      @apply w-4/5;
    }
    & div:not(:first-of-type) {
      @apply w-2/5;
    }
    & div:nth-child(2) {
      @apply pr-4;
    }
  }
}

@screen lg {
  .search-form {
    & div {
      @apply pr-4 w-auto;
    }
    & div:first-of-type {
      @apply w-auto;
    }
    & div:not(:first-of-type) {
      @apply w-auto;
    }
    & div:nth-child(2) {
      @apply w-auto;
    }
  }
}
</style>
