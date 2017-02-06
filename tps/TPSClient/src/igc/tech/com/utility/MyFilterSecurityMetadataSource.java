package igc.tech.com.utility;

import igc.tech.com.dao.MenuDao;
import igc.tech.com.mapper.MenuMapper;
import igc.tech.com.model.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class MyFilterSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

@Autowired
MenuDao menuDao;

    @Override
    public List<ConfigAttribute> getAttributes(Object object) {
        System.out.println("getAttribute");
        System.out.println("object"+object);
        FilterInvocation fi = (FilterInvocation) object;
        String url = fi.getRequestUrl();
//	        String httpMethod = fi.getRequest().getMethod();
        List<ConfigAttribute> attributes = new ArrayList<ConfigAttribute>();
        MenuModel menuModel = new MenuModel();
        menuModel.setMenuUrl(url);
        List list = menuDao.procMenu(menuModel,null,"a");
        System.out.println(list);

        for(int i=0; i< list.size();i++){
            Map map = (Map) list.get(i);
            attributes.add(new SecurityConfig(map.get("role_name").toString()));
        }

//        String[] roleList = new String[list.size()];
      /*  String[] roleList = new String[list.size()];
        list.toArray(roleList);

      *//*  for(int i=0; i< list.size();i++){
            attributes.add(new SecurityConfig(list[i]));
        }*//*

        attributes = SecurityConfig.createList(roleList);*/

        return attributes;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {



        System.out.println("hello");
        String[] roles = new String[] {"ROLE_ADMIN"};

        return SecurityConfig.createList(roles);

    }

    @Override
    public boolean supports(Class<?> clazz) {


        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}