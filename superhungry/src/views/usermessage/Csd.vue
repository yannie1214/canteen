<!--  -->
<template>
  <div>
    <nav-bar>
      <img
        src="../../assets/img/usertool/back.svg"
        slot="left"
        @click="backclick"
      />
      <div slot="center">系统版本</div>
    </nav-bar>
    <div class="none">
      <img src="../../assets/img/other/ios.svg" alt="" />

      <div class="text"><h4>当前版本号：1.1.1</h4></div>
    </div>
  </div>
</template>

<script>
import NavBar from "components/common/navbar/NavBar";
export default {
  data() {
    return {};
  },
  components: {
    NavBar,
  },
  methods: {
    backclick() {
      this.$router.go(-1);
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
.text {
  height: 40px;
  width: auto;

  position: absolute;
  right: 20%;
  /* bottom: 280px; */
  /* color: rgb(254, 118, 36); */

  margin: 20px;
}
.nav-bar img {
  height: 22px;
  width: 22px;
  margin-top: 12px;
}
.nav-bar {
  box-shadow: 3px 3px 5px rgb(238, 238, 238);
}
</style>
