import { request } from './request'

// 要想去请求后台的某个接口，必须调用某一个接口请求函数，下面就是对接口请求函数的封装

// 登录
export function login(phone, password, identity) {
  return request({
    method: 'get',
    url: '/login.do',
    params: {
      phone: phone,
      password: password,
      identity: identity
    }
  })
}

// 退出登录
export function logout() {
  return request({
    method: 'post',
    url: '/logout.do',
  })
}

