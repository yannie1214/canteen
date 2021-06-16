import axios from 'axios'
export function request(config) {
    const instance = axios.create({
        // baseURL: 'http://123.60.33.16:8080/Hungry',
        baseURL: 'http://124.71.155.172:8080/Hungry',
        // timeout: 15000
    })
    // 添加请求拦截器，在请求头中加token
    instance.interceptors.request.use(
        config => {
            if (localStorage.getItem('Authorization')) {
                config.headers.token = localStorage.getItem('Authorization');
            }

            return config;
        },
        error => {
            return Promise.reject(error);
        });

    instance.interceptors.response.use(res => {
        return res.data
    }, err => {
        console.log(err);
    })

    return instance(config)
}