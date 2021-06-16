<template>
  <div>
    system
    <el-button type="primary" size="default" @click="test">点我测试</el-button>
    
  </div>
</template>

<script>
  import {showType} from 'network/system'

  export default {
    methods: {
      test() {
        showType().then(res => {
          console.log(res);
        })
      }
    }
  }
</script>

<style>

</style>