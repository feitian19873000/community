<%@ page language="java" pageEncoding="UTF-8"%>  
<%@taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%> 

<!-- 每个标签可以导出的值参见文档 ，没有的可以用export导出 ,但用export的值也有规定-->   
<pg:pager items="1000" maxPageItems="10" maxIndexPages="10" export="number" url="${path}/base/login"><!-- export可以使用表达式: curpage=number，这样 curpage就相当于number -->   
    <pg:first>  
        <a href="${pageUrl}">首页[<%=pageNumber %>]</a><!-- pageNumber导出当前页的值 -->  
    </pg:first>  
    <pg:prev>  
        <a href="<%=pageUrl %>">上一页</a>     
    </pg:prev>  
    <pg:pages>  
    <%if(number==pageNumber){ %>  
        [<%=pageNumber %>]  
    <%} else { %>  
        <a href="<%=pageUrl %>">[<%=pageNumber %>]</a> <!-- pageUrl pageNumber导出值 -->  
    <%} %>  
    </pg:pages>  
    <pg:next>  
        <a href="<%=pageUrl %>">下一页</a>  
    </pg:next>  
    <pg:last>  
        <a href="<%=pageUrl%>">尾页</a>  
    </pg:last>  
</pg:pager>

