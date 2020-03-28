<template>
  <div id="app">
    <div class="container mt-3 mx-auto">
      <nav>
        <router-link to="/" :exact="$route.path !== '/search'" class="mr-6">Search</router-link>
        <router-link to="/add" class="">Add</router-link>
      </nav>
      <transition name="slide-fade" mode="out-in">
        <router-view />
      </transition>
    </div>
  </div>
</template>

<script>
export default {
  name: "app"
};
</script>

<style lang="postcss">
#app {
  .container {
    max-width: 60rem;
  }
  & nav {
    @apply flex items-center pt-6 pb-3 ml-2;

    a {
      border-bottom: 0.25rem solid transparent;
      transition: all 0.2s ease-in;
      &:hover,
      &.router-link-active {
        border-bottom: 0.25rem solid theme("colors.orange.400");
      }
    }
  }

  .slide-fade-enter {
    transform: translateY(-10px);
    opacity: 0;
  }

  .slide-fade-enter-active,
  .slide-fade-leave-active {
    transition: all 0.2s ease;
  }

  .slide-fade-leave-to {
    transform: translateY(10px);
    opacity: 0;
  }
}
</style>
