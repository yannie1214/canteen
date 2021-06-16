<!--  -->
<template>
  <div>
    <nav-bar>
      <img
        src="../../assets/img/usertool/back.svg"
        slot="left"
        @click="backclick"
      />
      <span slot="center">个人资料</span>
    </nav-bar>
    <edit-user></edit-user>
  </div>
</template>

<script>
import NavBar from "components/common/navbar/NavBar";
import EditUser from "../usertool/EditUser";
export default {
  data() {
    return {};
  },
  components: {
    NavBar,
    EditUser,
  },
  methods: {
    backclick() {
      this.$router.go(-1);
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
</style>
