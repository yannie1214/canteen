<template>
  <div>
    <div style="display: flex; justify-content: space-between">
      <!-- <div>
        <el-input prefix-icon="el-icon-search" 
                placeholder="请输入订单信息进行搜索..."
                style="width: 300px; margin-right: 10px"></el-input>
        <el-button icon="el-icon-search" type="primary" size="default" @click="">搜索</el-button>
      </div> -->
    </div>
    <div>
      <el-table
        :data="order"
        stripe
        border
        style="width: 100%">
        <!-- <el-table-column
          type="selection"
          width="60">
        </el-table-column> -->
        <el-table-column
          prop="user_id"
          label="用户ID"
          align="left"
          fixed="left"
          width="90">
        </el-table-column>
        <el-table-column
          prop="order_code"
          label="订单编号"
          align="left"
          width="250">
        </el-table-column>
        <el-table-column
          prop="create_date"
          label="下单日期"
          align="left"
          width="150">
        </el-table-column>
        <el-table-column
          prop="amount"
          align="left"
          width="90"
          label="订单总价">
        </el-table-column>
        <el-table-column
          prop="items[0].order_id"
          align="left"
          width="90"
          label="订单ID">
        </el-table-column>
        <el-table-column
          prop="items[0].order_num"
          align="left"
          width="90"
          label="订单数量">
        </el-table-column>
        <el-table-column
          prop="items[0].dishes.dishes_id"
          align="left"
          width="100"
          label="菜品ID">
        </el-table-column>
        <el-table-column
          prop="items[0].dishes.dishes_name"
          align="left"
          width="100"
          label="菜品名称">
        </el-table-column>
        <el-table-column
          prop="items[0].dishes.dishes_price"
          align="left"
          width="100"
          label="菜品价格">
        </el-table-column>
        <el-table-column
          prop="items[0].dishes.dishes_describe"
          align="left"
          width="100"
          label="菜品描述">
        </el-table-column>
        <el-table-column
          prop="items[0].dishes.dishes_cname"
          align="left"
          width="100"
          label="菜品分类">
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
  import {showAllOrder} from 'network/order'

  export default {
    data () {
      return {
        order: [],
        dishes: [],
      }
    },
    mounted () {
      this.initOrder()
    },
    methods: {
      initOrder() {
        showAllOrder().then(res => {
          // console.log(res);
          if(res) {
            this.order = res
            this.dishes = res.item
          }
        })
      },
    },
  }
</script>

<style>

</style>