<!--  -->
<template>
  <div id="detail" class="wrapper">
    <nav-bar>
      <img
        src="../../assets/img/usertool/back.svg"
        slot="left"
        @click="backclick"
      />
      <div slot="center">订单详情</div>
    </nav-bar>
    <scroll class="content" ref="scroll">
      <shop></shop>
      <item :article="detail"></item>
      <order-message :ordermsg="detail"></order-message>
    </scroll>
  </div>
</template>

<script>
import NavBar from "../../components/common/navbar/NavBar";
import Item from "./orderdetail/item.vue";
import Shop from "./orderdetail/shop.vue";
import { findOrderItem } from "../../network/findorder";
import OrderMessage from "./orderdetail/OrderMessage.vue";
import Scroll from "components/common/scroll/Scroll";

export default {
  name: "Detail",
  data() {
    return {
      detail: {},
    };
  },
  components: {
    NavBar,
    Shop,
    Item,
    OrderMessage,
    Scroll,
  },
  methods: {
    backclick() {
      this.$router.go(-1);
    },
  },
  created() {
    findOrderItem(this.$route.query.order_id).then((res) => {
      this.detail = res;
      console.log(res);
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
/* #detail {
  padding-top: 44px;
  position: relative;
  height: 100vh;
} */
.nav-bar img {
  height: 22px;
  width: 22px;
  margin-top: 12px;
}
.nav-bar {
  box-shadow: 3px 3px 5px rgb(238, 238, 238);
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
