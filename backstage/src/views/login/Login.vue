<template>
  <div>
    <el-form :rules="loginRules" 
             v-loading="loading"
             element-loading-text="正在登陆..."
             element-loading-spinner="el-icon-loading"
             element-loading-background="rgba(0, 0, 0, 0.8)"
             :model="loginForm" 
             ref="loginForm" 
             class="loginContainer">
      <h3 class="loginTitle">系统登录</h3>
      <!-- prop 里面填的字段才会和校验规则里面的字段对应上 -->
      <el-form-item label="电话号码" prop="phone">
        <el-input type="text" aria-autocomplete="false" v-model="loginForm.phone" placeholder="请输入电话号码"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input type="password" aria-autocomplete="false" v-model="loginForm.password" placeholder="请输入密码"></el-input>
      </el-form-item>
      <!-- <el-form-item label="" prop="code">
        <el-input type="text" aria-autocomplete="false" v-model="loginForm.code" placeholder="点击图片更换验证码" style="width: 250px; margin-right: 5px"></el-input>
        <img :src="captchaUrl" alt="">
      </el-form-item> -->
      <el-form-item>
        <el-button type="primary" @click="submitLogin" style="width: 100%">登录</el-button>
      </el-form-item>
    </el-form>
    
  </div>
</template>

<script>
  import {login} from 'network/login'

  export default {
    data() {
      return {
        // captchaUrl: '',
        loginForm: {
          // 13241526142
          phone: '',
          // 123456
          password: '',
          identity: 'merchant'
        },
        loading: false,
        // 校验信息
        loginRules: {
          phone: [
            {required: true, message: '请输入电话号码', trigger: 'blur'}
          ],
          password: [
            {required: true, message: '请输入密码', trigger: 'blur'}
          ],
          // code: [
          //   {required: true, message: '请输入验证码', trigger: 'blur'}
          // ]
        }
      }
    },
    methods: {
      submitLogin() {
        this.$refs.loginForm.validate((valid) => {
          if (valid) {
            this.loading = true
            // this.loginForm 
            login(this.loginForm.phone, this.loginForm.password, this.loginForm.identity).then(resp => {
              // console.log(resp);
              // console.log(typeof resp);
              // this.$router.replace('/home')
              
              // alert(JSON.stringify(resp))
              // if(resp == 'undefined') {
              //   alert('用户名或密码输入不正确，请重新输入！')
              // }
              if(resp) {
                this.loading = false
                const user = resp.data.user
                // 将 user 保存到 vuex 的 state里面
                this.$store.dispatch('recordUser', user)
                // 存储用户 token
                const token = resp.data.token
                // console.log(token);
                window.localStorage.setItem('token', token)
                window.localStorage.setItem('user', JSON.stringify(resp.data.user))
                // 登录成功跳转的页面
                this.$router.replace('/home')
              }
            })
            .catch((err) => {
              console.log(err);
            })
          } else {
            this.$message.error('请输入所有字段！');
            return false;
          }
        });
      }
    }
  }
</script>

<style>
  .loginContainer {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 180px auto;
    width: 350px;
    padding: 15px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }
  .loginTitle {
    margin: 0px auto 40px auto;
    text-align: center;
  }
</style>