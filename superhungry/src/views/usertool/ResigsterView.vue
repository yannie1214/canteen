<!--  -->
<template>
  <div id="box">
    <div id="log-box">
      <div class="userbox">
        <span class="iconfont">
          <img src="~assets/img/usertool/username.svg" alt="" />
        </span>
        <input
          class="user"
          id="user"
          :value="loginform.username"
          v-on:input="namechange"
          placeholder="用户名"
        />
        <br />
      </div>
      <br />
      <div class="pwdbox">
        <span class="iconfont">
          <img src="~assets/img/usertool/phone.svg" alt="" />
        </span>
        <input
          class="pwd"
          id="phone"
          :value="loginform.phone"
          v-on:input="phonechange"
          placeholder="电话号码"
        />
      </div>
      <br />
      <div class="pwdbox">
        <span class="iconfont">
          <img src="~assets/img/usertool/password.svg" alt="" />
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
      <br />
      <div class="pwdbox">
        <span class="iconfont">
          <img src="~assets/img/usertool/resure.svg" alt="" />
        </span>
        <input
          class="pwd"
          id="repwd"
          :value="repwd"
          v-on:input="repswchange"
          type="password"
          placeholder="确认密码"
        />
      </div>

      <div>
        <br />
        <button type="primary" class="register_btn" @click="register">
          注册
        </button>
      </div>
    </div>
    <br />
  </div>
</template>

<script>
// import { login } from "../../../network/login";
import { register } from "network/register";
// import { login } from "../../network/login";
export default {
  data() {
    return {
      loginform: {
        username: "",
        password: "",
        phone: "",
        identity: "customer",
      },
      userToken: "",
      repwd: "",
    };
  },

  methods: {
    namechange(event) {
      this.loginform.username = event.target.value;
      //   console.log(event);
    },
    pswchange(event) {
      this.loginform.password = event.target.value;
    },
    phonechange(event) {
      this.loginform.phone = event.target.value;
    },
    repswchange(event) {
      this.repwd = event.target.value;
    },

    register() {
      if (this.loginform.password != this.repwd) {
        alert("两次密码输入不一致！请重新输入");
      } else {
        register(
          this.loginform.username,
          this.loginform.password,
          this.loginform.phone,
          this.loginform.identity
        ).then((res) => {
          if (res) {
            alert("注册成功！");
            this.$router.replace("/login");
          } else {
            alert("身份认证不通过，注册失败！");
          }
        });
      }
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
  margin-top: 25%;
  height: 30px;
  width: 230px;
  display: flex;
  margin-left: 20px;
}
.pwdbox {
  height: 30px;
  width: 225px;
  display: flex;
  margin-left: 20px;
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
.register_btn {
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
  bottom: 13%;
  right: 15%;
}
.register_btn:hover {
  box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24),
    0 17px 50px 0 rgba(0, 0, 0, 0.19);
  cursor: pointer;
  background-color: #0b5137;
  transition: all 0.2s ease-in;
}
</style>
