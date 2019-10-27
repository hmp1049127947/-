var App=function () {
    var  idArray; //定义成员变量，用于存放checkbox的id
    var checkbox; //获取checkbox控件


    /**
     * 获取选中复选框的id
     */
    var getCheckboxIds=function () {
        idArray=new Array();
        checkbox=$('input[type="checkbox"]');
        //获取选中的checkbox的value,value值等于数据库的id的值
        checkbox.each(function () {
            var id =$(this).attr("value");
            if (id != null && id != "undefine" && $(this).is(":checked")) {
                idArray.push(id);
            }
        });
    }

    /**
     *
     * @param url 后台删除数据的url
     */
    var  handlerAjaxData=function (url) {
        $.ajax({
            "url": url,
            "type": "POST",
            "data": {"ids" : idArray.toString()},
            "dataType": "JSON",
            "success": function (data) {
                // 请求成功
                if (data.status === 200) {
                    $.messager.confirm('温馨提示', '删除成功', function(r){
                        if (r){
                            window.location.reload();
                        }
                    });
                }
                // 请求失败
                else {
                    $.messager.alert('温馨提示','删除失败','error');
                }
            }
        });
    }

    /**
     * 如果选中数据，就会执行 handlerAjaxData(url)方法删除数据
     * @param url
     */
    var handlerDelMulti=function (url) {
        getCheckboxIds();
        if (idArray.length > 0) {
            $.messager.confirm('温馨提示', '您确定要删除数据项吗', function(r){
                //如果点击了确认键.就把checkbox的ids提交到后台处理
                if (r){
                    handlerAjaxData(url);
                }
            });
        } else {
            $.messager.alert('温馨提示','您还没有选择任何数据，请至少选择一项!','info');
        }
    }


    /**
     * 如果选中数据，点击修改按钮就会弹出修改数据的页面
     *
     * @param url 加载修改数据的页面
     * @param title  修改数据页面的标题
     * @param width 修改数据页面的宽度
     * @param height 修改数据页面的高度
     * @param shadow true
     */
    var handlerEditUser=function (url, title, width, height, shadow) {
        getCheckboxIds();
        if (idArray.length ==1) {
            url = url + "?id="+idArray.toString();
            console.log(url);
            showEditArea(url, title, width, height, shadow)
        } else {
            $.messager.alert('操作错误', '请选择正确的数据项', 'error');
            $('#dg').datagrid('unselectAll');//清除所有选中项
        }
    }

    /**
     *弹出修改数据的窗口
     *
     * @param url 加载修改数据的页面的url
     * @param title  修改数据页面的标题
     * @param width 修改数据页面的宽度
     * @param height 修改数据页面的高度
     * @param shadow true
     */
    var showEditArea=function (url, title, width, height, shadow) {
            var content = '<iframe src="' + url + '" width="100%" height="99%" frameborder="0" scrolling="no"></iframe>';
            var boarddiv = '<div id="msgwindow" title="' + title + '"></div>'//style="overflow:hidden;"可以去掉滚动条
            $(document.body).append(boarddiv);
            var win = $('#msgwindow').dialog({
                content: content,
                width: width,
                height: height,
                modal: shadow,
                title: title,
                onClose: function () {
                    $(this).dialog('destroy');//后面可以关闭后的事件
                    window.location.reload();
                }
            });
            win.dialog('open');
    }
    

    return{
        delMulti:function (url) {
            handlerDelMulti(url);
        },

        editPerson:function (url, title, width, height, shadow) {
            handlerEditUser(url, title, width, height, shadow);
        }

    }

}();