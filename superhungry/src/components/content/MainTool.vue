<!--  -->
<template>
  <div>
    <tool>
      <tool-item path="/settings">
        <img src="../../assets/img/usertool/settings.svg" slot="tool-img" />
        <span slot="tool-name">设置</span>
        <img src="../../assets/img/usertool/start.svg" slot="tool-go" />
      </tool-item>
      <tool-item path="/csd">
        <img src="../../assets/img/usertool/csd.svg" slot="tool-img" />
        <span slot="tool-name">关于</span>
        <img src="../../assets/img/usertool/start.svg" slot="tool-go" />
      </tool-item>

      <tool-item path="/order">
        <img src="../../assets/img/usertool/order.svg" slot="tool-img" />
        <span slot="tool-name">我的订单</span>
        <img src="../../assets/img/usertool/start.svg" slot="tool-go" />
      </tool-item>
      <tool-item path="/user">
        <img src="../../assets/img/usertool/userprofile.svg" slot="tool-img" />
        <span slot="tool-name">个人资料</span>
        <img src="../../assets/img/usertool/start.svg" slot="tool-go" />
      </tool-item>
      <router-view></router-view>
    </tool>
  </div>
</template>

<script>
import Tool from "components/content/user/Tool";
import ToolItem from "components/content/user/ToolItem";
export default {
  data() {
    return {};
  },
  components: {
    Tool,
    ToolItem,
  },
};
</script>

<style  scoped>
</style>
