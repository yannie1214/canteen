<template>
  <div class="food" v-if="isShow"> 
    <div class="food-content"> 
      <div class="image-header"> 
        <img :src="food.photo"> 
        <!-- <p class="foodpanel-desc">主、辅料:水、大米、南瓜、冰糖等</p> -->
         <div class="back" @click="toggleShow"> 
           <i class="iconfont icon-back-1"></i> 
         </div> 
      </div> 
      <div class="content"> 
        <h1 class="title">{{food.dishes_name}}</h1>
         <div class="detail">
           <p class="foodpanel-desc">{{food.dishes_describe}}</p>
            <!-- <span class="sell-count">月售 91 份</span> -->
            <!-- <span class="rating">好评率 100%</span>  -->
         </div> 
         <div class="price"> 
           <span class="now">￥{{food.dishes_price}}</span> 
           <!-- <span class="old" style="display: none;">￥</span>  -->
         </div> 
         <div class="cartcontrol-wrapper">
            <cart-control :food="food"></cart-control>
         </div> 
      </div> 
    </div> 
    <div class="food-cover" @click="toggleShow"></div> 
  </div>
</template>

<script>
  import CartControl from 'components/common/cartControl/CartControl'
  
  export default {
    components: { 
      CartControl,
    },
    data () {
      return {
        isShow:false,
      }
    },
    props: {
      food: Object
    },
    methods: {
      toggleShow() {
        this.isShow = !this.isShow
      }
    }
  }
</script>

<style>
  @import url(assets/css/mixins.css);
  .food{
    position:fixed;
    left:0;
    top:0;
    bottom:48px;
    z-index:101;
    width:100%
  }
  .food.fade-enter-active,
  .food.fade-leave-active{
    transition:opacity .5s
  }
  .food.fade-enter,
  .food.fade-leave-to{
    opacity:0
  }
  .food .food-content{
    position:absolute;
    left:50%;
    top:50%;
    transform:translate(-50%,-50%);
    width:80%;
    height:65%;
    z-index:66;
    background:#fff;
    border-radius:5px
  }
  .food .food-content .image-header{
    position:relative;
    width:100%;
    height:0;
    padding-top:100%
  }
  .food .food-content .image-header img{
    position:absolute;
    top:0;
    left:0;
    width:100%;
    height:100%
  }
  /* .food .food-content .image-header .foodpanel-desc{
    font-size:10px;
    color:#ddd;
    letter-spacing:0;
    position:absolute;
    bottom:0;
    left:0;
    right:0;
    padding:0 10px 10px
  } */
  .food .food-content .image-header .back{
    position:absolute;
    top:10px;
    left:0
  }
  .food .food-content .image-header .back .icon-back-1{
    display:block;
    padding:10px;
    font-size:20px;
    color:#fff
  }
  .food .food-content .content{
    position:relative;
    padding:18px
  }
  .food .food-content .content .title{
    line-height:14px;
    margin-bottom:8px;
    font-size:14px;
    font-weight:700;
    color:#07111b
  }
  .food .food-content .content .detail{
    margin-bottom:18px;
    line-height:10px;
    height:10px;
    font-size:0
  }
  .food .food-content .content .detail .sell-count,
  .food .food-content .content .detail .rating,
  .food .food-content .content .detail .foodpanel-desc{
    font-size:10px;
    color:#93999f
  }
  .food .food-content .content .detail .sell-count{
    margin-right:12px
  }
  .food .food-content .content .price{
    font-weight:700;
    line-height:24px
  }
  .food .food-content .content .price .now{
    margin-right:8px;
    font-size:14px;
    color:#f01414
  }
  .food .food-content .content .price .old{
    text-decoration:line-through;
    font-size:10px;
    color:#93999f
  }
  .food .food-content .content .cartcontrol-wrapper{
    position:absolute;
    right:12px;
    bottom:12px
  }
  .food .food-content .content .buy{
    position:absolute;
    right:18px;
    bottom:18px;
    z-index:10;
    height:24px;
    line-height:24px;
    padding:0 12px;
    box-sizing:border-box;
    border-radius:12px;
    font-size:10px;
    color:#fff;
    background:#00a0dc
  }
  .food .food-content .content .buy.fade-transition{
    transition:all .2s;
    opacity:1
  }
  .food .food-content .content .buy.fade-enter,
  .food .food-content .content .buy.fade-leave{
    opacity:0
  }
  .food .food-cover{
    position:absolute;
    top:0;
    right:0;
    bottom:-48px;
    left:0;
    z-index:55;
    background-color:rgba(0,0,0,0.5)
  }
</style>