import {
  INITROUTES,
  RECEIVE_USER_INFO,
} from './mutations.types'

export default {
  [INITROUTES](state, {routes}) {
    state.routes = routes
  },
  [RECEIVE_USER_INFO](state, {userInfo}) {
    state.userInfo = userInfo
  },
}
