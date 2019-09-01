/**
 * 账户名验证
 * @param account
 * @returns {boolean}
 */
function verifyaccount(account) {
    var regax=/^[a-zA-Z][a-zA-Z0-9_]{4,15}$/;
    if (!regax.test(account)){
        // console.log("456252");
        return true;
    }else{
        return false;
    }
}

/**
 * 密码验证
 * @param password
 * @returns {boolean}
 */
function verifyPassword(password) {
    var regax=/^[a-zA-Z]\w{5,17}/;
    if(!regax.test(password)){
        return true;
    }else{
        return false;
    }
}

/**
 * 验证联系方式
 * @param phone
 * @returns {boolean}
 */
function verifyphone(phone) {
    var regax=/^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
    if(!regax.test(phone)){
        return true;
    }else{
        return false;
    }
}

/**
 * 验证邮箱
 * @param email
 * @returns {boolean}
 */
function verifyemail(email) {
    var regax=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
    if(!regax.test(email)){
        return true;
    }else{
        return false;
    }
}

/**
 * 验证信息是否为空
 * @param verifyvalue
 * @returns {boolean}
 */
function verifynull(verifyvalue) {
    if (verifyvalue!=''){
        return false;
    }else{
        return true;
    }
}