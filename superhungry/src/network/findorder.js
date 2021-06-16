import { request } from "./request"
export function findOrderItem(order_id) {
    return request({
        url: '/findOrderItem.do',
        params: {
            order_id
        },
        method: 'get',

    })
}