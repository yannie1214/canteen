<!--  -->
<template>
  <div>
    <swiper>
      <swiper-item v-for="item in homemess">
        <a href="#">
          <img :src="item.photo" alt="" />
        </a>
      </swiper-item>
    </swiper>
  </div>
</template>

<script>
import { Swiper, SwiperItem } from "components/common/swiper/index";
export default {
  props: {
    homemess: {
      type: Array,
      default() {
        return [];
      },
    },
  },
  data() {
    return {};
  },
  components: {
    Swiper,
    SwiperItem,
  },
};
</script>

<style  scoped>
img {
  width: 100%;
  height: 160px;
}
</style>
