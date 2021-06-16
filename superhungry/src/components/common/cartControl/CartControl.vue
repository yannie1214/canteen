<template>
  <div class="cartcontrol"> 
    <transition name="move">
      <div class="iconfont icon-down" v-if="food.count" @click.stop="updateCount(false)"></div> 
    </transition>
    <div class="cart-count" v-if="food.count">{{food.count}}</div> 
    <div class="iconfont icon-add" @click.stop="updateCount(true)"></div> 
  </div>
</template>

<script>
  export default {
    props: {
      food: Object
    },
    methods: {
      updateCount(isAdd) {
        this.$store.dispatch('updateCount', {isAdd, food: this.food})
      }
    },
  }
</script>

<style>
  @import url(assets/css/mixins.css);

  .cartcontrol{
    font-size:0
  }
  .cartcontrol .cart-decrease{
    display:inline-block;
    padding:6px;
    line-height:24px;
    font-size:24px;
    color:#00a0dc
  }
  .cartcontrol .icon-down{
    display:inline-block;
    padding:6px;
    line-height:24px;
    font-size:24px;
    color:#02a774;
  }
  .cartcontrol .move-enter-active,
  .cartcontrol .move-leave-active{
    transition:all .3s
  }
  .cartcontrol .move-enter,
  .cartcontrol .move-leave-to{
    transform:translateX(15px) rotate(180deg);
    opacity:0
  }
  .cartcontrol .cart-count{
    display:inline-block;
    vertical-align:top;
    width:12px;
    padding-top:6px;
    line-height:24px;
    text-align:center;
    font-size:10px;
    color:#93999f
  }
  .cartcontrol .icon-add{
    display:inline-block;
    padding:6px;
    line-height:24px;
    font-size:24px;
    color:#02a774
  }
</style>