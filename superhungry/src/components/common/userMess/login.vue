<!--  -->
<template>
  <div id="box">
    <div id="log-box">
      <div class="userbox">
        <span class="iconfont">
          <img src="../../../assets/img/usertool/username.svg" alt="" />
        </span>
        <input
          class="user"
          id="user"
          :value="loginform.phone"
          v-on:input="namechange"
          placeholder="手机号"
        />
      </div>
      <br />
      <div class="pwdbox">
        <span class="iconfont">
          <img src="../../../assets/img/usertool/password.svg" alt="" />
        </span>
        <input
          class="pwd"
          id="password"
          :value="loginform.password"
          v-on:input="pswchange"
          type="password"
          placeholder="密码"
        />
      </div>
      <div>
        <br />
        <button type="primary" class="login_btn" @click="login1">登录</button>
      </div>
      <br />
      <br />
      <div @click="register" class="register-text">没有账号？点我注册!</div>
    </div>
    <br />
  </div>
</template>

<script>
import { login } from "../../../network/login";

import { mapMutations } from "vuex";

export default {
  data() {
    return {
      loginform: {
        phone: "",
        password: "",
        identity: "customer",
      },
      userToken: "",
    };
  },
  //   created() {
  //     login(this.loginform.username, this.loginform.password).then((res) => {
  //       console.log(res);
  //     });
  //   },
  methods: {
    namechange(event) {
      this.loginform.phone = event.target.value;
      //   console.log(event);
    },
    pswchange(event) {
      this.loginform.password = event.target.value;
    },
    ...mapMutations(["changeLogin"]),
    login1() {
      let _this = this;

      if (this.loginform.phone === "" || this.loginform.password === "") {
        window.alert("账号或密码不能为空");
      } else {
        login(
          _this.loginform.phone,
          _this.loginform.password,
          _this.loginform.identity
        )
          .then((res) => {
            console.log(res);
            if (res.code == 200) {
              const user = res.data.user;

              // this.$router.replace("/profile");
              // console.log(res.data);
              _this.userToken = res.data.token;
              // console.log(_this.userToken);
              // console.log(res.data.token);
              // 将用户token保存到vuex中
              // this.$cookie.set("token", _this.userToken, 1);
              _this.changeLogin({ Authorization: _this.userToken });
              // console.log(user);
              this.$store.dispatch("recordUser", user);
              _this.$router.push("/profile");
              alert("登陆成功");
            } else {
              alert("登录失败");
            }
          })
          .catch((error) => {
            alert("账号或密码错误");
            console.log(error);
          });
      }
    },
    register() {
      this.$router.replace("/register");
    },
  },
};
</script>

<style  scoped>
#box {
  background-color: rgba(56, 55, 55);
  position: absolute;
  height: 100%;
  width: 100%;
}
#log-box {
  width: 70%;
  height: 50%;
  background-color: white;
  border-radius: 4px;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}
input:-webkit-autofill {
  /* 修改默认背景框的颜色 */
  box-shadow: 0 0 0px 1000px #89ab9e inset !important;
  /* 修改默认字体的颜色 */
  -webkit-text-fill-color: #445b53;
}

input:-webkit-autofill::first-line {
  /* 修改默认字体的大小 */
  font-size: 15px;
  /* 修改默认字体的样式 */
  font-weight: bold;
}
.userbox {
  margin-top: 120px;
  height: 30px;
  width: 230px;
  display: flex;
  margin-left: 25px;
}
.pwdbox {
  height: 30px;
  width: 225px;
  display: flex;
  margin-left: 25px;
}
input {
  outline-style: none;
  border: 0;
  border-bottom: 1px solid #e9e9e9;
  background-color: transparent;
  height: 20px;
  font-family: sans-serif;
  font-size: 14px;
  color: #445b53;
  font-weight: bold;
}
/* input::-webkit-input-placeholder{
    color:#E9E9E9;
 } */
input:focus {
  border-bottom: 2px solid #445b53;
  background-color: transparent;
  transition: all 0.2s ease-in;
  font-family: sans-serif;
  font-size: 15px;
  color: #445b53;
  font-weight: bold;
}
.iconfont img {
  font-family: "iconfont" !important;
  font-size: 20px;
  font-style: normal;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  height: 18px;
  color: #4e655d;
  margin-right: 10px;
  margin-top: 3px;
}
.login_btn {
  background-color: #5f8276; /* Green */
  border: none;
  color: #fafafa;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  font-size: 13px;
  border-radius: 20px;
  outline: none;
  position: absolute;
  bottom: 25%;
  right: 15%;
}
.login_btn:hover {
  box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24),
    0 17px 50px 0 rgba(0, 0, 0, 0.19);
  cursor: pointer;
  background-color: #0b5137;
  transition: all 0.2s ease-in;
}
.register-text {
  font-size: 12px;
  text-align: right;
  margin-top: 10px;
  margin-right: 20px;
  text-decoration: underline;
}
</style>
