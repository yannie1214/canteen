<!--  -->
<template>
  <div class="goods">
    <good-list-item v-for="item in goods" :gooditem="item" />
  </div>
</template>

<script>
import GoodListItem from "./GoodListItem";
export default {
  data() {
    return {};
  },
  components: {
    GoodListItem,
  },
  props: {
    goods: {
      type: Array,
      default: [],
    },
  },
};
</script>

<style  scoped>
.goods {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
  margin-top: 10px;
}
</style>
