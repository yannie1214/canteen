<template>
  <div class="meal-tab">
    <!-- 如果只是文字不一样的情况下，就没有必要用插条,只需要把文字传过来就好了 -->
    <div
      v-for="(item, index) in titles"
      :key="item.index"
      class="meal-tab-item"
      :class="{ active: index === currentIndex }"
      @click="itemClick(index)"
    >
      <span>{{ item }}</span>
    </div>
    <span class="back" @click="back">返回</span>
  </div>
</template>

<script>
export default {
  props: {
    titles: {
      type: Array,
      default() {
        return [];
      },
    },
  },
  data() {
    return {
      currentIndex: 0,
    };
  },
  methods: {
    itemClick(index) {
      this.currentIndex = index;
      this.$emit("tabClick", index);
    },
    back() {
      this.$router.push("/home");
    },
  },
};
</script>

<style>
.meal-tab {
  display: flex;
  text-align: center;
  font-size: 16px;
  height: 40px;
  line-height: 40px;
  background-color: #fff;
}
.meal-tab-item {
  flex: 1;
}
.meal-tab-item span {
  padding: 5px;
}
.active {
  color: #ff5777;
}
.active span {
  border-bottom: 3px solid #ff8198;
}
.back {
  padding-right: 5%;
}
</style>