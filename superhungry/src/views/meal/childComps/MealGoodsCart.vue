<template>
  <div>
    <div class="shopcart">
      <div class="content">
        <div class="content-left" @click="toggleShow">
          <div class="logo-wrapper">
            <div
              class="logo"
              :class="{ highlight: this.$store.getters.totalCount }"
            >
              <i
                class="iconfont icon-cart"
                :class="{ highlight: this.$store.getters.totalCount }"
              ></i>
            </div>
            <div class="num" v-if="this.$store.getters.totalCount">
              {{ this.$store.getters.totalCount }}
            </div>
          </div>
          <div
            class="price"
            :class="{ highlight: this.$store.getters.totalCount }"
          >
            ￥{{ this.$store.getters.totalPrice }}
          </div>
          <!-- <div class="desc">另需配送费￥4 元</div>  -->
        </div>
        <div class="content-right">
          <div class="pay" :class="payClass" @click="pay">去结算</div>
        </div>
      </div>

      <transition name="move">
        <div class="shopcart-list" v-show="listShow">
          <div class="list-header">
            <h1 class="title">购物车</h1>
            <span class="empty" @click="clearCart">清空购物车</span>
          </div>
          <scroll class="cart-scroll" ref="cartScroll">
            <div class="list-content">
              <ul>
                <li
                  class="food"
                  v-for="(item, index) in this.$store.state.cartFoods"
                  :key="index"
                >
                  <span class="name">{{ item.dishes_name }}</span>
                  <div class="price">
                    <span>￥{{ item.dishes_price }}</span>
                  </div>
                  <div class="cartcontrol-wrapper">
                    <div class="cartcontrol">
                      <cart-control :food="item"></cart-control>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
          </scroll>
        </div>
      </transition>
    </div>
    <transition name="fade">
      <div class="list-mask" v-show="listShow" @click="toggleShow"></div>
    </transition>
  </div>
</template>

<script>
import CartControl from "components/common/cartControl/CartControl";
import Scroll from "components/common/scroll/Scroll";

import { MessageBox } from "mint-ui";

export default {
  components: {
    CartControl,
    Scroll,
  },
  data() {
    return {
      isShow: false,
    };
  },
  computed: {
    payClass() {
      return this.$store.getters.totalCount > 0 ? "enough" : "not-enough";
    },
    listShow() {
      //如果总数量为0，就直接不显示
      if (this.$store.getters.totalCount === 0) {
        this.isShow = false;
        return false;
      }
      return this.isShow;
    },
  },
  methods: {
    toggleShow() {
      if (this.$store.getters.totalCount > 0) {
        this.isShow = !this.isShow;
      }
    },
    clearCart() {
      MessageBox.confirm("确定清空购物车吗?").then(
        (action) => {
          this.$store.dispatch("clearCart");
        },
        () => {}
      );
    },
    pay() {
      this.$router.push("/shopcar");
    },
  },
  activated() {
    this.$refs.cartScroll.refresh();
  },
};
</script>

