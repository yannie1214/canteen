<!--  -->
<template>
  <div id="tool-item" @click="stick">
    <slot name="tool-img"></slot>
    <slot name="tool-name"></slot>
    <div class="jiantou"><slot name="tool-go"></slot></div>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
  props: {
    path: String,
  },
  methods: {
    stick() {
      this.$router.push(this.path);
      // console.log(this.path);
    },
  },
};
</script>

<style  scoped>
#tool-item {
  /* flex: 1; */
  height: 50px;
  font-size: 14px;
  margin-left: 8px;
  line-height: 50px;
  /* text-align: center; */
}
#tool-item img {
  height: 22px;
  width: 22px;
}
.jiantou {
  display: inline-block;
  position: absolute;
  right: 18px;
}
</style>
