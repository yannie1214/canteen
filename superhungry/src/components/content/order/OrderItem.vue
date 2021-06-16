<!--  -->
<template>
  <div class="item">
    <div class="title">
      <span class="title-1">饿了吗</span>
      <span class="title-2" @click="detail">完成 ></span>
      <!-- 这里或许可以再添加一个组件显示完成的 -->
    </div>
    <div class="photo">
      <img v-for="item in order.items" :src="item.dishes.photo" />
    </div>
    <div class="msg1">
      <div class="left">
        订单编号：{{ order.order_code }}</p>
        <p>下单时间：{{ order.create_date }}</p>
      </div>
      <span class="right">￥{{ order.amount }}</span>
    </div>
    <div class="btn-size">
      <button class="_btn" @click="appraise">评价</button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
  props: {
    order: {
      type: Object,
      default: {},
    },
  },
  methods: {
    detail() {
      // console.log(this.order.id);
      this.$router.push({
        path: "/orderdetail",
        query: {
          order_id: this.order.id,
        },
      });
    },
    appraise() {
      this.$router.push({
        path: "/appraise",
        query: {
          order_id: this.order.id,
        },
      });
    },
  },
};
</script>

<style  scoped>
.item {
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
.title-2 {
  font-size: 16px;
  position: absolute;
  right: 28px;
  height: 32px;
  line-height: 32px;
}
.title {
  border-bottom-style: dotted;
  border-width: 0.6px;
  border-color: gray;
}
.photo {
  padding: 15px 8px;
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
  position: relative;
  left: 80%;
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
