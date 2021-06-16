<!--  -->
<template>
  <div id="order" class="wrapper">
    <nav-bar>
      <img
        src="../../assets/img/usertool/back.svg"
        slot="left"
        @click="backclick"
      />
      <div slot="center">我的订单</div>
    </nav-bar>
    <scroll class="content" ref="scroll">
      <!-- <div v-if="lengtho"></div> -->
      <!-- <div v-else><order-list :orders="orders"></order-list></div> -->
      <div v-if="orders.length != 0">
        <order-list :orders="orders"></order-list>
      </div>
      <div v-else><none-order></none-order></div>
    </scroll>
  </div>
</template>

<script>
import NavBar from "components/common/navbar/NavBar";
import OrderList from "components/content/order/OrderList";
import { showOrder } from "network/order";
import Scroll from "components/common/scroll/Scroll";
import NoneOrder from "../usertool/orderdetail/noneOrder.vue";

export default {
  name: "order",
  data() {
    return {
      orders: [],
      user_id: this.$store.state.userInfo.user_id,
      saveY: 0,
      lengtho: true,
    };
  },
  components: {
    NavBar,
    OrderList,
    Scroll,
    NoneOrder,
  },

  methods: {
    backclick() {
      this.$router.go(-1);
    },
  },
  created() {
    console.log(this.user_id);

    // const user_id = parseInt(this.id);
    // console.log(user_id);
    showOrder(this.user_id).then((res) => {
      // if (!res) {     //这里想做的是当返回的订单没有的时候，需要跳转到另一个组件
      //   this.router.push("/noOrder");
      //   console.log("kkk");
      // } else {

      console.log(res);
      this.orders = res;
    });
  },
  activated() {
    this.$refs.scroll.scrollTo(0, this.saveY, 0);
    this.$refs.scroll.refresh();
  },
  deactivated() {
    this.saveY = this.$refs.scroll.getScrollY();
  },
};
</script>

<style  scoped>
.nav-bar img {
  height: 22px;
  width: 22px;
  margin-top: 12px;
}
.nav-bar {
  box-shadow: 3px 3px 5px rgb(238, 238, 238);
}
#id {
  padding-top: 44px;
  position: relative;
  height: 100vh;
}
.content {
  overflow: hidden;
  position: absolute;
  top: 44px;
  bottom: 49px;
  left: 0;
  right: 0;
  /* height: 900px; */
}
</style>
