<%--
  Created by IntelliJ IDEA.
  User: liuxiwen
  Date: 2017/4/6
  Time: 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/public/head.jspf" %>
    <style type="text/css">
        form div {
            margin: 5px;
        }
    </style>
    <script type="text/javascript">
        $(function () {
            // iframe中的datagrid对象
            var dg = parent.$('iframe[title="类别管理"]').get(0).contentWindow.$('#dg');
            // 对管理员的下拉列表框进行远程加载
            $('#cc').combobox({
                // 将请求发送给accountAction中的query方法，这里需要将处理好的数据返回到这边来显示，所以后台需要将数据打包成json格式发过来
                url: 'account_query.action',
                valueField: 'id',
                textField: 'login',// 下拉列表中显示的是管理员的登录名
                panelHeight: 'auto',// 自适应高度
                panelWidth: 120,// 下拉列表是两个组件组成的
                width: 120,// 要同时设置两个宽度才行
                editable: false// 下拉框不允许编辑
            });
            // 完成数据回显，更新时，用户肯定先选择了要更新的那一行，首先得拿到那一行
            var rows = dg.datagrid("getSelections");
            // 将拿到的那一行对应的数据字段加载到表单里，实现回显
            $('#ff').form('load', {
                id: rows[0].id,
                type: rows[0].type,
                hot: rows[0].hot,
                'account.id': rows[0].account.id//easyui不支持account.id这种点操作，所以要加个引号
            });
            // 回显数据后，设置一下验证功能
            $('input[name=type]').validatebox({
                required: true,
                missingMessage: '请输入类别名称'
            });
            // 窗体弹出时默认禁用验证
            $('#ff').form('disableValidation');
            // 注册button事件
            $('#btn').click(function () {
                // 开启验证
                $('#ff').form('enableValidation');
                // 如果验证成功，则提交数据
                if ($('#ff').form('validate')) {
                    // 调用submit方法提交数据
                    $('#ff').form('submit', {
                        url: 'category_update.action',// 提交时将请求传给categoryAction的update方法执行
                        success: function () {
                            // 如果成功了，关闭当前窗口，并刷新页面
                            parent.$('#win').window('close');
                            dg.datagrid('reload');
                        }
                    });
                }
            });
        });
    </script>
</head>
<body>
    <form id="ff" method="post">
        <div>
            <label for="name">类别名称：</label>
            <input type="text" name="type" id="name" />
        </div>
        <div>
            <label for="hot">热点：</label>
            是<input type="radio" name="hot" value="true" id="hot" />
            否<input type="radio" name="hot" value="false" />
        </div>
        <div>
            <label>所属管理员：</label>
            <input id="cc" name="account.id" />
        </div>
        <div>
            <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls: 'icon-edit'">更新</a>
            <input type="hidden" name="id" />
        </div>
    </form>
</body>
</html>
