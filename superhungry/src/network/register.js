import { request } from "./request"
export function register(username, password, phone, identity) {
    return request({
        url: '/register.do',
        params: {

            username: username,
            password: password,
            phone: phone,
            identity: identity
        },
        method: 'get',
        dataType: 'jsonp',
    })
}