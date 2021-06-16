import { request } from './request'

// 要想去请求后台的某个接口，必须调用某一个接口请求函数，下面就是对接口请求函数的封装

// 获取全部菜品
export function getcate() {
  return request({
    method: 'get',
    url: '/getcate.do',
  })
}

// 添加分类
export function addCate(dishes_cname) {
  return request({
    method: 'post',
    url: '/addCate.do',
    params: {
      dishes_cname
    }
  })
}

// 删除分类
export function removecate(id) {
  return request({
    method: 'post',
    url: '/removecate.do',
    params: {
      id
    }
  })
}

// 修改分类
export function modifycate(id, dishes_cname) {
  return request({
    method: 'get',
    url: '/modifycate.do',
    params: {
      id,
      dishes_cname
    }
  })
}
