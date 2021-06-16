<!--  -->
<template>
  <div>
    <nav-bar>
      <img
        src="../../../assets/img/usertool/back.svg"
        slot="left"
        @click="backclick"
      />
      <div slot="center">菜品评价</div>
    </nav-bar>
    <div class="content">
      <div class="index">
        <div class="title">
          <p>本次交易您有什么想法呢？</p>
          <br />
        </div>
        <br />
        <div class="body">
          <p>您的意见和建议对我们非常重要！</p>
          <br />
          <star @starnum="cpnclick"></star>
        </div>
        <div>
          <button class="_btn" @click="appraise">提交</button></button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import NavBar from "components/common/navbar/NavBar";
import Star from "../../../components/common/userMess/star.vue";
import { sumbit } from "../../../network/appraise";
export default {
  data() {
    return {
      score: 0,
    };
  },
  components: {
    NavBar,
    Star,
  },
  methods: {
    backclick() {
      this.$router.go(-1);
    },
    cpnclick(star) {
      this.score = star;
    },
    appraise() {
      sumbit(this.score, this.$route.query.order_id).then((res) => {
        alert("提交成功！感谢您的评价~");
        this.$router.replace("/order");
      });
    },
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
}
.content {
  height: auto;
  width: 100%;
  /* background-color: rgb(204, 103, 103); */
  padding: 20px 15px;
}
.index {
  background-color: rgb(243, 243, 243);
  box-shadow: 3px 3px 25px rgb(224, 224, 224);
  height: 100%;
  width: 100%;
  padding: 12px 12px;
  margin-bottom: 10px;
}

.title {
  border-bottom-style: dotted;
  border-width: 0.6px;
  border-color: gray;
}
.title p {
  font-weight: bolder;
  font-size: 18px;
  height: 32px;
  line-height: 32px;
  color: rgb(53, 51, 51);
}
.body {
  height: auto;
  /* padding-top: 10px; */
  font-size: 13px;
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
  margin-top: 10px;
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
