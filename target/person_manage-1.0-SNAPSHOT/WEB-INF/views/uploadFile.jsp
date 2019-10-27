<%--
  Created by IntelliJ IDEA.
  User: 黄明潘
  Date: 2019/10/5
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/static/easyUpload/main.css">
    <style>
        html * {
            margin: 0;
            padding: 0;
        }
    </style>
</head>
<body>
<div id="uploader" style="padding: 10px"></div>

<script src="/static/easyUpload/easyUploader.jq.js"></script>
<script>
    var uploader = easyUploader({
        id: "uploader",
        accept: '.jpg,.png,.doc,.docx',
        action: '/file/uploadMul',
        dataFormat: 'formData',
        successKey: 'status', /* 标识上传成功的key */
        maxCount: 10,
        maxSize: 3,
        multiple: true,
        data: null,
        beforeUpload: function(file, data, args) {
            /* dataFormat为formData时配置发送数据的方式 */
            data.append('token', '387126b0-7b3e-4a2a-86ad-ae5c5edd0ae6TT');
            data.append('otherKey', 'otherValue');

            /* dataFormat为base64时配置发送数据的方式 */
            // data.base = file.base;
            // data.token = '387126b0-7b3e-4a2a-86ad-ae5c5edd0ae6TT';
            // data.otherKey = 'otherValue';
        },
        onChange: function(fileList) {
            /* input选中时触发 */
        },
        onRemove: function(removedFiles, files) {
            console.log('onRemove', removedFiles);
        },
        onSuccess: function(res) {
            console.log('onSuccess', res);

            /**
             * 注意，接口调通不代表视图会展示成功，接口调通时视图要展示成功需要满足以下两点条件
             * 1. 返回数据必须由对象包裹，如 { code: 200, data: null }
             * 2. 必须有一个用于标识成功状态的属性，默认属性是code，默认成功属性值是200，配置项分别对应successKey和successValue，可视情况自行配置
             */

            /**
             * 可以在onSuccess/onError等回调函数中通过实例的files属性可以访问上传文件，如 var files = uploader.files; console.log一下就会发现files数组中每个元素由以下属性构成
             * 1. ajaxResponse: ajax的的响应结果
             * 2. base: 文件的base64编码
             * 3. checked: 该文件是否被选中
             * 4. file: 文件对象
             * 5. id: 插件内部标识的文件id
             * 6. isImg: 插件内部标识文件时否是图片
             * 7. previewBase: 文件压缩后的base64编码，用于插件内部展示预览图
             * 8. uploadPercentage: 文件上传进度百分比值
             * 9. uploadStatus: 文件上传状态
             */
        },
        onError: function(err) {
            console.log('onError', err);
        },
    });
</script>
</body>
</html>
