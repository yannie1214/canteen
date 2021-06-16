export default {
    userInfo: {}, //用户信息
    Authorization: localStorage.getItem('Authorization') ? localStorage.getItem('Authorization') : '',
    cnames: '粤菜',
    goods: [],  //菜品数组
    categorys: [],  //菜品分类数组
    cartFoods: []   //购物车中菜品的数组列表
}

