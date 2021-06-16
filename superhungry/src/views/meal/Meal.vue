<template>
  <div>
    <meal-head></meal-head>
    <meal-tab
      class="meal-tab"
      :titles="['点餐']"
      @tabClick="tabClick"
      ref="mealTab"
    >
    </meal-tab>

    <meal-goods :goods="goods" :categorys="categorys"></meal-goods>
  </div>
</template>

<script>
import MealHead from "views/meal/childComps/MealHead";
import MealTab from "views/meal/childComps/MealTab";
import MealGoods from "views/meal/childComps/MealGoods";

import { showAll, showType } from "network/meal";

export default {
  name: "meal",
  components: {
    MealHead,
    MealTab,
    MealGoods,
  },
  data() {
    return {
      goods: [],
      categorys: [],
    };
  },
  // created 函数比较特殊，是当我们组件创建好就会执行的一个函数，最好把里面的东西抽取出去，只写重要的内容和主要的逻辑,这里把里面的方法抽取到了方法里面
  created() {
    this.showAll();
    // this.showType()
  },
  mounted() {
    this.$store.dispatch("getGoods");
    this.$store.dispatch("getGoodsCate");
  },
  methods: {
    /**
     * 事件监听相关的方法
     */
    tabClick(index) {
      switch (index) {
        case 0:
          this.currentType = "goods";
          break;
      }
      this.$refs.mealTab.currentIndex = index;
    },
    /**
     * 网络请求相关的方法
     */
    showAll() {
      showAll().then((res) => {
        console.log(res);
        for (const n of res) {
          this.goods.push(n);
          // console.log(this.goods);
        }
      });
    },
    showType() {
      showType(this.categorys).then((res) => {
        // console.log(res);
        // console.log(typeof res);
        for (const n of res) {
          this.categorys.push(n);
        }
      });
    },
  },
};
</script>

<style scoped>
</style>