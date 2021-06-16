import {
  RECEIVE_USER_INFO,
} from './mutations.types';

export default {
  // 同步记录登录的用户信息
  recordUser({commit}, userInfo) {
    commit(RECEIVE_USER_INFO, {userInfo})
  }
}
