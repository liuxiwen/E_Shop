<%--
  Created by IntelliJ IDEA.
  User: liuxiwen
  Date: 2017/3/29
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/public/head.jspf"%>
    <script type="text/javascript">
        $(function () {
            $('#dg').datagrid({
                // 请求数据的url地址
                url: 'category_queryJoinAccount.action',
                loadMsg: 'Loading......',
                queryParams: {type: ''},// 传给后台的参数
                fitColumns: true,// 水平自动展开，如果设置此属性，则不会有水平滚动条，演示冻结列时，该参数不要设置
                striped: true,// 显示斑马线
                nowrap: true,// 数据多时不换行
                singleSelect: true,// 如果为真，只允许勾选当行，全选功能失效
                pagination: true,// 设置分页
                rowStyler: function (index, row) {
                    if (index % 2 == 0) {
                        return 'background-color: #fff;';
                    } else {
                        return 'background-color: #c4e1e1;';
                    }
                },
                // 同列属性，但是这些列将会冻结在左侧，大小不会改变，当宽度大于250时，会显示滚动条，但是冻结的列不在滚动条内
                frozenColumns: [[
                    {field: 'checkbox', checkbox: true},
                    {field: 'id', title: '编号', width: 200}
                ]],
                // 配置datagrid的列字段，field：列字段的名称，与json的key捆绑，title：列标题，是显示给人看的
                columns: [[
                    {
                        field: 'type', title: '类别名称', width: 100,
                        // 用来格式化当前列的值，返回的是最终结果
                        formatter: function (value, row, index) {
                            return '<span title=' + value + '>' + value + '</span>';
                        }
                    },
                    {
                        field: 'hot', title: '热卖', width: 100,
                        formatter: function (value, row, index) {
                            if (value) {// 如果是hot，该值为true，value是boolean类型
                                return "<input type='checkbox' checked='checked' disabled='true'";// 勾选
                            } else {
                                return "<input type='checkbox' disabled='true'";// 不勾选
                            }
                        }
                    },
                    {
                        field: 'account.login', title: '所属管理员', width: 200,// account.login管理员登录名
                        formatter: function (value, row, index) {
                            if (row.account != null && row.account.login != null) {
                                return row.account.login;// 如果登录名不为空，显示登录名
                            } else {
                                return "此类别没有管理员";
                            }
                        }
                    }
                ]]
            });
        });
    </script>
</head>
<body>
    <table id="dg"></table>
</body>
</html>
