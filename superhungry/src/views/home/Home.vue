<!--  -->
<template>
  <div id="home" class="wrapper">
    <nav-bar class="home-nav">
      <div slot="center">购物车</div>
    </nav-bar>
    <scroll class="content" ref="scroll">
      <home-swiper :homemess="homemess" />
      <home-center>每周热销榜</home-center>
      <good-list :goods="homemess"></good-list>
    </scroll>
  </div>
</template>

<script>
import NavBar from "../../components/common/navbar/NavBar";
import HomeSwiper from "./childCompons/homeSwiper";
import HomeCenter from "./childCompons/HomeCenter";
import { getHomedata } from "network/home";
import GoodList from "components/content/goods/GoodList";
import Scroll from "components/common/scroll/Scroll";
export default {
  data() {
    return {
      homemess: [],
      saveY: 0,
    };
  },
  components: {
    NavBar,
    HomeSwiper,
    // RecommendView,
    GoodList,
    HomeCenter,
    Scroll,
  },
  created() {
    getHomedata().then((res) => {
      this.homemess = res;
      //这里好像是因为异步请求没办法使用filter方法
      // const rr = res.filter(function (n) {
      //   return n.photo;
      // });
      console.log(res);
    });
  },
  destroyed() {
    console.log("home destroyed");
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
#home {
  padding-top: 44px;
  position: relative;
  height: 100vh;
}

.home-nav {
  background-color: rgb(56, 55, 55);
  color: aliceblue;
  box-shadow: 2px 2px 2px rgb(134, 131, 131);
  font-size: 16px;
  font-weight: 500;
  position: fixed;
  left: 0;
  right: 0;
  top: 0;
  z-index: 9;
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
