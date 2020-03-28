<template>
  <div class="results-table">
    <table class="results-table__data">
      <slot />
    </table>
  </div>
</template>

<script>
export default {
  name: "results-table"
};
</script>

<style lang="postcss">
.results-table {
  @apply w-full rounded-lg shadow-lg;
  overflow: auto;

  .results-table__data {
    @apply border-collapse w-full;
    min-width: 48rem;
  }

  .results-table__data td,
  .results-table__data th {
    @apply p-2 border border-gray-200;
  }

  .results-table__data tr:nth-child(even) {
    background-color: theme("colors.gray.200");
  }

  .results-table__data tr:hover {
    background-color: theme("colors.gray.400");
  }

  .results-table__data th {
    @apply text-white text-left py-3 bg-blue-800;
  }
}
</style>
