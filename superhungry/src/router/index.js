import Vue from 'vue'
import Router from 'vue-router'


Vue.use(Router)

const Home = () => import('../views/home/Home')
const Category = () => import('../views/category/Categroy')
const Profile = () => import('../views/profile/Profile')
const Shopcart = () => import('../views/shopcart/ShopCar')
const login = () => import('../components/common/userMess/login')
const order = () => import('../views/usermessage/Order')
const coupon = () => import('../views/usermessage/Coupon')
const csd = () => import('../views/usermessage/Csd')
const Settings = () => import('../views/usermessage/Settings')
const user = () => import('../views/usermessage/User')
const orderdetail = () => import('../views/usertool/OrderDetail')
const register = () => import('../views/usertool/ResigsterView')
const Appraise = () => import('../views/usertool/orderdetail/Appraise')
const Meal = () => import('../views/meal/Meal')
const MealGoods = () => import('../views/meal/childComps/MealGoods')
const shopcar = () => import('../views/shopcart/ShopCar')
const finish = () => import('../views/shopcart/finish')
const router = new Router({
  mode: 'history',
  // base: process.env.BASE_URL,
  base: '/superhungry/',
  routes: [
    {
      path: '/',
      component: login
    },
    {
      path: '/home',
      component: Home
    }, {
      path: '/category',
      component: Category
    }, {
      path: '/profile',
      component: Profile
    },
    // {
    //   path: '/shopcart',
    //   component: Shopcart
    // },
    {
      path: '/login',
      component: login
    },
    {
      path: '/order',
      component: order
    },
    {
      path: '/coupon',
      component: coupon
    },
    {
      path: '/settings',
      component: Settings
    },
    {
      path: '/user',
      component: user
    },
    {
      path: '/csd',
      component: csd
    },
    {
      path: '/orderdetail',
      component: orderdetail
    },
    {
      path: '/register',
      component: register
    },
    {
      path: '/appraise',
      component: Appraise
    },
    //
    {
      path: '/shopcart',
      component: Meal,
      // meal 下面的子路由，也就是meal里面的navbar对应的路由
      children: [
        // 这个是默认进去的就是goods这个路由对应的页面
        {
          path: '',
          redirect: '/meal/goods'
        },
        {
          path: '/meal/goods',
          component: MealGoods,
        },

      ]
    },
    {
      path: '/shopcar',
      component: shopcar,
    },
    {
      path: '/finish',
      component: finish,
    },
  ],
})
router.beforeEach((to, from, next) => {
  if (to.path === '/login') {
    next();
  } else {
    let token = localStorage.getItem('Authorization');

    if (token === null || token === '') {
      next('/login');
    } else {
      next();
    }
  }
});
export default router

