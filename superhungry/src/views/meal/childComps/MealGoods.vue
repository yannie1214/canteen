<template>
  <div>
    <div class="goods">
      <scroll
        class="menu-scroll"
        ref="menuScroll"
        :probeType="probeType"
        @scroll="menuScroll"
      >
        <div class="menu-wrapper" ref="menuWrapper">
          <ul>
            <li
              class="menu-item"
              v-for="(item, index) in meal"
              :key="index"
              :class="{ current: index === currentIndex }"
              @click="menuItemClick(index)"
            >
              <span class="text bottom-border-1px">
                {{ item.dishes_cname }}
              </span>
            </li>
          </ul>
        </div>
      </scroll>

      <scroll
        class="foods-scroll"
        ref="foodsScroll"
        :probeType="probeType"
        @scroll="foodsScroll"
      >
        <div class="foods-wrapper" ref="foodsWrapper">
          <ul class="food-list" ref="foodsUI">
            <li
              class="food-list-hook"
              v-for="(item, index) in meal"
              :key="index"
            >
              <h1 class="title">{{ item.dishes_cname }}</h1>
              <ul>
                <li
                  class="food-item bottom-border-1px"
                  v-for="(item1, index) in item.foods"
                  :key="index"
                  @click="showFood(item1)"
                >
                  <div class="icon">
                    <img width="80" height="80" :src="item1.photo" />
                  </div>
                  <div class="content">
                    <h2 class="name">{{ item1.dishes_name }}</h2>
                    <p class="desc">{{ item1.dishes_describe }}</p>
                    <div class="extra"></div>
                    <div class="price">
                      <span class="now">￥{{ item1.dishes_price }}</span>
                    </div>
                    <div class="cartcontrol-wrapper">
                      <cart-control :food="item1"></cart-control>
                    </div>
                  </div>
                </li>
              </ul>
            </li>
          </ul>
        </div>
      </scroll>

      <meal-goods-cart></meal-goods-cart>
    </div>
    <meal-detail :food="food" ref="food"></meal-detail>
  </div>
</template>


<script>
import CartControl from "components/common/cartControl/CartControl";
import MealDetail from "./MealDetail";
import MealGoodsCart from "./MealGoodsCart";

import Scroll from "components/common/scroll/Scroll";

export default {
  components: {
    CartControl,
    MealDetail,
    MealGoodsCart,
    Scroll,
  },
  data() {
    return {
      //菜品列表滑动的Y轴坐标,滑动过程中，实时收集scrollY
      scrollY: 0,
      //所有菜品分类组成的数组
      tops: [],
      //展示菜品详情的那个菜品
      food: {},
      //展示所有的菜品
      meal: [],
      //侦测我们滚动的位置为实时侦测
      probeType: 3,
      // 记录我们滚动的位置
      saveMenuY: 0,
      saveFoodsY: 0,
    };
  },
  props: {
    goods: {
      type: Array,
    },
    categorys: {
      type: Array,
    },
  },
  mounted() {
    this.$store.dispatch("getGoods", () => {
      this.$nextTick(() => {
        this.getFood();
        this.$nextTick(() => {
          this.initTops();
        });
      });
    });
  },
  computed: {
    // 计算得到当前分类的下标
    // 初始和相关数据发生变化时执行
    currentIndex() {
      // 1. 得到条件数据
      const { saveFoodsY, tops } = this;
      // console.log(tops);

      // 2. 根据条件计算产生一个结果,一旦返回的是 true 那么查找就结束
      const index = tops.findIndex((top, index) => {
        // 这里的 top 指的是当前的 top 就是当前分类 saveFoodsY >= top && saveFoodsY < top+1(top+1指的是下一个 top)
        return -saveFoodsY >= top && -saveFoodsY < tops[index + 1];
      });
      // 3. 返回结果
      return index;
    },
  },
  methods: {
    //展示当前点击的food
    showFood(food) {
      // 1.设置food
      this.food = food;
      // 2. 显示 mealDetail 组件，在点击之前这个组件是隐藏的,这里写的是在 mealDetail 组件内部来控制显示隐藏的,调用子组件的对象方法,首先要得到他的对象，当然在这里来给 meal-detail 标签绑定显示隐藏也是可以的
      this.$refs.food.toggleShow();
    },
    menuScroll(position) {
      // console.log('menu');
      // console.log(position);
    },
    foodsScroll(position) {
      this.saveFoodsY = this.$refs.foodsScroll.getScrollY();

      // 1.判断BackTop是否显示
      // this.isShowBackTop = (-position.y) > 1000

      // 2.决定tabControl是否吸顶(position: fixed)
      // this.isTabFixed = (-position.y) > this.tabOffsetTop
    },
    // 收集所有菜品分类 tops
    initTops() {
      // 1. 初始化 tops
      const tops = [];
      let top = 0;
      tops.push(top);
      // 2. 找到所有分类的 li
      const lis = this.$refs.foodsUI.getElementsByClassName("food-list-hook");
      // console.log(lis);
      // console.log(typeof lis);
      // console.log(lis.length);
      // console.log(Object.keys(lis));
      Array.prototype.slice.call(lis).forEach((li) => {
        top += li.clientHeight;
        // console.log(top);
        tops.push(top);
      });
      // for (let i = 0; i < Object.keys(lis); i++) {
      //   console.log(i);
      //   top += Object.keys(lis)[i].clientHeight;
      //   console.log(top);
      //   tops.push(top);
      // }
      // 3. 更新状态
      this.tops = tops;
      // console.log(tops);
    },
    // 点击左边的导航栏可以让右边的菜品展示到相应的内容，并且点击的导航栏显示被选中
    menuItemClick(index) {
      // 使右侧的菜品展示到指定的位置
      this.$refs.foodsScroll.scrollTo(0, -this.tops[index], 300);
    },
    getFood() {
      // console.log(this.goods.length);
      for (let i = 0; i < this.goods.length; i++) {
        let good = {};
        // console.log(this.goods);
        if (typeof this.goods[i][0] != "undefined") {
          good.dishes_cname = this.goods[i][0].dishes_cname;
          good.foods = this.goods[i];
          // console.log(good);
          // console.log(good);
          this.meal.push(good);
          // console.log(this.meal);
        }
      }
      // console.log(this.meal);
    },
  },
  activated() {
    this.$refs.menuScroll.scrollTo(0, this.saveMenuY, 0);
    this.$refs.foodsScroll.scrollTo(0, this.saveFoodsY, 0);
    this.$refs.menuScroll.refresh();
    this.$refs.foodsScroll.refresh();
  },
  deactivated() {
    this.saveMenuY = this.$refs.menuScroll.getScrollY();
    this.saveFoodsY = this.$refs.foodsScroll.getScrollY();
  },
};
</script>