<style>
@import url(assets/css/mixins.css);
.shopcart {
  position: fixed;
  left: 0;
  bottom: 0;
  z-index: 50;
  width: 100%;
  height: 48px;
}
.shopcart .content {
  display: flex;
  background: #141d27;
  font-size: 0;
  color: rgba(255, 255, 255, 0.4);
}
.shopcart .content .content-left {
  flex: 1;
}
.shopcart .content .content-left .logo-wrapper {
  display: inline-block;
  vertical-align: top;
  position: relative;
  top: -10px;
  margin: 0 12px;
  padding: 6px;
  width: 56px;
  height: 56px;
  box-sizing: border-box;
  border-radius: 50%;
  background: #141d27;
}
.shopcart .content .content-left .logo-wrapper .logo {
  width: 100%;
  height: 100%;
  border-radius: 50%;
  text-align: center;
  background: #2b343c;
}
.shopcart .content .content-left .logo-wrapper .highlight {
  background: #02a774;
}
.shopcart .content .content-left .logo-wrapper .logo .icon-cart {
  line-height: 44px;
  font-size: 34px;
  color: #fff;
}
.shopcart .content .content-left .logo-wrapper .logo .icon-cart .highlight {
  color: #fff;
}
.shopcart .content .content-left .logo-wrapper .num {
  position: absolute;
  top: 0;
  right: 0;
  width: 24px;
  height: 16px;
  line-height: 16px;
  text-align: center;
  border-radius: 16px;
  font-size: 9px;
  font-weight: 700;
  color: #fff;
  background: #f01414;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.4);
}
.shopcart .content .content-left .price {
  display: inline-block;
  vertical-align: top;
  margin-top: 5px;
  line-height: 24px;
  padding-right: 12px;
  box-sizing: border-box;
  font-size: 16px;
  font-weight: 700;
  color: #fff;
}
.shopcart .content .content-left .highlight {
  color: #fff;
}
.shopcart .content .content-left .desc {
  display: inline-block;
  vertical-align: bottom;
  margin-bottom: 15px;
  margin-left: -45px;
  font-size: 10px;
}
.shopcart .content .content-right {
  flex: 0 0 105px;
  width: 105px;
}
.shopcart .content .content-right .pay {
  height: 48px;
  line-height: 48px;
  text-align: center;
  font-size: 12px;
  font-weight: 700;
  color: #fff;
}
.shopcart .content .content-right .not-enough {
  background: #2b333b;
}
.shopcart .content .content-right .enough {
  background: #00b43c;
  color: #fff;
}
.shopcart .ball-container .ball {
  position: fixed;
  left: 32px;
  bottom: 22px;
  z-index: 200;
  transition: all 0.4s cubic-bezier(0.49, -0.29, 0.75, 0.41);
}
.shopcart .ball-container .ball .inner {
  width: 16px;
  height: 16px;
  border-radius: 50%;
  background: #02a774;
  transition: all 0.4s linear;
}
.shopcart .shopcart-list {
  position: absolute;
  left: 0;
  top: 0;
  z-index: -1;
  width: 100%;
  transform: translateY(-100%);
  max-height: 240px;
}
.shopcart .move-enter-active,
.shopcart .move-leave-active {
  transition: transform 0.3s;
}
.shopcart .move-enter,
.shopcart .move-leave-to {
  transform: translateY(0);
}
.shopcart .shopcart-list .list-header {
  height: 40px;
  line-height: 40px;
  padding: 0 18px;
  background: #f3f5f7;
  border-bottom: 1px solid rgba(7, 17, 27, 0.1);
}
.shopcart .shopcart-list .list-header .title {
  float: left;
  margin: 0;
  font-size: 14px;
  color: #07111b;
}
.shopcart .shopcart-list .list-header .empty {
  float: right;
  font-size: 12px;
  color: #00a0dc;
}
.shopcart .cart-scroll {
  min-height: 49px;
  /* height: auto; */
  height: 200px;
  overflow: hidden;
  background-color: #fff;
}
.shopcart .shopcart-list .list-content {
  padding: 0 18px;
  /* min-height:49px; */
  /* max-height: 200px; */
  /* margin-bottom: 56px; */
  /* height: auto; */
  /* overflow:hidden; */
  background: rgb(255, 255, 255, 0.1);
}
.shopcart .shopcart-list .list-content .food {
  position: relative;
  padding: 12px 0;
  box-sizing: border-box;
  border-bottom: 1px solid rgba(7, 17, 27, 0.1);
}
.shopcart .shopcart-list .list-content .food .name {
  line-height: 24px;
  font-size: 14px;
  color: #07111b;
}
.shopcart .shopcart-list .list-content .food .price {
  position: absolute;
  right: 90px;
  bottom: 12px;
  line-height: 24px;
  font-size: 14px;
  font-weight: 700;
  color: #f01414;
}
.shopcart .shopcart-list .list-content .food .cartcontrol-wrapper {
  position: absolute;
  right: 0;
  bottom: 6px;
}
.list-mask {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 40;
  backdrop-filter: blur(10px);
  opacity: 1;
  background: rgba(7, 17, 27, 0.6);
}
.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.3s;
}
.fade-enter,
.fade-leave-to {
  opacity: 0;
}
</style>