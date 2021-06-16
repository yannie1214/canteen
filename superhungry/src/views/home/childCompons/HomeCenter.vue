<!--  -->
<template>
  <div class="home-center">
    <slot></slot>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
};
</script>

<style  scoped>
.home-center {
  height: 43px;
  background-color: rgb(155, 26, 39);
  line-height: 43px;
  text-align: center;
  color: aliceblue;
  opacity: 0.8;
  /* border-bottom: 8px solid rgb(241, 240, 240); */
}
</style>
