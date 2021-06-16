<!--  -->
<template>
  <div class="good-item">
    <a href="#" class="ll">
      <img :src="gooditem.photo" alt="" />
      <div class="title">{{ gooditem.dishes_name }}</div>
    </a>
    <div class="review">
      <a href="#">
        <span class="price">￥{{ gooditem.dishes_price }}</span>
        <span class="msg">{{ gooditem.dishes_cname }}</span>
      </a>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {};
  },
  props: {
    gooditem: {
      type: Object,
      defalut: {},
    },
  },
};
</script>
    
<style  scoped>
.good-item {
  float: left;

  padding-bottom: 12px;
  /* z-index: 0; */
  /* margin-left: 4px;
  margin-bottom: 4px; */

  /* -webkit-transition: all 0.2s linear;
  transition: all 0.2s linear; */
  position: relative;
  width: 46%;
}
.good-item img {
  width: 100%;
  display: block;
  /* height: 150px; */
  margin: 0 auto 6px;
  box-shadow: 0 0 5px rgb(102, 101, 101);
}
.title {
  /* margin: 0 10px; */
  font-size: 14px;
  font-weight: 400;
  text-align: center;
}
.review {
  position: absolute;
  bottom: 30%;
  left: 0;
  z-index: 10;
  width: 30%;
  /* height: 90px; */
  overflow: hidden;
  font-size: 12px;
  background: rgb(173, 70, 80);
  opacity: 0.8;
  text-align: left;
  /* -webkit-transition: all 0.2s linear;
  transition: all 0.2s linear; */
}

.review a {
  color: #757575;
  display: block;
  padding: 2px 7px;
  outline: 0;
}

.review a span {
  display: block;
  margin-bottom: 5px;
  color: #fff;
}
.ll:active + .review {
  opacity: 0.8;
  height: 30%;
}
.ll img {
  height: 110px;
  width: 150px;
}
</style>
