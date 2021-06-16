<!--  -->
<template>
  <div>
    <tab-bar>
      <tab-bar-item path="/home">
        <img src="../../assets/img/tabbar/home.svg" slot="slot-cion" />
        <img
          src="../../assets/img/tabbar/home_active.svg"
          slot="slot-cion-active"
        />
        <div slot="slot-text">首页</div>
      </tab-bar-item>
      <tab-bar-item path="/shopcart">
        <img src="../../assets/img/tabbar/shopcart.svg" slot="slot-cion" />
        <img
          src="../../assets/img/tabbar/shopcart_active.svg"
          slot="slot-cion-active"
        />
        <div slot="slot-text">购物车</div>
      </tab-bar-item>
      <tab-bar-item path="/order">
        <img src="../../assets/img/tabbar/category.svg" slot="slot-cion" />
        <img
          src="../../assets/img/tabbar/category_active.svg"
          slot="slot-cion-active"
        />
        <div slot="slot-text">订单</div>
      </tab-bar-item>
      <tab-bar-item path="/profile">
        <img src="../../assets/img/tabbar/profile.svg" slot="slot-cion" />
        <img
          src="../../assets/img/tabbar/profile_active.svg"
          slot="slot-cion-active"
        />
        <div slot="slot-text">我的</div>
      </tab-bar-item>
    </tab-bar>
  </div>
</template>

<script>
import TabBar from "../common/tabbar/TabBar";
import TabBarItem from "../common/tabbar/TabBarItem";
export default {
  data() {
    return {};
  },
  components: {
    TabBar,
    TabBarItem,
  },
};
</script>

<style  scoped>
</style>
