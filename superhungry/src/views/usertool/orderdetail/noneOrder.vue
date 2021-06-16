<!--  -->
<template>
  <div class="none">
    <div class="text">还没有订单信息哦~</div>
    <img src="../../../assets/img/other/none.svg" alt="" />
    <button type="primary" class="login_btn" @click="order">那就点我选餐吧(づ￣ 3￣)づ</button></button>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
  methods: {
    order() {
      this.$router.push("/meal/goods");
    },
  },
};
</script>

<style  scoped>
.none {
  width: 70%;
  height: 50%;
  /* background-color: white; */
  border-radius: 4px;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}
.login_btn {
  background-color: rgb(250, 133, 61); /* Green */
  border: none;
  color: #fafafa;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  font-size: 13px;
  border-radius: 20px;
  outline: none;
  position: absolute;
  bottom: 25%;
  right: 10%;
}
.text {
  height: 40px;
  width: auto;

  position: absolute;
  right: 0px;
  bottom: 280px;

  /* margin: 5px; */
}
.login_btn:hover {
  box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24),
    0 17px 50px 0 rgba(0, 0, 0, 0.19);
  cursor: pointer;
  background-color: rgb(248, 113, 29);
  transition: all 0.2s ease-in;
}
</style>
