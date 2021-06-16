<!--  -->
<template>
  <div class="orderitem-bg">
    <order-item v-for="item in orders" :order="item"></order-item>
  </div>
</template>

<script>
import OrderItem from "./OrderItem.vue";

export default {
  components: { OrderItem },
  data() {
    return {};
  },
  props: {
    orders: {
      type: Array,
      default: [],
    },
  },
};
</script>

<style  scoped>
.orderitem-bg {
  /* background-color: rgb(168, 99, 99); */

  height: auto;
  width: 100%;
  padding: 20px 15px;
}
</style>
