import { request } from './request'

// 要想去请求后台的某个接口，必须调用某一个接口请求函数，下面就是对接口请求函数的封装

// 获取全部菜品
export function dishes() {
  return request({
    method: 'get',
    url: '/dishes.do',
  })
}

// 获取所有的菜品分类
export function getcate() {
  return request({
    method: 'get',
    url: '/getcate.do',
  })
}

// 提交添加菜品的表单
export function toAddDish(price, dishes_name, dishes_describe, photo, dishes_cname) {
  return request({
    method: 'post',
    url: '/adddishes.do',
    params: {
      price,
      dishes_name,
      dishes_describe,
      photo,
      dishes_cname
    },
  })
}


// 搜索菜品
export function findByWord(word) {
  return request({
    method: 'post',
    url: '/findByWord.do',
    params: {
      word
    }
  })
}

// 上传图片
export function upload(photo) {
  return request({
    method: 'post',
    url: '/upload.do',
    params: {
      photo
    },
  })
}

// 下架菜品
export function removedishes(id) {
  return request({
    method: 'post',
    url: '/removedishes.do',
    params: {
      id
    },
  })
}

// 修改菜品
export function modifydishes(dishes_id, price, name, describe, cname, photo) {
  return request({
    method: 'post',
    url: '/modifydishes.do',
    params: {
      dishes_id,
      price,
      name,
      describe,
      cname,
      photo
    },
  })
}

