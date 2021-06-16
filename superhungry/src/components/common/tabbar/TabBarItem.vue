<!--  -->
<template>
  <div class="tab-bar-item" @click="itemclick">
    <div v-if="!isActive"><slot name="slot-cion"></slot></div>
    <div v-else><slot name="slot-cion-active"></slot></div>
    <div :class="{ active: isActive }"><slot name="slot-text"></slot></div>
  </div>
</template>

<script>
export default {
  name: "TabBarItem",
  data() {
    return {
      // isActive: true,
    };
  },
  computed: {
    isActive() {
      return this.$route.path.indexOf(this.path) != -1;
    },
  },
  props: {
    path: String,
  },
  methods: {
    itemclick() {
      this.$router.push(this.path);
    },
  },
};
</script>

<style  scoped>
.tab-bar-item {
  flex: 1;
  text-align: center;
  height: 49px;
  font-size: 12px;
  margin-top: 5px;
}
.tab-bar-item img {
  margin-bottom: 2px;
  height: 22px;
  width: 22px;
}
.active {
  color: rgb(254, 116, 142);
}
</style>
