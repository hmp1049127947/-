<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="url" type="java.lang.String" required="true" description="获取数据的url"%>
<%@ attribute name="name" type="java.lang.String" required="true" description="组合框的name"%>
<%@ attribute name="valueField" type="java.lang.String" required="true" description="组合框的valueField"%>
<%@ attribute name="textField" type="java.lang.String" required="true" description="组合框的textField"%>
<%@ attribute name="prompt" type="java.lang.String" required="false" description="组合框的提示"%>
<%@ attribute name="validation" type="java.lang.Boolean" required="true" description="组合框的验证"%>
<%@ attribute name="type" type="java.lang.String" required="false" description="获取数据的方式"%>
<%@ attribute name="value" type="java.lang.String" required="false" description="组合框的值"%>

<input class="easyui-combobox"
       name="${name}",
	   editable="false"
       data-options="
      				value:'${value}',
                    required:${validation},
                    prompt:${prompt==null}?'请选择数据':'${prompt}',
					url:'${url}',
					method:${type==null}?'get':'${type}',
					valueField:'${valueField}',
					textField:'${textField}',
					panelHeight:'auto'
			">
