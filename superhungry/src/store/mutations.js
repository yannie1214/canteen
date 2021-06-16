import Vue from 'vue'

import {
    RECEIVE_USER_INFO,
    RECEIVE_GOODS,
    RECEIVE_CATEGORYS,
    INCREMENT_FOOD_COUNT,
    DECREMENT_FOOD_COUNT,
    CLEAR_CART,
} from './mutation-types'

export default {
    [RECEIVE_USER_INFO](state, { userInfo }) {
        state.userInfo = userInfo
    },
    // 修改token，并将token存入localStorage
    changeLogin(state, user_token) {
        state.Authorization = user_token.Authorization;
        localStorage.setItem('Authorization', user_token.Authorization);
    },
    //
    [RECEIVE_GOODS](state, { goods }) {
        state.goods = goods
    },
    [RECEIVE_CATEGORYS](state, { categorys }) {
        state.categorys = categorys
    },
    [INCREMENT_FOOD_COUNT](state, { food }) {
        //第一次增加的时候food里面是没有count的
        if (!food.count) {
            //这是新增属性(没有绑定数据)
            // food.count = 1
            /*
              Vue函数里的set方法是用来给有数据绑定对象去添加属性的
              需要的参数有(对象, 属性名, 属性值)
              这种方式可以让新增的属性也有数据绑定
            */
            Vue.set(food, 'count', 1)
            //将 food 添加到 MealGoodsCart 中
            state.cartFoods.push(food)
        } else {
            food.count++
        }
    },
    [DECREMENT_FOOD_COUNT](state, { food }) {
        //只有count有值的时候才能减
        if (food.count) {
            food.count--
            if (food.count === 0) {
                //当减到 0 的时候，将 food 从 MealGoodsCart 中移除
                state.cartFoods.splice(state.cartFoods.indexOf(food), 1)
            }
        }
    },
    [CLEAR_CART](state) {
        //清除 food 中的 count
        state.cartFoods.forEach(food => food.count = 0)
        //将购物车中所有的 food 全部移除
        state.cartFoods = []
    }

}