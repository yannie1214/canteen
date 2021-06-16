import { request } from './request'

// 要想去请求后台的某个接口，必须调用某一个接口请求函数，下面就是对接口请求函数的封装

// 展示所有菜品
export function showAll() {
  return request({
    // url: '/hungry/meal/goods'
    url: '/showAll.do'
  })
}

// 展示分类菜品
export function showType(dishes_cname) {
  return request({
    // url: '/hungry/meal/category',
    url: '/showType.do',
    params: {
      dishes_cname
    }
  })
}

