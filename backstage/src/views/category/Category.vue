<template>
  <div>
    <div style="display: flex; justify-content: space-between">
      <!-- <div>
        <el-input prefix-icon="el-icon-search" 
                  placeholder="请输入菜品分类进行搜索..."
                  style="width: 300px; margin-right: 10px"></el-input>
        <el-button icon="el-icon-search" type="primary" size="default" @click="">搜索</el-button>
      </div> -->
      <div>
        <el-button type="primary" size="default" @click="showAddCate" class="el-icon-plus">添加分类</el-button>
      </div>
    </div>
    <div>
      <el-table
        :data="cates"
        stripe
        border
        style="width: 100%">
        <!-- <el-table-column
          type="selection"
          width="55">
        </el-table-column> -->
        <el-table-column
          prop="dishes_cid"
          label="分类ID"
          align="left"
          width="85">
        </el-table-column>
        <el-table-column
          prop="dishes_cname"
          label="分类名称"
          align="left"
          width="100">
        </el-table-column>
        <el-table-column
          label="操作"
          width="150">
          <template slot-scope="scope">
            <el-button style="padding: 5px" type="primary" size="default" @click="showEditCate(scope.row)">编辑</el-button>
            <el-button style="padding: 5px" type="danger" size="default" @click="deleteCate(scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <el-dialog
      :title="title"
      :visible.sync="dialogVisible"
      width="50%">
      <div>
        <el-form label-width="100px" :model="category" ref="cateForm" :rules="cateRules">
          <el-form-item label="分类名称:" prop="dishes_cname">
            <el-input v-model="category.dishes_cname" prefix-icon="el-icon-edit" placeholder="请输入分类名称"></el-input>
          </el-form-item>
        </el-form>
      </div>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="doCate(category)">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
  import {getcate, addCate, removecate, modifycate} from 'network/cate'

  export default {
    data () {
      return {
        // 所有分类的数据
        cates: [],  
        dialogVisible: false,
        title: '',
        category: {
          dishes_cid: null,
          dishes_cname: ''
        },
        cateRules: {
          dishes_cname: [
            {required: true, message: '请输入分类名称', trigger: 'blur'}
          ],
        },
      }
    },
    mounted () {
      this.initCate()
    },
    methods: {
      initCate() {
        getcate().then(res => {
          // console.log(res);
          if(res) {
            this.cates = res
          }
        })
      },
      showAddCate() {
        this.title = '添加分类'
        this.dialogVisible = true
        this.category = {
          dishes_cid: null,
          dishes_cname: ''
        }
      },
      doCate(category) {
        // 如果存在 dishes_cid 则说明是更新表单，否则是添加分类
        if (this.category.dishes_cid) {
          this.$refs.cateForm.validate((valid) => {
            if(valid) {
              // console.log(typeof category.dishes_cname);
              modifycate( category.dishes_cid, category.dishes_cname).then(res => {
                // console.log(res);
                if(res) {
                  this.dialogVisible = false
                  this.initCate()
                }
              })
            }
          })
        }else {
          this.$refs.cateForm.validate((valid) => {
            if(valid) {
              addCate( category.dishes_cname).then(res => {
                // console.log(res);
                if(res) {
                  this.dialogVisible = false
                  this.initCate()
                }
              })
            }
          })
        }
      },
      deleteCate(data) {
        this.$confirm('此操作将永久删除分类'+ data.dishes_cname +', 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          // 删除分类
          removecate(data.dishes_cid).then(res => {
            // console.log(res);
            if(res) {
              this.initCate()
            }
          })
          this.$message({
            type: 'success',
            message: '删除成功!'
          });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });          
        });
      },
      showEditCate(data) {
        this.title = '编辑分类信息'
        this.dialogVisible = true
        this.category = data
      }
    },
  }
</script>

<style>

</style>