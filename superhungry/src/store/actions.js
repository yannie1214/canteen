import {
    RECEIVE_USER_INFO,
    RECEIVE_GOODS,
    RECEIVE_CATEGORYS,
    INCREMENT_FOOD_COUNT,
    DECREMENT_FOOD_COUNT,
    CLEAR_CART,
} from './mutation-types'

import { showAll, showType } from 'network/meal'

export default {
    recordUser({ commit }, userInfo) {
        commit(RECEIVE_USER_INFO, { userInfo })
    },
    //
    //异步获取菜品列表
    getGoods({ commit }, callback) {
        //发送异步请求
        const result = showAll()
        // 提交一个 mutation
        result.then(res => {
            // console.log(res);
            const goods = res
            // console.log(result);
            commit(RECEIVE_GOODS, { goods })
            //数据更新，通知一下组件
            callback && callback()
        })
    },
    //获取菜品分类
    getGoodsCate({ commit, state }) {
        const cname = state.cnames
        const result = showType(cname)
        result.then(res => {
            // console.log(res);
            const categorys = res
            // console.log(result);
            commit(RECEIVE_CATEGORYS, { categorys })
        })
    },

    //同步更新food中的count值
    updateCount({ commit }, { isAdd, food }) {
        if (isAdd) {
            commit(INCREMENT_FOOD_COUNT, { food })
        } else {
            commit(DECREMENT_FOOD_COUNT, { food })
        }
    },

    //同步清空购物车
    clearCart({ commit }) {
        commit(CLEAR_CART)
    }
}