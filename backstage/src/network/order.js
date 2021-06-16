import { request } from './request'

// 要想去请求后台的某个接口，必须调用某一个接口请求函数，下面就是对接口请求函数的封装

// 获取全部菜品
export function showAllOrder() {
  return request({
    method: 'get',
    url: '/showAllOrder.do',
  })
}
