<template>
  <div>
    <div style="display: flex; justify-content: space-between">
      <div>
        <el-input prefix-icon="el-icon-search" 
                placeholder="请输入菜品信息进行搜索..."
                style="width: 300px; margin-right: 10px"
                v-model="dish.dishes_name"></el-input>
        <el-button icon="el-icon-search" type="primary" size="default" @click="findByWord">搜索</el-button>
      </div>
      <div>
        <el-button type="primary" size="default" @click="showAddDish" class="el-icon-plus">添加菜品</el-button>
      </div>
    </div>
    <div>
      <el-table
          :data="dishes"
          stripe
          border
          v-loading="loading"
          element-loading-text="拼命加载中"
          element-loading-spinner="el-icon-loading"
          element-loading-background="rgba(0, 0, 0, 0.8)"
          style="width: 100%">
          <!-- <el-table-column
            type="selection"
            width="55">
          </el-table-column> -->
          <el-table-column
            prop="dishes_id"
            label="菜品ID"
            align="left"
            width="85">
          </el-table-column>
          <el-table-column
            prop="dishes_name"
            label="菜品名称"
            fixed="left"
            align="left"
            width="200">
          </el-table-column>
          <el-table-column
            prop="dishes_cname"
            label="分类名称"
            align="left"
            width="100">
          </el-table-column>
          <el-table-column
            prop="dishes_price"
            label="价格"
            align="left"
            width="85">
          </el-table-column>
          <el-table-column
            prop="dishes_describe"
            label="描述"
            align="left"
            width="360">
          </el-table-column>
          <el-table-column
            label="操作"
            fixed="right"
            width="220">
            <template slot-scope="scope">
              <el-button style="padding: 5px" type="primary" size="default" @click="showEditMeal(scope.row)">编辑</el-button>
              <el-button style="padding: 5px" type="danger" size="default" @click="deleteMeal(scope.row)">删除</el-button>
            </template>
          </el-table-column>
      </el-table>
    </div>
    <div>
      <el-dialog
        :title="title"
        :visible.sync="dialogVisible"
        width="50%">
        <div>
          <el-form :label-position="labelPosition" label-width="100px" :model="dish" ref="mealForm" :rules="rules">
            <el-form-item label="菜品名称:" prop="dishes_name">
              <el-input v-model="dish.dishes_name" prefix-icon="el-icon-edit" placeholder="请输入菜品名称"></el-input>
            </el-form-item>
            <el-form-item label="菜品描述:" prop="dishes_describe">
              <el-input v-model="dish.dishes_describe" prefix-icon="el-icon-edit" placeholder="请输入菜品描述"></el-input>
            </el-form-item>
            <el-form-item label="菜品价格:" prop="dishes_price">
              <el-input v-model="dish.dishes_price" prefix-icon="el-icon-edit" placeholder="请输入菜品价格"></el-input>
            </el-form-item>
            <el-form-item label="菜品分类:" prop="dishes_cname">
              <el-select v-model="dish.dishes_cname" placeholder="请选择">
                <el-option
                  v-for="(item, index) in category"
                  :key="item.dishes_cid"
                  :label="item.dishes_cname"
                  :value="item.dishes_cname">
                </el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="菜品图片" prop="photo">
              <el-upload
                class="upload-demo"
                action="/upload.do"
                name="photo"
                :before-upload="handleBeforeUpload"
                :before-remove="beforeRemove" 
                :file-list="fileList"
                :on-success="handleSuccess"
                list-type="picture"
                v-model="dish.photo">
                <img width="100%" :src="dish.photo" alt="">
                <el-button size="small" type="primary">点击上传</el-button>
              </el-upload>
            </el-form-item>
          </el-form>
        </div>
        <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="doDish(dish)">确 定</el-button>
        </span>
      </el-dialog>
    </div>
  </div>
</template>

