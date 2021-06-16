<!--  -->
<template>
  <div>
    <tool>
      <tool-item>
        <span slot="tool-img" class="title">密码 </span>
        <span slot="tool-name" class="text"
          ><input
            placeholder="请输入修改后的密码..."
            :value="password"
            v-on:input="pwdchange"
        /></span>
      </tool-item>
      <tool-item>
        <span slot="tool-img" class="title">手机号码 </span>
        <span slot="tool-name" class="text"
          ><input
            placeholder="请输入手机号码..."
            :value="phone"
            v-on:input="phonechange"
        /></span>
      </tool-item>
      <tool-item>
        <span slot="tool-img" class="title">昵称 </span>
        <span slot="tool-name" class="text"
          ><input
            placeholder="请输入用户名..."
            :value="username"
            v-on:input="namechange"
        /></span>
      </tool-item>
    </tool>
    <button class="_btn" @click="editsubmit">提交</button>
  </div>
</template>

<script>
import Tool from "components/content/user/Tool";
import ToolItem from "components/content/user/ToolItem";
import { edit } from "network/edit";
export default {
  data() {
    return {
      password: this.$store.state.userInfo.password,
      username: this.$store.state.userInfo.username,
      phone: this.$store.state.userInfo.phone,
    };
  },
  components: {
    Tool,
    ToolItem,
  },

  methods: {
    editsubmit() {
      edit(
        this.$store.state.userInfo.user_id,
        this.password,
        this.phone,
        this.username
      ).then((res) => {
        if (res) {
          alert("信息修改成功！请重新登录~");
          this.$router.push("/login");
        }
      });
    },

    namechange(event) {
      this.username = event.target.value;
    },
    pwdchange(event) {
      this.password = event.target.value;
    },
    phonechange(event) {
      this.phone = event.target.value;
    },
  },
};
</script>

<style  scoped>
/* tool-item input {
  margin: 5% 0 8% 0; 
   border-bottom: 1rpx solid lightgray;
} */

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
input {
  outline-style: none;
  border: 0;
  /* border-bottom: 1px solid #e9e9e9; */
  background-color: transparent;
  width: auto;
  /* height: 20px; */
  font-family: sans-serif;
  font-size: 14px;
  color: #969797;
  /* font-weight: bold; */
}
.text {
  color: darkgrey;
  margin-left: 16px;
}
.title {
  font-weight: bold;
  width: 63px;
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
  position: absolute;
  bottom: 38%;
  right: 10%;
}
._btn:hover {
  box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24),
    0 17px 50px 0 rgba(0, 0, 0, 0.19);
  cursor: pointer;
  background-color: #0b5137;
  transition: all 0.2s ease-in;
}
</style>

