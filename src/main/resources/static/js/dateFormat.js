function formatSeconds(mss) {
    var days = parseInt(mss / ( 60 * 60 * 24));
    var hours = parseInt((mss % ( 60 * 60 * 24)) / (60 * 60));
    var minutes = parseInt((mss % ( 60 * 60)) /  60);
    var seconds = (mss % 60);
    return days + " 天 " + hours + " 小时 " + minutes + " 分钟 " + seconds + " 秒 ";
}