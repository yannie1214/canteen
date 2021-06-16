<!--  -->
<template>
  <div class="bottom-bar">
    <div class="left">￥{{ this.$store.getters.totalPrice }}</div>
    <div class="right">
      <button class="_btn" @click="pay">去支付</button>
    </div>
  </div>
</template>

<script>
import { saveorder } from "../../network/saveorder";
export default {
  data() {
    return {
      dishesInfo: "",
    };
  },
  methods: {
    pay() {
      for (let i of this.$store.state.cartFoods) {
        this.dishesInfo += i.count + "_" + i.dishes_id + "#";
      }
      console.log(this.dishesInfo);

      saveorder(
        this.$store.getters.totalPrice,
        this.dishesInfo,
        this.$store.state.userInfo.user_id
      ).then((res) => {
        if (res) {
          this.$router.push("/finish");
          this.$store.state.cartFoods = [];
        }
      });
    },
  },
};
</script>

<style  scoped>
.bottom-bar {
  height: 49px;
  background: rgb(243, 243, 243);
  box-shadow: 0 -1px 1px rgba(150, 150, 150, 0.1);
  position: fixed;
  left: 0;
  right: 0;
  bottom: 0;
  z-index: 1000;
}
.left {
  height: 49px;
  line-height: 49px;
  padding-left: 20px;
}
.right {
  height: 49px;
  line-height: 49px;
  padding-right: 20px;
}
._btn {
  background-color: #5f8276; /* Green */
  border: none;
  color: #fafafa;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  font-size: 13px;
  border-radius: 20px;
  outline: none;
}
._btn:hover {
  box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24),
    0 17px 50px 0 rgba(0, 0, 0, 0.19);
  cursor: pointer;
  background-color: #0b5137;
  transition: all 0.2s ease-in;
}
.btn-size {
  height: 45px;
  width: 100%;
}
</style>
