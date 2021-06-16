<!--  -->
<template>
  <div class="nav-bar">
    <div class="left"><slot name="left"></slot></div>
    <div class="center"><slot name="center"></slot></div>
    <div class="right"><slot name="right"></slot></div>
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
.nav-bar {
  display: flex;
  height: 44px;
  line-height: 44px;
  text-align: center;
  /* position: fixed; */
}
.left,
.right {
  width: 60px;
  /* background-color: rgb(184, 93, 93); */
}
.center {
  flex: 1;
  /* background-color: rgb(101, 179, 90); */
}
</style>