<style>
@import url(assets/css/mixins.css);

.goods {
  display: flex;
  /* position:fixed;
    top:195px;
    bottom:46px; */
  width: 100%;
  height: 426px;
  background: #fff;
  /* overflow:hidden */
}

.goods .menu-scroll {
  height: calc(100%-249px);
  overflow: hidden;
}

.goods .menu-wrapper {
  flex: 0 0 80px;
  width: 80px;
  background: #f3f5f7;
}

.goods .menu-wrapper .menu-item {
  display: table;
  position: relative;
  z-index: 10;
  height: 54px;
  width: 80px;
  padding: 0 12px;
  line-height: 14px;
}

.goods .menu-wrapper .current {
  position: relative;
  z-index: 10;
  margin-top: -1px;
  background: #fff;
  color: #02a774;
  font-weight: 700;
}

.goods .menu-wrapper .menu-item .icon {
  display: inline-block;
  vertical-align: top;
  width: 12px;
  height: 12px;
  margin-right: 2px;
  background-size: 12px 12px;
  background-repeat: no-repeat;
}

.goods .menu-wrapper .menu-item .text {
  display: table-cell;
  width: 56px;
  vertical-align: middle;
}

.goods .menu-wrapper .menu-item .bottom-border-1px {
  border-bottom: 1px solid rgba(7, 17, 27, 0.1);
  font-size: 14px;
}

.goods .foods-scroll {
  /* height: 426px;
    z-index: 10; */
  /* height: 900px; */
  /* overflow: hidden;
    position: fixed;
    top: 193px;
    bottom: 56px;
    left: 80px;
    right: 0; */
  /* height: calc(100%-249px); */
  height: 426px;
  overflow: hidden;
  /* margin-left: 80px; */
}

.goods .foods-wrapper {
  width: 295px;
  flex: 1;
}

.goods .foods-wrapper .title {
  position: relative;
  z-index: 10;
  padding-left: 14px;
  height: 26px;
  line-height: 26px;
  border-left: 2px solid #d9dde1;
  font-size: 12px;
  color: #93999f;
  background: #f3f5f7;
}

.goods .foods-wrapper .food-item {
  display: flex;
  position: relative;
  z-index: 10;
  margin: 18px;
  padding-bottom: 18px;
}

.goods .foods-wrapper .bottom-border-1px {
  border-bottom: 1px solid rgba(7, 17, 27, 0.1);
}

.goods .foods-wrapper .food-item:last-child {
  margin-bottom: 0;
}

.goods .foods-wrapper .food-item .icon {
  flex: 0 0 57px;
  margin-right: 10px;
}

.goods .foods-wrapper .food-item .content {
  flex: 1;
}

.goods .foods-wrapper .food-item .content .name {
  margin: 2px 0 8px 0;
  height: 14px;
  line-height: 14px;
  font-size: 14px;
  color: #07111b;
}

.goods .foods-wrapper .food-item .content .desc,
.goods .foods-wrapper .food-item .content .extra {
  line-height: 10px;
  font-size: 14px;
  color: #93999f;
}

.goods .foods-wrapper .food-item .content .desc {
  line-height: 12px;
  margin-bottom: 8px;
}

.goods .foods-wrapper .food-item .content .extra .count {
  margin-right: 12px;
}

.goods .foods-wrapper .food-item .content .price {
  font-weight: 700;
  line-height: 24px;
  font-size: 18px;
}

.goods .foods-wrapper .food-item .content .price .now {
  margin-right: 8px;
  font-size: 14px;
  color: #f01414;
}

.goods .foods-wrapper .food-item .content .price .old {
  text-decoration: line-through;
  font-size: 10px;
  color: #93999f;
}

.goods .foods-wrapper .food-item .content .cartcontrol-wrapper {
  position: absolute;
  right: 0;
  bottom: 12px;
  text-align: right;
}
</style>
