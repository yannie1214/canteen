<!--  -->
<template>
  <div class="item">
    <div class="title">
      <span class="title-1">商品明细</span>
    </div>

    <div class="photo" v-for="item in article.items">
      <img :src="item.dishes.photo" />
      <span class="name">{{ item.dishes.dishes_name }}</span>
      <span class="number"
        >x{{ item.order_num }}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span
      >
      <span class="money"
        >￥{{ item.order_num * item.dishes.dishes_price }}.00</span
      >
    </div>
    <div>
      <br />
      <span class="total">总计：￥{{ article.amount }}.00</span>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
  props: {
    article: {
      type: Object,
      default: {},
    },
  },
  computed: {
    // itemmoney(){
    //   return this.article.items.order_num *
    // }
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
.total {
  height: 60px;
  line-height: 40px;
  margin-left: 65%;
}
</style>
