import { request } from "./request"
export function saveorder(totalAmount, dishesInfo, user_id) {
    return request({
        url: '/saveOrder.do',
        params: {
            totalAmount,
            dishesInfo,
            user_id

        },
        method: 'get',
        dataType: 'jsonp',
    })
}