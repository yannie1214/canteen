<!--  -->
<template>
  <div>
    <div class="star" @click="starindex">
      <div
        v-for="(n, index) in 5"
        @mouseenter="enter(n)"
        @mouseleave="leave"
        @click="ok(n)"
        :class="{ active: curIndex >= n }"
      ></div>
      <p v-show="curIndex > 0 && flag">您的评分是：{{ curIndex }}</p>
    </div>
    <textarea class="text" cols="20" rows="10"></textarea>
  </div>
</template>

<script>
export default {
  data() {
    return {
      curIndex: -1,
      flag: false, //用户是否点击过 点击过true,否则就是false
    };
  },
  methods: {
    //鼠标经过改变curIndex为当前的元素的n值
    enter(n) {
      if (!this.flag) {
        //没有点击过
        this.curIndex = n;
      }
    },
    //鼠标离开，curIndex 变为-1
    leave() {
      if (!this.flag) {
        this.curIndex = -1;
      }
    },
    //点击时候，确认n值
    ok(n) {
      this.curIndex = n;
      this.flag = true; //用户点击过了
    },
    starindex() {
      this.$emit("starnum", this.curIndex);
    },
  },
};
</script>

<style  scoped>
.star div {
  display: inline-block;
  width: 25px;
  height: 25px;
  background: url("../../../assets/img/other/dislike.svg") no-repeat;
  background-size: contain;
}
.star div.active {
  background: url("../../../assets/img/other/ok.svg");
  background-size: contain;
}
.text {
  margin-top: 20px;
  height: 90px;
  width: 100%;
}
</style>
