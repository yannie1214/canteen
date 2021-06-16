import { request } from "./request"
export function edit(user_id, password, phone, username) {
    return request({
        url: '/modifyUser.do',
        params: {
            user_id,
            password,
            phone,
            username,

        },
        method: 'get',
        dataType: 'jsonp',
    })
}