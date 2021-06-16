<template>
  <div id="app">
    <keep-alive exclude="Detail,order,meal"><router-view /></keep-alive>
    <main-tab-bar></main-tab-bar>
  </div>
</template>

<script>
import MainTabBar from "../src/components/content/MainTabBar";
export default {
  components: {
    MainTabBar,
  },
};
</script>


<style>
@import url(./assets/css/base.css);
</style>