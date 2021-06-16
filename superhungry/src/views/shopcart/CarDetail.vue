<!--  -->
<template>
  <div id="detail">
    <div class="item">
      <div class="title">
        <span class="title-1">商品明细</span>
      </div>

      <div class="photo" v-for="item in mycar">
        <img :src="item.photo" />
        <span class="name">{{ item.dishes_name }}</span>
        <span class="number"
          >x{{ item.count }}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span
        >
        <span class="money">￥{{ item.count * item.dishes_price }}.00</span>
      </div>
      <div>
        <br />
        <span class="total"
          >总计：￥{{ this.$store.getters.totalPrice }}.00</span
        >
      </div>
    </div>
  </div>
</template>

<script>
import { showcar } from "../../network/shopcar";
import Scroll from "components/common/scroll/Scroll";
export default {
  data() {
    return {};
  },
  props: {
    mycar: {
      type: Array,
      default: [],
    },
  },

  computed: {},
  // created() {
  //   showcar(this.$store.state.userInfo.user_id).then((res) => {
  //     this.mycar = res;
  //     console.log(res);
  //   });
  // },
  components: {
    Scroll,
  },
};
</script>

<style  scoped>
.item {
  background-color: rgb(243, 243, 243);
  box-shadow: 3px 3px 25px rgb(224, 224, 224);
  height: auto;
  width: 100%;
  /* margin-bottom: 10px; */
  overflow: hidden;
  padding: 12px 12px;
}

.title-1 {
  font-weight: bolder;
  font-size: 18px;
  height: 32px;
  line-height: 32px;
  color: rgb(53, 51, 51);
}

.title {
  border-bottom-style: dotted;
  border-width: 0.6px;
  border-color: gray;
}
.name {
  margin-left: 3%;
  /* margin-top: 10px; */
}
.number {
  margin-left: 20%;
}
/* .money {
  margin-left: 21%;
} */
.photo {
  padding: 12px 2px;

  height: auto;
  width: 100%;
  border-bottom-style: dotted;
  border-width: 0.6px;
  border-color: gray;
  /* display: flex; */
  /* flex-direction: row;
  flex-wrap: wrap; */
}
.photo img {
  /* flex: 1; */
  height: 50px;
  width: 58px;
  margin-left: 17px;
  margin-bottom: 4px;
}
.msg1 {
  padding-top: 8px;
  height: 60px;
  width: 100%;
}
.left {
  font-size: 12px;
}
.right {
  position: relative;
  top: 15px;
  font-size: 18px;
  color: black;
}

.total {
  height: 60px;
  line-height: 40px;
  margin-right: 10%;
}
/* .content { */
/* background-color: #fff; */
/* height: calc(100%-93px); */
/* height: 300px; */
/* overflow: hidden;
  position: absolute;
  top: 44px;
  bottom: 49px;
  left: 0;
  right: 0;
} */
</style>
