<!--  -->
<template>
  <div class="shop-box">
    <div class="shop-detali">
      <div class="left">
        <h3>饿了吗</h3>
        <br />
        <p>广东工业大学一号店</p>
      </div>
      <div class="right">
        <img src="../../../assets/img/other/shop.svg" alt="" />
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
};
</script>

<style  scoped>
.shop-box {
  height: 130px;
  width: 100%;
  padding: 20px 15px;
  /* background-color: rgb(216, 188, 188); */
}
.shop-detali {
  height: 100%;
  width: 100%;
  background-color: rgb(243, 243, 243);
  box-shadow: 3px 3px 25px rgb(224, 224, 224);
  /* background-color: rgb(64, 189, 95); */
}
.left {
  position: relative;
  left: 8px;
  top: 18px;
}
.left p {
  font-size: 14px;
}
.right img {
  height: 55px;
  position: relative;
  top: 20px;
}
</style>
