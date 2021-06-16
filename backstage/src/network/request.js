import axios from 'axios'
import { Message } from 'element-ui';
import router from '../router/index'

export function request(config) {
  // 1.创建axios的实例
  const instance = axios.create({
    // baseURL: 'http://123.60.33.16:8080/Hungry',
    baseURL: 'http://124.71.155.172:8080/Hungry',
    // baseURL: '/Hungry',
    // timeout: 5000
  })

  // 2.axios的拦截器
  // 2.1.请求拦截的作用
  instance.interceptors.request.use(config => {
    // console.log(config);
    // 如果存在 token ，请求携带这个 token
    if (window.localStorage.getItem('token')) {
      // console.log(window.localStorage.getItem('token'));
      config.headers['token'] = window.localStorage.getItem('token')
      // config.headers['Content-Type'] = application/x-www-form-urlencoded
    }
    return config
  }, err => {
    console.log(err);
  })

  // 2.2.响应拦截
  // 这里的成功表示不是能够返回成功的内容，而是说你可以成功的调用后端的接口
  instance.interceptors.response.use(res => {
    // console.log(res);
    // 业务逻辑错误
    // 404, “Not Found”
    // 400, “Bad Request” 错误请求
    // 403, “Forbidden”禁止
    // 401, “unauthorized”无权限
    // 500, “Server Internal Error”服务器错误
    // 1001,”customer Error” 重新登录
    if (res.status && res.status == 200) {
      if (res.data.code == 500 || res.data.code == 1001 || res.data.code == 403 || res.data.code == 400) {
        Message.error({ message: res.data.message })
        return;
      }
      if (res.data.message) {
        Message.success({message: res.data.message})
      }
    }
    return res.data
  }, err => {
    // console.log(err);
    // console.log(err.response.status);
    if (err.response.status == 500) {
      Message.error({message: '服务器被吃了(づ￣ ³￣)づ'})
    } else if (err.response.status == 401) {
      Message.error({message: '权限不足(づ￣ ³￣)づ'})
    }else if (err.response.status == 404) {
      Message.error({message: '找不到页面(づ￣ ³￣)づ'})
    }else if (err.response.status == 1001) {
      Message.error({ message: '请重新登录！' })
      router.replace('/')
    } else {
      if (err.response.data.message) {
        Message.error({message: err.response.data.message})
      } else {
        Message.error({message: '未知错误！'})
      }
    }
    return;
  })

  // 3.发送真正的网络请求
  return instance(config)
}
