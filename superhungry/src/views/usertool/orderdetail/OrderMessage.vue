<!--  -->
<template>
  <div class="order-detail">
    <div class="title">
      <span class="title-1">订单信息</span>
    </div>
    <div class="content">
      <div class="message">
        <span class="left"> 订单号 </span>
        <span class="right"> {{ ordermsg.order_code }} </span>
      </div>
      <div class="message">
        <span class="left"> 下单时间 </span>
        <span class="right"> {{ ordermsg.create_date }} </span>
      </div>
      <div class="message">
        <span class="left"> 订单类型 </span>
        <span class="right"> 堂食 </span>
      </div>
      <div class="message">
        <span class="left"> 支付状态 </span>
        <span class="right"> 已支付 </span>
      </div>
      <div class="message">
        <span class="left"> 备注 </span>
        <span class="right"> </span>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
  props: {
    ordermsg: {
      type: Object,
      default: {},
    },
  },
};
</script>

<style  scoped>
.order-detail {
  background-color: rgb(243, 243, 243);
  box-shadow: 3px 3px 25px rgb(224, 224, 224);
  height: 100%;
  width: 100%;
  padding: 12px 12px;
  margin-bottom: 10px;
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
.message {
  padding: 12px 2px;
  margin-bottom: 10px;
  height: auto;
  width: 100%;
  /* border-bottom-style: dotted;
  border-width: 0.6px;
  border-color: gray; */
  /* display: flex; */
  /* flex-direction: row;
  flex-wrap: wrap; */
}
.left {
  position: relative;
  height: 18px;
  width: auto;
  /* background-color: rgb(112, 35, 35); */
  left: 0px;
}
.right {
  position: relative;
  height: 18px;
  width: auto;
  /* background-color: rgb(112, 35, 35); */
  left: 0px;
}
.content {
  padding-top: 5px;
}
</style>
