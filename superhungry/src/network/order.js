import { request } from "./request"
export function showOrder(user_id) {
    return request({

        url: '/showOrder.do',
        method: 'get',
        params: {
            user_id
        },


    })
}