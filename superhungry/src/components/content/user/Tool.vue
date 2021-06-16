<!--  -->
<template>
  <div id="tool">
    <slot></slot>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
  components: {},
};
</script>

<style  scoped>
#tool {
  height: auto;

  background-color: rgb(243, 243, 243);
  position: fixed;
  top: 180px;

  left: 15px;
  right: 15px;

  box-shadow: 2px 2px 10px rgb(202, 199, 199);

  /* 设置垂直分布 */
  display: flex;
  flex-direction: column-reverse;
  align-content: space-between;
}
</style>
