import { request } from "./request"
export function login(phone, password, identity) {
    return request({
        url: '/login.do',
        params: {
            phone: phone,
            password: password,
            identity: 'customer'
        },
        method: 'get',

    })
}