<script>
  import {dishes, getcate, toAddDish, findByWord, removedishes, modifydishes} from 'network/meal'

  export default {
    data() {
      return {
        loading:false,
        dialogVisible: false,
        labelPosition: 'right',
        dish: {
          dishes_id: null,
          dishes_price: null,
          dishes_name: '',
          dishes_describe: '',
          photo: '',
          dishes_cname: ''
        },
        category: [],
        // 所有菜品的数组
        dishes: [],
        fileList: [],
        searchValue: {
          dishes_name: '',
        },
        title: '',
        rules: {
          dishes_price: [
            {required: true, message: '请输入菜品价格', trigger: 'blur'}
          ],
          dishes_name: [
            {required: true, message: '请输入菜品名称', trigger: 'blur'}
          ],
          dishes_describe: [
            {required: true, message: '请输入菜品描述信息', trigger: 'blur'}
          ],
          dishes_cname: [
            {required: true, message: '请输入分类名称', trigger: 'blur'}
          ],
        }
      }
    },
    mounted () {
      this.initMeals()
      this.getcate()
    },
    methods: {
      // 获取所有菜品
      initMeals() {
        this.cloading = true
          dishes().then(res => {
            // console.log(res);
            this.cloading = false
            if(res) {
              this.dishes = []
              for (let i = 0; i < res.length; i++) {
                this.dishes.push(res[i]);
              }
            }
          })
      },
      findByWord() {
        this.cloading = true
          if(this.dish.dishes_name == '') {
            // alert("搜索不能为空！")
            this.initMeals()
          }else {
            findByWord(this.dish.dishes_name).then(res => {
              // console.log(res);
              this.cloading = false
              if(res) {
                this.dishes = res;
              }
            })
          }
      },
      showAddDish() {
        this.title = '添加菜品'
        this.dialogVisible = true
        this.dish = {
          dishes_id: null,
          dishes_price: null,
          dishes_name: '',
          dishes_describe: '',
          photo: '',
          dishes_cname: ''
        }
      },
      getcate() {
        getcate().then(res => {
          // console.log(res);
          if (res) {
            this.category = res
          }
          // console.log(this.category);
        })
      },
      doDish(dish) {
        // 如果存在 dishes_id 则说明是更新表单，否则是添加菜品
        if (this.dish.dishes_id) {
          // console.log(dish.photo);
          this.$refs.mealForm.validate((valid) => {
            if(valid) {
              modifydishes(dish.dishes_id, dish.dishes_price, dish.dishes_name, dish.dishes_describe, dish.dishes_cname, dish.photo).then(res => {
                // console.log(res);
                // console.log(dish.photo);
                if(res) {
                  this.dialogVisible = false
                  this.initMeals()
                }
              })
            }
          })
        }else {
          this.$refs.mealForm.validate((valid) => {
            if(valid) {
              toAddDish(dish.dishes_price, dish.dishes_name, dish.dishes_describe, dish.photo, dish.dishes_cname).then(res => {
                // console.log(res);
                if(res) {
                  this.dialogVisible = false
                  this.initMeals()
                }
              })
            }
          })
        }
        
      },
      beforeRemove(file, fileList) {
			  return this.$confirm(`确定移除 ${ file.name }？`);
      },
      handleUploadError(error, file) {
        console.log("文件上传出错："+error)
          // this.$notify.error({
          //          title: 'error',
          //          message: '上传出错:' +  error,
          //          type: 'error',
          //          position: 'bottom-right'
          //        })
      },
      //测试上传文件(注意web的上下文)
      handleBeforeUpload(file){
        // console.log("开始上传，上传的文件为："+file)
        // console.log(file);
        const isJPG = file.type === 'image/jpeg';
        const isGIF = file.type === 'image/gif';
        const isPNG = file.type === 'image/png';
        const isBMP = file.type === 'image/bmp';
        const isLt2M = file.size / 1024 / 1024 < 2;

        if (!isJPG && !isGIF && !isPNG && !isBMP) {
            this.$message.error('上传图片必须是JPG/GIF/PNG/BMP 格式!');
        }
        if (!isLt2M) {
            this.$message.error('上传图片大小不能超过 2MB!');
        }
        return (isJPG || isBMP || isGIF || isPNG) && isLt2M;
      },
      //文件上传成功的钩子函数
      handleSuccess(res, file) {
        // console.log(res);
        this.$message({
            type: 'info',
            message: '图片上传成功',
            duration: 6000
        });
        if (file.status) {
          // console.log(file);
          // console.log(file.name);
          this.dish.photo = file.name; //将返回的文件储存路径赋值picture字段
        }
      },
      deleteMeal(data) {
        this.$confirm('此操作将永久删除菜品'+ data.dishes_name +', 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          // 删除菜品
          removedishes(data.dishes_id).then(res => {
            // console.log(res);
            if(res) {
              this.initMeals()
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
      showEditMeal(data) {
        this.title = '编辑菜品'
        this.dialogVisible = true
        this.dish = data
      }
    },
  }
</script>

<style>

</style>