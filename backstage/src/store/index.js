import Vue from 'vue'
import Vuex from 'vuex'

import mutations from './mutations'
import actions from './actions'
import getters from './getters'

// 1. 安装插件
Vue.use(Vuex)

// 2. 创建对象
const state = {
  // 存储登录用户的所有信息
  userInfo: {},
  // 存储菜单路由的数组
  routes: [],
}

const store = new Vuex.Store({
  // 保存状态
  // 在 state 里面定义的属性，都会被加入到响应式系统中，也就是说，这里的属性都是响应式的,而响应式系统会监听我们属性的变化，当属性发生变化时，会通知界面中所有用到该属性的地方，让界面发生刷新
  state,
  // 方法
  // Vuex的store状态的更新唯一方式：提交Mutation
  mutations,
  // Action类似于Mutation, 但是是用来代替Mutation进行异步操作的
  actions,
  // 从store中获取一些state变异后的状态,就可以用 getters
  // getters默认是不能传递参数的, 如果希望传递参数, 那么只能让getters本身返回另一个函数
  getters,
})

// 3. 导出 store 对象
export default store