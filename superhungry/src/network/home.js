import { request } from "./request"

export function getHomedata() {
    return request({
        url: '/recommend.do',

        method: 'get',
    })
}