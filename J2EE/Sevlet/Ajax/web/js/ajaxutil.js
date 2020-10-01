/**
 * ajax封装
 * @param method 请求方式，get或post
 * @param url 请求地址
 * @param data 请求数据，格式"name=value&..."，没有值需要传入null
 * @param deal200 接收一个带有一个形参的js函数对象，形参接收的实参是ajax引擎对象
 * @param deal404 接收一个js函数对象
 * @param deal500 接收一个js函数对象
 * @param async 异步或同步，boolean
 */


function myAjax(method, url, data, deal200, deal404, deal500, async=true) {
    // 创建ajax引擎对象
    var ajax = getAjax();
    // 覆写onreadystatement函数
    ajax.onreadystatechange = function () {
        // 获取元素对象
        let showdiv = document.getElementById("showDiv");
        // 会执行4次,判断ajax状态码，只在数据成功接收时执行以下代码
        if (4 === ajax.readyState) {
            // 判断响应状态码
            if (200 === ajax.status) {
                if (deal200)
                    deal200(ajax);
            } else if (404 === ajax.status) {
                if (deal404)
                    deal404();
            } else if (500 === ajax.status) {
                if (deal500)
                    deal500();
            }
        }
    }
    if ("get" === method) {
        // 发送请求
        ajax.open("get", url + (data === null ? "" : "?" + data), async); // false同步，true异步
        ajax.send(null);
    } else if ("post" === method) {
        ajax.open("post", url, async);
        ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        ajax.send(data);
    }
}

/*ajax的封装*/
function getAjax() {
    var ajax;
    if (window.XMLHttpRequest) {  // firefox
        ajax = new XMLHttpRequest();
    } else if (window.ActiveXObject) { // ie
        ajax = new ActiveXObject("Msxml2.XMLHTTP");
    }
    return ajax;
}