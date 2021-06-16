import { request } from "./request"
export function sumbit(assessment, id) {
    return request({
        url: '/assess.do',
        params: {
            assessment,
            id

        },
        method: 'get',
        dataType: 'jsonp',
    })
}