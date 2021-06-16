<template>
  <div>
    <el-container>
      <el-header class="homeHeader">
        <div class="title">有点饿   superhungry</div>
        <el-dropdown @command="handleCommand">
          <span class="el-dropdown-link">
            {{user.username}}<i class="el-icon-arrow-down el-icon--right"></i>
          </span>
          <el-dropdown-menu slot="dropdown">
            <!-- <el-dropdown-item command="userinfo">个人中心</el-dropdown-item> -->
            <!-- <el-dropdown-item command="setting">设置</el-dropdown-item> -->
            <el-dropdown-item command="logout">注销登录</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </el-header>
      <el-container>
        <el-aside width="200px">
          <!-- 启动路由模式,就会用下面的 index 作为 path 去进行路由的跳转 -->
          <el-menu router unique-opened>
            <!-- 循环遍历菜单路由,实现动态绑定 -->
            <el-submenu :index="index + ''" 
                        v-for="(item, index) in this.$router.options.routes" 
                        :key="index"
                        v-if="!item.hidden">
              <template slot="title">
                <i class="el-icon-menu" style="color: #1accff; magin-right: 5px"></i>
                <span>{{item.name}}</span>
              </template>
              <el-menu-item v-for="(children, index1) in item.children"
                            :key="index1"
                            :index="children.path">
                {{children.name}}
              </el-menu-item>
            </el-submenu>
          </el-menu>
        </el-aside>
        <el-main>
          <el-breadcrumb separator-class="el-icon-arrow-right"
                        v-if="this.$router.currentRoute.path != '/home'">
            <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>{{this.$router.currentRoute.name}}</el-breadcrumb-item>
          </el-breadcrumb>
          <div class="homeWelcome" v-if="this.$router.currentRoute.path == '/home'">
            欢迎来到有点饿系统!
          </div>
          <router-view class="homeRouterView"></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
  import {logout} from 'network/login'

  export default {
    data () {
      return {
        user: JSON.parse(window.localStorage.getItem('user'))
      }
    },
    methods: {
      handleCommand(command) {
        if(command == 'logout') {
          this.$confirm('此操作将注销登录, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          logout();
          //清空用户信息
          localStorage.removeItem('token');
          window.localStorage.removeItem('user')
          // 进行页面跳转
          this.$router.replace('/'),
          this.$message({
            type: 'success',
            message: '注销成功!'
          });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消操作'
          });          
        });
          
        }
      }
    }
  }
</script>

<style>
  .homeHeader {
    background: #409eff;
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 0 15px;
    box-sizing: border-box;
  }
  .homeHeader .title {
    font-size: 30px;
    font-family: 楷体;
    color: white;
  }
  .homeWelcome {
    text-align: center;
    font-size: 30px;
    font-family: 楷体;
    color: #409eff;
    padding-top: 50px;
  }
  .homeRouterView {
    margin-top: 10px;
  }
</style>