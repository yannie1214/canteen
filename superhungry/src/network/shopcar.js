import { request } from "./request"
export function showcar(user_id) {
    return request({
        url: '/showCart.do',
        params: {
            user_id
        },
        method: 'get',
        dataType: 'jsonp',
    })
}