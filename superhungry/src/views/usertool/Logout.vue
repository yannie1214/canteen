<!--  -->
<template>
  <div>
    <button class="login_btn" @click="logout">退出登录</button>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
  methods: {
    logout() {
      window.localStorage.clear();
      this.$router.push("/login");
    },
  },
};
</script>

<style  scoped>
.login_btn {
  background-color: #5f8276; /* Green */
  border: none;
  color: #fafafa;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  font-size: 16px;
  border-radius: 20px;
  outline: none;
  position: absolute;
  bottom: 30%;
  right: 38%;
}
.login_btn:hover {
  box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24),
    0 17px 50px 0 rgba(0, 0, 0, 0.19);
  cursor: pointer;
  background-color: #0b5137;
  transition: all 0.2s ease-in;
}
</style>
