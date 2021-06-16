<!--  -->
<template>
  <div id="user-msg">
    <h2 v-if="name">嗨！{{ name }}~</h2>
    <h3 v-else><span @click="login">登录</span>|<span @click="register">注册</span></span></h3>
  </div>
</template>

<script>
import UserMessage from "components/common/userMess/UserMessage";
export default {
  data() {
    return {
      name: this.$store.state.userInfo.username,
    };
  },
  props: {},
  components: {
    UserMessage,
  },
  methods: {
    login() {
      this.$router.push("/login");
    },
    register() {
      this.$router.push("/register");
    },
  },
};
</script>

<style  scoped>
#user-msg {
  height: 90px;
  /* background-color: rgb(240, 240, 240); */
  line-height: 90px;
  padding-left: 15px;
}

/* #user-msg img {
  position: relative;
  left: 8px;
  height: 60px;
  width: 60px;
  border-radius: 50%;
} */
</style>
