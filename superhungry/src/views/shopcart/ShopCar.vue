<!--  -->
<template>
  <div id="detail">
    <nav-bar>
      <img src="~assets/img/usertool/back.svg" slot="left" @click="backclick" />
      <div slot="center">菜篮子</div>
    </nav-bar>

    <scroll class="content" ref="scroll">
      <car-detail :mycar="meals"></car-detail>
    </scroll>
    <bottom-bar></bottom-bar>
  </div>
</template>

<script>
import NavBar from "../../components/common/navbar/NavBar";
import BottomBar from "./BottomBar.vue";
import CarDetail from "./CarDetail.vue";
import Scroll from "components/common/scroll/Scroll";
export default {
  data() {
    return {
      meals: this.$store.state.cartFoods,
    };
  },
  components: {
    NavBar,
    CarDetail,
    BottomBar,
    Scroll,
  },
  methods: {
    backclick() {
      this.$router.go(-1);
    },
  },
  created() {
    console.log(this.$store.state.cartFoods);
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
  position: relative;
  z-index: 19999;
  background-color: rgb(243, 243, 243);
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
#detail {
  height: 100vh;
  position: relative;

  /* padding-bottom: 3px; */
  /* background-color: #fff; */
  z-index: 9;
}
</style>
