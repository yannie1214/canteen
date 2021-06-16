import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

// 路由的懒加载
const Login = () => import('views/login/Login')
const Home = () => import('views/home/Home')
const Meal = () => import('views/meal/Meal')
const Category = () => import('views/category/Category')
const Order = () => import('views/order/Order')
// const System = () => import('views/system/System')

const routes = [
  {
    path: '/',
    name: 'Login',
    component: Login,
    hidden: true
  },
  {
    path: '/home',
    name: '常用操作',
    component: Home,
    children: [
      {
        path: '/meal',
        name: '菜品管理',
        component: Meal
      },
      {
        path: '/category',
        name: '分类管理',
        component: Category
      },
      {
        path: '/order',
        name: '订单管理',
        component: Order
      },
    ]
  },
  // {
  //   path: '/home',
  //   name: '系统管理',
  //   component: Home,
  //   children: [
  //     {
  //       path: '/system',
  //       name: '系统设置',
  //       component: System
  //     },
  //   ]
  // },
]

export default new Router({
  mode: 'history',
  // 在我自己电脑跑用这句
  // base: process.env.BASE_URL,
  // 在虚拟机跑用这句
  base:'/backstage/',
  routes,
})
