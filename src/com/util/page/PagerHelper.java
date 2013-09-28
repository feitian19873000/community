package com.util.page;

import javax.servlet.http.HttpServletRequest;

public class PagerHelper
{ 
    public static Pager getInstance(HttpServletRequest request)
    {
        Pager pager = new Pager();
        
        pager.setPageUrl(request.getRequestURI());	//访问路径
        
        //当前页
        if(request.getParameter("currentPage")!=null)
        {
            try
            {
                pager.setCurrentPage(Integer.parseInt(request.getParameter("currentPage")));
            }
            catch (Exception e) {
            }
        }
        
        //每页数量
        if(request.getParameter("pageSize")!=null)
        {
            try
            {
                pager.setPageSize(Integer.parseInt(request.getParameter("itemPerPage")));
            }
            catch (Exception e) {
                
            }
        } 

        request.setAttribute("pager", pager);
        return pager;
    }
    
}
